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
 * 种子 经营 销售表 
 * 即“销售处种子的表”
 * 
 *  t_seedout**/
@Entity
@Table(name = "T_SEEDOUT")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class SeedOut implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long seedout_id;//种子进货ID
			
		@Column(length=50)
		private String seed_company ;//供货公司
		
		
		@Column(length=50)
		private String count ;//数量（万公斤）//---
		
		@Column(length=50)
		private String contract_id;//合同编号
		
		@Column(length=50)
		private String output_time;//售出时间
		
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//购买者2 相关 
		

		@ManyToOne
		@JoinColumn(name = "enter_id", referencedColumnName = "enter_id")
		private BuySeed buySeed1;//购买者1
		
		public BuySeed getBuySeed1() {
			return buySeed1;
		}

		public void setBuySeed1(BuySeed buySeed1) {
			this.buySeed1 = buySeed1;
		}

		@ManyToOne
		@JoinColumn(name = "userID", referencedColumnName = "userID")
		private User user;//这是为了和卖者  销售商关联	

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
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}

		public String getOutput_time() {
			return output_time;
		}

		public void setOutput_time(String outputTime) {
			output_time = outputTime;
		}

		@Column(length=50)
		private String store_number;//贮藏仓号
		
		@Column(length=50)
		private String water;//入库时种子质量检疫结果  水分（%）
		
		@Column(length=50)
		private String neatness;//入库时种子质量检疫结果 净度（%）
		
		@Column(length=50)
		private String sprout;//入库时种子质量检疫结果 发芽率（%）
		
		@Column(length=50)
		private String pure;//入库时种子质量检疫结果 纯度（%）
		
		@Column(length=200)
		private String content;//备注信息
		
		@ManyToOne
		@JoinColumn(name = "seed_id", referencedColumnName = "seed_id")
		private Seed seed;//对应 种子商品 类

		public long getSeedout_id() {
			return seedout_id;
		}

		public void setSeedout_id(long seedoutId) {
			seedout_id = seedoutId;
		}

		public String getSeed_company() {
			return seed_company;
		}

		public void setSeed_company(String seedCompany) {
			seed_company = seedCompany;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getContract_id() {
			return contract_id;
		}

		public void setContract_id(String contractId) {
			contract_id = contractId;
		}

		

		public String getStore_number() {
			return store_number;
		}

		public void setStore_number(String storeNumber) {
			store_number = storeNumber;
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

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Seed getSeed() {
			return seed;
		}

		public void setSeed(Seed seed) {
			this.seed = seed;
		}

		
		
	}

