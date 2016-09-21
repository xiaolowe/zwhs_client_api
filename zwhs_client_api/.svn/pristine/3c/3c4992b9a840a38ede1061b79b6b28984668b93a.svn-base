package cn.org.citycloud.zwhs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.ServiceStore;

public interface ServiceStoreDao extends JpaRepository<ServiceStore, Integer>, JpaSpecificationExecutor<ServiceStore>
{
    
    public long countByStoreId(int store_id);
    
    public ServiceStore findByStoreId(int store_id);
    
    public ServiceStore findByIdAndStoreId(int id, int storeId);
    
    public ServiceStore findByServiceIdAndStoreId(int serviceId, int storeId);
    
    public List<ServiceStore> findByStoreIdAndServiceStateAndServiceVerify(int storeId, int serviceState,
        int serviceVerify);
    
}
