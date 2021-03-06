package cn.org.citycloud.zwhs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.bean.OrderCancel;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.StoreServiceOrder;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.service.BabyServiceOrderService;

/**
 * 我的服务订单相关API
 * 
 * @author lanbo
 *
 */
@Controller
public class ServiceOrderController extends BaseController {
	
	@Autowired
	private BabyServiceOrderService orderService;
	
	
	/**
	 * 所有订单
	 */
	@RequestMapping(value = "/serviceOrders/status/{status}", method = RequestMethod.GET)
	@ResponseBody()
	public List<StoreServiceOrder> getOrders(@PathVariable int status) {

		List<StoreServiceOrder> orderList = orderService.findStoreOrderList(
				getStoreId(), getMemberId(), status);

		return orderList;
	}

	/**
	 * 订单详情
	 * 
	 */
	@RequestMapping(value = "/serviceOrders/{id}", method = RequestMethod.GET)
	@ResponseBody()
	public StoreServiceOrder getOrderDetail(@PathVariable int id) {

		return orderService.findStoreOrder(id, getStoreId(), getMemberId());
	}

	/**
	 * 取消订单
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/serviceOrders/{id}", method = RequestMethod.PUT)
	@ResponseBody()
	public void cancelOrder(@PathVariable int id,
			@Valid @RequestBody(required = false) OrderCancel cancel)
			throws BusinessErrorException {

		orderService.cancelOrder(id, getStoreId(), getMemberId(), cancel);

	}

	/**
	 * 确认服务订单
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/serviceOrders/{id}", method = RequestMethod.POST)
	@ResponseBody()
	public void confirmOrder(@PathVariable int id)
			throws BusinessErrorException {

		orderService.confirmOrder(id, getStoreId(), getMemberId());

	}

}
