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
 * 兽药使用记录表  ------对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_CLEARFLUSH")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class XuShuiChiClear implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long clearID;//WAP版使用主键
		
		@Column(length=10)
		private Date createTime;//日期
		
		@Column(length=100)
		private String clearObject;//清洗对象
		
		@Column(length=10)
		private String attach;//附着物
		
		@Column(length=50)
		private String clearMethod;//清洗方式（使用消毒药剂及浓度）
		
		@Column(length=20)
		private String carry_name;//执行人员
		
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
		
		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		
		public String getPiCi() {
			return piCi;
		}

		public void setPiCi(String piCi) {
			this.piCi = piCi;
		}
		
		@Transient
		private long idss;
		
		
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


		public long getClearID() {
			return clearID;
		}



		public void setClearID(long clearID) {
			this.clearID = clearID;
		}



		public Date getCreateTime() {
			return createTime;
		}



		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}



		public String getClearObject() {
			return clearObject;
		}



		public void setClearObject(String clearObject) {
			this.clearObject = clearObject;
		}



		public String getAttach() {
			return attach;
		}



		public void setAttach(String attach) {
			this.attach = attach;
		}



		public String getClearMethod() {
			return clearMethod;
		}



		public void setClearMethod(String clearMethod) {
			this.clearMethod = clearMethod;
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
