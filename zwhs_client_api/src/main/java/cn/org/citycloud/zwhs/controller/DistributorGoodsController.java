package cn.org.citycloud.zwhs.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.DistShopGoodsSearch;
import cn.org.citycloud.zwhs.bean.DistributorsGoods;
import cn.org.citycloud.zwhs.bean.RetailShopGoodBean;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.RetailShopGood;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.RetailMemberDao;
import cn.org.citycloud.zwhs.repository.RetailShopDao;
import cn.org.citycloud.zwhs.repository.RetailShopGoodDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
import cn.org.citycloud.zwhs.service.StoreGoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 分销商商品控制器
 * 
 * @author lanbo
 *
 */
@RestController
@RequestMapping(value = "/distributorGoods")
@Api(tags = "分销商(后台)", position = 8, value = "/distributorGoods", description = "我的分销模块", consumes = "application/json")
public class DistributorGoodsController extends BaseController {

	@Autowired
	private RetailMemberDao retailMemberDao;

	@Autowired
	private RetailShopDao retailShopDao;

	@Autowired
	private RetailShopGoodDao retailShopGoodDao;

	@Autowired
	private StoreGoodsDao storeGoodsDao;
	
	@Autowired
	private StoreGoodService storeGoodsService;
	
	

//	/**
//	 * 分销店铺基础商品
//	 */
//	@RequestMapping(value = "/storeGood", method = RequestMethod.GET)
//	@ApiOperation(value = "分销店铺基础商品列表", notes = "分销店铺基础商品列表信息")
//	@ApiImplicitParams(value = {
//	            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
//	public Object getBabyGoodsListByKeyWord(
//			@ApiParam(value = "商品名称", required = false) @RequestParam(value = "goodsName", required = false) String goodsName ) throws Exception {
//
//		int storeId = getStoreId();
//		if(storeId == 0){
//			
//			throw new BusinessErrorException(ErrorCodes.NO_DATA, "请登录!");
//		}
//		
//		Sort sort = new Sort(Direction.DESC, "goodsId");
//		Pageable pageable = new PageRequest(0, 99999999, sort);
//		 
//		Page<StoreGood> goodsList = storeGoodsService.getRetailStoreGoodList(pageable, goodsName, storeId);
//		List<StoreGood> list = goodsList.getContent();
//		List<StoreGood> listOut = new ArrayList<StoreGood>();
//		if(list != null && list.size() > 0){
//			for(int i = 0; i < list.size(); i++){
//				StoreGood storeGood = list.get(i);
//				RetailShopGood rsg = retailShopGoodDao.findByGoodsIdAndMemberId(storeGood.getGoodsId(), getMemberId());
//				if(rsg != null){
//					storeGood.setGoodsState(1); 	// 分销商品已存在， 提示该商品已上架
//				}
//				listOut.add(storeGood);
//			}
//		}
//		
//		return listOut;
//	}
	
	
	
	@RequestMapping(value="/{goodsId}",method=RequestMethod.GET)
	@ApiOperation(value = "分销商品详情", notes = "分销商品详情", response = RetailShopGood.class)
	@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header")
	public Object getGoodInfo(@ApiParam(name="goodsId",value="分销商品ID",required=true) @PathVariable int goodsId)throws Exception{
		
		RetailShopGood retailShopGood = retailShopGoodDao.findByGoodsIdAndMemberId(goodsId, getMemberId());
		StoreGood storeGood = storeGoodsDao.findOne(goodsId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("retailShopGood", retailShopGood);
		map.put("storeGood", storeGood);
		
		return map;
		
	}
	
	
	@RequestMapping(value="/count",method=RequestMethod.GET)
	@ApiOperation(value = "分销上下架数量", notes = "分销上下架数量", response = RetailShopGood.class)
	@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header")
	public Object getCount(@ApiParam(value = "上下架数量（ 1 上架   2  下架）", required = false) @RequestParam(value = "status", defaultValue = "0", required = false) int status )throws Exception{
		
		long count =  retailShopGoodDao.countByMemberIdAndStatus(getMemberId(), status);
		Map<String, String> map = new HashMap<String, String>();
		map.put("count", String.valueOf(count));
		return map;
	}
	
	

	/**
	 * 分销商商品一览
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "分销商上架商品一览", notes = "分销商上架商品一览", response = RetailShopGood.class, responseContainer = "List")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header"),
			@ApiImplicitParam(name = "page", value = "页码（默认0）", required = false, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "size", value = "分页大小（默认20）", required = false, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "sort", value = "排序字段（salePrice，alreadySale）", required = false, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "order", value = "顺序DESC、ASC", required = false, dataType = "string", paramType = "query"),
			@ApiImplicitParam(name = "status", value = "商品状态（1 上架   2  下架）", required = false, dataType = "int", paramType = "query")})
	
	public Object getGoods(@ApiIgnore @Valid DistShopGoodsSearch search) {

		// 分页
		Pageable pageable = new PageRequest(search.getPage(), search.getSize());

		Specification<RetailShopGood> specs = new Specification<RetailShopGood>() {

			@Override
			public Predicate toPredicate(Root<RetailShopGood> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				Predicate where = cb.conjunction();

				// 分销商ID
				Path<Integer> memberId = root.get("memberId");
				where = cb.and(where, cb.equal(memberId, getMemberId()));
				
				int status = search.getStatus();
				if(status > 0){
					Path<Integer> statusQuery = root.get("status");
					where = cb.and(where, cb.equal(statusQuery, status));
				}

				query.where(where);

				List<Order> orderList = new ArrayList<Order>();

				// 按销量排序 按价格排序
				if (StringUtils.isNotBlank(search.getSort())) {
					if ("salePrice".equals(search.getSort())) {
						Path<BigDecimal> salePrice = root.get("shopGoodsPrice");

						Order salePriceFlgOrder = cb.asc(salePrice);
						if (Constants.SORT_DESC.equals(search.getOrder())) {
							salePriceFlgOrder = cb.desc(salePrice);
						}
						orderList.add(salePriceFlgOrder);

					} else if ("alreadySale".equals(search.getSort())) {
						Path<Integer> alreadySale = root.get("alreadySale");

						Order alreadySaleOrder = cb.asc(alreadySale);
						if (Constants.SORT_DESC.equals(search.getOrder())) {
							alreadySaleOrder = cb.desc(alreadySale);
						}
						orderList.add(alreadySaleOrder);
					}
				}

				// 上架时间倒序
				Path<Date> onlineTime = root.get("onlineTime");
				Order onlineTimeOrder = cb.desc(onlineTime);
				orderList.add(onlineTimeOrder);

				// 排序
				query.orderBy(orderList);
				return null;
			}

		};

		Page<RetailShopGood> goodsList = retailShopGoodDao.findAll(specs, pageable);

		return goodsList.getContent();
	}

//	/**
//	 * 分销商上架商品
//	 * 
//	 * @throws BusinessErrorException
//	 */
//	@RequestMapping(method = RequestMethod.POST)
//	@ApiOperation(value = "分销商上架商品", notes = "分销商上架商品",response = RetailShopGood.class)
//	@ApiImplicitParams(value = {
//			@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header") })
//	public Object addGoods(@Valid @RequestBody DistributorsGoods distGoods) throws BusinessErrorException {
//		// 验证分销商品 分销属性
////		StoreGood distGoodInfo = storeGoodsDao.findOne(distGoods.getGoodsId());
//
////		if (distGoodInfo.getIsAddRetail() != 1) {
////
////			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品不是分销商品，无法上架");
////		}
//
//		// 分销利润空间Low
////		BigDecimal rangeLow = distGoodInfo.getRetailPriceLow().divide(new BigDecimal(100));
////		BigDecimal rangeHigh = distGoodInfo.getRetailPriceHigh().divide(new BigDecimal(100));
//
////		BigDecimal rangeLowPrice = distGoodInfo.getRetailPriceLow();
////		BigDecimal rangeHighPrice = distGoodInfo.getRetailPriceHigh();
////
////		if (distGoods.getShopGoodsPrice().compareTo(rangeLowPrice) < 0
////				|| distGoods.getShopGoodsPrice().compareTo(rangeHighPrice) > 0) {
////			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "商品价格设置不在分销利润空间内");
////		}
//
////		SalesMember salesMember = salesMemberDao.findOne(getMemberId());
//
//		// 插入分销商品信息 如果已存在，判断状态是否下架，如果不存在，创建
//		RetailShopGood existGoods = retailShopGoodDao.findByGoodsIdAndMemberId(distGoods.getGoodsId(), getMemberId());
//		Date now = new Date();
//		if (existGoods!=null) {
//			if(existGoods.getStatus()==Constants.DIST_GOODS_ONLINE){
//				throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "该分销商品已经上架");
//			}
//			existGoods.setMemberId(getMemberId());
//			existGoods.setShopGoodsPrice(distGoods.getShopGoodsPrice());
//			existGoods.setStatus(Constants.DIST_GOODS_ONLINE);
//			existGoods.setUpdateTime(now);
//			return retailShopGoodDao.save(existGoods);
//		}else {
//			RetailShopGood distGood = new RetailShopGood();
//			distGood.setGoodsId(distGoods.getGoodsId());
//			distGood.setMemberId(getMemberId());
//			distGood.setShopGoodsPrice(distGoods.getShopGoodsPrice());
//			distGood.setStatus(Constants.DIST_GOODS_ONLINE);			
//
//			distGood.setCreateTime(now);
//			distGood.setUpdateTime(now);
//			distGood.setOnlineTime(now);
//			
//			return retailShopGoodDao.save(distGood);
//		}
//
//		
//	}
	
	@RequestMapping(value="/{goodsId}",method=RequestMethod.PUT)
	@ApiOperation(value = "分销商上下架商品", notes = "分销商上下架商品",response = RetailShopGood.class)
	@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header")
	public Object downGoods(@ApiParam(name="goodsId",value="商品ID",required=true)@PathVariable int goodsId,
			@Valid @RequestBody RetailShopGoodBean bean )throws Exception{
		
		StoreGood distGoodInfo = storeGoodsDao.findOne(goodsId);

		if (distGoodInfo.getIsAddRetail() != 1) {

			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "该商品已不是分销商品");
		}
		
		RetailShopGood distGood = retailShopGoodDao.findByGoodsIdAndMemberId(goodsId, getMemberId());
		if(distGood==null){
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "该分销商品不存在");
		}
		Date now = new Date();
		distGood.setStatus(bean.getGoodsState());
		distGood.setUpdateTime(now);
		distGood.setOnlineTime(now);
		return retailShopGoodDao.save(distGood);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "分销商修改价格", notes = "分销商修改价格",response = RetailShopGood.class)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name="token",value="token",required=false,dataType="string",paramType="header") })
	public Object mergeGoods(@Valid @RequestBody DistributorsGoods distGoods) throws BusinessErrorException {
		
		StoreGood distGoodInfo = storeGoodsDao.findOne(distGoods.getGoodsId());

		if (distGoodInfo.getIsAddRetail() != 1) {

			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品不是分销商品，无法修改价格");
		}

		// 分销利润空间Low
//		BigDecimal rangeLow = distGoodInfo.getRetailPriceLow().divide(new BigDecimal(100));
//		BigDecimal rangeHigh = distGoodInfo.getRetailPriceHigh().divide(new BigDecimal(100));

		BigDecimal rangeLowPrice = distGoodInfo.getRetailPriceLow();
		BigDecimal rangeHighPrice = distGoodInfo.getRetailPriceHigh();

		if (distGoods.getShopGoodsPrice().compareTo(rangeLowPrice) < 0
				|| distGoods.getShopGoodsPrice().compareTo(rangeHighPrice) > 0) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "商品价格设置不在分销利润区间内");
		}
		
		RetailShopGood distGood = retailShopGoodDao.findByGoodsIdAndMemberId(distGoods.getGoodsId(), getMemberId());
		if(distGood==null){
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "该分销商品不存在");
		}
		distGood.setShopGoodsPrice(distGoods.getShopGoodsPrice());
		distGood.setUpdateTime(new Date());
		return retailShopGoodDao.save(distGood);
	}
}
