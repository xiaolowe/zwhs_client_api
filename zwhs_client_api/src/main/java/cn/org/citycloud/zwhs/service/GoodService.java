package cn.org.citycloud.zwhs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.entity.GoodsClass;
import cn.org.citycloud.zwhs.repository.GoodDao;


//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class GoodService {
	@Autowired
	private GoodDao goodDao;
	
	
	public Iterable<GoodsClass> getGoods(Pageable pageable) {
       Page<GoodsClass> goodClass = goodDao.findAll(pageable);
       return goodClass;
	}
	
}
