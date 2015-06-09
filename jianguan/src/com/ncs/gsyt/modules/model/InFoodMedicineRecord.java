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
 * 投入品（药品、饲料等）采购记录
 * 
 * 
 * **/
//产品表
@Entity
@Table(name = "T_INFOODMEDICINERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class InFoodMedicineRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long inMFRecordID;//投入品记录ID
		
		@Column(length=20)
		private String count;//数量
		
		@Column(length=20)
		private String buyName;//采购人
		
		@Column(length=20)
		private Date input_time;//采购时间
		
		@ManyToOne
		@JoinColumn(name = "inmedicienfoodID", referencedColumnName = "inmedicienfoodID")
		private InFoodMedicine inFoodMedicine;//对应 投入品（药品、饲料等）
		
		public InFoodMedicine getInFoodMedicine() {
			return inFoodMedicine;
		}

		public void setInFoodMedicine(InFoodMedicine inFoodMedicine) {
			this.inFoodMedicine = inFoodMedicine;
		}

		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应 供货商【供应药品，饲料的供货商1】
/*	
		private long enterpriseDI;//对应其中的 供应商1；ID
		@Column(length=20)
		private String enterprisename;//对应其中的 供应商1 名称
*/		@Transient
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

		@ManyToOne
		@JoinColumn(name = "supplyID", referencedColumnName = "supplyID")
		private FoodMedicineSupply foodMedicineSupply;//对应 供货商【供应药品，饲料的供货商2】

		public FoodMedicineSupply getFoodMedicineSupply() {
			return foodMedicineSupply;
		}

		public void setFoodMedicineSupply(FoodMedicineSupply foodMedicineSupply) {
			this.foodMedicineSupply = foodMedicineSupply;
		}

		private long enterpriseDI;//这个字段 具体是为了对应到，家禽生产者企业名下，和具体某个企业相关的
		
		

		public long getEnterpriseDI() {
			return enterpriseDI;
		}

		public void setEnterpriseDI(long enterpriseDI) {
			this.enterpriseDI = enterpriseDI;
		}

		@Column(length=20)
		private String enterpriseName;//这个字段 具体是为了对应到，家禽生产者企业名下，和具体某个企业相关的
		
		
		
/*
		public long getEnterpriseDI() {
			return enterpriseDI;
		}

		public void setEnterpriseDI(long enterpriseDI) {
			this.enterpriseDI = enterpriseDI;
		}

		public String getEnterprisename() {
			return enterprisename;
		}

		public void setEnterprisename(String enterprisename) {
			this.enterprisename = enterprisename;
		}*/

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}

		
/*
		public FoodMedicineSupply getFoodMedicineSupply() {
			return foodMedicineSupply;
		}

		public void setFoodMedicineSupply(FoodMedicineSupply foodMedicineSupply) {
			this.foodMedicineSupply = foodMedicineSupply;
		}

		*/

		public long getInMFRecordID() {
			return inMFRecordID;
		}

		public void setInMFRecordID(long inMFRecordID) {
			this.inMFRecordID = inMFRecordID;
		}

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getBuyName() {
			return buyName;
		}

		public void setBuyName(String buyName) {
			this.buyName = buyName;
		}

		public Date getInput_time() {
			return input_time;
		}

		public void setInput_time(Date inputTime) {
			input_time = inputTime;
		}

		
		
		
}
