package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.RetailShop;

public interface RetailShopDao extends JpaRepository<RetailShop, Integer>, JpaSpecificationExecutor<RetailShop> {

	RetailShop findByMemberId(int memberId);
}
