package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.entity.RegionInfo;

public interface RegionInfoDao extends JpaRepository<RegionInfo, Integer>, JpaSpecificationExecutor<RegionInfo> {

	public long countByRegionCode(int regionCode);
	
	List<RegionInfo> findByRegionLevel(int regionlevel);
	
	@Query(value="select * from region_info a where a.region_code like ?1% and a.region_level = ?2", nativeQuery = true)
	List<RegionInfo> findCityOrAreaRegionCode(int regioncode, int regionlevel);
	
	RegionInfo findByRegionCode(int regionCode);
}
