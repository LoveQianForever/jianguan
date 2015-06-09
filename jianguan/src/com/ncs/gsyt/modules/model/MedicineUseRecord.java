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

import com.ncs.gsyt.core.base.search.Search;


/**
 * 禽类生产记录档案
 * 
 * 兽药使用记录  对应的实体类
 * 
 * 
 * **/
//产品表
@Entity
@Table(name = "T_MEDICUSERED")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MedicineUseRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long useMedicineID;//产品ID
		
	@Column(length=50)
	private String use_name;//使用人
	
	@Column(length=50)
	private Date use_time;//使用时间
	
	@Column(length=50)
	private String use_count;//使用量
	
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
	private InFoodMedicine inFoodMedicine;//对应产品种类

	private long enterpriseID;//与所属企业相关的 企业名称字段
	
	@Column(length=50)
	private String enterpriseName;//与所属企业相关的 企业名称字段
	
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

	/*@ManyToOne
	@JoinColumn(name = "EnterpriseID", referencedColumnName = "EnterpriseID")
	private Enterprise enterprise;//对应禽类生产记录档案 ，具体的某个家禽企业；
*/
	/*public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}*/

	public long getUseMedicineID() {
		return useMedicineID;
	}

	public void setUseMedicineID(long useMedicineID) {
		this.useMedicineID = useMedicineID;
	}

	public String getUse_name() {
		return use_name;
	}

	public void setUse_name(String useName) {
		use_name = useName;
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

	
}
