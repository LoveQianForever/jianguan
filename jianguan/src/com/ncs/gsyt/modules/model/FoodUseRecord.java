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
 * 饲料使用情况记录表， 对应的实体类
 * 
 * **/
//产品表
@Entity
@Table(name = "T_FOODUSERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FoodUseRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long foodUseRecord;//饲料使用记录ID
		
	@Column(length=50)
	private Date use_time;//使用时间
	/**--------doc 表需要年月日---------------------**/
	@Column(length=50)
	private String year1;//使用时间
	
	@Column(length=50)
	private String month1;//使用时间
	
	@Column(length=50)
	private String day1;//使用时间
	/**--------doc 表需要年月日---------------------**/
	@Column(length=50)
	private String  use_count;//使用数量
	@Transient
	private long idss;	

	public long getIdss() {
		return idss;
	}


	public void setIdss(long idss) {
		this.idss = idss;
	}


	@ManyToOne
	@JoinColumn(name = "inmedicienfoodID", referencedColumnName = "inmedicienfoodID")
	private InFoodMedicine inFoodMedicine;//对应采购的 药品 和饲料
/*
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应 禽类生产记录档案，具体的某个禽类企业
*/
	private long enterpriseID;//所属企业的ID
	
	
	@Column(length=50)
	private String enterpriseName;//所属企业的名称

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


	public InFoodMedicine getInFoodMedicine() {
		return inFoodMedicine;
	}


	public void setInFoodMedicine(InFoodMedicine inFoodMedicine) {
		this.inFoodMedicine = inFoodMedicine;
	}

/*
	public Enterprise getEnterprise() {
		return enterprise;
	}


	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}*/


	public long getFoodUseRecord() {
		return foodUseRecord;
	}


	public void setFoodUseRecord(long foodUseRecord) {
		this.foodUseRecord = foodUseRecord;
	}


	public Date getUse_time() {
		return use_time;
	}


	public void setUse_time(Date useTime) {
		use_time = useTime;
	}

	public String getUse_count() {
		return use_count;
	}


	public void setUse_count(String use_count) {
		this.use_count = use_count;
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


	

}
