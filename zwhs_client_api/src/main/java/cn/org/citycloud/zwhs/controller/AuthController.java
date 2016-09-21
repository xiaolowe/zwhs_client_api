package cn.org.citycloud.zwhs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWTSigner;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.org.citycloud.zwhs.bean.UserToken;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.entity.StoreMember;
import cn.org.citycloud.zwhs.entity.WechatMember;
import cn.org.citycloud.zwhs.repository.StoreMemberDao;
import cn.org.citycloud.zwhs.repository.WechatMemberDao;
import cn.org.citycloud.zwhs.service.WechatMemberService;
import cn.org.citycloud.zwhs.utils.HttpClientUtil;
import cn.org.citycloud.zwhs.utils.IPUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.rubyeye.xmemcached.MemcachedClient;

/**
 * 微信网页授权登录
 * 
 * @author lanbo
 *
 */
@Controller
@Api(tags="微信网页授权登录",   description = "微信网页授权登录", consumes="application/json")
public class AuthController
{
    
    private static Logger logger = Logger.getLogger(AuthController.class);
    
    @Autowired
    private WechatMemberService memberService;
    
    @Autowired
    MemcachedClient memcachedClient;
    
    @Autowired
    private WechatMemberDao wcmemberDao;
    
    @Autowired
    private StoreMemberDao smemberDao;
    
    /**
     * 微商城登录首页(测试之用)
     * 
     * @return
     */
    
//      @RequestMapping(value = "/auth/{store_id}", method = RequestMethod.GET) public String index(@PathVariable int
//                            store_id) { StringBuilder sb = new StringBuilder(); sb.append("redirect:");
//                            sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=" );
//                            sb.append("wxc796abe07a062d84");
//      
//                            sb.append("&redirect_uri=");
//      
//                           String redirect_uri = ""; try { redirect_uri = URLEncoder.encode(Constants.CALLBACK_URL +
//                            "?storeId=" + store_id, "UTF-8"); } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace(); }
//      
//                           sb.append(redirect_uri); sb.append(
//                            "&response_type=code&scope=snsapi_userinfo&state=12112121#wechat_redirect" );
//      
//                            return sb.toString(); }
//     
    
    /**
     * 微信网页授权登录后回调
     * 
     * @param code
     * @param state
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth/callback", method = RequestMethod.GET)
    @ApiOperation(value = "微信网页授权登录后回调", notes = "微信网页授权登录后回调")
    public Object callback(@RequestParam int storeId, @RequestParam String code, @RequestParam String state,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        
        // 通过code换取网页授权access_token
        StringBuilder accessUrl = new StringBuilder();
        accessUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        accessUrl.append(Constants.API_ID);
        accessUrl.append("&secret=");
        accessUrl.append(Constants.API_SECRET);
        accessUrl.append("&code=");
        accessUrl.append(code);
        accessUrl.append("&grant_type=authorization_code");
        
        String accessTokenStr = HttpClientUtil.getInstance().sendHttpGet(accessUrl.toString());
        
        ObjectMapper mapper = new ObjectMapper();
        
        @SuppressWarnings("unchecked")
        Map<String, Object> accessTokenMap = mapper.readValue(accessTokenStr, Map.class);
        
        Object errcode = accessTokenMap.get("errcode");
        
        if (errcode != null)
        {
            logger.error("通过code换取网页授权access_token失败:" + accessUrl.toString());
            String errMsg = "微信登录失败:" + accessTokenMap.get("errmsg");
            logger.error(errMsg);
            // 错误页面
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("errMsg", errMsg);
            return new ModelAndView("error", map);
        }
        
        // 是否获取到access_token
        String accessToken = (String)accessTokenMap.get("access_token");
        
        int expires_in = (int)accessTokenMap.get("expires_in");
        
        String openId = (String)accessTokenMap.get("openid");
        
        logger.info("accessToken=" + accessToken);
        logger.info("openId=" + openId);
        
        // 拉取用户信息(需scope为 snsapi_userinfo)
        StringBuilder userinfo = new StringBuilder();
        userinfo.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
        userinfo.append(accessToken);
        userinfo.append("&openid=");
        userinfo.append(openId);
        userinfo.append("&lang=zh_CN");
        
        String userInfoStr = HttpClientUtil.getInstance().sendHttpGet(userinfo.toString());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> userInfoMap = mapper.readValue(userInfoStr, Map.class);
        
        Object userInfoCode = userInfoMap.get("errcode");
        
        if (userInfoCode != null)
        {
            logger.error("微信用户信息获取URL:" + userinfo.toString());
            String errMsg = "微信用户信息获取失败:" + userInfoMap.get("errmsg");
            logger.error(errMsg); // 错误页面
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("errMsg", errMsg);
            return new ModelAndView("error", map);
        }
        
        String utfStr = (String)userInfoMap.get("nickname");
        
        logger.info("nickname-old=" + utfStr);
        
        // byte[] converttoBytes = utfStr.getBytes("UTF-8");
        
        // String nickname = new String(converttoBytes, "UTF-8");
        
        String nickname = decodeUnicode(utfStr);
        
        logger.info("nickname=" + nickname);
        
        int sex = (int)userInfoMap.get("sex");
        String province = (String)userInfoMap.get("province");
        String city = (String)userInfoMap.get("city");
        
        String headImgUrl = (String)userInfoMap.get("headimgurl");
        
        // 只要在微信公众号授权登录过的微信号都算门店会员
        // 新建会员信息
        // OpenID 用户微信登录后回调
        WechatMember wcMember = memberService.getWechatMember(openId);
        
        // 客户端IP
        String remoteIP = IPUtil.getIp(request);
        Date now = new Date();
        if (wcMember != null)
        {
            wcMember.setWechatAliasname(nickname);
            wcMember.setMemberSex(sex);
            
            wcMember.setRegionProvName(province);
            wcMember.setRegionCityName(city);
            
            wcMember.setMemberAvatar(headImgUrl);
            // 登录次数
            wcMember.setMemberLoginNum(wcMember.getMemberLoginNum() + 1);
            // 上次登录时间
            wcMember.setMemberOldLoginTime(wcMember.getMemberLoginTime());
            // 上次登录ip
            wcMember.setMemberOldLoginIp(wcMember.getMemberLoginIp());
            // 当前登录ip
            wcMember.setMemberLoginIp(remoteIP);
            // 当前登录时间
            wcMember.setMemberLoginTime(now);
            
            wcMember.setUpdDate(now);
            
            wcmemberDao.save(wcMember);
            
            StoreMember storeMember = smemberDao.findByStoreIdAndOpenId(storeId, openId);
            
            if (storeMember == null)
            {
                StoreMember entity = new StoreMember();
                entity.setMemberId(wcMember.getMemberId());
                entity.setStoreId(storeId);
                entity.setOpenId(openId);
                entity.setInsDate(new Date());
                
                smemberDao.save(entity);
            }
            
        }
        else
        {
            WechatMember entity = new WechatMember();
            entity.setOpenId(openId);
            entity.setWechatAliasname(nickname);
            entity.setMemberSex(sex);
            entity.setRegionProvName(province);
            entity.setRegionCityName(city);
            entity.setMemberAvatar(headImgUrl);
            entity.setMemberLoginIp(remoteIP);
            // 会员状态
            entity.setMemberState(Constants.MEMBER_STATE_OPEN);
            entity.setMemberTime(now);
            // 当前登录ip
            entity.setMemberLoginIp(remoteIP);
            // 当前登录时间
            entity.setMemberLoginTime(now);
            // 登录次数
            entity.setMemberLoginNum(1);
            entity.setInsDate(now);
            entity.setUpdDate(now);
            
            wcMember = memberService.addWechatMember(entity, storeId);
        }
        
        // 生成登录用Token
        String token = generateToken(openId, storeId, Constants.TOKEN_SECRET);
        
        // 将Token存入Memcached
        UserToken tokenEntity = new UserToken();
        tokenEntity.setToken(token);
        tokenEntity.setOpenId(openId);
        tokenEntity.setMemberId(wcMember.getMemberId());
        tokenEntity.setStoreId(storeId);
        tokenEntity.setAccessToken(accessToken);
        tokenEntity.setCreateTs(System.currentTimeMillis());
        tokenEntity.setExpiresIn(expires_in);
        
        // 如果已经存在Token 替换掉旧的Token存储
        memcachedClient.set(token, Integer.parseInt(String.valueOf(expires_in)), tokenEntity);
        
        StringBuilder sb = new StringBuilder();
        sb.append("redirect:");
        sb.append(Constants.WSC_URL);
        sb.append(storeId);
        sb.append("/token/");
        sb.append(token);
        
        
        return sb.toString();
        
    }
    
    
    /**
     * 微信网页授权登录后回调(分销端)
     * 
     * @param code
     * @param state
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/auth/callbackRetail", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "微信网页授权登录后回调(分销端)", notes = "微信网页授权登录后回调(分销端)")
    public Object callbackRetail(@RequestParam int storeId, @RequestParam String code, @RequestParam String state,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        
        // 通过code换取网页授权access_token
        StringBuilder accessUrl = new StringBuilder();
        accessUrl.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        accessUrl.append(Constants.API_ID);
        accessUrl.append("&secret=");
        accessUrl.append(Constants.API_SECRET);
        accessUrl.append("&code=");
        accessUrl.append(code);
        accessUrl.append("&grant_type=authorization_code");
        
        String accessTokenStr = HttpClientUtil.getInstance().sendHttpGet(accessUrl.toString());
        
        ObjectMapper mapper = new ObjectMapper();
        
        @SuppressWarnings("unchecked")
        Map<String, Object> accessTokenMap = mapper.readValue(accessTokenStr, Map.class);
        
        Object errcode = accessTokenMap.get("errcode");
        
        if (errcode != null)
        {
            logger.error("通过code换取网页授权access_token失败:" + accessUrl.toString());
            String errMsg = "微信登录失败:" + accessTokenMap.get("errmsg");
            logger.error(errMsg);
            // 错误页面
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("errMsg", errMsg);
            return new ModelAndView("error", map);
        }
        
        // 是否获取到access_token
        String accessToken = (String)accessTokenMap.get("access_token");
        
        int expires_in = (int)accessTokenMap.get("expires_in");
        
        String openId = (String)accessTokenMap.get("openid");
        
        logger.info("accessToken=" + accessToken);
        logger.info("openId=" + openId);
        
        // 拉取用户信息(需scope为 snsapi_userinfo)
        StringBuilder userinfo = new StringBuilder();
        userinfo.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
        userinfo.append(accessToken);
        userinfo.append("&openid=");
        userinfo.append(openId);
        userinfo.append("&lang=zh_CN");
        
        String userInfoStr = HttpClientUtil.getInstance().sendHttpGet(userinfo.toString());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> userInfoMap = mapper.readValue(userInfoStr, Map.class);
        
        Object userInfoCode = userInfoMap.get("errcode");
        
        if (userInfoCode != null)
        {
            logger.error("微信用户信息获取URL:" + userinfo.toString());
            String errMsg = "微信用户信息获取失败:" + userInfoMap.get("errmsg");
            logger.error(errMsg); // 错误页面
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("errMsg", errMsg);
            return new ModelAndView("error", map);
        }
        
        String utfStr = (String)userInfoMap.get("nickname");
        
        logger.error("nickname-old=" + utfStr);
        
        // byte[] converttoBytes = utfStr.getBytes("UTF-8");
        
        // String nickname = new String(converttoBytes, "UTF-8");
        
        String nickname = decodeUnicode(utfStr);
        
        logger.error("nickname=" + nickname);
        
        int sex = (int)userInfoMap.get("sex");
        String province = (String)userInfoMap.get("province");
        String city = (String)userInfoMap.get("city");
        
        String headImgUrl = (String)userInfoMap.get("headimgurl");
        
        // 只要在微信公众号授权登录过的微信号都算门店会员
        // 新建会员信息
        // OpenID 用户微信登录后回调
        WechatMember wcMember = memberService.getWechatMember(openId);
        
        // 客户端IP
        String remoteIP = IPUtil.getIp(request);
        Date now = new Date();
        if (wcMember != null)
        {
            wcMember.setWechatAliasname(nickname);
            wcMember.setMemberSex(sex);
            
            wcMember.setRegionProvName(province);
            wcMember.setRegionCityName(city);
            
            wcMember.setMemberAvatar(headImgUrl);
            // 登录次数
            wcMember.setMemberLoginNum(wcMember.getMemberLoginNum() + 1);
            // 上次登录时间
            wcMember.setMemberOldLoginTime(wcMember.getMemberLoginTime());
            // 上次登录ip
            wcMember.setMemberOldLoginIp(wcMember.getMemberLoginIp());
            // 当前登录ip
            wcMember.setMemberLoginIp(remoteIP);
            // 当前登录时间
            wcMember.setMemberLoginTime(now);
            
            wcMember.setUpdDate(now);
            
            wcmemberDao.save(wcMember);
            
            StoreMember storeMember = smemberDao.findByStoreIdAndOpenId(storeId, openId);
            
            if (storeMember == null)
            {
                StoreMember entity = new StoreMember();
                entity.setMemberId(wcMember.getMemberId());
                entity.setStoreId(storeId);
                entity.setOpenId(openId);
                entity.setInsDate(new Date());
                
                smemberDao.save(entity);
            }
            
        }
        else
        {
            WechatMember entity = new WechatMember();
            entity.setOpenId(openId);
            entity.setWechatAliasname(nickname);
            entity.setMemberSex(sex);
            entity.setRegionProvName(province);
            entity.setRegionCityName(city);
            entity.setMemberAvatar(headImgUrl);
            entity.setMemberLoginIp(remoteIP);
            // 会员状态
            entity.setMemberState(Constants.MEMBER_STATE_OPEN);
            entity.setMemberTime(now);
            // 当前登录ip
            entity.setMemberLoginIp(remoteIP);
            // 当前登录时间
            entity.setMemberLoginTime(now);
            // 登录次数
            entity.setMemberLoginNum(1);
            entity.setInsDate(now);
            entity.setUpdDate(now);
            
            wcMember = memberService.addWechatMember(entity, storeId);
        }
        
        // 生成登录用Token
        String token = generateToken(openId, storeId, Constants.TOKEN_SECRET);
        
        // 将Token存入Memcached
        UserToken tokenEntity = new UserToken();
        tokenEntity.setToken(token);
        tokenEntity.setOpenId(openId);
        tokenEntity.setMemberId(wcMember.getMemberId());
        tokenEntity.setStoreId(storeId);
        tokenEntity.setAccessToken(accessToken);
        tokenEntity.setCreateTs(System.currentTimeMillis());
        tokenEntity.setExpiresIn(expires_in);
        
        // 如果已经存在Token 替换掉旧的Token存储
        memcachedClient.set(token, Integer.parseInt(String.valueOf(expires_in)), tokenEntity);
        
        StringBuilder sb = new StringBuilder();
        sb.append("redirect:");
        sb.append(Constants.WSC_URL);
        sb.append(storeId);
        sb.append("/token/");
        sb.append(token);
        
        Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("token", token);
		resultMap.put("memberId", wcMember.getMemberId());
		resultMap.put("wechatAliasName", wcMember.getWechatAliasname());
		resultMap.put("avatar", headImgUrl);
        
        
        return resultMap;
        
    }
    
    /**
     * 生成token值
     * 
     * @param user
     * @return
     */
    private String generateToken(String openid, int store_id, String secret)
    {
        JWTSigner jwtSigner = new JWTSigner(secret);
        Map<String, Object> claims = new HashMap<String, Object>();
        
        claims.put("openid", openid);
        claims.put("store_id", String.valueOf(store_id));
        claims.put("time", System.currentTimeMillis());
        String token = jwtSigner.sign(claims);
        
        return token;
    }
    
    /**
     * 
     * UTF转码
     * 
     * @param theString
     * @return
     */
    private static String decodeUnicode(String theString)
    {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;)
        {
            aChar = theString.charAt(x++);
            if (aChar == '\\')
            {
                aChar = theString.charAt(x++);
                if (aChar == 'u')
                {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++)
                    {
                        aChar = theString.charAt(x++);
                        switch (aChar)
                        {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                        
                    }
                    outBuffer.append((char)value);
                }
                else
                {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            }
            else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();
    }
}
