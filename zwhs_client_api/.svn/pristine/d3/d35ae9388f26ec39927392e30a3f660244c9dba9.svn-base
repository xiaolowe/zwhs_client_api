package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.ShoppingCart;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer>, JpaSpecificationExecutor<ShoppingCart> {

	// 购物车所有商品
	public List<ShoppingCart> findByStoreIdAndMemberId(int store_id, int member_id);
	
	// 购物车商品
	public ShoppingCart findByStoreIdAndMemberIdAndGoodsId(int store_id, int member_id, int goods_Id);
	
	// 购物车商品
	public ShoppingCart findByIdAndStoreIdAndMemberId(int id, int store_id, int member_id);
	
}

