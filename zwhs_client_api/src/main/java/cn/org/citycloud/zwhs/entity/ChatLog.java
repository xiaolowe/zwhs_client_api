package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the chat_log database table.
 * 
 */
@Entity
@Table(name="chat_log")
@NamedQuery(name="ChatLog.findAll", query="SELECT c FROM ChatLog c")
public class ChatLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_time")
	private Date addTime;

	@Column(name="f_id", nullable=false)
	private int fId;

	@Column(name="f_ip", nullable=false, length=15)
	private String fIp;

	@Column(name="f_name", nullable=false, length=50)
	private String fName;

	@Column(name="t_id", nullable=false)
	private int tId;

	@Column(name="t_msg", length=300)
	private String tMsg;

	@Column(name="t_name", nullable=false, length=50)
	private String tName;

	public ChatLog() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getFId() {
		return this.fId;
	}

	public void setFId(int fId) {
		this.fId = fId;
	}

	public String getFIp() {
		return this.fIp;
	}

	public void setFIp(String fIp) {
		this.fIp = fIp;
	}

	public String getFName() {
		return this.fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public int getTId() {
		return this.tId;
	}

	public void setTId(int tId) {
		this.tId = tId;
	}

	public String getTMsg() {
		return this.tMsg;
	}

	public void setTMsg(String tMsg) {
		this.tMsg = tMsg;
	}

	public String getTName() {
		return this.tName;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}

}