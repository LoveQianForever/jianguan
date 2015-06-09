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
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * 农产品生猪类生产记录
 * 
 * 兽药使用记录表  ------对应的实体类
 * 
 * **/
/*商品表*/
@Entity
@Table(name = "T_PMEDICINEUSERECORD")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PigMedicineUseRecord implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long pigMedicineUseID;//WAP版使用主键
		
		@Column(length=10)
		private Date useDate;//用药时间
		
		@Column(length=100)
		private String use_Object;//用药对象
		
		@Column(length=10)
		private String zhengZhuang;//症状
		
									
		
		@Column(length=50)
		private String jiYaoTuJing;//给药途径
		
		@Column(length=20)
		private String jiYaocount;//给药剂量
		
		@Column(length=20)
		private String effect;//治疗效果
		
		@Column(length=20)
		private String carry_name;//执行人
		
		@Column(length=20)
		private Date sleepDate;//休药期
		
		@Column(length=20)
		private String content;//备注
		
		
		@ManyToOne
		@JoinColumn(name = "pigFoodMedicineID", referencedColumnName = "pigFoodMedicineID")
		private InPigFoodMedicine inPigFoodMedicine;////所用药品,对应投入品管理商品
		
		
		private Long enterpriseDI;//对应所属企业的ID
		
		@Column(length=20)
		private String enterpriseName;//对应所属企业的名称；

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
		public long getPigMedicineUseID() {
			return pigMedicineUseID;
		}

		public void setPigMedicineUseID(long pigMedicineUseID) {
			this.pigMedicineUseID = pigMedicineUseID;
		}

		public Date getUseDate() {
			return useDate;
		}

		public void setUseDate(Date useDate) {
			this.useDate = useDate;
		}

		public String getUse_Object() {
			return use_Object;
		}

		public void setUse_Object(String useObject) {
			use_Object = useObject;
		}

		public String getZhengZhuang() {
			return zhengZhuang;
		}

		public void setZhengZhuang(String zhengZhuang) {
			this.zhengZhuang = zhengZhuang;
		}

		public String getJiYaoTuJing() {
			return jiYaoTuJing;
		}

		public void setJiYaoTuJing(String jiYaoTuJing) {
			this.jiYaoTuJing = jiYaoTuJing;
		}

		public String getJiYaocount() {
			return jiYaocount;
		}

		public void setJiYaocount(String jiYaocount) {
			this.jiYaocount = jiYaocount;
		}

		public String getEffect() {
			return effect;
		}

		public void setEffect(String effect) {
			this.effect = effect;
		}

		public String getCarry_name() {
			return carry_name;
		}

		public void setCarry_name(String carryName) {
			carry_name = carryName;
		}

		public Date getSleepDate() {
			return sleepDate;
		}

		public void setSleepDate(Date sleepDate) {
			this.sleepDate = sleepDate;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public InPigFoodMedicine getInPigFoodMedicine() {
			return inPigFoodMedicine;
		}

		public void setInPigFoodMedicine(InPigFoodMedicine inPigFoodMedicine) {
			this.inPigFoodMedicine = inPigFoodMedicine;
		}

		

		public Long getEnterpriseDI() {
			return enterpriseDI;
		}

		public void setEnterpriseDI(Long enterpriseDI) {
			this.enterpriseDI = enterpriseDI;
		}

		public String getEnterpriseName() {
			return enterpriseName;
		}

		public void setEnterpriseName(String enterpriseName) {
			this.enterpriseName = enterpriseName;
		}
		
		
}
