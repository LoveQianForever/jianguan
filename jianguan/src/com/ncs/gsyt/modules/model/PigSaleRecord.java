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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/*商品表*/
@Entity
@Table(name = "T_PIGSALE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/**
 * 农产品生猪类生产记录
 * 
 * 饲料使用记录表  ------对应的实体类
 * 
 * **/
public class PigSaleRecord implements Serializable{
	

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long pigSaleID;//WAP版使用主键
		
		@Column(length=10)
		private Date saleDate;//销售日期
		
		@Column(length=100)
		private String leiBie;//猪只类别
		
		@Column(length=50)
		private int count;//销售头数
		
		@Column(length=50)
		private String erBiao;//耳    标
		
		@Column(length=50)
		private String singlePrice;//销售单价
		
		@Column(length=50)
		private String weight;//销售总重量
		
		@Column(length=20)
		private String salePlace;//销 售去 向
		
		@Column(length=20)
		private String carry_name;//执行人
		
		@Column(length=20)
		private String content;//检疫结论
		
		
		/*@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应商品种类
*/

		private long enterpriseID;// 所属企业ID
		
		@Column(length=20)
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

		public long getPigSaleID() {
			return pigSaleID;
		}


		public void setPigSaleID(long pigSaleID) {
			this.pigSaleID = pigSaleID;
		}


		public Date getSaleDate() {
			return saleDate;
		}


		public void setSaleDate(Date saleDate) {
			this.saleDate = saleDate;
		}


		public String getLeiBie() {
			return leiBie;
		}


		public void setLeiBie(String leiBie) {
			this.leiBie = leiBie;
		}


		public int getCount() {
			return count;
		}


		public void setCount(int count) {
			this.count = count;
		}


		public String getErBiao() {
			return erBiao;
		}


		public void setErBiao(String erBiao) {
			this.erBiao = erBiao;
		}

		public String getSinglePrice() {
			return singlePrice;
		}

		public void setSinglePrice(String singlePrice) {
			this.singlePrice = singlePrice;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getSalePlace() {
			return salePlace;
		}


		public void setSalePlace(String salePlace) {
			this.salePlace = salePlace;
		}


		public String getCarry_name() {
			return carry_name;
		}


		public void setCarry_name(String carryName) {
			carry_name = carryName;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
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
