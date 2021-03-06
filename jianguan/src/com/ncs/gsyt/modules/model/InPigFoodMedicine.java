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
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 农产品生猪类生产记录
 * 
 * 投入品药物 饲料管理表  ------对应的实体类
 * 
 * **/
/*商品表*/
@Entity
@Table(name = "T_PIGFMEDICINE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InPigFoodMedicine implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long pigFoodMedicineID;//WAP版使用主键
		
		@Column(length=10)
		private String name;//品名
		
		@Column(length=100)
		private String proFactory;//商生产厂家
		
		@Column(length=10)
		private String piWenPiHao;//批文批号
		
		@Column(length=50)
		private String guige;//规格
		
		@Column(length=50)
		private String singlePrice;//单价（总金额）
		
		@Column(length=20)
		private Date lastTime;//有效期
		
	/*	
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应所属企业
*/

		private long enterpriseID;// 所属企业ID
		
		@Column(length=20)
		private String enterpriseName;//所属企业名称
		
		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		
		public String getPiCi() {
			return piCi;
		}

		public void setPiCi(String piCi) {
			this.piCi = piCi;
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


		public long getPigFoodMedicineID() {
			return pigFoodMedicineID;
		}


		public void setPigFoodMedicineID(long pigFoodMedicineID) {
			this.pigFoodMedicineID = pigFoodMedicineID;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getProFactory() {
			return proFactory;
		}


		public void setProFactory(String proFactory) {
			this.proFactory = proFactory;
		}


		public String getPiWenPiHao() {
			return piWenPiHao;
		}


		public void setPiWenPiHao(String piWenPiHao) {
			this.piWenPiHao = piWenPiHao;
		}


		public String getGuige() {
			return guige;
		}


		public void setGuige(String guige) {
			this.guige = guige;
		}

		public String getSinglePrice() {
			return singlePrice;
		}

		public void setSinglePrice(String singlePrice) {
			this.singlePrice = singlePrice;
		}

		public Date getLastTime() {
			return lastTime;
		}


		public void setLastTime(Date lastTime) {
			this.lastTime = lastTime;
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
