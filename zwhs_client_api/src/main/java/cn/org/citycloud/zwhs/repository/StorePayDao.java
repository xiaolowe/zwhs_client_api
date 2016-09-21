package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.StorePay;

public interface StorePayDao extends JpaRepository<StorePay, Integer>, JpaSpecificationExecutor<StorePay> {

	
}
