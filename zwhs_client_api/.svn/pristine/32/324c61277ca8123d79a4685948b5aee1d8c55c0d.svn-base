package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.entity.WechatMemberAddr;

public interface WechatMemberAddrDao extends JpaRepository<WechatMemberAddr, Integer>, JpaSpecificationExecutor<WechatMemberAddr> {

	@Query(value = "SELECT * FROM wechat_member_addr WHERE member_id = ?1 limit 1", nativeQuery = true)
	public WechatMemberAddr findByMemberId(int memberId);
}
