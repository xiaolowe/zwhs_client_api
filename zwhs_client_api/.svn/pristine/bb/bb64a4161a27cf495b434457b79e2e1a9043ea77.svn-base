package cn.org.citycloud.zwhs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.PersonalInfo;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.WechatMember;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.StoreOrderDao;
import cn.org.citycloud.zwhs.repository.WechatMemberDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 个人中心信息API
 * 
 * @author lanbo
 *
 */
@RestController
@Api(tags="个人中心信息API",   description = "个人中心信息API", consumes="application/json")
public class PersonalCenterController extends BaseController {

	@Autowired
	private WechatMemberDao memberDao;

	@Autowired
	private StoreOrderDao orderDao;

	/**
	 * 收货地址共享初始化参数接口
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/personalInfo", method = RequestMethod.GET)
	@ApiOperation(value = "个人中心信息", notes = "个人中心信息")
	public Object getPersonalCenterInfo() throws BusinessErrorException {

		// 微信会员信息
		WechatMember member = memberDao.findByOpenId(getOpenId());

		if (member == null) {
			throw new BusinessErrorException(ErrorCodes.NON_EXIST_MEMBER,
					"不存在的用户");
		}

		List<Byte> orderStatusList = orderDao.countOrderStatus(getStoreId(),
				getMemberId());

		int defaultOrder = 0;
		int payedOrder = 0;
		int receivedOrder = 0;
		for (Byte status : orderStatusList) {
			// byte 转换成int
			int orderStatus = status & 0xFF;

			switch (orderStatus) {
			case Constants.ORDER_STATUS_DEFAULT:
				defaultOrder += 1;
				break;
			case Constants.ORDER_STATUS_PAYED:
				payedOrder += 1;
				break;
			case Constants.ORDER_STATUS_RECEIVED:
				receivedOrder += 1;
				break;
			default:
				break;
			}
		}

		PersonalInfo pInfo = new PersonalInfo();
		pInfo.setMemberAvatar(member.getMemberAvatar());
		pInfo.setWechatAliasname(member.getWechatAliasname());
		pInfo.setToPay(defaultOrder);
		pInfo.setToReceive(payedOrder);
		pInfo.setToComment(receivedOrder);

		return pInfo;
	}
}
