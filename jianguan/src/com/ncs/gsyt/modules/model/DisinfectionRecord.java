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
 * 防疫消毒记录 对应 的实体类
 * 
 * **/
//产品表
@Entity
@Table(name = "T_DISINFECTION")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DisinfectionRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long disinfectionID;//产品ID
		
		@Column(length=50)
		private Date createtime;//消毒时间
		
		@Column(length=50)
		private String scope;//消毒范围
		
		@Column(length=100)
		private String metho;//消毒方法
		
		@Column(length=50)
		private String proDisinf;//消毒药名称
		
		@Column(length=50)
		private String proFactory;//消毒药生产厂家
		
		@Column(length=50)
		private Date pro_time;//消毒药生产日期
		
		@Column(length=50)
		private Date lastTime;//消毒药有效期
		
		@Column(length=50)
		private String disinf_name;//消毒员
		
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；

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

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}

		public long getDisinfectionID() {
			return disinfectionID;
		}

		public void setDisinfectionID(long disinfectionID) {
			this.disinfectionID = disinfectionID;
		}

		public Date getCreatetime() {
			return createtime;
		}

		public void setCreatetime(Date createtime) {
			this.createtime = createtime;
		}

		public String getScope() {
			return scope;
		}

		public void setScope(String scope) {
			this.scope = scope;
		}

		public String getMetho() {
			return metho;
		}

		public void setMetho(String metho) {
			this.metho = metho;
		}

		public String getProDisinf() {
			return proDisinf;
		}

		public void setProDisinf(String proDisinf) {
			this.proDisinf = proDisinf;
		}

		public String getProFactory() {
			return proFactory;
		}

		public void setProFactory(String proFactory) {
			this.proFactory = proFactory;
		}

		public Date getPro_time() {
			return pro_time;
		}

		public void setPro_time(Date proTime) {
			pro_time = proTime;
		}

		public Date getLastTime() {
			return lastTime;
		}

		public void setLastTime(Date lastTime) {
			this.lastTime = lastTime;
		}

		public String getDisinf_name() {
			return disinf_name;
		}

		public void setDisinf_name(String disinfName) {
			disinf_name = disinfName;
		}
	

		
}
