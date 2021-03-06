package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cash_recoder database table.
 * 
 */
@Entity
@Table(name="cash_recoder")
@NamedQuery(name="CashRecoder.findAll", query="SELECT c FROM CashRecoder c")
public class CashRecoder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cash_no", unique=true, nullable=false)
	private int cashNo;

	@Column(name="acc_surplus", precision=10)
	private BigDecimal accSurplus;

	@Column(name="apply_money", precision=10, scale=2)
	private BigDecimal applyMoney;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="apply_time")
	private Date applyTime;

	@Column(name="apply_type")
	private int applyType;

	@Column(name="store_user_id")
	private int applyUserId;

	@Column(name="apply_user_name", length=30)
	private String applyUserName;

	@Column(name="bank_acc_name", length=50)
	private String bankAccName;

	@Column(name="bank_acc_number", length=50)
	private String bankAccNumber;

	@Column(name="bank_name", length=50)
	private String bankName;

	@Column(name="company_name", length=50)
	private String companyName;

	@Column(name="confirm_stat")
	private int confirmStat;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="confirm_time")
	private Date confirmTime;

	@Column(name="confirm_user_id")
	private int confirmUserId;

	@Column(name="confirm_user_name", length=30)
	private String confirmUserName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="paying_certificate", length=100)
	private String payingCertificate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="paying_time")
	private Date payingTime;

	@Column(name="paying_user_name", length=30)
	private String payingUserName;

	@Column(name="paying_user_no")
	private int payingUserNo;

	@Column(name="store_id", nullable=false)
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	@Column(name="bank_owner", length=100)
	private String bankOwner;
	
	@Column(name="retail_member_id")
	private int retailMemberId;
	
	@Column(name="retail_member_name", length=50)
	private String retailMemberName;
	
	@Column(name="acc_type")
	private byte accType;
	

	public CashRecoder() {
	}

	public int getCashNo() {
		return this.cashNo;
	}

	public void setCashNo(int cashNo) {
		this.cashNo = cashNo;
	}

	public BigDecimal getAccSurplus() {
		return this.accSurplus;
	}

	public void setAccSurplus(BigDecimal accSurplus) {
		this.accSurplus = accSurplus;
	}

	public BigDecimal getApplyMoney() {
		return this.applyMoney;
	}

	public void setApplyMoney(BigDecimal applyMoney) {
		this.applyMoney = applyMoney;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public int getApplyType() {
		return this.applyType;
	}

	public void setApplyType(int applyType) {
		this.applyType = applyType;
	}

	public int getApplyUserId() {
		return this.applyUserId;
	}

	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
		return this.applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getConfirmStat() {
		return this.confirmStat;
	}

	public void setConfirmStat(int confirmStat) {
		this.confirmStat = confirmStat;
	}

	public Date getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public int getConfirmUserId() {
		return this.confirmUserId;
	}

	public void setConfirmUserId(int confirmUserId) {
		this.confirmUserId = confirmUserId;
	}

	public String getConfirmUserName() {
		return this.confirmUserName;
	}

	public void setConfirmUserName(String confirmUserName) {
		this.confirmUserName = confirmUserName;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getPayingCertificate() {
		return this.payingCertificate;
	}

	public void setPayingCertificate(String payingCertificate) {
		this.payingCertificate = payingCertificate;
	}

	public Date getPayingTime() {
		return this.payingTime;
	}

	public void setPayingTime(Date payingTime) {
		this.payingTime = payingTime;
	}

	public String getPayingUserName() {
		return this.payingUserName;
	}

	public void setPayingUserName(String payingUserName) {
		this.payingUserName = payingUserName;
	}

	public int getPayingUserNo() {
		return this.payingUserNo;
	}

	public void setPayingUserNo(int payingUserNo) {
		this.payingUserNo = payingUserNo;
	}


	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public int getRetailMemberId() {
		return retailMemberId;
	}

	public void setRetailMemberId(int retailMemberId) {
		this.retailMemberId = retailMemberId;
	}

	public String getRetailMemberName() {
		return retailMemberName;
	}

	public void setRetailMemberName(String retailMemberName) {
		this.retailMemberName = retailMemberName;
	}

	public byte getAccType() {
		return accType;
	}

	public void setAccType(byte accType) {
		this.accType = accType;
	}

	public String getBankOwner() {
		return bankOwner;
	}

	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}

	
	
	

}