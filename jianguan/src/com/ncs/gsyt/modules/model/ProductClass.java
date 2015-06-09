package com.ncs.gsyt.modules.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//产品种类表
@Entity
@Table(name = "T_PRODUCT_CLASS")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProductClass implements Serializable{

	public ProductClass() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productclassID;//产品种类ID
	
	@Column(length=50)
	private String productclassName;//产品种类名称
	
	@Column(length=50)
	private String productdclassSubject;//产品种类科目

	public long getProductclassID() {
		return productclassID;
	}

	public void setProductclassID(long productclassID) {
		this.productclassID = productclassID;
	}

	public String getProductclassName() {
		return productclassName;
	}

	public void setProductclassName(String productclassName) {
		this.productclassName = productclassName;
	}

	public String getProductdclassSubject() {
		return productdclassSubject;
	}

	public void setProductdclassSubject(String productdclassSubject) {
		this.productdclassSubject = productdclassSubject;
	}
	
	
}
