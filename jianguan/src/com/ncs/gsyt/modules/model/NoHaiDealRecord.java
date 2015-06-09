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
 * 无害化处理记录表  ------对应的实体类
 * 
 * **/
/*商品表*/
@Entity
@Table(name = "T_NOHAIDEAL")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NoHaiDealRecord implements Serializable{
	
	

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long dealRecordID;//WAP版使用主键
		
		@Column(length=10)
		private Date createDate;//日期
		
		@Column(length=100)
		private String dealObject;//处理对象
		
		@Column(length=10)
		private String dealReason;//处理原因
		
		@Column(length=50)
		private String dealCount;//处理数量
		
		@Column(length=20)
		private String dealMethod;//处理方法
		
		@Column(length=20)
		private String carry_name;//执行人
		
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


		public long getDealRecordID() {
			return dealRecordID;
		}


		public void setDealRecordID(long dealRecordID) {
			this.dealRecordID = dealRecordID;
		}


		public Date getCreateDate() {
			return createDate;
		}


		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}


		public String getDealObject() {
			return dealObject;
		}


		public void setDealObject(String dealObject) {
			this.dealObject = dealObject;
		}


		public String getDealReason() {
			return dealReason;
		}


		public void setDealReason(String dealReason) {
			this.dealReason = dealReason;
		}

		public String getDealCount() {
			return dealCount;
		}

		public void setDealCount(String dealCount) {
			this.dealCount = dealCount;
		}

		public String getDealMethod() {
			return dealMethod;
		}


		public void setDealMethod(String dealMethod) {
			this.dealMethod = dealMethod;
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


		/*public Enterprise getEnterprise() {
			return enterprise;
		}


		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}
*/
		
		
}
