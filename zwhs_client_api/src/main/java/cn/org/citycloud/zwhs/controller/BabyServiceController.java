package cn.org.citycloud.zwhs.controller;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.bean.ServiceSearch;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.core.BaseController;
import cn.org.citycloud.zwhs.entity.ServiceInfo;
import cn.org.citycloud.zwhs.entity.ServiceStore;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.ServiceInfoDao;
import cn.org.citycloud.zwhs.repository.ServiceStoreDao;

/**
 * 宝宝服务 API
 * 
 * @author lanbo
 *
 */
@RestController
public class BabyServiceController extends BaseController
{
    
    @Autowired
    private ServiceInfoDao serviceDao;
    
    @Autowired
    private ServiceStoreDao serviceStoreDao;
    
    /**
     * 母婴店上架服务列表
     * 
     */
    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public Object getBabyServiceList(@Valid ServiceSearch search)
        throws Exception
    {
        
        // 分页排序
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // 分页
        Pageable pageable = new PageRequest(search.getPage() - 1, search.getSize(), sort);
        
        // 查询构造器
        Specification<ServiceStore> spec = new Specification<ServiceStore>()
        {
            
            @Override
            public Predicate toPredicate(Root<ServiceStore> root, CriteriaQuery<?> query, CriteriaBuilder cb)
            {
                Predicate predicate = cb.conjunction();
                
                // 服务商ID
                Path<Integer> storeId = root.get("storeId");
                predicate = cb.and(predicate, cb.equal(storeId, getStoreId()));
                
                // 服务状态
                Path<Integer> serviceState = root.get("serviceState");
                predicate = cb.and(predicate, cb.equal(serviceState, Constants.SERVICE_STATE_NORMAL));
                
                // 审核状态
                Path<Integer> serviceVerify = root.get("serviceVerify");
                predicate = cb.and(predicate, cb.equal(serviceVerify, Constants.SERVICE_VERIFY_PASS));
                
                return query.where(predicate).getRestriction();
            }
            
        };
        return serviceStoreDao.findAll(spec, pageable);
        
    }
    
    /**
     * 母婴店上架服务详情
     */
    @RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
    public Object getBabyService(@PathVariable int id)
        throws Exception
    {
        
        // 母婴店服务信息
        ServiceStore serviceStoreInfo = serviceStoreDao.findByServiceIdAndStoreId(id, getStoreId());
        
        if (serviceStoreInfo == null)
        {
            
            throw new BusinessErrorException(ErrorCodes.SERVICE_CODE_ERROR, "店铺服务不存在或者已经下架。");
        }
        
        // 店铺服务状态
        if (Constants.SERVICE_VERIFY_NOTPASS == serviceStoreInfo.getServiceVerify()
            || Constants.SERVICE_STATE_NORMAL != serviceStoreInfo.getServiceState())
        {
            
            throw new BusinessErrorException(ErrorCodes.SERVICE_CODE_ERROR, "店铺服务不存在或者已经下架。");
        }
        
        // 服务信息
        ServiceInfo serviceInfo = serviceDao.findOne(serviceStoreInfo.getServiceId());
        
        if (serviceInfo == null)
        {
            throw new BusinessErrorException(ErrorCodes.SERVICE_CODE_ERROR, "店铺服务不存在或者已经下架。");
        }
        
        // 服务状态
        if (Constants.SERVICE_VERIFY_NOTPASS == serviceInfo.getServiceVerify()
            || Constants.SERVICE_STATE_NORMAL != serviceInfo.getServiceState())
        {
            
            throw new BusinessErrorException(ErrorCodes.SERVICE_CODE_ERROR, "店铺服务不存在或者已经下架。");
        }
        
        return serviceStoreInfo;
    }
    
}
