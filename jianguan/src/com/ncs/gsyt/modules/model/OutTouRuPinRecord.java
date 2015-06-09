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
 * 
 * 农业投入品记录
 * 
 * 农业投入品出货记录  对应的实体类
 * **/
@Entity
@Table(name = "T_OUTTOURUPINRECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class OutTouRuPinRecord implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long outrecordID;//出货ID
		
	@Column(length=50)
	private String names;//姓名
	
	@Column(length=50)
	private String addressPhone;//地址、电话（乡、村、组）
	
	@Column(length=50)
	private String count;//数量
			
	@Column(length=50)
	private Date input_time;//供货时间
			
	@Transient
	private long idss;
			
	private long enterpriseID;//所属企业ID
			
	@Column(length=50)
	private String enterpriseName;//所属企业名称
			
			
	@ManyToOne
	@JoinColumn(name = "tourupinID", referencedColumnName = "tourupinID")
	private TouRuPin touRuPin;//对应商品种类

	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}

	public long getOutrecordID() {
		return outrecordID;
	}


	public void setOutrecordID(long outrecordID) {
		this.outrecordID = outrecordID;
	}

	public String getNames() {
		return names;
	}


	public void setNames(String names) {
		this.names = names;
	}


	public String getAddressPhone() {
		return addressPhone;
	}


	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Date getInput_time() {
		return input_time;
	}


	public void setInput_time(Date inputTime) {
		input_time = inputTime;
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


	public TouRuPin getTouRuPin() {
		return touRuPin;
	}


	public void setTouRuPin(TouRuPin touRuPin) {
		this.touRuPin = touRuPin;
	}


}
