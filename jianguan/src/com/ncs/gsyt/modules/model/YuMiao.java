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
 * 水产生产档案记录
 * 
 * 鱼苗放养记录  ， 对应的实体类；
 * **/
//产品表
@Entity
@Table(name = "T_YUMIAO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class YuMiao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long yumiaoID;//引种记录ID
			
	@Column(length=50)
	private Date input_time;//放养时间
			
	/*@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应所属企业
*/		
	@Column(length=50)
	private String count;//放养数量
	@Column
	private String name;//放养品种
		
	@Column
	private String guige;//规格

	@Column
	private String fromPlace;//苗种来源
	
	@Column
	private String jingBanRen;//经办人
	
	@Column
	private String content;//备注
	
	private long enterpriseID;//所属企业ID
	
	@Column
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

	public long getYumiaoID() {
		return yumiaoID;
	}

	public void setYumiaoID(long yumiaoID) {
		this.yumiaoID = yumiaoID;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date inputTime) {
		input_time = inputTime;
	}

	/*public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}*/

	

	public String getName() {
		return name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getJingBanRen() {
		return jingBanRen;
	}

	public void setJingBanRen(String jingBanRen) {
		this.jingBanRen = jingBanRen;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
