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
 * The persistent class for the service_order_code database table.
 * 
 */
@Entity
@Table(name = "service_order_code")
@NamedQuery(name = "ServiceOrderCode.findAll", query = "SELECT s FROM ServiceOrderCode s")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class ServiceOrderCode implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id", unique = true, nullable = false)
    private int codeId;
    
    @Column(name = "code_val", nullable = false, length = 12)
    private String codeVal;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    private Date insDate;
    
    @Column(name = "member_truename", length = 20)
    private String memberTruename;
    
    @Column(name = "order_id", nullable = false)
    private int orderId;
    
    @Column(name = "provider_id")
    private int providerId;
    
    @Column(name = "service_id")
    private int serviceId;
    
    @Column(name = "service_name", length = 30)
    private String serviceName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "use_date")
    private Date useDate;
    
    @Column(name = "use_status", nullable = false)
    private int useStatus;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @JsonIgnore
    private StoreServiceOrder storeServiceOrder;
    
    public ServiceOrderCode()
    {
    }
    
    public int getCodeId()
    {
        return this.codeId;
    }
    
    public void setCodeId(int codeId)
    {
        this.codeId = codeId;
    }
    
    public String getCodeVal()
    {
        return this.codeVal;
    }
    
    public void setCodeVal(String codeVal)
    {
        this.codeVal = codeVal;
    }
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
    }
    
    public String getMemberTruename()
    {
        return this.memberTruename;
    }
    
    public void setMemberTruename(String memberTruename)
    {
        this.memberTruename = memberTruename;
    }
    
    public int getOrderId()
    {
        return this.orderId;
    }
    
    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }
    
    public int getProviderId()
    {
        return this.providerId;
    }
    
    public void setProviderId(int providerId)
    {
        this.providerId = providerId;
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
    
    public Date getUpdDate()
    {
        return this.updDate;
    }
    
    public void setUpdDate(Date updDate)
    {
        this.updDate = updDate;
    }
    
    public Date getUseDate()
    {
        return this.useDate;
    }
    
    public void setUseDate(Date useDate)
    {
        this.useDate = useDate;
    }
    
    public int getUseStatus()
    {
        return this.useStatus;
    }
    
    public void setUseStatus(int useStatus)
    {
        this.useStatus = useStatus;
    }
    
    /**
     * 获取 storeServiceOrder
     * 
     * @return 返回 storeServiceOrder
     */
    public StoreServiceOrder getStoreServiceOrder()
    {
        return storeServiceOrder;
    }
    
    /**
     * 设置 storeServiceOrder
     * 
     * @param 对storeServiceOrder进行赋值
     */
    public void setStoreServiceOrder(StoreServiceOrder storeServiceOrder)
    {
        this.storeServiceOrder = storeServiceOrder;
    }
    
}