package cn.org.citycloud.zwhs.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.entity.StoreOrder;

public interface StoreOrderDao extends JpaRepository<StoreOrder, Integer>, JpaSpecificationExecutor<StoreOrder> {
	
	public StoreOrder findByOrderIdAndStoreIdAndMemberId(int id, int storeId, int memberId);

	public List<StoreOrder> findByStoreIdAndMemberIdAndOrderStatusOrderByInsDateDesc(int storeId, int memberId, int status);
	
	public List<StoreOrder> findByStoreIdAndMemberIdOrderByInsDateDesc(int storeId, int memberId);
	
	public long countByStoreIdAndMemberId(int storeId, int memberId);
	
	@Query(value = "SELECT order_status FROM store_order WHERE store_id = ?1 AND member_id = ?2", nativeQuery = true)
	public List<Byte> countOrderStatus(int store_id, int member_id);
	
	// 分销信息
	public List<StoreOrder> findByRetailMemberIdAndMemberIdAndIsRetailOrderByInsDateDesc(int storeId, int memberId, int isReetail);
	
	public List<StoreOrder> findByRetailMemberIdAndMemberIdAndOrderStatusAndIsRetailOrderByInsDateDesc(int storeId, int memberId, int status, int isRetail);
	
	@Query(value="select sum(o.retail_amount) retailAmount from store_order o where date(o.pay_time) = curdate() and o.retail_member_id=?1 and o.member_id=?2 and o.is_retail=1 and o.order_status >10", nativeQuery = true)
	BigDecimal findTodayOrderMoney(int retailMemberId, int memberId);
	
	public StoreOrder findByOrderIdAndRetailMemberIdAndMemberId(int id, int retailMemberId, int memberId);
}
