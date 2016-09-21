package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.StoreCoupon;

public interface StoreCouponDao extends JpaRepository<StoreCoupon, Integer>, JpaSpecificationExecutor<StoreCoupon> {

	public List<StoreCoupon> findByStoreId(int storeId);
}
