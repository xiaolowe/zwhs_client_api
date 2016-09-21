package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_class database table.
 * 
 */
@Entity
@Table(name="goods_class")
@NamedQuery(name="GoodsClass.findAll", query="SELECT g FROM GoodsClass g")
public class GoodsClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="gc_no", unique=true, nullable=false)
	private int gcNo;

	@Column(name="gc_description", length=255)
	private String gcDescription;

	@Column(name="gc_keywords", length=255)
	private String gcKeywords;

	@Column(name="gc_name", nullable=false, length=100)
	private String gcName;

	@Column(name="gc_parent_id", nullable=false)
	private int gcParentId;

	@Column(name="gc_sort", nullable=false)
	private byte gcSort;

	@Column(name="gc_title", nullable=false, length=200)
	private String gcTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public GoodsClass() {
	}

	public int getGcNo() {
		return this.gcNo;
	}

	public void setGcNo(int gcNo) {
		this.gcNo = gcNo;
	}

	public String getGcDescription() {
		return this.gcDescription;
	}

	public void setGcDescription(String gcDescription) {
		this.gcDescription = gcDescription;
	}

	public String getGcKeywords() {
		return this.gcKeywords;
	}

	public void setGcKeywords(String gcKeywords) {
		this.gcKeywords = gcKeywords;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public int getGcParentId() {
		return this.gcParentId;
	}

	public void setGcParentId(int gcParentId) {
		this.gcParentId = gcParentId;
	}

	public byte getGcSort() {
		return this.gcSort;
	}

	public void setGcSort(byte gcSort) {
		this.gcSort = gcSort;
	}

	public String getGcTitle() {
		return this.gcTitle;
	}

	public void setGcTitle(String gcTitle) {
		this.gcTitle = gcTitle;
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