package cn.org.citycloud.zwhs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.ShoppingFavorite;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.ShoppingFavoriteDao;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;

/**
 * 我的收藏接口API
 * 
 * @author lanbo
 *
 */
@RestController
public class FavoritesController extends BaseController {

	@Autowired
	private ShoppingFavoriteDao favoriteDao;

	@Autowired
	private StoreGoodsDao goodsDao;

	/**
	 * 获取我的收藏列表
	 * 
	 * @return
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	public Object getShoppingFavorites() throws BusinessErrorException {

		List<ShoppingFavorite> favorites = favoriteDao
				.findByStoreIdAndMemberIdOrderByInsDateDesc(getStoreId(),
						getMemberId());

		return favorites;
	}

	/**
	 * 添加我的收藏
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/favorites/{goodsId}", method = RequestMethod.POST)
	public void addGoodsToFavorites(@PathVariable int goodsId)
			throws BusinessErrorException {
		ShoppingFavorite favorite = favoriteDao
				.findByStoreIdAndMemberIdAndGoodsId(getStoreId(),
						getMemberId(), goodsId);

		if (favorite == null) {
			// 商品信息
			favorite = new ShoppingFavorite();
			
			StoreGood goodItem = goodsDao.findOne(goodsId);
			BeanUtils.copyProperties(goodItem, favorite);

			Date now = new Date();
			favorite.setStoreId(getStoreId());
			favorite.setMemberId(getMemberId());
			favorite.setGoodsType(Constants.GOODS_TYPE_DEFAULT);
			favorite.setGoodsPrice(goodItem.getGoodsSellprice());
			favorite.setInsDate(now);
			favorite.setUpdDate(now);

			favoriteDao.save(favorite);
		} else {
			throw new BusinessErrorException(ErrorCodes.ALREADY_COLLECTED,
					"此宝贝已经收藏");
		}
	}

	/**
	 * 删除我的收藏
	 */
	@RequestMapping(value = "/favorites/{goodsId}", method = RequestMethod.DELETE)
	public void deleteGoodsFromFavorites(@PathVariable int goodsId) {

		ShoppingFavorite favorite = favoriteDao
				.findByStoreIdAndMemberIdAndGoodsId(getStoreId(),
						getMemberId(), goodsId);

		if (favorite != null) {
			favoriteDao.delete(favorite);
		}
	}
}
