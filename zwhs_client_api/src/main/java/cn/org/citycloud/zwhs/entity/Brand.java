package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Table(name="brand")
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="brand_no", unique=true, nullable=false)
	private int brandNo;

	@Column(name="brand_name", length=100)
	private String brandName;

	@Column(name="brand_pic", length=100)
	private String brandPic;

	@Column(name="brand_sort")
	private byte brandSort;

	@Column(name="brand_stat")
	private int brandStat;

	@Column(name="contacts_name", length=50)
	private String contactsName;

	@Column(name="goods_source")
	private int goodsSource;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public Brand() {
	}

	public int getBrandNo() {
		return this.brandNo;
	}

	public void setBrandNo(int brandNo) {
		this.brandNo = brandNo;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandPic() {
		return this.brandPic;
	}

	public void setBrandPic(String brandPic) {
		this.brandPic = brandPic;
	}

	public byte getBrandSort() {
		return this.brandSort;
	}

	public void setBrandSort(byte brandSort) {
		this.brandSort = brandSort;
	}

	public int getBrandStat() {
		return this.brandStat;
	}

	public void setBrandStat(int brandStat) {
		this.brandStat = brandStat;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public int getGoodsSource() {
		return this.goodsSource;
	}

	public void setGoodsSource(int goodsSource) {
		this.goodsSource = goodsSource;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}