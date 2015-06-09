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

/**
 * 农产品生猪类生产记录
 * 
 * 饲料使用记录表  ------对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_PIGFOODRECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class PigFoodUseRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long pigFoodURecordID;//WAP版使用主键
		
		@Column(length=10)
		private Date createTime;//投放日期
		
		@Column(length=100)
		private String foodNumber;//饲料型号
		
		@Column(length=10)
		private String room;//喂饲栏舍
		
		@Column(length=50)
		private String useCount;//投入量
		
		@Column(length=50)
		private String pigNum;//猪只数量
		
		@Column(length=20)
		private String siYang_name;//饲养人员
		
		@Column(length=20)
		private String content;//备注
		
		/*	
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应所属企业
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


		public long getPigFoodURecordID() {
			return pigFoodURecordID;
		}


		public void setPigFoodURecordID(long pigFoodURecordID) {
			this.pigFoodURecordID = pigFoodURecordID;
		}


		public Date getCreateTime() {
			return createTime;
		}


		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}


		public String getFoodNumber() {
			return foodNumber;
		}


		public void setFoodNumber(String foodNumber) {
			this.foodNumber = foodNumber;
		}


		public String getRoom() {
			return room;
		}


		public void setRoom(String room) {
			this.room = room;
		}
		
		public String getUseCount() {
			return useCount;
		}

		public void setUseCount(String useCount) {
			this.useCount = useCount;
		}

		public String getPigNum() {
			return pigNum;
		}

		public void setPigNum(String pigNum) {
			this.pigNum = pigNum;
		}

		public String getSiYang_name() {
			return siYang_name;
		}


		public void setSiYang_name(String siYangName) {
			siYang_name = siYangName;
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
		}*/

		
}
