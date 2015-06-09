package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//产品表
@Entity
@Table(name = "T_PRODUCT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Product implements Serializable{

	public Product() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productID;//产品ID
	
	@Column(length=50)
	private String productName;//产品名称
	
	@Column(length=50)
	private String packName;//包装名称
	
	@Column(length=1000)
	private String productPresent;//产品介绍
	
	@Column(length=50)
	private String productSpec;//产品规格
	
	@ManyToOne
	@JoinColumn(name = "productclassID", referencedColumnName = "productclassID")
	private ProductClass productClass;//对应产品种类

	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应企业
	
	@OneToMany(mappedBy = "product",cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
	private List<ProductAtta> attalist = new ArrayList<ProductAtta>();//产品附件
	
	@Transient
	private List<ProductClass> productclassList;//页面显示用下拉列表
	
	@Transient
	private List<Enterprise> enterpriseList;//页面显示用下拉列表
	
	@Transient
	private String attachStr;//页面显示附件图片

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getProductPresent() {
		return productPresent;
	}

	public void setProductPresent(String productPresent) {
		this.productPresent = productPresent;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public ProductClass getProductClass() {
		return productClass;
	}

	public void setProductClass(ProductClass productClass) {
		this.productClass = productClass;
	}

	public List<ProductAtta> getAttalist() {
		return attalist;
	}

	public void setAttalist(List<ProductAtta> attalist) {
		this.attalist = attalist;
	}
	
	public void addProductAtta(ProductAtta atta) {
		if (atta != null) {
			this.attalist.add(atta);
			atta.setProduct(this);
		}
	}

	public List<ProductClass> getProductclassList() {
		return productclassList;
	}

	public void setProductclassList(List<ProductClass> productclassList) {
		this.productclassList = productclassList;
	}

	public String getAttachStr() {
		return attachStr;
	}

	public void setAttachStr(String attachStr) {
		this.attachStr = attachStr;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	
	
}
