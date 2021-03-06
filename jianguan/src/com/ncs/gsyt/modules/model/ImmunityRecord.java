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
 * 免疫记录  对应的实体类
 * 
 * 
 * **/
//产品表
@Entity
@Table(name = "T_IMMUNITY")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ImmunityRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long immunityID;//产品ID
		
	@Column(length=50)
	private Date immunity_time;//免疫时间
	
	@Column(length=50)
	private String immunity_ais;//免疫病种
	
	@Column(length=50)
	private String count;//免疫数量
	
	@Column(length=50)
	private String immunity_f;//免疫方法；
	
	@Transient
	private long idss;
	
	public long getIdss() {
		return idss;
	}

	public void setIdss(long idss) {
		this.idss = idss;
	}

	@Column(length=50)
	private String proFactory;//疫苗生产厂家
	
	@Column(length=50)
	private String immunity_Code;//疫苗批号
	

	private int immunity_count;//未免疫数
	
	@Column(length=50)
	private String imm_because;//未免疫原因；
	
	@Column(length=50)
	private String number;//未免室编号
	
	@Column(length=50)
	private String imm_name;//防疫人；
	
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；

	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public long getImmunityID() {
		return immunityID;
	}

	public void setImmunityID(long immunityID) {
		this.immunityID = immunityID;
	}

	public Date getImmunity_time() {
		return immunity_time;
	}

	public void setImmunity_time(Date immunityTime) {
		immunity_time = immunityTime;
	}

	public String getImmunity_ais() {
		return immunity_ais;
	}

	public void setImmunity_ais(String immunityAis) {
		immunity_ais = immunityAis;
	}

	

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getImmunity_f() {
		return immunity_f;
	}

	public void setImmunity_f(String immunityF) {
		immunity_f = immunityF;
	}

	public String getProFactory() {
		return proFactory;
	}

	public void setProFactory(String proFactory) {
		this.proFactory = proFactory;
	}

	public String getImmunity_Code() {
		return immunity_Code;
	}

	public void setImmunity_Code(String immunityCode) {
		immunity_Code = immunityCode;
	}

	public int getImmunity_count() {
		return immunity_count;
	}

	public void setImmunity_count(int immunityCount) {
		immunity_count = immunityCount;
	}

	public String getImm_because() {
		return imm_because;
	}

	public void setImm_because(String immBecause) {
		imm_because = immBecause;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getImm_name() {
		return imm_name;
	}

	public void setImm_name(String immName) {
		imm_name = immName;
	}
		
	
	
		

}
