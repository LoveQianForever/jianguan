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
@Table(name = "T_SALERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SaleRecord  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long saleID;//销售记录ID
		
	@Column(length=50)
	private Date sale_time;//销售时间
	
	@Column(length=50)
	private String count;//销售数量
	
	@Column(length=50)
	private String salePlace;//销售地
	
	@Column(length=50)
	private String buyName;//购买人
	
	@Column(length=50)
	private String buyTelephone;//购买人电话
	
	@Column(length=50)
	private String checkout;//是否检疫 1、是  2、否
	
	@Column(length=50)
	private String checkName;//检疫员
	
	@Column(length=50)
	private String checkCode;//检疫证号
	
	@Transient
	private String monthh;//用于在word 模板中显示月份的
	
	@Transient
	private String dayth;//用于在word 模板中显示 天 的；
	
	@Transient
	private String yeardd;//用于记录年份的；
	
	public String getYeardd() {
		return yeardd;
	}

	public void setYeardd(String yeardd) {
		this.yeardd = yeardd;
	}

	public String getMonthh() {
		return monthh;
	}

	public void setMonthh(String monthh) {
		this.monthh = monthh;
	}

	public String getDayth() {
		return dayth;
	}

	public void setDayth(String dayth) {
		this.dayth = dayth;
	}

	@Transient
	private long idss;
	public long getIdss() {
		return idss;
	}

	public void setIdss(long idss) {
		this.idss = idss;
	}

	@Column(length=50)
	private String piCi;//批次，用于保存溯源里的“批次”概念
	
	
	public String getPiCi() {
		return piCi;
	}

	public void setPiCi(String piCi) {
		this.piCi = piCi;
	}
	
	@ManyToOne
	@JoinColumn(name = "poultryID", referencedColumnName = "poultryID")
	private PoultryKinds poultryKinds;//对应家禽种类产品
	
	@Column(length=50)
	private String enterpriseName;//对应所属企业名称
	
	private long enterpriseID;//对应所属企业ID
	/*@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}*/

	
	public long getSaleID() {
		return saleID;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public long getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(long enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public void setSaleID(long saleID) {
		this.saleID = saleID;
	}

	public Date getSale_time() {
		return sale_time;
	}

	public void setSale_time(Date saleTime) {
		sale_time = saleTime;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getSalePlace() {
		return salePlace;
	}

	public void setSalePlace(String salePlace) {
		this.salePlace = salePlace;
	}

	public String getBuyName() {
		return buyName;
	}

	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}

	public String getBuyTelephone() {
		return buyTelephone;
	}

	public void setBuyTelephone(String buyTelephone) {
		this.buyTelephone = buyTelephone;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public PoultryKinds getPoultryKinds() {
		return poultryKinds;
	}

	public void setPoultryKinds(PoultryKinds poultryKinds) {
		this.poultryKinds = poultryKinds;
	}
		
	
	
}
