package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the service_info database table.
 * 
 */
@Entity
@Table(name = "service_info")
@NamedQuery(name = "ServiceInfo.findAll", query = "SELECT s FROM ServiceInfo s")
public class ServiceInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id", unique = true, nullable = false)
    private int serviceId;
    
    @Column(name = "business_end")
    private Time businessEnd;
    
    @Column(name = "business_start")
    private Time businessStart;
    
    @Column(name = "commis_rates", precision = 10, scale = 2)
    private BigDecimal commisRates;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "confirm_time")
    private Date confirmTime;
    
    @Column(name = "confirm_user_id")
    private int confirmUserId;
    
    @Column(name = "confirm_user_name", length = 30)
    private String confirmUserName;
    
    @Column(name = "contacts_name", length = 50)
    private String contactsName;
    
    @Column(name = "contacts_phone", length = 20)
    private String contactsPhone;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    private Date insDate;
    
    @Column(name = "provider_id")
    private int providerId;
    
    @Column(name = "provider_rates", precision = 10, scale = 2)
    private BigDecimal providerRates;
    
    @Lob
    private String remark;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "service_addtime")
    private Date serviceAddtime;
    
    @Column(name = "service_logo", length = 100)
    private String serviceLogo;
    
    @Column(name = "service_name", length = 30)
    private String serviceName;
    
    @Column(name = "service_pic1", length = 100)
    private String servicePic1;
    
    @Column(name = "service_pic2", length = 100)
    private String servicePic2;
    
    @Column(name = "service_pic3", length = 100)
    private String servicePic3;
    
    @Column(name = "service_pic4", length = 100)
    private String servicePic4;
    
    @Column(name = "service_pic5", length = 100)
    private String servicePic5;
    
    @Column(name = "service_price", precision = 10, scale = 2)
    private BigDecimal servicePrice;
    
    @Column(name = "service_state")
    private int serviceState;
    
    @Column(name = "service_time", length = 30)
    private String serviceTime;
    
    @Column(name = "service_verify")
    private int serviceVerify;
    
    @Column(name = "store_rates", precision = 10, scale = 2)
    private BigDecimal storeRates;
    
    private int type;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    // 关联服务覆盖区域
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Set<ServiceCoverageArea> serviceCoverageAreas;
    
    // 关联服务网点
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Set<ServiceOutlet> serviceOutlets;
    
    public ServiceInfo()
    {
    }
    
    public int getServiceId()
    {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }
    
    public Time getBusinessEnd()
    {
        return this.businessEnd;
    }
    
    public void setBusinessEnd(Time businessEnd)
    {
        this.businessEnd = businessEnd;
    }
    
    public Time getBusinessStart()
    {
        return this.businessStart;
    }
    
    public void setBusinessStart(Time businessStart)
    {
        this.businessStart = businessStart;
    }
    
    public BigDecimal getCommisRates()
    {
        return this.commisRates;
    }
    
    public void setCommisRates(BigDecimal commisRates)
    {
        this.commisRates = commisRates;
    }
    
    public Date getConfirmTime()
    {
        return this.confirmTime;
    }
    
    public void setConfirmTime(Date confirmTime)
    {
        this.confirmTime = confirmTime;
    }
    
    public int getConfirmUserId()
    {
        return this.confirmUserId;
    }
    
    public void setConfirmUserId(int confirmUserId)
    {
        this.confirmUserId = confirmUserId;
    }
    
    public String getConfirmUserName()
    {
        return this.confirmUserName;
    }
    
    public void setConfirmUserName(String confirmUserName)
    {
        this.confirmUserName = confirmUserName;
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
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
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
    
    public String getRemark()
    {
        return this.remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    public Date getServiceAddtime()
    {
        return this.serviceAddtime;
    }
    
    public void setServiceAddtime(Date serviceAddtime)
    {
        this.serviceAddtime = serviceAddtime;
    }
    
    public String getServiceLogo()
    {
        return this.serviceLogo;
    }
    
    public void setServiceLogo(String serviceLogo)
    {
        this.serviceLogo = serviceLogo;
    }
    
    public String getServiceName()
    {
        return this.serviceName;
    }
    
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    
    public String getServicePic1()
    {
        return this.servicePic1;
    }
    
    public void setServicePic1(String servicePic1)
    {
        this.servicePic1 = servicePic1;
    }
    
    public String getServicePic2()
    {
        return this.servicePic2;
    }
    
    public void setServicePic2(String servicePic2)
    {
        this.servicePic2 = servicePic2;
    }
    
    public String getServicePic3()
    {
        return this.servicePic3;
    }
    
    public void setServicePic3(String servicePic3)
    {
        this.servicePic3 = servicePic3;
    }
    
    public String getServicePic4()
    {
        return this.servicePic4;
    }
    
    public void setServicePic4(String servicePic4)
    {
        this.servicePic4 = servicePic4;
    }
    
    public String getServicePic5()
    {
        return this.servicePic5;
    }
    
    public void setServicePic5(String servicePic5)
    {
        this.servicePic5 = servicePic5;
    }
    
    public BigDecimal getServicePrice()
    {
        return this.servicePrice;
    }
    
    public void setServicePrice(BigDecimal servicePrice)
    {
        this.servicePrice = servicePrice;
    }
    
    public int getServiceState()
    {
        return this.serviceState;
    }
    
    public void setServiceState(int serviceState)
    {
        this.serviceState = serviceState;
    }
    
    public String getServiceTime()
    {
        return this.serviceTime;
    }
    
    public void setServiceTime(String serviceTime)
    {
        this.serviceTime = serviceTime;
    }
    
    public int getServiceVerify()
    {
        return this.serviceVerify;
    }
    
    public void setServiceVerify(int serviceVerify)
    {
        this.serviceVerify = serviceVerify;
    }
    
    public BigDecimal getStoreRates()
    {
        return this.storeRates;
    }
    
    public void setStoreRates(BigDecimal storeRates)
    {
        this.storeRates = storeRates;
    }
    
    public int getType()
    {
        return this.type;
    }
    
    public void setType(int type)
    {
        this.type = type;
    }
    
    public Date getUpdDate()
    {
        return this.updDate;
    }
    
    public void setUpdDate(Date updDate)
    {
        this.updDate = updDate;
    }
    
    /**
     * 获取 serviceCoverageAreas
     * 
     * @return 返回 serviceCoverageAreas
     */
    public Set<ServiceCoverageArea> getServiceCoverageAreas()
    {
        return serviceCoverageAreas;
    }
    
    /**
     * 设置 serviceCoverageAreas
     * 
     * @param 对serviceCoverageAreas进行赋值
     */
    public void setServiceCoverageAreas(Set<ServiceCoverageArea> serviceCoverageAreas)
    {
        this.serviceCoverageAreas = serviceCoverageAreas;
    }
    
    /**
     * 获取 serviceOutlets
     * 
     * @return 返回 serviceOutlets
     */
    public Set<ServiceOutlet> getServiceOutlets()
    {
        return serviceOutlets;
    }
    
    /**
     * 设置 serviceOutlets
     * 
     * @param 对serviceOutlets进行赋值
     */
    public void setServiceOutlets(Set<ServiceOutlet> serviceOutlets)
    {
        this.serviceOutlets = serviceOutlets;
    }
    
}