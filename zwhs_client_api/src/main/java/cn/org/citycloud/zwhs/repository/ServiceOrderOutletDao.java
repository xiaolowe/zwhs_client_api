/*
 * 文 件 名:  ServiceOrderOutletDao.java
 * 版    权:  CCDC Copyright 2016,  All rights reserved
 * 描    述:  服务商平台
 * 修 改 人:  Lanbo
 * 创建时间:  2016年1月28日
 */
package cn.org.citycloud.zwhs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.entity.ServiceOrderOutlet;

/**
 * 服务订单网点
 * 
 * @author lanbo
 * @version [V1.0, 2016年1月28日]
 * @since [B2C/V1.0]
 */
public interface ServiceOrderOutletDao extends JpaRepository<ServiceOrderOutlet, Integer>,
    JpaSpecificationExecutor<ServiceOrderOutlet>
{
    
}
