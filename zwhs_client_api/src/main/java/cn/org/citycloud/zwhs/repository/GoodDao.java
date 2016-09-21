package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.entity.GoodsClass;

/**
 * GoodDao
 *
 */
public interface GoodDao extends PagingAndSortingRepository<GoodsClass, Integer> , JpaRepository<GoodsClass, Integer>, JpaSpecificationExecutor<GoodsClass> {

	@Query(value = "SELECT * FROM goods_class ", nativeQuery = true)
	public List<GoodsClass> findGoodClass();
	
}
