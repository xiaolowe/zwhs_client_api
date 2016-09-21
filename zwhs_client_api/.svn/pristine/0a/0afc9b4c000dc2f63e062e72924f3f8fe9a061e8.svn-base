package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.StoreServiceOrder;


public interface StoreServiceOrderDao extends JpaRepository<StoreServiceOrder, Integer>, JpaSpecificationExecutor<StoreServiceOrder> {

	public StoreServiceOrder findByOrderIdAndStoreIdAndMemberId(int id, int storeId, int memberId);
	
	public List<StoreServiceOrder> findByStoreIdAndMemberIdAndOrderStatusOrderByInsDateDesc(int storeId, int memberId, int status);
	
	public List<StoreServiceOrder> findByStoreIdAndMemberIdOrderByInsDateDesc(int storeId, int memberId);
	
}
