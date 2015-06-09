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
 * 母猪配种生成记录表  ------对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_MUZHUPEIZHONG")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class MuZhuPeiZhongRecord implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long peiZhongID;//WAP版使用主键
		
	@Column(length=10)
	private String erHaoM;//耳号（母猪）
		
		@Column(length=100)
		private String pinZhongM;//品种(母猪)
		
		private String taici;//胎次
		//-----------主---------------
		@Column(length=50)
		private Date peiDuiTime;//配对时间
		
		@Column(length=50)
		private String year1;//nian
		@Column(length=50)
		private String month1;//yue
		@Column(length=50)
		private String day1;//ri
		
		@Column(length=20)
		private String pinZhongG;//品种（公）
		
		@Column(length=10)
		private String erHaoG;//耳号（公）
		
		@Column(length=20)
		private String peiZhongFangShi;//配种方式
		
		@Column(length=20)
		private String peiZhong_name;//配种执行人
		//-----------主---------------
		//----------------副----------
		@Column(length=50)
		private Date peiDuiTime11;//配对时间
		
		@Column(length=50)
		private String year11;//nian
		@Column(length=50)
		private String month11;//yue
		@Column(length=50)
		private String day11;//ri
		
		@Column(length=20)
		private String pinZhongG11;//品种（公）
		
		@Column(length=10)
		private String erHaoG11;//耳号（公）
		
		@Column(length=20)
		private String peiZhongFangShi11;//配种方式
		
		@Column(length=20)
		private String peiZhong_name11;//配种执行人
		//----------------副-----------------------
		@Column(length=20)
		private Date yuChanQi;//预产期
		
		@Column(length=50)
		private String year2;//nian
		@Column(length=50)
		private String month2;//yue
		@Column(length=50)
		private String day2;//ri
		
		@Column(length=20)
		private Date fenWanQi;//分娩日期
		
		@Column(length=50)
		private String year3;//nian
		@Column(length=50)
		private String month3;//yue
		@Column(length=50)
		private String day3;//ri
		
		private int zaiShu;//仔数
		
		
		private int huoZai;//活仔
		
		private int muNaiYi;//木乃伊
		
		private int ruoZai;//弱仔
		
		private int siZai;//死胎
		
		@Column(length=20)
		private String fenWan_name;//分娩执行人
		
		
		/*
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应商品种类
*/


		private long enterpriseID;// 所属企业ID
		
		@Column(length=20)
		private String enterpriseName;//所属企业名称
		
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

		

		public String getYear1() {
			return year1;
		}

		public void setYear1(String year1) {
			this.year1 = year1;
		}

		public String getMonth1() {
			return month1;
		}

		public void setMonth1(String month1) {
			this.month1 = month1;
		}

		public String getDay1() {
			return day1;
		}

		public void setDay1(String day1) {
			this.day1 = day1;
		}

		public String getYear2() {
			return year2;
		}

		public void setYear2(String year2) {
			this.year2 = year2;
		}

		public String getMonth2() {
			return month2;
		}

		public void setMonth2(String month2) {
			this.month2 = month2;
		}

		public String getDay2() {
			return day2;
		}

		public void setDay2(String day2) {
			this.day2 = day2;
		}

		public String getYear3() {
			return year3;
		}

		public void setYear3(String year3) {
			this.year3 = year3;
		}

		public String getMonth3() {
			return month3;
		}

		public void setMonth3(String month3) {
			this.month3 = month3;
		}

		public String getDay3() {
			return day3;
		}

		public void setDay3(String day3) {
			this.day3 = day3;
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


		public long getPeiZhongID() {
			return peiZhongID;
		}



		public void setPeiZhongID(long peiZhongID) {
			this.peiZhongID = peiZhongID;
		}



		public String getErHaoM() {
			return erHaoM;
		}



		public void setErHaoM(String erHaoM) {
			this.erHaoM = erHaoM;
		}



		public String getPinZhongM() {
			return pinZhongM;
		}



		public void setPinZhongM(String pinZhongM) {
			this.pinZhongM = pinZhongM;
		}



		public String getTaici() {
			return taici;
		}



		public void setTaici(String taici) {
			this.taici = taici;
		}



		public Date getPeiDuiTime() {
			return peiDuiTime;
		}



		public void setPeiDuiTime(Date peiDuiTime) {
			this.peiDuiTime = peiDuiTime;
		}



		public String getPinZhongG() {
			return pinZhongG;
		}



		public void setPinZhongG(String pinZhongG) {
			this.pinZhongG = pinZhongG;
		}



		public String getErHaoG() {
			return erHaoG;
		}



		public void setErHaoG(String erHaoG) {
			this.erHaoG = erHaoG;
		}



		public String getPeiZhongFangShi() {
			return peiZhongFangShi;
		}



		public void setPeiZhongFangShi(String peiZhongFangShi) {
			this.peiZhongFangShi = peiZhongFangShi;
		}



		public String getPeiZhong_name() {
			return peiZhong_name;
		}



		public void setPeiZhong_name(String peiZhongName) {
			peiZhong_name = peiZhongName;
		}



		public Date getYuChanQi() {
			return yuChanQi;
		}



		public void setYuChanQi(Date yuChanQi) {
			this.yuChanQi = yuChanQi;
		}



		public Date getFenWanQi() {
			return fenWanQi;
		}



		public void setFenWanQi(Date fenWanQi) {
			this.fenWanQi = fenWanQi;
		}



		public int getZaiShu() {
			return zaiShu;
		}



		public void setZaiShu(int zaiShu) {
			this.zaiShu = zaiShu;
		}



		public int getHuoZai() {
			return huoZai;
		}



		public void setHuoZai(int huoZai) {
			this.huoZai = huoZai;
		}



		public int getMuNaiYi() {
			return muNaiYi;
		}



		public void setMuNaiYi(int muNaiYi) {
			this.muNaiYi = muNaiYi;
		}



		public int getRuoZai() {
			return ruoZai;
		}



		public void setRuoZai(int ruoZai) {
			this.ruoZai = ruoZai;
		}



		public int getSiZai() {
			return siZai;
		}



		public void setSiZai(int siZai) {
			this.siZai = siZai;
		}



		public String getFenWan_name() {
			return fenWan_name;
		}



		public void setFenWan_name(String fenWanName) {
			fenWan_name = fenWanName;
		}

		public Date getPeiDuiTime11() {
			return peiDuiTime11;
		}

		public void setPeiDuiTime11(Date peiDuiTime11) {
			this.peiDuiTime11 = peiDuiTime11;
		}

		public String getYear11() {
			return year11;
		}

		public void setYear11(String year11) {
			this.year11 = year11;
		}

		public String getMonth11() {
			return month11;
		}

		public void setMonth11(String month11) {
			this.month11 = month11;
		}

		public String getDay11() {
			return day11;
		}

		public void setDay11(String day11) {
			this.day11 = day11;
		}

		public String getPinZhongG11() {
			return pinZhongG11;
		}

		public void setPinZhongG11(String pinZhongG11) {
			this.pinZhongG11 = pinZhongG11;
		}

		public String getErHaoG11() {
			return erHaoG11;
		}

		public void setErHaoG11(String erHaoG11) {
			this.erHaoG11 = erHaoG11;
		}

		public String getPeiZhongFangShi11() {
			return peiZhongFangShi11;
		}

		public void setPeiZhongFangShi11(String peiZhongFangShi11) {
			this.peiZhongFangShi11 = peiZhongFangShi11;
		}

		public String getPeiZhong_name11() {
			return peiZhong_name11;
		}

		public void setPeiZhong_name11(String peiZhongName11) {
			peiZhong_name11 = peiZhongName11;
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
