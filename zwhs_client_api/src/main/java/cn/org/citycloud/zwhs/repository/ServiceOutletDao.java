/*
 * 文 件 名:  ServiceOutletDao.java
 * 版    权:  CCDC Copyright 2016,  All rights reserved
 * 描    述:  服务商平台
 * 修 改 人:  Lanbo
 * 创建时间:  2016年1月28日
 */
package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.ServiceOutlet;

/**
 * <一句话功能简述>
 * 
 * @author lanbo
 * @version [V1.0, 2016年1月28日]
 * @since [B2C/V1.0]
 */
public interface ServiceOutletDao extends JpaRepository<ServiceOutlet, Integer>,
    JpaSpecificationExecutor<ServiceOutlet>
{
    
}
