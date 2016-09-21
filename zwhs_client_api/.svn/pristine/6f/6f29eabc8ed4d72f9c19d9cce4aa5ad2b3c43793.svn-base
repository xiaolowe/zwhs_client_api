package cn.org.citycloud.zwhs.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rel_menu_role database table.
 * 
 */
@Entity
@Table(name="rel_menu_role")
@NamedQuery(name="RelMenuRole.findAll", query="SELECT r FROM RelMenuRole r")
public class RelMenuRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="menu_id", nullable=false)
	private int menuId;

	@Column(name="role_id", nullable=false)
	private int roleId;

	@Temporal(TemporalType.DATE)
	@Column(name="upd_date")
	private Date updDate;

	public RelMenuRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuId() {
		return this.menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}