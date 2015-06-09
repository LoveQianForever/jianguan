package com.ncs.gsyt.modules.model;
import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import javax.persistence.Table;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * 种子 经营 调入种子 表
 * 即“进货表”
 * 
 *  t_seedin**/
@Entity
@Table(name = "T_SEEDIN")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SeedIn  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long seedin_id;//种子进货ID
		
	@Column(length=50)
	private String buy_company ;//供货公司
	
	
	@Column(length=50)
	private String s_count ;//数量（万公斤）//---
	
	@Column(length=50)
	private String contract_id;//合同编号
	
	@Column(length=50)
	private String input_time;//进货时间
	
	
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//进货商
	
	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}
	
	@Transient
	private long enterpriseID;

	public long getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(long enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getInput_time() {
		return input_time;
	}

	public void setInput_time(String inputTime) {
		input_time = inputTime;
	}

	@Column(length=50)
	private String store_id;//贮藏仓号
	
	@Column(length=50)
	private String water;//入库时种子质量检疫结果  水分（%）
	
	@Column(length=50)
	private String neatness;//入库时种子质量检疫结果 净度（%）
	
	@Column(length=50)
	private String sprout;//入库时种子质量检疫结果 发芽率（%）
	
	@Column(length=50)
	private String pure;//入库时种子质量检疫结果 纯度（%）
	
	@Column(length=50)
	private String checkCode;//检疫证号
	
	@ManyToOne
	@JoinColumn(name = "seed_id", referencedColumnName = "seed_id")
	private Seed seed;//对应 种子商品 类

	public long getSeedin_id() {
		return seedin_id;
	}

	public void setSeedin_id(long seedinId) {
		seedin_id = seedinId;
	}

	public String getBuy_company() {
		return buy_company;
	}

	public void setBuy_company(String buyCompany) {
		buy_company = buyCompany;
	}

	public String getS_count() {
		return s_count;
	}

	public void setS_count(String sCount) {
		s_count = sCount;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contractId) {
		contract_id = contractId;
	}

	

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String storeId) {
		store_id = storeId;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getNeatness() {
		return neatness;
	}

	public void setNeatness(String neatness) {
		this.neatness = neatness;
	}

	public String getSprout() {
		return sprout;
	}

	public void setSprout(String sprout) {
		this.sprout = sprout;
	}

	public String getPure() {
		return pure;
	}

	public void setPure(String pure) {
		this.pure = pure;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	
			
	
	
}
