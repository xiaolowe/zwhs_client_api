package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the wechat_member_addr database table.
 * 
 */
@Entity
@Table(name="wechat_member_addr")
@NamedQuery(name="WechatMemberAddr.findAll", query="SELECT w FROM WechatMemberAddr w")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class WechatMemberAddr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_addr_id", unique=true, nullable=false)
	@JsonIgnore
	private int memberAddrId;

	@Column(name="contacts_address", length=50)
	private String contactsAddress;

	@Column(name="contacts_name", length=30)
	private String contactsName;

	@Column(name="contacts_phone", length=11)
	private String contactsPhone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	@JsonIgnore
	private Date insDate;

	@Column(name="member_id", nullable=false)
	@JsonIgnore
	private int memberId;

	@Column(name="post_code", length=6)
	private String postCode;

	@Column(name="region_area_name", length=50)
	private String regionAreaName;

	@Column(name="region_city_name", length=50)
	private String regionCityName;

	@Column(name="region_code")
	private int regionCode;

	@Column(name="region_prov_name", length=50)
	private String regionProvName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	@JsonIgnore
	private Date updDate;

	public WechatMemberAddr() {
	}

	public int getMemberAddrId() {
		return this.memberAddrId;
	}

	public void setMemberAddrId(int memberAddrId) {
		this.memberAddrId = memberAddrId;
	}

	public String getContactsAddress() {
		return this.contactsAddress;
	}

	public void setContactsAddress(String contactsAddress) {
		this.contactsAddress = contactsAddress;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsPhone() {
		return this.contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRegionAreaName() {
		return this.regionAreaName;
	}

	public void setRegionAreaName(String regionAreaName) {
		this.regionAreaName = regionAreaName;
	}

	public String getRegionCityName() {
		return this.regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

	public int getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(int regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionProvName() {
		return this.regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}