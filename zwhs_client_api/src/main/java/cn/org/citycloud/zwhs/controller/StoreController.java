package cn.org.citycloud.zwhs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.bean.StoreInfo;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.entity.Store;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.StoreDao;

/**
 * 门店相关API
 * @author lanbo
 *
 */
@Controller
public class StoreController {
	
	@Autowired
	private StoreDao storeDao;
	

	/**
	 * 获取店铺信息
	 * @throws BusinessErrorException 
	 */
	@RequestMapping(value = "/store/{store_id}", method = RequestMethod.GET)
	@ResponseBody()
	public Object getStoreInfo(@PathVariable int store_id) throws Exception {
		
		Store store = storeDao.findOne(store_id);
		
		if(store == null) {
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "此店铺信息不存在！");
		}
		
		StoreInfo info = new StoreInfo();
		info.setCompanyAddress(store.getCompanyAddress());
		info.setCompanyName(store.getCompanyName());
		info.setContent(store.getContent());
		info.setStoreAliasName(store.getStoreAliasName());
		info.setStoreId(store.getStoreId());
		info.setStoreImage(store.getStoreImage());
		info.setStoreOwner(store.getStoreOwner());
		info.setUserPhone(store.getUserPhone());
		info.setStoreState(store.getStoreState());
		
		return info;
	}
	
	/**
	 * 更新店铺模板信息
	 * @throws Exception 
	 */
//	@RequestMapping(value = "/store/{store_id}", method = RequestMethod.PUT)
//	@ResponseBody()
//	public Object updateStoreInfo(@PathVariable int store_id, @RequestBody String content) throws Exception {
//		
//		Store store = storeDao.findOne(store_id);
//		
//		if(store == null) {
//			throw new BusinessErrorException(ErrorCodes.NO_DATA, "此店铺信息不存在！");
//		}
//		
//		store.setContent(content);
//		store.setUpdDate(new Date());
//		storeDao.save(store);
//		
//		StoreInfo info = new StoreInfo();
//		info.setCompanyAddress(store.getCompanyAddress());
//		info.setCompanyName(store.getCompanyName());
//		info.setContent(store.getContent());
//		info.setStoreAliasName(store.getStoreAliasName());
//		info.setStoreId(store.getStoreId());
//		info.setStoreImage(store.getStoreImage());
//		info.setStoreOwner(store.getStoreOwner());
//		info.setUserPhone(store.getUserPhone());
//		
//		return info;
//	}
	
}
