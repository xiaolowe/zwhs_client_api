package cn.org.citycloud.zwhs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.bean.StoreMemberInfo;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
import cn.org.citycloud.zwhs.repository.StoreOrderDao;

/**
 * 店铺首页信息
 * 
 * @author Administrator
 *
 */
@Controller
public class StoreMemberController extends BaseController {

	@Autowired
	private StoreGoodsDao storeGoodsDao;

	@Autowired
	private StoreOrderDao storeOrderDao;

	/**
	 * 获取店铺首页统计信息
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/storeMemberInfo", method = RequestMethod.GET)
	@ResponseBody()
	public Object getStoreInfo() throws Exception {

		// 全部商品数量
		long allGoods = 0;
		// 最新上架商品数量
		long newArrival = 0;
		// 全部订单数
		long allOrder = 0;

		allGoods = storeGoodsDao.countAllGoodsByStoreId(getStoreId());
		newArrival = storeGoodsDao.countNewArrivalByStoreId(getStoreId());
		allOrder = storeOrderDao.countByStoreIdAndMemberId(getStoreId(),
				getMemberId());

		StoreMemberInfo memberInfo = new StoreMemberInfo();
		memberInfo.setAllGoods(allGoods);
		memberInfo.setNewArrival(newArrival);
		memberInfo.setAllOrder(allOrder);

		return memberInfo;
	}

}
