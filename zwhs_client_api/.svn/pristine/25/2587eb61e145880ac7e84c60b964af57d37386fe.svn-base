package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.ShoppingFavorite;

public interface ShoppingFavoriteDao extends JpaRepository<ShoppingFavorite, Integer>, JpaSpecificationExecutor<ShoppingFavorite> {

	public List<ShoppingFavorite> findByStoreIdAndMemberIdOrderByInsDateDesc(int storeId, int memberId);
	
	public ShoppingFavorite findByStoreIdAndMemberIdAndGoodsId(int storeId, int memberId, int goodsId);
	
}
