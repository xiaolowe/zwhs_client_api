package cn.org.citycloud.zwhs.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.BatchDelete;
import cn.org.citycloud.zwhs.bean.CartGoods;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.RetailShopGood;
import cn.org.citycloud.zwhs.entity.ShoppingCart;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.RetailShopGoodDao;
import cn.org.citycloud.zwhs.repository.ShoppingCartDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 购物车
 * 
 * @author lanbo
 *
 */
@RestController
@Api(tags="分销购物车",  description = "分销购物车", consumes="application/json")
public class RetailShoppingCartController extends BaseController {

	@Autowired
	private ShoppingCartDao cartDao;

	@Autowired
	private StoreGoodsDao goodsDao;
	
	@Autowired
	private RetailShopGoodDao retailShopGoodDao;

	/**
	 * 获取购物车商品
	 * 
	 * @return
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/retailshoppingcart", method = RequestMethod.GET)
	@ApiOperation(value = "获取购物车商品", notes = "获取购物车商品")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public Object getShoppingCart() throws BusinessErrorException {

		List<ShoppingCart> cartGoods = cartDao.findByStoreIdAndMemberId(
				getStoreId(), getMemberId());

		return cartGoods;
	}

	/**
	 * 添加购物车商品
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/retailshoppingcart", method = RequestMethod.POST)
	@ApiOperation(value = "添加购物车商品", notes = "添加购物车商品")
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	public void addGoodsToCart(@Valid @RequestBody CartGoods cartGoods)
			throws BusinessErrorException {

		int goodsId = cartGoods.getGoodsId();
		// 商品信息
		StoreGood goodItem = goodsDao.findOne(goodsId);
		
		// 分销商品
		RetailShopGood retailShopGood = retailShopGoodDao.findByGoodsIdAndMemberId(goodsId, getMemberId());

		if (retailShopGood == null) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品信息不存在");
		}

		// 商品状态
		int goodState = retailShopGood.getStatus();

		if (Constants.GOODS_STATE_NORMAL != goodState) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS,
					"此商品已下架或者禁售。");
		}
		// 自动下架时间
		Date offlineTime = goodItem.getOfflineTime();
		Date now = new Date();

		if (offlineTime.getTime() < now.getTime()) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品已下架。");
		}
		
		// 商品已经没有库存了
		if(goodItem.getStockNumber() <= 0) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品已经售罄。");
		}

		BigDecimal num = new BigDecimal(cartGoods.getGoodsNum());
		BigDecimal goodsPayPrice = retailShopGood.getShopGoodsPrice().multiply(num);
		
		
		ShoppingCart goods = cartDao.findByStoreIdAndMemberIdAndGoodsId(
				getStoreId(), getMemberId(), goodsId);
		// 购物车中已经有的商品
		if (goods != null) {
			goods.setGoodsNum(cartGoods.getGoodsNum() + goods.getGoodsNum());

			// 实际成交价
			goods.setGoodsPayPrice(goods.getGoodsPayPrice().add(goodsPayPrice));
			
			goods.setUpdDate(now);

			cartDao.save(goods);
		} else {
			ShoppingCart cartGood = new ShoppingCart();
			cartGood.setGoodsId(cartGoods.getGoodsId());
			cartGood.setStoreId(getStoreId());
			cartGood.setMemberId(getMemberId());

			cartGood.setGoodsName(goodItem.getGoodsName());
			cartGood.setGoodsPrice(goodItem.getRetailSalePrice());
			cartGood.setGoodsNum(cartGoods.getGoodsNum());
			cartGood.setGoodsImage(goodItem.getGoodsImage());
			// 实际成交价
			cartGood.setGoodsPayPrice(goodsPayPrice);
			
			cartGood.setGoodsSpec(goodItem.getGoodsSpec());
			// 商品类型
			cartGood.setGoodsType(1);	//1默认2团购商品3限时折扣商品4组合套装5赠品
			// 状态
			cartGood.setCartState(3); 	//状态 1 从购物车删除; 2 提交订单;3 正常 
			cartGood.setInsDate(now);
			cartGood.setUpdDate(now);
			cartDao.save(cartGood);
		}

	}

	/**
	 * 删除购物车中的商品
	 */
	@RequestMapping(value = "/retailshoppingcart/{id}", method = RequestMethod.DELETE)
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	@ApiOperation(value = "删除购物车中的商品", notes = "删除购物车中的商品")
	public void deleteGoodsFromCart(@PathVariable int id) {

		ShoppingCart cart = cartDao.findByIdAndStoreIdAndMemberId(id,
				getStoreId(), getMemberId());

		if (cart != null)

			cartDao.delete(cart);

	}

	/**
	 * 批量删除购物车中的商品
	 */
	@RequestMapping(value = "/retailshoppingcart/batchDelele", method = RequestMethod.POST)
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	@ApiOperation(value = "批量删除购物车中的商品", notes = "批量删除购物车中的商品")
	public void batchDeleteGoodsFromCart(
			@Valid @RequestBody List<BatchDelete> ids) {

		for (BatchDelete batchDelete : ids) {
			ShoppingCart cart = cartDao.findByIdAndStoreIdAndMemberId(
					batchDelete.getId(), getStoreId(), getMemberId());
			if (cart != null)
				cartDao.delete(cart);
		}
	}

	/**
	 * 修改商品数量
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/retailshoppingcart/id/{id}/number/{num}", method = RequestMethod.PUT)
	@ApiImplicitParams(value = {
            @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header")})
	@ApiOperation(value = "修改商品数量", notes = "修改商品数量")
	public void editCartGoods(@PathVariable int id, @PathVariable int num)
			throws BusinessErrorException {

		ShoppingCart cartGoods = cartDao.findByIdAndStoreIdAndMemberId(id,
				getStoreId(), getMemberId());
		if (cartGoods == null) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "此商品不存在或已删除！");
		}

		// 商品信息
		StoreGood goodItem = goodsDao.findOne(cartGoods.getGoodsId());
		// 分销商品
	    RetailShopGood retailShopGood = retailShopGoodDao.findOne(cartGoods.getGoodsId());

		if (retailShopGood == null) {

			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品信息不存在");
		}

		// 商品状态
		int goodState = retailShopGood.getStatus();

		if (Constants.GOODS_STATE_NORMAL != goodState) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS,
					"此商品已下架或者禁售");
		}
		// 自动下架时间
		Date offlineTime = goodItem.getOfflineTime();
		Date now = new Date();

		if (offlineTime.getTime() < now.getTime()) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品已下架");
		}

		cartGoods.setGoodsNum(num);

		// 商品数量
		BigDecimal numDec = new BigDecimal(num);
		// 实际成交价
		cartGoods.setGoodsPayPrice(retailShopGood.getShopGoodsPrice()
				.multiply(numDec));

		cartGoods.setUpdDate(now);

		cartDao.save(cartGoods);
	}
}
