package com.ncs.gsyt.modules.model;

import java.io.Serializable;

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

/**
 * 农产品生猪类生产记录
 * 
 * 饲料车间生产记录  ------对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_FOODPRORECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FoodProRecord implements Serializable{
	
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long foodProRecordID;//WAP版使用主键
		
		@Column(length=10)
		private String xingHao;//型号

		@Column(length=50)
		private String proCount;//生产量
		/**---组成集----以下 单位  kg------------------**/
		@Column(length=50)
		private String yuMicount;//玉米
		
		@Column(length=50)
		private String douBcount;//豆粕
		
		@Column(length=50)
		private String  maiSuiCount;//麦麸
		
		@Column(length=50)
		private String daDouCount;//膨化大豆
		
		@Column(length=50)
		private String xiKangCount;//细糠
		
		@Column(length=50)
		private String caiZiCount;//菜籽粕
		
		@Column(length=50)
		private String yuFenCount;//鱼粉
		
		@Column(length=50)
		private String zaYuCount;//杂鱼
		
		@Column(length=50)
		private String hunLiaoCount;//预混料
		
		/**-----------以下   药物添加情况（克）-----------------------**/
		
		@Column(length=1000)
		private String proName1;//品名
		
		@Column(length=50)
		private String proCount1;//添加
		
		@Column(length=20)
		private String proName2;//品名 
		@Column(length=50)
		private String proCount2;//添加
		
		@Column(length=1000)
		private String proName3;//品名
		@Column(length=50)
		private String proCount3;//添加
		
		@Column(length=500)
		private String sampleContent;//备注
		
	
		/*@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应所属企业 关系
*/

		private long enterpriseID;// 所属企业ID
		
		@Column(length=20)
		private String enterpriseName;//所属企业名称
		
		@Column(length=50)
		private String piCi;//批次，用于保存溯源里的“批次”概念
		
		
		public String getPiCi() {
			return piCi;
		}

		public void setPiCi(String piCi) {
			this.piCi = piCi;
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


		public long getFoodProRecordID() {
			return foodProRecordID;
		}


		public void setFoodProRecordID(long foodProRecordID) {
			this.foodProRecordID = foodProRecordID;
		}


		public String getXingHao() {
			return xingHao;
		}


		public void setXingHao(String xingHao) {
			this.xingHao = xingHao;
		}


		public String getProCount() {
			return proCount;
		}


		public void setProCount(String proCount) {
			this.proCount = proCount;
		}


		public String getYuMicount() {
			return yuMicount;
		}


		public void setYuMicount(String yuMicount) {
			this.yuMicount = yuMicount;
		}


		public String getDouBcount() {
			return douBcount;
		}


		public void setDouBcount(String douBcount) {
			this.douBcount = douBcount;
		}


		public String getMaiSuiCount() {
			return maiSuiCount;
		}


		public void setMaiSuiCount(String maiSuiCount) {
			this.maiSuiCount = maiSuiCount;
		}


		public String getDaDouCount() {
			return daDouCount;
		}


		public void setDaDouCount(String daDouCount) {
			this.daDouCount = daDouCount;
		}


		public String getXiKangCount() {
			return xiKangCount;
		}


		public void setXiKangCount(String xiKangCount) {
			this.xiKangCount = xiKangCount;
		}


		public String getCaiZiCount() {
			return caiZiCount;
		}


		public void setCaiZiCount(String caiZiCount) {
			this.caiZiCount = caiZiCount;
		}


		public String getYuFenCount() {
			return yuFenCount;
		}


		public void setYuFenCount(String yuFenCount) {
			this.yuFenCount = yuFenCount;
		}


		public String getZaYuCount() {
			return zaYuCount;
		}


		public void setZaYuCount(String zaYuCount) {
			this.zaYuCount = zaYuCount;
		}


		public String getHunLiaoCount() {
			return hunLiaoCount;
		}


		public void setHunLiaoCount(String hunLiaoCount) {
			this.hunLiaoCount = hunLiaoCount;
		}


		public String getProName1() {
			return proName1;
		}


		public void setProName1(String proName1) {
			this.proName1 = proName1;
		}


		public String getProCount1() {
			return proCount1;
		}


		public void setProCount1(String proCount1) {
			this.proCount1 = proCount1;
		}


		public String getProName2() {
			return proName2;
		}


		public void setProName2(String proName2) {
			this.proName2 = proName2;
		}


		public String getProCount2() {
			return proCount2;
		}


		public void setProCount2(String proCount2) {
			this.proCount2 = proCount2;
		}


		public String getProName3() {
			return proName3;
		}


		public void setProName3(String proName3) {
			this.proName3 = proName3;
		}


		public String getProCount3() {
			return proCount3;
		}


		public void setProCount3(String proCount3) {
			this.proCount3 = proCount3;
		}


		public String getSampleContent() {
			return sampleContent;
		}


		public void setSampleContent(String sampleContent) {
			this.sampleContent = sampleContent;
		}


	



/*

		public Enterprise getEnterprise() {
			return enterprise;
		}


		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}
	
	*/

}
