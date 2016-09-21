package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the retail_shop database table.
 * 
 */
@Entity
@Table(name="retail_shop")
@NamedQuery(name="RetailShop.findAll", query="SELECT r FROM RetailShop r")
public class RetailShop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="retail_shop_id")
	private int retailShopId;

	@Column(name="banner_image")
	private String bannerImage;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="logo_image")
	private String logoImage;

	@Column(name="member_id")
	private int memberId;

	@Column(name="retail_shop")
	private String retailShop;

	private int status;

	@Lob
	private String template;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public RetailShop() {
	}

	public int getRetailShopId() {
		return this.retailShopId;
	}

	public void setRetailShopId(int retailShopId) {
		this.retailShopId = retailShopId;
	}

	public String getBannerImage() {
		return this.bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getLogoImage() {
		return this.logoImage;
	}

	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getRetailShop() {
		return this.retailShop;
	}

	public void setRetailShop(String retailShop) {
		this.retailShop = retailShop;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}