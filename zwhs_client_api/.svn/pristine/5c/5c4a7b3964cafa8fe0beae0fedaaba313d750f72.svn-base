package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.bean.OrderCoupon;
import cn.org.citycloud.zwhs.entity.WechatMemberCoupon;

public interface WechatMemberCouponDao extends JpaRepository<WechatMemberCoupon, Integer>, JpaSpecificationExecutor<WechatMemberCoupon> {

	
	public long countByCouponIdAndMemberIdAndStoreId(int couponId, int memberId, int storeId);
	
	public List<WechatMemberCoupon> findByMemberIdAndStoreId(int memberId, int storeId);
	
	public WechatMemberCoupon findByIdAndMemberIdAndStoreId(int id, int memberId, int storeId);
	
	@Query(value="SELECT A.id,B.coupon_name FROM wechat_member_coupon A "
			+ " LEFT JOIN store_coupon B ON A.coupon_id = B.coupon_id "
			+ " WHERE "
			+ " A.member_id = ?1 "
			+ " AND A.store_id = ?2 "
			+ " AND B.coupon_condition < ?3 "
			+ " AND A.is_used = 10 "
			+ " AND B.coupon_status = 10 "
			+ " AND B.effective_time < now() "
			+ " AND B.expiration_time > now() " , nativeQuery = true)
	public List<Object> getOrderCoupon(int memberId, int storeId, int goodsAmount);
	
}
