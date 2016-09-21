package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;


/**
 * The persistent class for the order_goods database table.
 * 
 */
@Entity
@Table(name="order_goods")
@NamedQuery(name="OrderGood.findAll", query="SELECT o FROM OrderGood o")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class OrderGood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_goods_id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderGoodsId;

	@Column(name="brand_name", length=100)
	private String brandName;

	@Column(name="commis_rate", nullable=false, precision=10, scale=2)
	@JsonIgnore
	private BigDecimal commisRate;

	@Column(name="goods_id", nullable=false)
	private int goodsId;

	@Column(name="goods_image", length=100)
	private String goodsImage;

	@Column(name="goods_name", nullable=false, length=50)
	private String goodsName;

	@Column(name="goods_num", nullable=false)
	private int goodsNum;

	@Column(name="goods_pay_price", nullable=false, precision=10, scale=2)
	private BigDecimal goodsPayPrice;

	@Column(name="goods_price", nullable=false, precision=10, scale=2)
	private BigDecimal goodsPrice;

	@Lob
	@Column(name="goods_spec")
	private String goodsSpec;

	@Column(name="goods_type", nullable=false)
	private int goodsType;

	@Column(name="member_id")
	@JsonIgnore
	private int memberId;

	@Column(name="order_id", nullable=false)
	private int orderId;

	@Column(name="order_type")
	private int orderType;

	@Column(name="promotions_id", nullable=false)
	@JsonIgnore
	private int promotionsId;

	@Column(name="store_id", nullable=false)
	@JsonIgnore
	private int storeId;
	

	public OrderGood() {
	}

	public int getOrderGoodsId() {
		return this.orderGoodsId;
	}

	public void setOrderGoodsId(int orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getCommisRate() {
		return this.commisRate;
	}

	public void setCommisRate(BigDecimal commisRate) {
		this.commisRate = commisRate;
	}

	public int getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public BigDecimal getGoodsPayPrice() {
		return this.goodsPayPrice;
	}

	public void setGoodsPayPrice(BigDecimal goodsPayPrice) {
		this.goodsPayPrice = goodsPayPrice;
	}

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsSpec() {
		return this.goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public int getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderType() {
		return this.orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public int getPromotionsId() {
		return this.promotionsId;
	}

	public void setPromotionsId(int promotionsId) {
		this.promotionsId = promotionsId;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}


	
}