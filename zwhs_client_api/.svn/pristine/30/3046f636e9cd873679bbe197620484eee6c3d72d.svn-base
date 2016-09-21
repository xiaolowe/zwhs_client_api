package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.WechatMember;

/**
 * 微信会员信息Dao
 * @author lanbo
 *
 */
public interface WechatMemberDao extends JpaRepository<WechatMember, Integer>, JpaSpecificationExecutor<WechatMember> {
	
	
	public WechatMember findByOpenId(String openId);
	
}
