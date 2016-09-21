package cn.org.citycloud.zwhs.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.AddrParams;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.WechatMemberAddr;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.WechatMemberAddrDao;
import cn.org.citycloud.zwhs.utils.EncryptUtil;
import cn.org.citycloud.zwhs.utils.WeChatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 收货地址共享初始化参数接口
 * 
 * @author lanbo
 *
 */
@RestController
@Api(tags="收货地址共享初始化参数接口",  description = "收货地址共享初始化参数接口", consumes="application/json")
public class AddressController extends BaseController {
	
	@Autowired
	private WechatMemberAddrDao memberAddrDao;

	/**
	 * 微信收货地址共享初始化参数接口
	 * 
	 * @throws InterruptedException
	 * @throws TimeoutException
	 * @throws BusinessErrorException 
	 */
	@RequestMapping(value = "/address/params", method = RequestMethod.POST)
	@ApiOperation(value = " 微信收货地址共享初始化参数接口", notes = " 微信收货地址共享初始化参数接口")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object getAddressJSCallParams(@Valid @RequestBody AddrParams addrParams, HttpServletRequest request)
			throws TimeoutException, InterruptedException, BusinessErrorException {

		 // 判断是否微信环境, 5.0 之后的支持微信支付
        if (!WeChatUtil.isWeiXin(request))
        {
            throw new BusinessErrorException(ErrorCodes.INVALID_PARAMETER, "微信5.0以下不支持微信支付！");
        }
		// 公众号appID
		String appId = Constants.API_ID;

		// 时间戳
		long time = System.currentTimeMillis() / 1000;

		// 随机字符串
		String nonceStr = RandomStringUtils.randomAlphanumeric(30);

		// 参与addrSign 签名的字段包括：appId、url（调用JavaScript
		// API的网页url）、timestamp、noncestr、accessToken
		StringBuilder aString = new StringBuilder();
		aString.append("accesstoken=");
		aString.append(getAccessToken());
		aString.append("&appid=");
		aString.append(appId);
		aString.append("&noncestr=");
		aString.append(nonceStr);
		aString.append("&timestamp=");
		aString.append(time);
		aString.append("&url=");
		aString.append(addrParams.getUrl());
		String addrSign = EncryptUtil.sha(aString.toString());

		Map<String, String> rstMap = new HashMap<String, String>();
		rstMap.put("appId", appId);
		rstMap.put("scope", "jsapi_address");
		rstMap.put("signType", "sha1");
		rstMap.put("addrSign", addrSign);
		rstMap.put("timeStamp", String.valueOf(time));
		rstMap.put("nonceStr", nonceStr);
		rstMap.put("accesstoken", getAccessToken());

		return rstMap;
	}
	
	/**
	 * 获取微信用户默认地址
	 * @return
	 */
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	@ApiOperation(value = "获取微信用户默认地址", notes = "获取微信用户默认地址")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object getMemberAddress() {
		
		WechatMemberAddr memberAddr = memberAddrDao.findByMemberId(getMemberId());
		
		return memberAddr;
	}
}
