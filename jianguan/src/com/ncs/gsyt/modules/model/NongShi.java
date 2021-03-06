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
 * 生产基地   对应的实体类
 * **/

@Entity
@Table(name = "T_NONGSHI")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class NongShi implements Serializable{
	
			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private long nongShiID;//ID
				
			@Column(length=50)
			private Date input_time;//日期
			
			@Column(length=50)
			private String code;//田块编号
			
			@Column(length=50)
			private String name;//作物名称（注明品种
			
			@Column(length=50)
			private String area;//作业面积
			
			@Column(length=50)
			private String content;//作业内容
			
			@Column(length=50)
			private String touruPin;//农业投入品（肥、药、商品
			
			@Column(length=50)
			private String count;//用量
			
			@Column(length=50)
			private String tianQi;//天气状况
			
			@Column(length=50)
			private String jiLuRen;//记录人
			
			@Column(length=50)
			private String simpleContent;//备注
			
			private long enterpriseID;
			
			@Column(length=50)
			private String enterpriseName;
			
			@Transient
			private long idss;
			
			@Column(length=50)
			private String piCi;//批次，用于保存溯源里的“批次”概念
			
			@ManyToOne
			@JoinColumn(name = "baseID", referencedColumnName = "baseID")
			private ShengChanBase shengChanBase; //所属基地
			
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

			public long getNongShiID() {
				return nongShiID;
			}

			public void setNongShiID(long nongShiID) {
				this.nongShiID = nongShiID;
			}

			public Date getInput_time() {
				return input_time;
			}

			public void setInput_time(Date inputTime) {
				input_time = inputTime;
			}

			public String getCode() {
				return code;
			}

			public void setCode(String code) {
				this.code = code;
			}

			

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getArea() {
				return area;
			}

			public void setArea(String area) {
				this.area = area;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public String getTouruPin() {
				return touruPin;
			}

			public void setTouruPin(String touruPin) {
				this.touruPin = touruPin;
			}

			public String getCount() {
				return count;
			}

			public void setCount(String count) {
				this.count = count;
			}

			public String getTianQi() {
				return tianQi;
			}

			public void setTianQi(String tianQi) {
				this.tianQi = tianQi;
			}

			public String getJiLuRen() {
				return jiLuRen;
			}

			public void setJiLuRen(String jiLuRen) {
				this.jiLuRen = jiLuRen;
			}

			public String getSimpleContent() {
				return simpleContent;
			}

			public void setSimpleContent(String simpleContent) {
				this.simpleContent = simpleContent;
			}

			public ShengChanBase getShengChanBase() {
				return shengChanBase;
			}

			public void setShengChanBase(ShengChanBase shengChanBase) {
				this.shengChanBase = shengChanBase;
			}

			
}
