package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the shopping_cart database table.
 * 
 */
@Entity
@Table(name = "shopping_cart")
@NamedQuery(name = "ShoppingCart.findAll", query = "SELECT s FROM ShoppingCart s")
public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false)
	private int id;

	@Column(name = "cart_state")
	private int cartState;

	@Column(name = "commis_rate", nullable = false, precision = 10, scale = 2)
	private BigDecimal commisRate;

	@Column(name = "goods_id", nullable = false)
	private int goodsId;

	@Column(name = "goods_image", length = 100)
	private String goodsImage;

	@Column(name = "goods_name", nullable = false, length = 50)
	private String goodsName;

	@Column(name = "goods_num", nullable = false)
	private int goodsNum;

	@Column(name = "goods_pay_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal goodsPayPrice;

	@Column(name = "goods_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal goodsPrice;

	@Lob
	@Column(name = "goods_spec")
	private String goodsSpec;

	@Column(name = "goods_type", nullable = false)
	private int goodsType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ins_date")
	private Date insDate;

	@Column(name = "member_id")
	private int memberId;

	@Column(name = "order_type")
	private int orderType;

	@Column(name = "promotions_id")
	private int promotionsId;

	@Column(name = "store_id", nullable = false)
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_date")
	private Date updDate;
	
	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
	@JoinColumn(name = "goods_id", insertable = false, updatable = false)
	private StoreGood storeGood;

	public ShoppingCart() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCartState() {
		return this.cartState;
	}

	public void setCartState(int cartState) {
		this.cartState = cartState;
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

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public StoreGood getStoreGood() {
		return storeGood;
	}

	public void setStoreGood(StoreGood storeGood) {
		this.storeGood = storeGood;
	}

	
	

}