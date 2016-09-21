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
import cn.org.citycloud.zwhs.entity.ShoppingCart;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.ShoppingCartDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;

/**
 * 购物车
 * 
 * @author lanbo
 *
 */
@RestController
public class ShoppingCartController extends BaseController {

	@Autowired
	private ShoppingCartDao cartDao;

	@Autowired
	private StoreGoodsDao goodsDao;

	/**
	 * 获取购物车商品
	 * 
	 * @return
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
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
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.POST)
	public void addGoodsToCart(@Valid @RequestBody CartGoods cartGoods)
			throws BusinessErrorException {

		int goodsId = cartGoods.getGoodsId();
		// 商品信息
		StoreGood goodItem = goodsDao.findOne(goodsId);

		if (goodItem == null) {
			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品信息不存在");
		}

		// 商品状态
		int goodState = goodItem.getGoodsState();

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
		BigDecimal goodsPayPrice = goodItem.getGoodsSellprice().multiply(num);

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
			cartGood.setGoodsPrice(goodItem.getGoodsSellprice());
			cartGood.setGoodsNum(cartGoods.getGoodsNum());
			cartGood.setGoodsImage(goodItem.getGoodsImage());
			// 实际成交价
			cartGood.setGoodsPayPrice(goodsPayPrice);
			cartGood.setGoodsSpec(goodItem.getGoodsSpec());
			// 商品类型
			cartGood.setGoodsType(1);
			// 状态
			cartGood.setCartState(3);

			cartGood.setInsDate(now);
			cartGood.setUpdDate(now);
			cartDao.save(cartGood);
		}

	}

	/**
	 * 删除购物车中的商品
	 */
	@RequestMapping(value = "/shoppingcart/{id}", method = RequestMethod.DELETE)
	public void deleteGoodsFromCart(@PathVariable int id) {

		ShoppingCart cart = cartDao.findByIdAndStoreIdAndMemberId(id,
				getStoreId(), getMemberId());

		if (cart != null)

			cartDao.delete(cart);

	}

	/**
	 * 批量删除购物车中的商品
	 */
	@RequestMapping(value = "/shoppingcart/batchDelele", method = RequestMethod.POST)
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
	@RequestMapping(value = "/shoppingcart/id/{id}/number/{num}", method = RequestMethod.PUT)
	public void editCartGoods(@PathVariable int id, @PathVariable int num)
			throws BusinessErrorException {

		ShoppingCart cartGoods = cartDao.findByIdAndStoreIdAndMemberId(id,
				getStoreId(), getMemberId());
		if (cartGoods == null) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "此商品不存在或已删除！");
		}

		// 商品信息
		StoreGood goodItem = goodsDao.findOne(cartGoods.getGoodsId());

		if (goodItem == null) {

			throw new BusinessErrorException(ErrorCodes.WRONG_GOODS, "此商品信息不存在");
		}

		// 商品状态
		int goodState = goodItem.getGoodsState();

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
		cartGoods.setGoodsPayPrice(goodItem.getGoodsSellprice()
				.multiply(numDec));

		cartGoods.setUpdDate(now);

		cartDao.save(cartGoods);
	}
}
