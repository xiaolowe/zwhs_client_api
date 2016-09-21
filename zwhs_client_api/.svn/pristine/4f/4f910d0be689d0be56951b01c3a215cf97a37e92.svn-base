package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.GoodsClass;

public interface GoodsClassDao extends JpaRepository<GoodsClass, Integer>, JpaSpecificationExecutor<GoodsClass> {

	
	public List<GoodsClass> findByGcParentIdOrderByGcSort(int gcParentId);
	
	
}
