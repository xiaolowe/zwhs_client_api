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

/**
 * The persistent class for the service_outlets database table.
 * 
 */
@Entity
@Table(name = "service_outlets")
@NamedQuery(name = "ServiceOutlet.findAll", query = "SELECT s FROM ServiceOutlet s")
public class ServiceOutlet implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outlets_id", unique = true, nullable = false)
    private int outletsId;
    
    @Column(length = 100)
    private String address;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    private Date insDate;
    
    @Column(length = 10)
    private String latitude;
    
    @Column(length = 10)
    private String longitude;
    
    @Column(name = "outlets_name", length = 30)
    private String outletsName;
    
    @Column(length = 20)
    private String phone;
    
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    
    private int status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    @JsonIgnore
    private ServiceInfo serviceInfo;
    
    public ServiceOutlet()
    {
    }
    
    public int getOutletsId()
    {
        return this.outletsId;
    }
    
    public void setOutletsId(int outletsId)
    {
        this.outletsId = outletsId;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
    }
    
    public String getLatitude()
    {
        return this.latitude;
    }
    
    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }
    
    public String getLongitude()
    {
        return this.longitude;
    }
    
    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }
    
    public String getOutletsName()
    {
        return this.outletsName;
    }
    
    public void setOutletsName(String outletsName)
    {
        this.outletsName = outletsName;
    }
    
    public String getPhone()
    {
        return this.phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public int getServiceId()
    {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }
    
    public int getStatus()
    {
        return this.status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
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