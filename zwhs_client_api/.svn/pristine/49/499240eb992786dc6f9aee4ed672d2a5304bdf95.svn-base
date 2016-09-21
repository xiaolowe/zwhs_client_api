package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the goods_common database table.
 * 
 */
@Entity
@Table(name="goods_common")
@NamedQuery(name="GoodsCommon.findAll", query="SELECT g FROM GoodsCommon g")
public class GoodsCommon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="goods_id", unique=true, nullable=false)
	private int goodsId;

	@Column(name="brand_name", nullable=false, length=100)
	private String brandName;

	@Column(name="brand_no", nullable=false)
	private int brandNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="confirm_time")
	private Date confirmTime;

	@Column(name="confirm_user_id")
	private int confirmUserId;

	@Column(name="confirm_user_name", length=30)
	private String confirmUserName;

	@Column(name="contacts_name", length=50)
	private String contactsName;

	@Column(name="contacts_phone", length=20)
	private String contactsPhone;

	@Column(name="gc_lit_id", nullable=false)
	private int gcLitId;

	@Column(name="gc_lit_name", nullable=false, length=200)
	private String gcLitName;

	@Column(name="gc_name", nullable=false, length=200)
	private String gcName;

	@Column(name="gc_no", nullable=false)
	private int gcNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="goods_addtime")
	private Date goodsAddtime;

	@Lob
	@Column(name="goods_attr")
	private String goodsAttr;

	@Lob
	@Column(name="goods_body")
	private String goodsBody;

	@Column(name="goods_costprice", precision=10, scale=2)
	private BigDecimal goodsCostprice;

	@Column(name="goods_image", length=100)
	private String goodsImage;

	@Column(name="goods_image_small", length=100)
	private String goodsImageSmall;

	@Column(name="goods_marketprice", precision=10, scale=2)
	private BigDecimal goodsMarketprice;

	@Column(name="goods_name", nullable=false, length=50)
	private String goodsName;

	@Column(name="goods_price", precision=10, scale=2)
	private BigDecimal goodsPrice;

	@Column(name="goods_sn", length=20)
	private String goodsSn;

	@Lob
	@Column(name="goods_spec", nullable=false)
	private String goodsSpec;

	@Column(name="goods_state", nullable=false)
	private byte goodsState;

	@Column(name="goods_verify", nullable=false)
	private byte goodsVerify;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_id")
	private int memberId;

	@Column(name="store_id")
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public GoodsCommon() {
	}

	public int getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandNo() {
		return this.brandNo;
	}

	public void setBrandNo(int brandNo) {
		this.brandNo = brandNo;
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

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsPhone() {
		return this.contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public int getGcLitId() {
		return this.gcLitId;
	}

	public void setGcLitId(int gcLitId) {
		this.gcLitId = gcLitId;
	}

	public String getGcLitName() {
		return this.gcLitName;
	}

	public void setGcLitName(String gcLitName) {
		this.gcLitName = gcLitName;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public int getGcNo() {
		return this.gcNo;
	}

	public void setGcNo(int gcNo) {
		this.gcNo = gcNo;
	}

	public Date getGoodsAddtime() {
		return this.goodsAddtime;
	}

	public void setGoodsAddtime(Date goodsAddtime) {
		this.goodsAddtime = goodsAddtime;
	}

	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	public String getGoodsBody() {
		return this.goodsBody;
	}

	public void setGoodsBody(String goodsBody) {
		this.goodsBody = goodsBody;
	}

	public BigDecimal getGoodsCostprice() {
		return this.goodsCostprice;
	}

	public void setGoodsCostprice(BigDecimal goodsCostprice) {
		this.goodsCostprice = goodsCostprice;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsImageSmall() {
		return this.goodsImageSmall;
	}

	public void setGoodsImageSmall(String goodsImageSmall) {
		this.goodsImageSmall = goodsImageSmall;
	}

	public BigDecimal getGoodsMarketprice() {
		return this.goodsMarketprice;
	}

	public void setGoodsMarketprice(BigDecimal goodsMarketprice) {
		this.goodsMarketprice = goodsMarketprice;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public String getGoodsSpec() {
		return this.goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public byte getGoodsState() {
		return this.goodsState;
	}

	public void setGoodsState(byte goodsState) {
		this.goodsState = goodsState;
	}

	public byte getGoodsVerify() {
		return this.goodsVerify;
	}

	public void setGoodsVerify(byte goodsVerify) {
		this.goodsVerify = goodsVerify;
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