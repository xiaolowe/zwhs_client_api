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
 * The persistent class for the service_coverage_area database table.
 * 
 */
@Entity
@Table(name = "service_coverage_area")
@NamedQuery(name = "ServiceCoverageArea.findAll", query = "SELECT s FROM ServiceCoverageArea s")
public class ServiceCoverageArea implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id", unique = true, nullable = false)
    private int areaId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ins_date")
    private Date insDate;
    
    @Column(name = "region_area")
    private int regionArea;
    
    @Column(name = "region_area_name", length = 50)
    private String regionAreaName;
    
    @Column(name = "region_city")
    private int regionCity;
    
    @Column(name = "region_city_name", length = 50)
    private String regionCityName;
    
    @Column(name = "region_prov")
    private int regionProv;
    
    @Column(name = "region_prov_name", length = 50)
    private String regionProvName;
    
    @Column(name = "service_id", nullable = false)
    private int serviceId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upd_date")
    private Date updDate;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, optional = true)
    @JoinColumn(name = "service_id", insertable = false, updatable = false)
    @JsonIgnore
    private ServiceInfo serviceInfo;
    
    public ServiceCoverageArea()
    {
    }
    
    public int getAreaId()
    {
        return this.areaId;
    }
    
    public void setAreaId(int areaId)
    {
        this.areaId = areaId;
    }
    
    public Date getInsDate()
    {
        return this.insDate;
    }
    
    public void setInsDate(Date insDate)
    {
        this.insDate = insDate;
    }
    
    public int getRegionArea()
    {
        return this.regionArea;
    }
    
    public void setRegionArea(int regionArea)
    {
        this.regionArea = regionArea;
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
    
    public int getServiceId()
    {
        return this.serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
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