package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.Store;

public interface StoreDao extends JpaRepository<Store, Integer>, JpaSpecificationExecutor<Store> {

	
	Store findByretailCode(String retailCode);
}
