package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the store_sg database table.
 * 
 */
@Entity
@Table(name="store_sg")
@NamedQuery(name="StoreSg.findAll", query="SELECT s FROM StoreSg s")
public class StoreSg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sg_id", unique=true, nullable=false)
	private int sgId;

	@Column(name="commis_rates", precision=10, scale=2)
	private BigDecimal commisRates;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="sg_name", length=30)
	private String sgName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public StoreSg() {
	}

	public int getSgId() {
		return this.sgId;
	}

	public void setSgId(int sgId) {
		this.sgId = sgId;
	}

	public BigDecimal getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(BigDecimal commisRates) {
		this.commisRates = commisRates;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getSgName() {
		return this.sgName;
	}

	public void setSgName(String sgName) {
		this.sgName = sgName;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}