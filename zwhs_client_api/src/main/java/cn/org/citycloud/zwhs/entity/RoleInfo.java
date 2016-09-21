package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the role_info database table.
 * 
 */
@Entity
@Table(name="role_info")
@NamedQuery(name="RoleInfo.findAll", query="SELECT r FROM RoleInfo r")
public class RoleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id", unique=true, nullable=false)
	private int roleId;

	@Column(name="order_flag")
	private int orderFlag;

	@Column(length=150)
	private String remark;

	@Column(name="role_name", length=45)
	private String roleName;

	@Column(length=5)
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public RoleInfo() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getOrderFlag() {
		return this.orderFlag;
	}

	public void setOrderFlag(int orderFlag) {
		this.orderFlag = orderFlag;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}