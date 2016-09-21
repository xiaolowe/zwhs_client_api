package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the store_coupon database table.
 * 
 */
@Entity
@Table(name="store_coupon")
@NamedQuery(name="StoreCoupon.findAll", query="SELECT s FROM StoreCoupon s")
public class StoreCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="coupon_id", unique=true, nullable=false)
	private int couponId;

	@Column(name="coupon_amount", nullable=false)
	private int couponAmount;

	@Column(name="coupon_condition", nullable=false, precision=10, scale=2)
	private BigDecimal couponCondition;

	@Lob
	@Column(name="coupon_desc")
	private String couponDesc;

	@Column(name="coupon_limit", nullable=false)
	private int couponLimit;

	@Column(name="coupon_money", nullable=false, precision=10, scale=2)
	private BigDecimal couponMoney;

	@Column(name="coupon_name", length=50)
	private String couponName;

	@Column(name="coupon_number", nullable=false)
	private int couponNumber;

	@Column(name="coupon_status", nullable=false)
	private int couponStatus;

	@Column(name="coupon_symbol", length=10)
	private String couponSymbol;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="effective_time")
	private Date effectiveTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_time")
	private Date expirationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="store_id")
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public StoreCoupon() {
	}

	public int getCouponId() {
		return this.couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public int getCouponAmount() {
		return this.couponAmount;
	}

	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}

	public BigDecimal getCouponCondition() {
		return this.couponCondition;
	}

	public void setCouponCondition(BigDecimal couponCondition) {
		this.couponCondition = couponCondition;
	}

	public String getCouponDesc() {
		return this.couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public int getCouponLimit() {
		return this.couponLimit;
	}

	public void setCouponLimit(int couponLimit) {
		this.couponLimit = couponLimit;
	}

	public BigDecimal getCouponMoney() {
		return this.couponMoney;
	}

	public void setCouponMoney(BigDecimal couponMoney) {
		this.couponMoney = couponMoney;
	}

	public String getCouponName() {
		return this.couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getCouponNumber() {
		return this.couponNumber;
	}

	public void setCouponNumber(int couponNumber) {
		this.couponNumber = couponNumber;
	}

	public int getCouponStatus() {
		return this.couponStatus;
	}

	public void setCouponStatus(int couponStatus) {
		this.couponStatus = couponStatus;
	}

	public String getCouponSymbol() {
		return this.couponSymbol;
	}

	public void setCouponSymbol(String couponSymbol) {
		this.couponSymbol = couponSymbol;
	}

	public Date getEffectiveTime() {
		return this.effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getExpirationTime() {
		return this.expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
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

}