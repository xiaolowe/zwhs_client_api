package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the store_service_order database table.
 * 
 */
@Entity
@Table(name = "store_service_order")
@NamedQuery(name = "StoreServiceOrder.findAll", query = "SELECT s FROM StoreServiceOrder s")
public class StoreServiceOrder implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private int orderId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "add_time", nullable = false)
    private Date addTime;
    
    @Column(name = "commis_amount", precision = 10, scale = 2)
    private BigDecimal commisAmount;
    
    @Column(name = "commis_rates", precision = 10, scale = 2)
    private BigDecimal commisRates;
    
    @Column(name = "company_name", length = 50)
    private String companyName;
    
    @Column(name = "contacts_address", length = 50)
    private String contactsAddress;
    
    @Column(name = "contacts_name", length = 30)
    private String contactsName;
    
    @Column(name = "contacts_phone", length = 11)
    private String contactsPhone;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "finish_time")
    private Date finishTime;
    
    @Column(name = "geval_type")
    private int gevalType;
    
    @Column(name = "goods_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal goodsAmount;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    private Date insDate;
    
    @Column(name = "member_addr_id")
    private int memberAddrId;
    
    @Column(name = "member_id")
    private int memberId;
    
    @Column(name = "member_truename", length = 20)
    private String memberTruename;
    
    @Column(name = "menber_phone", length = 20)
    private String menberPhone;
    
    @Column(name = "order_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal orderAmount;
    
    @Column(name = "order_status", nullable = false)
    private int orderStatus;
    
    @Column(name = "order_type")
    private int orderType;
    
    @Column(name = "pay_code", length = 10)
    private String payCode;
    
    @Column(name = "pay_id")
    private int payId;
    
    @Column(name = "pay_sn")
    private BigInteger paySn;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pay_time")
    private Date payTime;
    
    @Column(name = "post_code", length = 6)
    private String postCode;
    
    @Column(name = "pre_pay", length = 100)
    private String prePay;
    
    @Column(name = "provider_amount", precision = 10, scale = 2)
    private BigDecimal providerAmount;
    
    @Column(name = "provider_id", nullable = false)
    private int providerId;
    
    @Column(name = "provider_rates", precision = 10, scale = 2)
    private BigDecimal providerRates;
    
    @Column(name = "region_area_name", length = 50)
    private String regionAreaName;
    
    @Column(name = "region_city")
    private int regionCity;
    
    @Column(name = "region_city_name", length = 50)
    private String regionCityName;
    
    @Column(name = "region_code")
    private int regionCode;
    
    @Column(name = "region_prov")
    private int regionProv;
    
    @Column(name = "region_prov_name", length = 50)
    private String regionProvName;
    
    @Column(length = 1000)
    private String remark;
    
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    
    @Column(name = "service_name", length = 30)
    private String serviceName;
    
    @Column(name = "service_num")
    private int serviceNum;
    
    @Column(name = "service_price", precision = 10, scale = 2)
    private BigDecimal servicePrice;
    
    @Column(name = "service_type")
    private int serviceType;
    
    @Column(name = "store_amount", precision = 10, scale = 2)
    private BigDecimal storeAmount;
    
    @Column(name = "store_id", nullable = false)
    private int storeId;
    
    @Column(name = "store_rates", precision = 10, scale = 2)
    private BigDecimal storeRates;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "visit_time")
    private Date visitTime;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Set<ServiceOrderCode> serviceOrderCodes;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private ServiceOrderOutlet serviceOrderOutlet;
    
    public StoreServiceOrder()
    {
    }
    
    public int getOrderId()
    {
        return this.orderId;
    }
    
    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }
    
    public Date getAddTime()
    {
        return this.addTime;
    }
    
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }
    
    public BigDecimal getCommisAmount()
    {
        return this.commisAmount;
    }
    
    public void setCommisAmount(BigDecimal commisAmount)
    {
        this.commisAmount = commisAmount;
    }
    
    public BigDecimal getCommisRates()
    {
        return this.commisRates;
    }
    
    public void setCommisRates(BigDecimal commisRates)
    {
        this.commisRates = commisRates;
    }
    
    public String getCompanyName()
    {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    
    public String getContactsAddress()
    {
        return this.contactsAddress;
    }
    
    public void setContactsAddress(String contactsAddress)
    {
        this.contactsAddress = contactsAddress;
    }
    
    public String getContactsName()
    {
        return this.contactsName;
    }
    
    public void setContactsName(String contactsName)
    {
        this.contactsName = contactsName;
    }
    
    public String getContactsPhone()
    {
        return this.contactsPhone;
    }
    
    public void setContactsPhone(String contactsPhone)
    {
        this.contactsPhone = contactsPhone;
    }
    
    public Date getFinishTime()
    {
        return this.finishTime;
    }
    
    public void setFinishTime(Date finishTime)
    {
        this.finishTime = finishTime;
    }
    
    public int getGevalType()
    {
        return this.gevalType;
    }
    
    public void setGevalType(int gevalType)
    {
        this.gevalType = gevalType;
    }
    
    public BigDecimal getGoodsAmount()
    {
        return this.goodsAmount;
    }
    
    public void setGoodsAmount(BigDecimal goodsAmount)
    {
        this.goodsAmount = goodsAmount;
    }
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
    }
    
    public int getMemberAddrId()
    {
        return this.memberAddrId;
    }
    
    public void setMemberAddrId(int memberAddrId)
    {
        this.memberAddrId = memberAddrId;
    }
    
    public int getMemberId()
    {
        return this.memberId;
    }
    
    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }
    
    public String getMemberTruename()
    {
        return this.memberTruename;
    }
    
    public void setMemberTruename(String memberTruename)
    {
        this.memberTruename = memberTruename;
    }
    
    public String getMenberPhone()
    {
        return this.menberPhone;
    }
    
    public void setMenberPhone(String menberPhone)
    {
        this.menberPhone = menberPhone;
    }
    
    public BigDecimal getOrderAmount()
    {
        return this.orderAmount;
    }
    
    public void setOrderAmount(BigDecimal orderAmount)
    {
        this.orderAmount = orderAmount;
    }
    
    public int getOrderStatus()
    {
        return this.orderStatus;
    }
    
    public void setOrderStatus(int orderStatus)
    {
        this.orderStatus = orderStatus;
    }
    
    public int getOrderType()
    {
        return this.orderType;
    }
    
    public void setOrderType(int orderType)
    {
        this.orderType = orderType;
    }
    
    public String getPayCode()
    {
        return this.payCode;
    }
    
    public void setPayCode(String payCode)
    {
        this.payCode = payCode;
    }
    
    public int getPayId()
    {
        return this.payId;
    }
    
    public void setPayId(int payId)
    {
        this.payId = payId;
    }
    
    public BigInteger getPaySn()
    {
        return this.paySn;
    }
    
    public void setPaySn(BigInteger paySn)
    {
        this.paySn = paySn;
    }
    
    public Date getPayTime()
    {
        return this.payTime;
    }
    
    public void setPayTime(Date payTime)
    {
        this.payTime = payTime;
    }
    
    public String getPostCode()
    {
        return this.postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getPrePay()
    {
        return this.prePay;
    }
    
    public void setPrePay(String prePay)
    {
        this.prePay = prePay;
    }
    
    public BigDecimal getProviderAmount()
    {
        return this.providerAmount;
    }
    
    public void setProviderAmount(BigDecimal providerAmount)
    {
        this.providerAmount = providerAmount;
    }
    
    public int getProviderId()
    {
        return this.providerId;
    }
    
    public void setProviderId(int providerId)
    {
        this.providerId = providerId;
    }
    
    public BigDecimal getProviderRates()
    {
        return this.providerRates;
    }
    
    public void setProviderRates(BigDecimal providerRates)
    {
        this.providerRates = providerRates;
    }
    
    public String getRegionAreaName()
    {
        return this.regionAreaName;
    }
    
    public void setRegionAreaName(String regionAreaName)
    {
        this.regionAreaName = regionAreaName;
    }
    
    public int getRegionCity()
    {
        return this.regionCity;
    }
    
    public void setRegionCity(int regionCity)
    {
        this.regionCity = regionCity;
    }
    
    public String getRegionCityName()
    {
        return this.regionCityName;
    }
    
    public void setRegionCityName(String regionCityName)
    {
        this.regionCityName = regionCityName;
    }
    
    public int getRegionCode()
    {
        return this.regionCode;
    }
    
    public void setRegionCode(int regionCode)
    {
        this.regionCode = regionCode;
    }
    
    public int getRegionProv()
    {
        return this.regionProv;
    }
    
    public void setRegionProv(int regionProv)
    {
        this.regionProv = regionProv;
    }
    
    public String getRegionProvName()
    {
        return this.regionProvName;
    }
    
    public void setRegionProvName(String regionProvName)
    {
        this.regionProvName = regionProvName;
    }
    
    public String getRemark()
    {
        return this.remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public int getServiceId()
    {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }
    
    public String getServiceName()
    {
        return this.serviceName;
    }
    
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    
    public int getServiceNum()
    {
        return this.serviceNum;
    }
    
    public void setServiceNum(int serviceNum)
    {
        this.serviceNum = serviceNum;
    }
    
    public BigDecimal getServicePrice()
    {
        return this.servicePrice;
    }
    
    public void setServicePrice(BigDecimal servicePrice)
    {
        this.servicePrice = servicePrice;
    }
    
    public int getServiceType()
    {
        return this.serviceType;
    }
    
    public void setServiceType(int serviceType)
    {
        this.serviceType = serviceType;
    }
    
    public BigDecimal getStoreAmount()
    {
        return this.storeAmount;
    }
    
    public void setStoreAmount(BigDecimal storeAmount)
    {
        this.storeAmount = storeAmount;
    }
    
    public int getStoreId()
    {
        return this.storeId;
    }
    
    public void setStoreId(int storeId)
    {
        this.storeId = storeId;
    }
    
    public BigDecimal getStoreRates()
    {
        return this.storeRates;
    }
    
    public void setStoreRates(BigDecimal storeRates)
    {
        this.storeRates = storeRates;
    }
    
    public Date getUpdDate()
    {
        return this.updDate;
    }
    
    public void setUpdDate(Date updDate)
    {
        this.updDate = updDate;
    }
    
    public Date getVisitTime()
    {
        return this.visitTime;
    }
    
    public void setVisitTime(Date visitTime)
    {
        this.visitTime = visitTime;
    }
    
    /**
     * 获取 serviceOrderCodes
     * 
     * @return 返回 serviceOrderCodes
     */
    public Set<ServiceOrderCode> getServiceOrderCodes()
    {
        return serviceOrderCodes;
    }
    
    /**
     * 设置 serviceOrderCodes
     * 
     * @param 对serviceOrderCodes进行赋值
     */
    public void setServiceOrderCodes(Set<ServiceOrderCode> serviceOrderCodes)
    {
        this.serviceOrderCodes = serviceOrderCodes;
    }
    
    /**
     * 获取 serviceOrderOutlet
     * 
     * @return 返回 serviceOrderOutlet
     */
    public ServiceOrderOutlet getServiceOrderOutlet()
    {
        return serviceOrderOutlet;
    }
    
    /**
     * 设置 serviceOrderOutlet
     * 
     * @param 对serviceOrderOutlet进行赋值
     */
    public void setServiceOrderOutlet(ServiceOrderOutlet serviceOrderOutlet)
    {
        this.serviceOrderOutlet = serviceOrderOutlet;
    }
    
}