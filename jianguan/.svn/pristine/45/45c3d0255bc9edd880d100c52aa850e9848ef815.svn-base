package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_ROLE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleid;

	private String rolename;

	private String roledesc;

	private String rolestatus;
	
	
	private String roletype;
	
	@Transient
	private String[] nodeCodes;

	@ManyToMany
	@JoinTable(name = "T_ROLE_MENU_REF", joinColumns = { @JoinColumn(name = "roleid") }, inverseJoinColumns = { @JoinColumn(name = "nodeCode") })
	private List<Menu> menus;

	@ManyToMany
	@JoinTable(name = "T_ROLE_FUN_REF", joinColumns = { @JoinColumn(name = "roleid") }, inverseJoinColumns = { @JoinColumn(name = "id") })
	private List<Function> funcs;	

	public String getRoletype() {
		return roletype;
	}

	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public List<Function> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Function> funcs) {
		this.funcs = funcs;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledesc() {
		return roledesc;
	}

	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	public String getRolestatus() {
		return rolestatus;
	}

	public void setRolestatus(String rolestatus) {
		this.rolestatus = rolestatus;
	}

	public String[] getNodeCodes() {
		return nodeCodes;
	}

	public void setNodeCodes(String[] nodeCodes) {
		this.nodeCodes = nodeCodes;
	}
	
	

}
