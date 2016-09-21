package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the store_member database table.
 * 
 */
@Entity
@Table(name="store_member")
@NamedQuery(name="StoreMember.findAll", query="SELECT s FROM StoreMember s")
public class StoreMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_id", nullable=false)
	private int memberId;

	@Column(name="open_id", length=30)
	private String openId;

	@Column(name="store_id", nullable=false)
	private int storeId;

	public StoreMember() {
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

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

}