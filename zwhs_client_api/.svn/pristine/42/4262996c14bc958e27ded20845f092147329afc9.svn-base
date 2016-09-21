package cn.org.citycloud.zwhs.bean;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class ServicePreOrder
{
    
    @Min(1)
    private int serviceId;
    
    @NotEmpty
    private String productName;
    
    private String contactsName;
    
    private String contactsPhone;
    
    private String contactsAddress;
    
    private int regionCode = 0;
    
    // @Length(min = 6, max = 6)
    private String postCode;
    
    private String regionProvName;
    
    private String regionCityName;
    
    private String regionAreaName;
    
    @Min(1)
    private int peopleNumber;
    
    @Future
    private Date visitTime;
    
    // 服务网点
    private int outletsId = 0;
    
    public int getServiceId()
    {
        return serviceId;
    }
    
    public void setServiceId(int serviceId)
    {
        this.serviceId = serviceId;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    public String getContactsName()
    {
        return contactsName;
    }
    
    public void setContactsName(String contactsName)
    {
        this.contactsName = contactsName;
    }
    
    public String getContactsPhone()
    {
        return contactsPhone;
    }
    
    public void setContactsPhone(String contactsPhone)
    {
        this.contactsPhone = contactsPhone;
    }
    
    public String getContactsAddress()
    {
        return contactsAddress;
    }
    
    public void setContactsAddress(String contactsAddress)
    {
        this.contactsAddress = contactsAddress;
    }
    
    public int getRegionCode()
    {
        return regionCode;
    }
    
    public void setRegionCode(int regionCode)
    {
        this.regionCode = regionCode;
    }
    
    public String getPostCode()
    {
        return postCode;
    }
    
    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
    
    public String getRegionProvName()
    {
        return regionProvName;
    }
    
    public void setRegionProvName(String regionProvName)
    {
        this.regionProvName = regionProvName;
    }
    
    public String getRegionCityName()
    {
        return regionCityName;
    }
    
    public void setRegionCityName(String regionCityName)
    {
        this.regionCityName = regionCityName;
    }
    
    public String getRegionAreaName()
    {
        return regionAreaName;
    }
    
    public void setRegionAreaName(String regionAreaName)
    {
        this.regionAreaName = regionAreaName;
    }
    
    public int getPeopleNumber()
    {
        return peopleNumber;
    }
    
    public void setPeopleNumber(int peopleNumber)
    {
        this.peopleNumber = peopleNumber;
    }
    
    public Date getVisitTime()
    {
        return visitTime;
    }
    
    public void setVisitTime(Date visitTime)
    {
        this.visitTime = visitTime;
    }
    
    /**
     * 获取 outletsId
     * 
     * @return 返回 outletsId
     */
    public int getOutletsId()
    {
        return outletsId;
    }
    
    /**
     * 设置 outletsId
     * 
     * @param 对outletsId进行赋值
     */
    public void setOutletsId(int outletsId)
    {
        this.outletsId = outletsId;
    }
    
}
