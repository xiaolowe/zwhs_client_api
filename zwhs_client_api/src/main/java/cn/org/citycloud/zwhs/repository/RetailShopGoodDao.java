package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.entity.RetailShopGood;

public interface RetailShopGoodDao extends JpaRepository<RetailShopGood, Integer>, JpaSpecificationExecutor<RetailShopGood> {

	public RetailShopGood findByGoodsIdAndMemberId(int goodsId, int memberId);
	
	// 分销全部商品
	public long countAllDistGoodsByMemberId(int memberId);
	
	// 分销上新商品(7天内上架)
	public long countNewDistGoodsByMemberId(int memberId);
	
	// 分销全部商品上下架数量
	@Query(value="SELECT count(1) FROM retail_shop_goods a WHERE a.member_id = ?1 AND a.status = ?2", nativeQuery = true)
	public long countByMemberIdAndStatus(int memberId, int status);
	
}
