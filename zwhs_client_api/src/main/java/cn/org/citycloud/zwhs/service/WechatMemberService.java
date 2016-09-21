package cn.org.citycloud.zwhs.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.entity.StoreMember;
import cn.org.citycloud.zwhs.entity.WechatMember;
import cn.org.citycloud.zwhs.repository.StoreMemberDao;
import cn.org.citycloud.zwhs.repository.WechatMemberDao;

@Component
@Transactional
public class WechatMemberService {
	
	@Autowired
	private WechatMemberDao wcmemberDao;
	
	@Autowired
	private StoreMemberDao smemberDao;
	
	/**
	 * 根据OpenId获取母婴店会员信息
	 */
	public WechatMember getWechatMember(String openId) {
		
		return wcmemberDao.findByOpenId(openId);
		
	}
	
	/**
	 * 新建母婴店会员信息
	 */
	public WechatMember addWechatMember(WechatMember member, int store_id) {
		String openId = member.getOpenId();
		
		wcmemberDao.save(member);
		
		// 获取新增的会员信息
		WechatMember newMember = wcmemberDao.findByOpenId(openId);
		
		StoreMember storeMember = smemberDao.findByStoreIdAndOpenId(store_id, openId);
		
		if(storeMember == null) {
			StoreMember entity = new StoreMember();
			entity.setMemberId(newMember.getMemberId());
			entity.setStoreId(store_id);
			entity.setOpenId(openId);
			entity.setInsDate(new Date());
			
			smemberDao.save(entity);
		}
		
		return newMember;
	}

}
