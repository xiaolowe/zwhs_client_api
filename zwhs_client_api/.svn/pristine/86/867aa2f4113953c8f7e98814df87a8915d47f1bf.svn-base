package cn.org.citycloud.zwhs.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.bean.BabyGoods;
import cn.org.citycloud.zwhs.bean.GoodsSearch;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.GoodsClassDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
import cn.org.citycloud.zwhs.service.StoreGoodService;

/**
 * 宝宝用品
 * 
 * @author lanbo
 *
 */
@Controller
public class BabyGoodsController {

	@Autowired
	private StoreGoodsDao storeGoodsDao;

	@Autowired
	private GoodsClassDao goodsClassDao;
	
	@Autowired
	private StoreGoodService goodService;

	/**
	 * 宝宝用品列表
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goodsList/{store_id}", method = RequestMethod.GET)
	@ResponseBody()
	public Object getBabyGoodsList(@PathVariable int store_id) throws Exception {

		// 母婴店 所有商品信息
		List<StoreGood> goodsList = storeGoodsDao
				.findStoreGoodByStoreId(store_id);

		if (goodsList.size() == 0) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "没有数据！");
		}

		// 宝宝用品列表
		List<BabyGoods> babygoodsList = new ArrayList<BabyGoods>();
		Set<Integer> gcNoSet = new HashSet<Integer>();

		for (StoreGood storeGood : goodsList) {

			gcNoSet.add(storeGood.getGcNo());
		}
		for (Integer gcNo : gcNoSet) {
			BabyGoods good = new BabyGoods();
			good.setGcNo(gcNo);

			for (StoreGood storeGood : goodsList) {
				if (storeGood.getGcNo() == gcNo) {
					if (StringUtils.isEmpty(good.getGcName())) {
						good.setGcName(storeGood.getGcName());
					}

					good.getGoods().add(storeGood);
				}
			}
			babygoodsList.add(good);
		}

		return babygoodsList;
	}

	/**
	 * 宝宝用品搜索
	 */
	@RequestMapping(value = "/goodsList/{store_id}", method = RequestMethod.POST)
	@ResponseBody()
	public Object getBabyGoodsListByKeyWord(@PathVariable int store_id,
			@Valid @RequestBody(required = false) GoodsSearch goodsSearch) throws Exception {

		if(goodsSearch == null) {
			goodsSearch = new GoodsSearch();
		}
//		List<Order> orderList = new ArrayList<Order>();
//		
//		Sort sort = new Sort(orders)
		
		Pageable pageable = new PageRequest(goodsSearch.getPage() - 1, goodsSearch.getSize());

		Page<StoreGood> goodsList = goodService.getStoreGoodList(pageable, goodsSearch, store_id);
		
		return goodsList;
	}
}
