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
 * 投入品（药物、饲料）采购记录表  ------对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_PIGFOODMEDICINERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InPigFoodMedicineRecord implements Serializable{
	

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long ipigFoodMedicineID;//WAP版使用主键
		
		@Column(length=10)
		private Date createTime;//日期
		@Column(length=50)
		private String count;//数量
		
		@Column(length=100)
		private String buy_name;//采购人
		
		private long enterpriseDI;//所属企业ID
		
		@Column(length=20)
		private String enterpriseName;//所属企业name
		
		
		@ManyToOne
		@JoinColumn(name = "pigFoodMedicineID", referencedColumnName = "pigFoodMedicineID")
		private InPigFoodMedicine inPigFoodMedicine;//对应采购的 品种

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

		public long getIpigFoodMedicineID() {
			return ipigFoodMedicineID;
		}


		public void setIpigFoodMedicineID(long ipigFoodMedicineID) {
			this.ipigFoodMedicineID = ipigFoodMedicineID;
		}


		public Date getCreateTime() {
			return createTime;
		}


		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getBuy_name() {
			return buy_name;
		}


		public void setBuy_name(String buyName) {
			buy_name = buyName;
		}


	

		public long getEnterpriseDI() {
			return enterpriseDI;
		}


		public void setEnterpriseDI(long enterpriseDI) {
			this.enterpriseDI = enterpriseDI;
		}


		public String getEnterpriseName() {
			return enterpriseName;
		}


		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}


		public InPigFoodMedicine getInPigFoodMedicine() {
			return inPigFoodMedicine;
		}


		public void setInPigFoodMedicine(InPigFoodMedicine inPigFoodMedicine) {
			this.inPigFoodMedicine = inPigFoodMedicine;
		}
		

		
}
