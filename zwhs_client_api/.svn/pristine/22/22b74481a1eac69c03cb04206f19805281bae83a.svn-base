package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the material_class database table.
 * 
 */
@Entity
@Table(name="material_class")
@NamedQuery(name="MaterialClass.findAll", query="SELECT m FROM MaterialClass m")
public class MaterialClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="material_class_id", unique=true, nullable=false)
	private int materialClassId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="material_class_name", length=30)
	private String materialClassName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public MaterialClass() {
	}

	public int getMaterialClassId() {
		return this.materialClassId;
	}

	public void setMaterialClassId(int materialClassId) {
		this.materialClassId = materialClassId;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getMaterialClassName() {
		return this.materialClassName;
	}

	public void setMaterialClassName(String materialClassName) {
		this.materialClassName = materialClassName;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}