package cn.org.citycloud.zwhs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.entity.StoreCoupon;
import cn.org.citycloud.zwhs.entity.WechatMemberCoupon;
import cn.org.citycloud.zwhs.repository.StoreCouponDao;
import cn.org.citycloud.zwhs.repository.WechatMemberCouponDao;

/**
 * 优惠劵服务
 * 
 * @author lanbo
 *
 */
@Component
@Transactional
public class CouponService {
	
	@Autowired
	private StoreCouponDao storeCouponDao;

	@Autowired
	private WechatMemberCouponDao memberCouponDao;
	
	/**
	 * 用户领取优惠劵
	 * @param coupon
	 */
	public void addMemberCoupon(WechatMemberCoupon coupon) {
		
		StoreCoupon storeCoupon = storeCouponDao.findOne(coupon.getCouponId());
		storeCoupon.setCouponAmount(storeCoupon.getCouponAmount() + 1);
		storeCoupon.setUpdDate(coupon.getUpdDate());
		
		storeCouponDao.save(storeCoupon);
		
		memberCouponDao.save(coupon);
	}
	
}
