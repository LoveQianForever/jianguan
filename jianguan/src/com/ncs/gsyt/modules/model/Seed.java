package com.ncs.gsyt.modules.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * 种子商品表
 * 
 *  t_seed**/
@Entity
@Table(name = "T_SEED")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Seed implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long seed_id;//商品ID
				
	@Column(length=50)
	private String seed_name;//商品名称
			
	@Column(length=50)
	private String seed_group;//商品组合
	
	@Column(length=50)
	private String seed_place;//产地
	
	@Column(length=50)
	private String seed_code;//商品批号
	
	@Column(length=50)
	private String seed_pack;//包装
	
	@Column(length=50)
	private String store_condition;//存储条件
	
	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//所属企业

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public long getSeed_id() {
		return seed_id;
	}

	public void setSeed_id(long seedId) {
		seed_id = seedId;
	}

	public String getSeed_name() {
		return seed_name;
	}

	public void setSeed_name(String seedName) {
		seed_name = seedName;
	}

	public String getSeed_group() {
		return seed_group;
	}

	public void setSeed_group(String seedGroup) {
		seed_group = seedGroup;
	}

	public String getSeed_place() {
		return seed_place;
	}

	public void setSeed_place(String seedPlace) {
		seed_place = seedPlace;
	}

	public String getSeed_code() {
		return seed_code;
	}

	public void setSeed_code(String seedCode) {
		seed_code = seedCode;
	}

	public String getSeed_pack() {
		return seed_pack;
	}

	public void setSeed_pack(String seedPack) {
		seed_pack = seedPack;
	}

	public String getStore_condition() {
		return store_condition;
	}

	public void setStore_condition(String storeCondition) {
		store_condition = storeCondition;
	}
			
			
}
