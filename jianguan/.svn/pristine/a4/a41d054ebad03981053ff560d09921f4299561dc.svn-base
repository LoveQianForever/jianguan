package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_MENU")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Menu implements Serializable, Comparable {

	public Menu() {
		super();
	}
	public Menu(String code, String name, String link, List<Function> funcs) {
		this.nodeCode = code;
		this.nodeName = name;
		this.linkURL = link;
		this.funcs = funcs;
	}
	private static final long serialVersionUID = 1L;

	@Id
	private String nodeCode;

	private String nodeName;

	private String viewSec = "0";

	private String parentNode;

	private String linkURL;
	
	private int sysType;//系统类型 0溯源 1GIS 2水产 3家禽 4大田 5大棚 6茶叶 7监管

	@OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
	private List<Function> funcs;
	
	@Transient
	private List<Function> myFuncs = new LinkedList<Function>();

	public List<Function> getFuncs() {
		return funcs;
	}

	public void setFuncs(List<Function> funcs) {
		this.funcs = funcs;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getViewSec() {
		return viewSec;
	}

	public void setViewSec(String viewSec) {
		this.viewSec = viewSec;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	public String getLinkURL() {
		return linkURL;
	}

	public void setLinkURL(String linkURL) {
		this.linkURL = linkURL;
	}

	/** 根据URL把方法装进里菜单 */
	public static void functionINTOMenu(Map<String, Menu> menuList,
			List<Function> funcList) {
		for (int i = 0; i < funcList.size(); i++) {
			Function f = funcList.get(i);
			Menu m = menuList.get(f.getMenu().getLinkURL());
			m.getMyFuncs().add(f);
		}
	}

	public List<Function> getMyFuncs() {
		return myFuncs;
	}

	public void setMyFuncs(List<Function> myFuncs) {
		this.myFuncs = myFuncs;
	}
	public int getSysType() {
		return sysType;
	}
	public void setSysType(int sysType) {
		this.sysType = sysType;
	}
	
	@Override
    public int compareTo(Object o){  
		Menu menu = (Menu)o;
		return this.getNodeCode().compareTo(menu.getNodeCode());
	}
	
	@Override
    public boolean equals(Object o){
		boolean flag = false;
		if(o instanceof Menu){
			if(this.nodeCode.equals(((Menu) o).nodeCode)) {
				 flag = true;
			}
		}
		return flag;
	}
}
