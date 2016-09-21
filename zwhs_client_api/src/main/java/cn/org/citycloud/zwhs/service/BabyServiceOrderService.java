package cn.org.citycloud.zwhs.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.bean.OrderCancel;
import cn.org.citycloud.zwhs.bean.ServicePreOrder;
import cn.org.citycloud.zwhs.constants.Constants;
import cn.org.citycloud.zwhs.constants.ErrorCodes;
import cn.org.citycloud.zwhs.entity.RegionInfo;
import cn.org.citycloud.zwhs.entity.ServiceInfo;
import cn.org.citycloud.zwhs.entity.ServiceOrderOutlet;
import cn.org.citycloud.zwhs.entity.ServiceOutlet;
import cn.org.citycloud.zwhs.entity.ServiceStore;
import cn.org.citycloud.zwhs.entity.Store;
import cn.org.citycloud.zwhs.entity.StoreServiceOrder;
import cn.org.citycloud.zwhs.entity.WechatMember;
import cn.org.citycloud.zwhs.entity.WechatMemberAddr;
import cn.org.citycloud.zwhs.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.repository.RegionInfoDao;
import cn.org.citycloud.zwhs.repository.ServiceInfoDao;
import cn.org.citycloud.zwhs.repository.ServiceOrderOutletDao;
import cn.org.citycloud.zwhs.repository.ServiceOutletDao;
import cn.org.citycloud.zwhs.repository.ServiceStoreDao;
import cn.org.citycloud.zwhs.repository.StoreDao;
import cn.org.citycloud.zwhs.repository.StoreServiceOrderDao;
import cn.org.citycloud.zwhs.repository.WechatMemberAddrDao;
import cn.org.citycloud.zwhs.repository.WechatMemberDao;

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class BabyServiceOrderService
{
    
    @Autowired
    private WechatMemberDao wcmemberDao;
    
    @Autowired
    private StoreDao storeDao;
    
    @Autowired
    private StoreServiceOrderDao serviceOrderDao;
    
    @Autowired
    private WechatMemberAddrDao memberAddrDao;
    
    @Autowired
    private ServiceInfoDao serviceDao;
    
    @Autowired
    private ServiceStoreDao serviceStoreDao;
    
    @Autowired
    private RegionInfoDao reginDao;
    
    @Autowired
    private ServiceOrderOutletDao orderOutletDao;
    
    @Autowired
    private ServiceOutletDao serviceOutletDao;
    
    /**
     * 根据订单号 获取订单信息
     * 
     * @param orderId
     * @return
     */
    public StoreServiceOrder findStoreOrderById(int orderId)
    {
        
        return serviceOrderDao.findOne(orderId);
    }
    
    /**
     * 用户订单信息
     * 
     * @param orderId
     * @return
     */
    public StoreServiceOrder findStoreOrderById(int storeId, int memberId, int orderId)
    {
        
        return serviceOrderDao.findOne(orderId);
    }
    
    /**
     * 根据订单号 获取订单状态 获取订单信息
     * 
     * @param orderId
     * @return
     */
    public List<StoreServiceOrder> findStoreOrderList(int storeId, int memberId, int status)
    {
        List<StoreServiceOrder> orderList = null;
        if (99 == status)
        {
            orderList = serviceOrderDao.findByStoreIdAndMemberIdOrderByInsDateDesc(storeId, memberId);
        }
        else
        {
            orderList =
                serviceOrderDao.findByStoreIdAndMemberIdAndOrderStatusOrderByInsDateDesc(storeId, memberId, status);
        }
        
        if (orderList.size() == 0)
        {
            return null;
        }
        
        return orderList;
    }
    
    /**
     * 订单详情
     * 
     * @param storeId
     * @param memberId
     * @param id
     * @return
     */
    public StoreServiceOrder findStoreOrder(int id, int storeId, int memberId)
    {
        
        StoreServiceOrder order = serviceOrderDao.findByOrderIdAndStoreIdAndMemberId(id, storeId, memberId);
        
        return order;
    }
    
    /**
     * 取消订单
     * 
     * @throws BusinessErrorException
     */
    public void cancelOrder(int orderId, int storeId, int memberId, OrderCancel cancel)
        throws BusinessErrorException
    {
        
        StoreServiceOrder order = serviceOrderDao.findByOrderIdAndStoreIdAndMemberId(orderId, storeId, memberId);
        
        if (order == null)
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单不存在！");
        
        // 已经付款的订单无法取消
        if (Constants.SERVICE_ORDER_DEFAULT != order.getOrderStatus())
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "已经付款的订单无法取消！");
        }
        
        // 取消订单理由
        if (cancel != null && StringUtils.isNotEmpty(cancel.getCancelReason()))
        {
            order.setRemark(cancel.getCancelReason());
        }
        order.setOrderStatus(Constants.SERVICE_ORDER_CANCELD);
        order.setUpdDate(new Date());
        
        serviceOrderDao.save(order);
    }
    
    /**
     * 确认收货
     * 
     * @throws BusinessErrorException
     */
    public void confirmOrder(int orderId, int storeId, int memberId)
        throws BusinessErrorException
    {
        
        StoreServiceOrder order = serviceOrderDao.findByOrderIdAndStoreIdAndMemberId(orderId, storeId, memberId);
        
        if (order == null)
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此订单不存在！");
        if (Constants.ORDER_STATUS_PAYED == order.getOrderStatus())
        {
            Date now = new Date();
            order.setOrderStatus(Constants.SERVICE_ORDER_USED);
            order.setFinishTime(now);
            order.setUpdDate(now);
            
            serviceOrderDao.save(order);
        }
        else
        {
            throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "此服务订单无法确认完成！");
        }
    }
    
    /**
     * 生成服务预订单信息
     * 
     * @throws BusinessErrorException
     */
    public StoreServiceOrder generateServiceOrder(ServicePreOrder order, int storeId, int memberId)
        throws BusinessErrorException
    {
        
        // 店铺信息
        Store store = storeDao.findOne(storeId);
        if (Constants.STORE_STATE_OPEN != store.getStoreState())
        {
            throw new BusinessErrorException(ErrorCodes.WRONG_STORE, "此门店不存在！");
        }
        
        // 会员信息
        WechatMember member = wcmemberDao.getOne(memberId);
        if (Constants.MEMBER_STATE_CLOSED == member.getMemberState())
        {
            throw new BusinessErrorException(ErrorCodes.WRONG_MEMBER, "此会员已经被禁用！");
        }
        
        // 校验服务信息是否可用 start
        // 母婴店服务信息
        ServiceStore serviceStoreInfo = serviceStoreDao.findByServiceIdAndStoreId(order.getServiceId(), storeId);
        
        if (serviceStoreInfo == null)
        {
            
            throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "店铺服务不存在或者已经下架。");
        }
        
        // 店铺服务状态
        if (Constants.SERVICE_VERIFY_NOTPASS == serviceStoreInfo.getServiceVerify()
            || Constants.SERVICE_STATE_NORMAL != serviceStoreInfo.getServiceState())
        {
            
            throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "店铺服务不存在或者已经下架。");
        }
        
        ServiceInfo serviceInfo = serviceDao.findOne(order.getServiceId());
        if (serviceInfo == null)
        {
            throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "店铺服务不存在或者已经下架。");
        }
        
        // 服务状态
        if (Constants.SERVICE_VERIFY_NOTPASS == serviceInfo.getServiceVerify()
            || Constants.SERVICE_STATE_NORMAL != serviceInfo.getServiceState())
        {
            
            throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "店铺服务不存在或者已经下架。");
        }
        
        // 校验服务信息是否可用 end
        
        // 生成时间
        Date now = new Date();
        
        StoreServiceOrder preOrder = new StoreServiceOrder();
        preOrder.setServiceId(order.getServiceId());
        // 订单生成时间
        preOrder.setAddTime(now);
        
        // 到店服务 无需地址信息
        if (Constants.SERVICE_TYPE_CALL == serviceInfo.getType())
        {
            
            if (order.getRegionCode() == 0)
            {
                throw new BusinessErrorException(ErrorCodes.ORDER_ERROR, "上门服务地址没有选择。");
            }
            
            // 收货地址信息
            preOrder.setRegionCode(order.getRegionCode());
            
            // 地址码
            long countRegin = reginDao.countByRegionCode(order.getRegionCode());
            
            // 如果此区县码 不在系统库中，追加此地址码
            if (countRegin == 0L)
            {
                
                RegionInfo region = new RegionInfo();
                region.setRegionCode(order.getRegionCode());
                region.setRegionName(order.getRegionAreaName());
                region.setRegionLevel(3);
                
                reginDao.save(region);
            }
            
            String reginCode = String.valueOf(order.getRegionCode());
            int reginProv = Integer.parseInt(reginCode.substring(0, 2) + "0000");
            int regionCity = Integer.parseInt(reginCode.substring(0, 4) + "00");
            // 省
            preOrder.setRegionProv(reginProv);
            // 市
            preOrder.setRegionCity(regionCity);
            
            preOrder.setContactsName(order.getContactsName());
            preOrder.setContactsPhone(order.getContactsPhone());
            preOrder.setContactsAddress(order.getContactsAddress());
            preOrder.setPostCode(order.getPostCode());
            preOrder.setRegionProvName(order.getRegionProvName());
            preOrder.setRegionCityName(order.getRegionCityName());
            preOrder.setRegionAreaName(order.getRegionAreaName());
            
            WechatMemberAddr memberAddr = memberAddrDao.findByMemberId(memberId);
            
            // 插入微信用户收货地址信息
            if (memberAddr == null)
            {
                WechatMemberAddr newAddr = new WechatMemberAddr();
                newAddr.setMemberId(memberId);
                newAddr.setRegionCode(order.getRegionCode());
                newAddr.setContactsName(order.getContactsName());
                newAddr.setContactsPhone(order.getContactsPhone());
                newAddr.setContactsAddress(order.getContactsAddress());
                newAddr.setPostCode(order.getPostCode());
                newAddr.setRegionProvName(order.getRegionProvName());
                newAddr.setRegionCityName(order.getRegionCityName());
                newAddr.setRegionAreaName(order.getRegionAreaName());
                newAddr.setInsDate(now);
                newAddr.setUpdDate(now);
                
                memberAddrDao.save(newAddr);
            }
            else
            {
                // 更新微信用户收货地址信息
                if (!order.getContactsAddress().equals(memberAddr.getContactsAddress()))
                {
                    memberAddr.setRegionCode(order.getRegionCode());
                    memberAddr.setContactsName(order.getContactsName());
                    memberAddr.setContactsPhone(order.getContactsPhone());
                    memberAddr.setContactsAddress(order.getContactsAddress());
                    memberAddr.setPostCode(order.getPostCode());
                    memberAddr.setRegionProvName(order.getRegionProvName());
                    memberAddr.setRegionCityName(order.getRegionCityName());
                    memberAddr.setRegionAreaName(order.getRegionAreaName());
                    memberAddr.setUpdDate(now);
                    
                    memberAddrDao.save(memberAddr);
                }
            }
        }
        
        // 门店
        preOrder.setStoreId(storeId);
        preOrder.setProviderId(serviceInfo.getProviderId());
        
        preOrder.setServiceName(serviceInfo.getServiceName());
        
        // 分成
        preOrder.setProviderRates(serviceInfo.getProviderRates());
        preOrder.setStoreRates(serviceInfo.getStoreRates());
        preOrder.setCommisRates(serviceInfo.getCommisRates());
        
        if (StringUtils.isEmpty(store.getCompanyName()))
        {
            preOrder.setCompanyName(store.getStoreAliasName());
        }
        else
        {
            preOrder.setCompanyName(store.getCompanyName());
        }
        
        // 会员信息
        preOrder.setMemberId(memberId);
        if (StringUtils.isNotEmpty(member.getMemberTruename()))
        {
            preOrder.setMemberTruename(member.getMemberTruename());
        }
        else
        {
            preOrder.setMemberTruename(member.getWechatAliasname());
        }
        preOrder.setMenberPhone(member.getMemberPhone());
        
        // 订单状态
        preOrder.setOrderStatus(Constants.ORDER_STATUS_DEFAULT);
        preOrder.setOrderType(Constants.ORDER_TYPE_SERVICE);
        
        // 服务时间
        preOrder.setVisitTime(order.getVisitTime());
        
        preOrder.setInsDate(now);
        preOrder.setUpdDate(now);
        
        // 订单金额计算
        // 服务金额
        preOrder.setServicePrice(serviceInfo.getServicePrice());
        // 服务人数
        preOrder.setServiceNum(order.getPeopleNumber());
        
        // 服务类型
        preOrder.setServiceType(serviceInfo.getType());
        
        // 商品总价格
        BigDecimal goodsAmount = BigDecimal.ZERO;
        
        // 订单总价格
        BigDecimal orderAmount = BigDecimal.ZERO;
        
        // 服务价格
        goodsAmount = serviceInfo.getServicePrice().multiply(new BigDecimal(preOrder.getServiceNum()));
        
        // 佣金比例
        BigDecimal commisRates = BigDecimal.ZERO;
        if (preOrder.getCommisRates() != null)
        {
            commisRates = preOrder.getCommisRates();
        }
        
        // 母婴店营收
        BigDecimal storeAmount = BigDecimal.ZERO;
        
        // 服务商营收
        BigDecimal providerAmount = BigDecimal.ZERO;
        
        // 平台分成金额
        BigDecimal commisAmount = BigDecimal.ZERO;
        
        // 保存预订单
        preOrder.setGoodsAmount(goodsAmount);
        
        // 订单金额
        orderAmount = goodsAmount;
        preOrder.setOrderAmount(orderAmount);
        
        // 计算服务佣金 无佣金
        if (BigDecimal.ZERO.compareTo(commisRates) == 0)
        {
            providerAmount = orderAmount;
        }
        else
        {
            // 有佣金
            // 服务商营收
            providerAmount =
                orderAmount.multiply(preOrder.getProviderRates())
                    .divide(new BigDecimal(100))
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            
            // 平台分成金额
            commisAmount =
                orderAmount.multiply(commisRates).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
            
            // 母婴店营收
            storeAmount = orderAmount.subtract(providerAmount).subtract(commisAmount);
        }
        
        // 设置服务商营收
        preOrder.setProviderAmount(providerAmount);
        
        // 设置平台分成金额
        preOrder.setCommisAmount(commisAmount);
        // 设置母婴店营收
        preOrder.setStoreAmount(storeAmount);
        
        StoreServiceOrder newOrder = serviceOrderDao.save(preOrder);
        
        // 服务信息 到店服务 服务网点 2016 Add
        if (Constants.SERVICE_TYPE_STORE == serviceInfo.getType())
        {
            // // 检查服务网点信息
            // if (order.getOutletsId() == 0)
            // {
            //
            // throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "店铺服务网点不存在。");
            // }
            
            if (order.getOutletsId() != 0)
            {
                ServiceOutlet outlet = serviceOutletDao.findOne(order.getOutletsId());
                if (outlet.getStatus() == 0)
                {
                    
                    throw new BusinessErrorException(ErrorCodes.WRONG_STORE_SERVICE, "此服务网点已经停止服务了。");
                }
                // 插入订单网点信息
                ServiceOrderOutlet orderOutlet = new ServiceOrderOutlet();
                BeanUtils.copyProperties(outlet, orderOutlet);
                orderOutlet.setOrderId(newOrder.getOrderId());
                orderOutlet.setInsDate(now);
                
                orderOutletDao.save(orderOutlet);
            }
            
        }
        
        return newOrder;
    }
}
