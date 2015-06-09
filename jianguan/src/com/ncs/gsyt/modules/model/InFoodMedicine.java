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


/**
 * 禽类生产记录档案
 * 
 * 投入品（药品、饲料等）名称记录
 * 
 * **/
//产品表
@Entity
@Table(name = "T_MEDFOOD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InFoodMedicine implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long inmedicienfoodID;//投入品 ID
		
		@Column(length=50)
		private String mf_name;//投入品名称；

		@Column(length=50)
		private String proFactory;//生产厂家
		
		@Column(length=50)
		private String acceptCode;//批文批号
		
		@Column(length=50)
		private String packag;//规格
		
		@Column(length=50)
		private String siglePrice;//单价
		
		@Column(length=50)
		private String lastTime;//有效日期；
		

		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应的 具体某个养殖企业
		
		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		
		public String getPiCi() {
			return piCi;
		}

		public void setPiCi(String piCi) {
			this.piCi = piCi;
		}
		

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}

		
		
		public long getInmedicienfoodID() {
			return inmedicienfoodID;
		}

		public void setInmedicienfoodID(long inmedicienfoodID) {
			this.inmedicienfoodID = inmedicienfoodID;
		}

		public String getMf_name() {
			return mf_name;
		}

		public void setMf_name(String mfName) {
			mf_name = mfName;
		}

		public String getProFactory() {
			return proFactory;
		}

		public void setProFactory(String proFactory) {
			this.proFactory = proFactory;
		}

		public String getAcceptCode() {
			return acceptCode;
		}

		public void setAcceptCode(String acceptCode) {
			this.acceptCode = acceptCode;
		}

		public String getPackag() {
			return packag;
		}

		public void setPackag(String packag) {
			this.packag = packag;
		}

		public String getSiglePrice() {
			return siglePrice;
		}

		public void setSiglePrice(String siglePrice) {
			this.siglePrice = siglePrice;
		}

		public String getLastTime() {
			return lastTime;
		}

		public void setLastTime(String lastTime) {
			this.lastTime = lastTime;
		}
		
		
		
		
}
