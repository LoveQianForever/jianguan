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
@Table(name = "T_XIAODU")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
/**
 * 农产品生猪类生产记录
 * 
 * 兽药使用记录表  ------对应的实体类
 * 
 * **/
public class XiaoDuRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long xiaoduRecordID;//WAP版使用主键
		
		@Column(length=10)
		private Date createDate;//消毒时间
		
		@Column(length=50)
		private String year1;//nian
		
		@Column(length=50)
		private String month1;//yue
		
		@Column(length=50)
		private String day1;//ri
		
		@Column(length=100)
		private String proObject;//消毒对象
		
		@Column(length=10)
		private String productName;//消毒剂名称
		
		@Column(length=50)
		private String count;//消毒剂用量
		
		@Column(length=50)
		private String xiaoDuFa;//消毒方法
		
		@Column(length=20)
		private String carry_name;//执行人员
		
		@Column(length=20)
		private String content;//备  注
		
		
		/*@ManyToOne
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

		
		public String getYear1() {
			return year1;
		}

		public void setYear1(String year1) {
			this.year1 = year1;
		}

		public String getMonth1() {
			return month1;
		}

		public void setMonth1(String month1) {
			this.month1 = month1;
		}

		public String getDay1() {
			return day1;
		}

		public void setDay1(String day1) {
			this.day1 = day1;
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

		public long getXiaoduRecordID() {
			return xiaoduRecordID;
		}


		public void setXiaoduRecordID(long xiaoduRecordID) {
			this.xiaoduRecordID = xiaoduRecordID;
		}


		public Date getCreateDate() {
			return createDate;
		}


		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}


		public String getProObject() {
			return proObject;
		}


		public void setProObject(String proObject) {
			this.proObject = proObject;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getXiaoDuFa() {
			return xiaoDuFa;
		}


		public void setXiaoDuFa(String xiaoDuFa) {
			this.xiaoDuFa = xiaoDuFa;
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
