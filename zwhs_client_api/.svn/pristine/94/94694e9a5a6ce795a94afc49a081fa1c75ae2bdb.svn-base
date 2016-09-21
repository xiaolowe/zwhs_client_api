package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the service_provider database table.
 * 
 */
@Entity
@Table(name="service_provider")
@NamedQuery(name="ServiceProvider.findAll", query="SELECT s FROM ServiceProvider s")
public class ServiceProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="provider_id", unique=true, nullable=false)
	private int providerId;

	@Column(name="bank_acc_name", length=50)
	private String bankAccName;

	@Column(name="bank_acc_number", length=50)
	private String bankAccNumber;

	@Column(name="bank_name", length=50)
	private String bankName;

	@Column(name="bank_owner", length=255)
	private String bankOwner;

	@Column(name="business_licence", length=50)
	private String businessLicence;

	@Column(name="company_address", length=50)
	private String companyAddress;

	@Column(name="company_fax", length=50)
	private String companyFax;

	@Column(name="company_name", length=50)
	private String companyName;

	@Column(name="company_postcode", length=6)
	private String companyPostcode;

	@Column(name="company_region")
	private int companyRegion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="joinin_message", length=200)
	private String joininMessage;

	@Column(name="joinin_state", length=50)
	private String joininState;

	@Column(name="organization_code", length=50)
	private String organizationCode;

	@Column(name="owner_card_back", length=50)
	private String ownerCardBack;

	@Column(name="owner_card_front", nullable=false, length=50)
	private String ownerCardFront;

	@Column(name="provider_alias_name", length=50)
	private String providerAliasName;

	@Column(name="provider_image", length=50)
	private String providerImage;

	@Column(name="provider_owner", length=50)
	private String providerOwner;

	@Column(name="provider_owner_card", nullable=false, length=50)
	private String providerOwnerCard;

	@Column(name="provider_state", nullable=false)
	private int providerState;

	@Column(name="region_area_name", length=50)
	private String regionAreaName;

	@Column(name="region_city")
	private int regionCity;

	@Column(name="region_city_name", length=50)
	private String regionCityName;

	@Column(name="region_prov")
	private int regionProv;

	@Column(name="region_prov_name", length=50)
	private String regionProvName;

	@Column(name="tax_reg_cert", length=50)
	private String taxRegCert;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="user_phone", length=20)
	private String userPhone;

	public ServiceProvider() {
	}

	public int getProviderId() {
		return this.providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getBankAccName() {
		return this.bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getBankAccNumber() {
		return this.bankAccNumber;
	}

	public void setBankAccNumber(String bankAccNumber) {
		this.bankAccNumber = bankAccNumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankOwner() {
		return this.bankOwner;
	}

	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}

	public String getBusinessLicence() {
		return this.businessLicence;
	}

	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyFax() {
		return this.companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPostcode() {
		return this.companyPostcode;
	}

	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
	}

	public int getCompanyRegion() {
		return this.companyRegion;
	}

	public void setCompanyRegion(int companyRegion) {
		this.companyRegion = companyRegion;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getJoininMessage() {
		return this.joininMessage;
	}

	public void setJoininMessage(String joininMessage) {
		this.joininMessage = joininMessage;
	}

	public String getJoininState() {
		return this.joininState;
	}

	public void setJoininState(String joininState) {
		this.joininState = joininState;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOwnerCardBack() {
		return this.ownerCardBack;
	}

	public void setOwnerCardBack(String ownerCardBack) {
		this.ownerCardBack = ownerCardBack;
	}

	public String getOwnerCardFront() {
		return this.ownerCardFront;
	}

	public void setOwnerCardFront(String ownerCardFront) {
		this.ownerCardFront = ownerCardFront;
	}

	public String getProviderAliasName() {
		return this.providerAliasName;
	}

	public void setProviderAliasName(String providerAliasName) {
		this.providerAliasName = providerAliasName;
	}

	public String getProviderImage() {
		return this.providerImage;
	}

	public void setProviderImage(String providerImage) {
		this.providerImage = providerImage;
	}

	public String getProviderOwner() {
		return this.providerOwner;
	}

	public void setProviderOwner(String providerOwner) {
		this.providerOwner = providerOwner;
	}

	public String getProviderOwnerCard() {
		return this.providerOwnerCard;
	}

	public void setProviderOwnerCard(String providerOwnerCard) {
		this.providerOwnerCard = providerOwnerCard;
	}

	public int getProviderState() {
		return this.providerState;
	}

	public void setProviderState(int providerState) {
		this.providerState = providerState;
	}

	public String getRegionAreaName() {
		return this.regionAreaName;
	}

	public void setRegionAreaName(String regionAreaName) {
		this.regionAreaName = regionAreaName;
	}

	public int getRegionCity() {
		return this.regionCity;
	}

	public void setRegionCity(int regionCity) {
		this.regionCity = regionCity;
	}

	public String getRegionCityName() {
		return this.regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

	public int getRegionProv() {
		return this.regionProv;
	}

	public void setRegionProv(int regionProv) {
		this.regionProv = regionProv;
	}

	public String getRegionProvName() {
		return this.regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public String getTaxRegCert() {
		return this.taxRegCert;
	}

	public void setTaxRegCert(String taxRegCert) {
		this.taxRegCert = taxRegCert;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

}