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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Table(name = "T_SEEDMANAGER")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SeedManager implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long seedManagerID;//种子id
	
	@Column(length=100)
	private String manageRecord;//种子监管记录
	
	@Column(length=100)
	private String lastCreatetime;//最后登记时间
	
	@Column(length=50)
	private String name;//经营单位名称
				
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=50)
	private String license_code;//经营许可证
		
	public String getLicense_code() {
		return license_code;
	}

	public void setLicense_code(String licenseCode) {
		license_code = licenseCode;
	}

	@Column(length=50)
	private Date time;//成立时间


	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public long getSeedManagerID() {
		return seedManagerID;
	}

	public void setSeedManagerID(long seedManagerID) {
		this.seedManagerID = seedManagerID;
	}

	public String getManageRecord() {
		return manageRecord;
	}

	public void setManageRecord(String manageRecord) {
		this.manageRecord = manageRecord;
	}

	public String getLastCreatetime() {
		return lastCreatetime;
	}

	public void setLastCreatetime(String lastCreatetime) {
		this.lastCreatetime = lastCreatetime;
	}

	
	
	
	
	
	
	

}
