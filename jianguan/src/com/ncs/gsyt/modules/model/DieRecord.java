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
 * 禽类生产记录档案
 * 
 * 病死以及产品无害化处理记录
 * 
 * 对应的实体类
 * 
 * **/
//产品表
@Entity
@Table(name = "T_DIERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DieRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long dieRecordID;//病死处理ID
		
		@Column(length=50)
		private Date record_time;//病死处理时间
		
		@Column(length=50)
		private String count;//病死数量（羽）
		
		@Column(length=1000)
		private String dieReason;//病死原因
		
		@Column(length=50)
		private String dealMethod;//处理方法
		
		@Column(length=50)
		private String deal_name;//负责人
		
		@ManyToOne
		@JoinColumn(name = "poultryID", referencedColumnName = "poultryID")
		private PoultryKinds poultryKinds;//对应家禽品种；
		
		private long enterpriseID;//对应所属企业的ID
		
		@Column(length=50)
		private String enterpriseName;//对应所属企业的名称
		
		/*@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}*/
		
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



		public long getDieRecordID() {
			return dieRecordID;
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

		public void setDieRecordID(long dieRecordID) {
			this.dieRecordID = dieRecordID;
		}

		public Date getRecord_time() {
			return record_time;
		}

		public void setRecord_time(Date recordTime) {
			record_time = recordTime;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getDieReason() {
			return dieReason;
		}

		public void setDieReason(String dieReason) {
			this.dieReason = dieReason;
		}

		public String getDealMethod() {
			return dealMethod;
		}

		public void setDealMethod(String dealMethod) {
			this.dealMethod = dealMethod;
		}

		public String getDeal_name() {
			return deal_name;
		}

		public void setDeal_name(String dealName) {
			deal_name = dealName;
		}

		public PoultryKinds getPoultryKinds() {
			return poultryKinds;
		}

		public void setPoultryKinds(PoultryKinds poultryKinds) {
			this.poultryKinds = poultryKinds;
		}
		
		
		

}
