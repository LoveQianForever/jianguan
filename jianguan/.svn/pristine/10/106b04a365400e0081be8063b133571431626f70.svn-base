package com.ncs.gsyt.modules.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_FUNCTION")
public class Function implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Function() {
		super();
	}
	
	public Function(String code, String name) {
		this.functionCode = code;
		this.functionName = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String functionCode;

	private String functionName;

	@ManyToOne
	@JoinColumn(name = "nodeCode", referencedColumnName = "nodeCode")
	private Menu menu;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
