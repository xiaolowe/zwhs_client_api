package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the menu_info database table.
 * 
 */
@Entity
@Table(name="menu_info")
@NamedQuery(name="MenuInfo.findAll", query="SELECT m FROM MenuInfo m")
public class MenuInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id", unique=true, nullable=false)
	private int menuId;

	@Column(name="menu_name", length=77)
	private String menuName;

	@Column(name="order_flag")
	private int orderFlag;

	@Column(name="par_menu_id")
	private int parMenuId;

	@Column(length=150)
	private String remark;

	@Column(name="root_flag")
	private int rootFlag;

	@Column(length=5)
	private String status;

	@Column(name="tmpl_id", nullable=false)
	private int tmplId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(length=128)
	private String url;

	public MenuInfo() {
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getOrderFlag() {
		return this.orderFlag;
	}

	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}

	public int getParMenuId() {
		return this.parMenuId;
	}

	public void setParMenuId(int parMenuId) {
		this.parMenuId = parMenuId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getRootFlag() {
		return this.rootFlag;
	}

	public void setRootFlag(int rootFlag) {
		this.rootFlag = rootFlag;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTmplId() {
		return this.tmplId;
	}

	public void setTmplId(int tmplId) {
		this.tmplId = tmplId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}