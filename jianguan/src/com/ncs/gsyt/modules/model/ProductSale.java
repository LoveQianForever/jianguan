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
@Table(name = "T_PRODUCTSALE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class ProductSale implements Serializable{
	
	
		
			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private long productSaleID;//ID
				
			@Column(length=50)
			private Date input_time;//日 期
			
			@Column(length=50)
			private String proPlace;//生产地点
			
			@Column(length=50)
			private String name;//销售产品名称
			
			@Column(length=50)
			private String count;//数量
			
			@Column(length=50)
			private String toPlace;//销售去向（市场、单位或个人
			
			@Column(length=50)
			private String jiLuRen;//记录人
			
			@Column(length=50)
			private String content;//备注
			
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

			public long getProductSaleID() {
				return productSaleID;
			}

			public void setProductSaleID(long productSaleID) {
				this.productSaleID = productSaleID;
			}

			public Date getInput_time() {
				return input_time;
			}

			public void setInput_time(Date inputTime) {
				input_time = inputTime;
			}

			public String getProPlace() {
				return proPlace;
			}

			public void setProPlace(String proPlace) {
				this.proPlace = proPlace;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getCount() {
				return count;
			}

			public void setCount(String count) {
				this.count = count;
			}

			public String getToPlace() {
				return toPlace;
			}

			public void setToPlace(String toPlace) {
				this.toPlace = toPlace;
			}

			public String getJiLuRen() {
				return jiLuRen;
			}

			public void setJiLuRen(String jiLuRen) {
				this.jiLuRen = jiLuRen;
			}

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public ShengChanBase getShengChanBase() {
				return shengChanBase;
			}

			public void setShengChanBase(ShengChanBase shengChanBase) {
				this.shengChanBase = shengChanBase;
			}
			
			

}
