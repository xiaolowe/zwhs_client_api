package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wechat_reply database table.
 * 
 */
@Entity
@Table(name="wechat_reply")
@NamedQuery(name="WechatReply.findAll", query="SELECT w FROM WechatReply w")
public class WechatReply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="keyword_search")
	private int keywordSearch;

	@Column(name="material_id1")
	private int materialId1;

	@Column(name="material_id2")
	private int materialId2;

	@Column(name="reply_keyword", length=30)
	private String replyKeyword;

	@Column(name="reply_text", length=300)
	private String replyText;

	@Column(name="reply_type")
	private int replyType;

	@Column(name="store_id")
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public WechatReply() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public int getKeywordSearch() {
		return this.keywordSearch;
	}

	public void setKeywordSearch(int keywordSearch) {
		this.keywordSearch = keywordSearch;
	}

	public int getMaterialId1() {
		return this.materialId1;
	}

	public void setMaterialId1(int materialId1) {
		this.materialId1 = materialId1;
	}

	public int getMaterialId2() {
		return this.materialId2;
	}

	public void setMaterialId2(int materialId2) {
		this.materialId2 = materialId2;
	}

	public String getReplyKeyword() {
		return this.replyKeyword;
	}

	public void setReplyKeyword(String replyKeyword) {
		this.replyKeyword = replyKeyword;
	}

	public String getReplyText() {
		return this.replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public int getReplyType() {
		return this.replyType;
	}

	public void setReplyType(int replyType) {
		this.replyType = replyType;
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