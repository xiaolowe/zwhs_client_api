package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The persistent class for the service_store database table.
 * 
 */
@Entity
@Table(name = "service_store")
@NamedQuery(name = "ServiceStore.findAll", query = "SELECT s FROM ServiceStore s")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ServiceStore implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    
    @Column(name = "company_name", length = 50)
    @JsonIgnore
    private String companyName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "confirm_time")
    @JsonIgnore
    private Date confirmTime;
    
    @Column(name = "confirm_user_id")
    @JsonIgnore
    private int confirmUserId;
    
    @Column(name = "confirm_user_name", length = 30)
    @JsonIgnore
    private String confirmUserName;
    
    @Column(name = "contacts_name", length = 50)
    @JsonIgnore
    private String contactsName;
    
    @Column(name = "contacts_phone", length = 20)
    @JsonIgnore
    private String contactsPhone;
    
    @Column(name = "finish_num")
    private int finishNum;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    @JsonIgnore
    private Date insDate;
    
    @Column(name = "order_num")
    private int orderNum;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "service_addtime")
    private Date serviceAddtime;
    
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    
    @Column(name = "service_state")
    @JsonIgnore
    private int serviceState;
    
    @Column(name = "service_verify")
    @JsonIgnore
    private int serviceVerify;
    
    @Column(name = "store_id", nullable = false)
    private int storeId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    @Column(name = "user_id")
    @JsonIgnore
    private int userId;
    
    // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    private ServiceInfo serviceInfo;
    
    public ServiceStore()
    {
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getCompanyName()
    {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
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
    
    public int getFinishNum()
    {
        return this.finishNum;
    }
    
    public void setFinishNum(int finishNum)
    {
        this.finishNum = finishNum;
    }
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
    }
    
    public int getOrderNum()
    {
        return this.orderNum;
    }
    
    public void setOrderNum(int orderNum)
    {
        this.orderNum = orderNum;
    }
    
    public Date getServiceAddtime()
    {
        return this.serviceAddtime;
    }
    
    public void setServiceAddtime(Date serviceAddtime)
    {
        this.serviceAddtime = serviceAddtime;
    }
    
    public int getServiceId()
    {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }
    
    public int getServiceState()
    {
        return this.serviceState;
    }
    
    public void setServiceState(int serviceState)
    {
        this.serviceState = serviceState;
    }
    
    public int getServiceVerify()
    {
        return this.serviceVerify;
    }
    
    public void setServiceVerify(int serviceVerify)
    {
        this.serviceVerify = serviceVerify;
    }
    
    public int getStoreId()
    {
        return this.storeId;
    }
    
    public void setStoreId(int storeId)
    {
        this.storeId = storeId;
    }
    
    public Date getUpdDate()
    {
        return this.updDate;
    }
    
    public void setUpdDate(Date updDate)
    {
        this.updDate = updDate;
    }
    
    public int getUserId()
    {
        return this.userId;
    }
    
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    
    /**
     * 获取 serviceInfo
     * 
     * @return 返回 serviceInfo
     */
    public ServiceInfo getServiceInfo()
    {
        return serviceInfo;
    }
    
    /**
     * 设置 serviceInfo
     * 
     * @param 对serviceInfo进行赋值
     */
    public void setServiceInfo(ServiceInfo serviceInfo)
    {
        this.serviceInfo = serviceInfo;
    }
    
}