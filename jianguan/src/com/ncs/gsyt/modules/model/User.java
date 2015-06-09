package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_USER", uniqueConstraints = { @UniqueConstraint(columnNames = "USERCODE") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User implements Serializable {

	public User() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userID;

	private String userCode;

	private String userPassword;

	private String userName;

	
	private String enable;
	
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "roleid", referencedColumnName = "roleid")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//所属企业
	
	@ManyToOne
	@JoinColumn(name = "areaID", referencedColumnName = "areaID")
	private Area area;//所属地区
	
	@Column(precision=20, scale=14)
	private double lat=0.00;//纬度
	
	@Column(precision=20, scale=14)
	private double lng=0.00;//经度

	@Transient
	private List<Menu> menuList;
	@Transient
	private Map<String, Menu> menuMap;
	@Transient
	private String roleName;

	public User(String userName, List<Menu> menus, String rolename) {
		this.userName = userName;
		this.menuList = menus;
		this.roleName = rolename;
	}
	
	public User(String userName, String rolename, long id) {
		this.userName = userName;
		this.roleName = rolename;
		this.userID = id;
	}
	
	public User(long userid, String username) {
		this.userID = userid;
		this.userName = username;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Map<String, Menu> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(Map<String, Menu> menuMap) {
		this.menuMap = menuMap;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
}
