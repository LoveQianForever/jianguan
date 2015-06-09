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
 * 
 * 农业投入品记录
 * 
 * 投入品对应的  实体类
 * **/
@Entity
@Table(name = "T_TOURUPIN")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TouRuPin implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long tourupinID;//ID
					
		@Column(length=50)
		private String name;//产品名称
				
		@Column(length=50)
		private String guige;//规格
				
		@Column(length=50)
		private String dengjiCode;//登记证号
				
				
		@Column(length=50)
		private String factory;//生产厂家
				
		@Column(length=50)
		private Date proDate;//生产日期
				
				
	/*	@Transient
		private long idss;*/
				
				
		private long enterpriseID;//所属企业ID
				
		@Column(length=50)
		private String enterpriseName;//所属企业名称

		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		
		public String getPiCi() {
			return piCi;
		}

		public void setPiCi(String piCi) {
			this.piCi = piCi;
		}
		
		public long getTourupinID() {
			return tourupinID;
		}

		public void setTourupinID(long tourupinID) {
			this.tourupinID = tourupinID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public String getFactory() {
			return factory;
		}

		public void setFactory(String factory) {
			this.factory = factory;
		}

		public Date getProDate() {
			return proDate;
		}

		public void setProDate(Date proDate) {
			this.proDate = proDate;
		}

		/*public long getIdss() {
			return idss;
		}

		public void setIdss(long idss) {
			this.idss = idss;
		}
*/
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
				
				

}
