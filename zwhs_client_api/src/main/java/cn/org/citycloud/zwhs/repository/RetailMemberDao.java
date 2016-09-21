package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.RetailMember;

public interface RetailMemberDao extends JpaRepository<RetailMember, Integer>, JpaSpecificationExecutor<RetailMember> {

	
}
