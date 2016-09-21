//package cn.org.citycloud.zwhs.controller;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import cn.org.citycloud.zwhs.bean.UserToken;
//import cn.org.citycloud.zwhs.constants.Constants;
//import cn.org.citycloud.zwhs.constants.ErrorCodes;
//import cn.org.citycloud.zwhs.entity.WechatMember;
//import cn.org.citycloud.zwhs.exception.BusinessErrorException;
//import cn.org.citycloud.zwhs.service.WechatMemberService;
//
//import com.auth0.jwt.JWTSigner;
//
///**
// * 微信登录相关API
// * 
// * @author lanbo
// *
// */
//@Controller
//public class AuthenticationController {
//	
//	@Autowired
//	private WechatMemberService memberService;
//
//	@Autowired
//	MemcachedClient memcachedClient;
//
//	@RequestMapping(value = "/authentication/login", method = RequestMethod.GET)
//	@ResponseBody()
//	public Object login(@RequestBody Map<String, String> paramMap,
//			HttpServletRequest request) throws Exception {
//
//		String openId = paramMap.get("openid");
//		String nickname = paramMap.get("nickname");
//		String store_id = paramMap.get("store_id");
//
//		if (StringUtils.isEmpty(openId) || StringUtils.isEmpty(store_id)) {
//			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR);
//		}
//		// OpenID 用户微信登录后回调
//		WechatMember wcMember = memberService.getWechatMember(openId);
//
//		// 客户端IP
//		String remoteIP = getIp(request);
//		if (wcMember != null) {
//			// 登录次数
//			wcMember.setMemberLoginNum(wcMember.getMemberLoginNum() + 1);
//			// 上次登录时间
//
//			// 上次登录ip
//			wcMember.setMemberOldLoginIp(wcMember.getMemberLoginIp());
//			// 当前登录ip
//			wcMember.setMemberLoginIp(remoteIP);
//
//		} else {
//			WechatMember entity = new WechatMember();
//			Date now = new Date();
//			entity.setUnionId(openId);
//			entity.setWechatAliasname(nickname);
//			entity.setMemberLoginIp(remoteIP);
//			// 会员状态
//			entity.setMemberState(Constants.MEMBER_STATE_OPEN);
//			entity.setMemberTime(now);
//			entity.setInsDate(now);
//			entity.setUpdDate(now);
//
//			wcMember = memberService.addWechatMember(entity,
//					Integer.parseInt(store_id));
//		}
//
//		// 生成登录用Token
//		String token = generateToken(paramMap, Constants.TOKEN_SECRET);
//
//		// 将Token存入Memcached
//		UserToken tokenEntity = new UserToken();
//		tokenEntity.setToken(token);
//		tokenEntity.setCreateTs(System.currentTimeMillis());
//		tokenEntity.setMemberId(wcMember.getMemberId());
//		tokenEntity.setExpiresIn(Constants.TOKEN_EXPIRES_IN);
//
//		memcachedClient.add(token,
//				Integer.parseInt(String.valueOf(Constants.TOKEN_EXPIRES_IN)),
//				tokenEntity);
//
//		Map<String, String> rstMap = new HashMap<String, String>();
//		rstMap.put("user_id", String.valueOf(wcMember.getMemberId()));
//		rstMap.put("nickname", wcMember.getWechatAliasname());
//		rstMap.put("zwhs_token", token);
//		rstMap.put("expires_in", String.valueOf(Constants.TOKEN_EXPIRES_IN));
//		return rstMap;
//
//	}
//
//	
//	/**
//	 * 生成token值
//	 * 
//	 * @param user
//	 * @return
//	 */
//	private String generateToken(Map<String, String> user, String secret) {
//		JWTSigner jwtSigner = new JWTSigner(secret);
//		Map<String, Object> claims = new HashMap<String, Object>();
//
//		claims.put("openid", user.get("openid"));
//		claims.put("nickname", user.get("nickname"));
//		claims.put("store_id", user.get("store_id"));
//		String token = jwtSigner.sign(claims);
//
//		return token;
//	}
//
//	private String getIp(HttpServletRequest request) {
//		String ip = request.getHeader("X-Forwarded-For");
//		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
//			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
//			int index = ip.indexOf(",");
//			if (index != -1) {
//				return ip.substring(0, index);
//			} else {
//				return ip;
//			}
//		}
//		ip = request.getHeader("X-Real-IP");
//		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
//			return ip;
//		}
//		return request.getRemoteAddr();
//	}
//}
