package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the fin_acc database table.
 * 
 */
@Entity
@Table(name="fin_acc")
@NamedQuery(name="FinAcc.findAll", query="SELECT f FROM FinAcc f")
public class FinAcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="acc_bal", precision=10, scale=2)
	private BigDecimal accBal;

	@Column(name="acc_income", precision=10, scale=2)
	private BigDecimal accIncome;

	@Column(name="acc_no", nullable=false)
	private int accNo;

	@Column(name="acc_pay", precision=10, scale=2)
	private BigDecimal accPay;

	@Column(name="acc_type")
	private int accType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public FinAcc() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAccBal() {
		return this.accBal;
	}

	public void setAccBal(BigDecimal accBal) {
		this.accBal = accBal;
	}

	public BigDecimal getAccIncome() {
		return this.accIncome;
	}

	public void setAccIncome(BigDecimal accIncome) {
		this.accIncome = accIncome;
	}

	public int getAccNo() {
		return this.accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public BigDecimal getAccPay() {
		return this.accPay;
	}

	public void setAccPay(BigDecimal accPay) {
		this.accPay = accPay;
	}

	public int getAccType() {
		return this.accType;
	}

	public void setAccType(int accType) {
		this.accType = accType;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}