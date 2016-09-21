package cn.org.citycloud.zwhs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.entity.StoreGood;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.StoreGoodsDao;

/**
 * 商品详情
 * @author lanbo
 *
 */
@Controller
public class GoodsDetailController {
	
	@Autowired
	private StoreGoodsDao storeGoodsDao;

	/**
	 * 商品详情
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
	@ResponseBody()
	public Object getBabyGoodsDetail(@PathVariable int id) throws Exception {
		
		StoreGood good = storeGoodsDao.findOne(id);
		
		if(good == null) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "此商品不存在!");
		}
		
		return good;
	}
}
