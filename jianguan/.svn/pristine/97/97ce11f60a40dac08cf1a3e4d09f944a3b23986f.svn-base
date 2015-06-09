package com.ncs.gsyt.modules.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * 种子商品表
 * 
 *  t_seed**/
@Entity
@Table(name = "SEED_ENTERPRISE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SeedEnterprise implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long enid;//商品ID
					
	public long getEnid() {
		return enid;
	}

	public void setEnid(long enid) {
		this.enid = enid;
	}

	@Column(length=50)
	private String name;//经营单位名称
				
	@Column(length=50)
	private String license_code;//经营许可证
		
	@Column(length=50)
	private Date time;//成立时间

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense_code() {
		return license_code;
	}

	public void setLicense_code(String licenseCode) {
		license_code = licenseCode;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
		
	

}
