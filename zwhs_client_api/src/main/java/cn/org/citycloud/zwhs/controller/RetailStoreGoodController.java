//package cn.org.citycloud.zwhs.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.org.citycloud.zwhs.constants.ErrorCodes;
//import cn.org.citycloud.zwhs.core.BaseController;
//import cn.org.citycloud.zwhs.entity.StoreGood;
//import cn.org.citycloud.zwhs.exception.BusinessErrorException;
//import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
//import cn.org.citycloud.zwhs.service.StoreGoodService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//
//@RestController
//@Api(tags="分销店铺基础商品", value = "/retailStoreGood",  description = "分销店铺基础商品", consumes="application/json")
//public class RetailStoreGoodController extends BaseController{
//	
//	@Autowired
//	private StoreGoodsDao storeGoodsDao;
//	
//	@Autowired
//	private StoreGoodService storeGoodsService;
//	
//	
//	
//	/**
//	 * 分销店铺基础商品
//	 */
//	@RequestMapping(value = "/retailStoreGood", method = RequestMethod.GET)
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
//		
//		return goodsList;
//	}
//	
//
//	
////	/**
////	 * 修改商品上下架
////	 * @return
////	 * @throws Exception
////	 */
////	@RequestMapping(value = "/retailStoreGood/{goodsId}", method = RequestMethod.PUT)
////	@ApiOperation(value = "修改商品上下架信息", notes = "修改商品上下架信息")
////	@ApiImplicitParams(value = {
////            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
////	public Object bindCard(@ApiParam(value = "商品Id", required = true) @PathVariable int goodsId,
////			@ApiParam(value = "分销商品信息", required = false) @Valid @RequestBody RetailGoodBean bean,
////			@ApiParam(value = "商品状态  0 下架，1 上架，10违规（禁售）", required = false) @RequestParam(value = "goodsState", required = false, defaultValue = "-1") int goodsState) throws BusinessErrorException {
////		
////		StoreGood storeGood = storeGoodsDao.findOne(goodsId);
////		if(goodsState > -1){
////			storeGood.setGoodsState(goodsState);
////		}
////		if(bean.getRetailSalePrice() != null){
////			if(bean.getRetailSalePrice().compareTo(storeGood.getRetailPriceLow()) == 1
////					&& bean.getRetailSalePrice().compareTo(storeGood.getRetailPriceHigh()) == -1){
////				
////				storeGood.setRetailSalePrice(bean.getRetailSalePrice());
////			}else{
////				throw new BusinessErrorException(ErrorCodes.SYSTEM_ERROR, "请输入分销售价范围的价格!");
////			}
////			
////		}
////		StoreGood sg = storeGoodsDao.save(storeGood);
////		
////		return sg.getGoodsState();
////		
////		
////	}
//	
////	/**
////	 * 获取上下架商品数量
////	 * @return
////	 * @throws Exception
////	 */
////	@RequestMapping(value = "/retailStoreGood/count", method = RequestMethod.GET)
////	@ApiOperation(value = "获取上下架商品数量", notes = "获取上下架商品数量")
////	@ApiImplicitParams(value = {
////            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
////	public Object getCount() throws BusinessErrorException {
////		
////		int storeId = getStoreId();
////		
////		if(storeId == 0){
////			
////			throw new BusinessErrorException(ErrorCodes.NO_DATA, "请登录!");
////		}
////		long countUp = storeGoodsDao.countAllRetailGoodsUp(storeId);
////		long countDown = storeGoodsDao.countAllRetailGoodsDown(storeId);
////		
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("countUp", countUp);
////		map.put("countDown", countDown);
////		
////		return map;
////		
////		
////	}
//	
////	/**
////	 * 分销店铺商品详情
////	 */
////	@RequestMapping(value = "/retailStoreGood/{goodsId}", method = RequestMethod.GET)
////	@ApiOperation(value = "分销店铺商品详情", notes = "分销店铺商品详情信息")
////	@ApiImplicitParams(value = {
////            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
////	public Object getInfo(@ApiParam(value = "商品Id", required = true) @PathVariable int goodsId) throws Exception {
////
////		StoreGood storeGood = storeGoodsDao.findOne(goodsId);
////		
////		return storeGood;
////	}
//	
//	
//}
