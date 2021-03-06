package com.ncs.gsyt.modules.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
/**
 * 水产生产档案记录
 * 
 * 投入品采购  ， 对应的实体类；
 * **/
//产品表
@Entity
@Table(name = "T_CAIGOU")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CaiGou implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long caigouID;//引种记录ID
			
	@Column(length=50)
	private Date input_time;//采购时间
	
	@Column
	private String name;//饵料或者药物品种
	
	@Column
	private String include;//主要成分及含量
	
	@Column
	private String count;//数量
	
	@Column
	private String guige;//规格
	
	@Column
	private String dengjiCode;//登记证号
	
	@Column
	private String proFactory;//生产单位
	
	@Column
	private String saleFactory;//销售单位
	
	@Column
	private String piaojuCode;//票据号
	
	@Column
	private String jingbanren;//经办人

	/*@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应所属企业
*/
	
	private long enterpriseID;//所属企业ID
	
	@Column
	private String enterpriseName;//所属企业名称
	@Transient
	private long idss;
	
	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}
	
	public long getIdss() {
		return idss;
	}

	public void setIdss(long idss) {
		this.idss = idss;
	}

	public long getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(long enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public long getCaigouID() {
		return caigouID;
	}

	public void setCaigouID(long caigouID) {
		this.caigouID = caigouID;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date inputTime) {
		input_time = inputTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getDengjiCode() {
		return dengjiCode;
	}

	public void setDengjiCode(String dengjiCode) {
		this.dengjiCode = dengjiCode;
	}

	public String getProFactory() {
		return proFactory;
	}

	public void setProFactory(String proFactory) {
		this.proFactory = proFactory;
	}

	public String getSaleFactory() {
		return saleFactory;
	}

	public void setSaleFactory(String saleFactory) {
		this.saleFactory = saleFactory;
	}

	public String getPiaojuCode() {
		return piaojuCode;
	}

	public void setPiaojuCode(String piaojuCode) {
		this.piaojuCode = piaojuCode;
	}

	public String getJingbanren() {
		return jingbanren;
	}

	public void setJingbanren(String jingbanren) {
		this.jingbanren = jingbanren;
	}
/*
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
		*/
	


}
