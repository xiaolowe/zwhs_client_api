package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.StoreMember;

public interface StoreMemberDao extends JpaRepository<StoreMember, Integer>, JpaSpecificationExecutor<StoreMember> {

	public StoreMember findByStoreIdAndOpenId(int store_id, String open_id);
	
}
