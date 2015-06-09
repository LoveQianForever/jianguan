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
 * 种植类生产记录档案
 * 
 * 生产资料购买记录   对应的实体类
 * **/

@Entity
@Table(name = "T_SHENGCHAN")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ShengChan implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long shengchanID;//ID
				
			@Column(length=50)
			private Date input_time;//日期
			
			@Column(length=50)
			private String name;//产品名称
			
			@Column(length=50)
			private String chengFen;//主要成分
			
			@Column(length=50)
			private String count;//数量
			
			@Column(length=50)
			private String checkCode;//产品批准登记号
			
			@Column(length=50)
			private String jiage;//价格
			
			@Column(length=50)
			private String proName;//生产单位
			
			@Column(length=50)
			private String jingYingName;//经营单位
			
			@Column(length=50)
			private String buyName;//购买人
			
			@Column(length=50)
			private String content;//备注
			
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
			private long enterpriseID;
			
			@Column(length=50)
			private String enterpriseName;
			
			
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

			public long getShengchanID() {
				return shengchanID;
			}

			public void setShengchanID(long shengchanID) {
				this.shengchanID = shengchanID;
			}

			public Date getInput_time() {
				return input_time;
			}

			public void setInput_time(Date inputTime) {
				input_time = inputTime;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getChengFen() {
				return chengFen;
			}

			public void setChengFen(String chengFen) {
				this.chengFen = chengFen;
			}

			public String getCount() {
				return count;
			}

			public void setCount(String count) {
				this.count = count;
			}

			public String getCheckCode() {
				return checkCode;
			}

			public void setCheckCode(String checkCode) {
				this.checkCode = checkCode;
			}

			public String getJiage() {
				return jiage;
			}

			public void setJiage(String jiage) {
				this.jiage = jiage;
			}

			public String getProName() {
				return proName;
			}

			public void setProName(String proName) {
				this.proName = proName;
			}

			public String getJingYingName() {
				return jingYingName;
			}

			public void setJingYingName(String jingYingName) {
				this.jingYingName = jingYingName;
			}

			public String getBuyName() {
				return buyName;
			}

			public void setBuyName(String buyName) {
				this.buyName = buyName;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			
}
