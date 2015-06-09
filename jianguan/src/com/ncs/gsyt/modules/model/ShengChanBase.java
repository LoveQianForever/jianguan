package com.ncs.gsyt.modules.model;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "T_SHENGCHANBASE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ShengChanBase implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long baseID;//基地ID
			
		@Column(length=50)
		private String address;//基地地址
		
		@Column(length=50)
		private String area;//耕地面积
		
		@Column(length=50)
		private String turang;//土壤类型
		
		@Column(length=50)
		private String shuiyuanName;//灌溉水源名称
		
		@Column(length=50)
		private String huanjing;//周边环境描述
		
		@Column(length=50)
		private String noHaiBase;//是否为无公害农产品（绿色食品、有机食品）基地
		
		@Column(length=50)
		private String code;//是，无公害，注明的编号
		
		@Column(length=50)
		private String zhongzhiMethod;//主要种植作物或复种方式
		
		@Column(length=50)
		private String content;//备    注
		
		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		@OneToMany(mappedBy = "shengChanBase",cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
		private List<NongShi> nongShilist = new ArrayList<NongShi>();//附件
		
		@OneToMany(mappedBy = "shengChanBase",cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
		private List<ZhiLiang> zhiLianglist = new ArrayList<ZhiLiang>();//附件
		
		@OneToMany(mappedBy = "shengChanBase",cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
		private List<ProductSale> productSalelist = new ArrayList<ProductSale>();//附件
		
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
		
		public long getEnterpriseID() {
			return enterpriseID;
		}

		public void setEnterpriseID(long enterpriseID) {
			this.enterpriseID = enterpriseID;
		}

		@Column(length=50)
		private String enterpriseName;
		
		

		

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}

		public long getBaseID() {
			return baseID;
		}

		public void setBaseID(long baseID) {
			this.baseID = baseID;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getTurang() {
			return turang;
		}

		public void setTurang(String turang) {
			this.turang = turang;
		}

		public String getShuiyuanName() {
			return shuiyuanName;
		}

		public void setShuiyuanName(String shuiyuanName) {
			this.shuiyuanName = shuiyuanName;
		}

		public String getHuanjing() {
			return huanjing;
		}

		public void setHuanjing(String huanjing) {
			this.huanjing = huanjing;
		}

		public String getNoHaiBase() {
			return noHaiBase;
		}

		public void setNoHaiBase(String noHaiBase) {
			this.noHaiBase = noHaiBase;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getZhongzhiMethod() {
			return zhongzhiMethod;
		}

		public void setZhongzhiMethod(String zhongzhiMethod) {
			this.zhongzhiMethod = zhongzhiMethod;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public List<NongShi> getNongShilist() {
			return nongShilist;
		}

		public void setNongShilist(List<NongShi> nongShilist) {
			this.nongShilist = nongShilist;
		}

		public List<ZhiLiang> getZhiLianglist() {
			return zhiLianglist;
		}

		public void setZhiLianglist(List<ZhiLiang> zhiLianglist) {
			this.zhiLianglist = zhiLianglist;
		}

}
