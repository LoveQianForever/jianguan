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
 * 农产品生猪类生产记录
 * 
 *免疫接种记录表------ 对应的实体类
 * 
 * **/

/*商品表*/
@Entity
@Table(name = "T_JIEZHONG")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ImmunityJieZhong implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long immunityID;//WAP版 使用主键
		
	@Column(length=20)
	private String xubie;//畜别
		
	
	private long productName;//日龄
		
	@Column(length=20)
	private String dongbie;//栋别
		
	@Column(length=20)
	private String lanhao;//栏号
		
	@Column(length=100)
	private String yufangAis;//预防疾病
		
	@Column(length=100)
	private	Date lastTime;//前次时间
	/**----------------------**/
	@Column(length=50)
	private	String year1;//nian
	
	@Column(length=50)
	private	String month1;//yue
	
	@Column(length=50)
	private	String day1;//ri
	/**-------------------------**/	
	@Column(length=100)
	private Date nowTime;//本次时间
	/**----------------------**/
	@Column(length=50)
	private	String year2;//nian
	
	@Column(length=50)
	private	String month2;//yue
	
	@Column(length=50)
	private	String day2;//ri
	/**-------------------------**/	
		
	@Column(length=50)
	private String count;//免疫次数
		
	@Column(length=100)
	private String useYimiao;//选用疫苗
		
	@Column(length=100)
	private String jiLiang;//剂量
		
	@Column(length=100)
	private String tuJing;//途径
		
	@Column(length=50)
	private String number;//接种头数
		
	@Column(length=100)
	private String reback;//反应情况
		
	@Column(length=100)
	private String immu_name;//执行者
		
	/*@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；
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

	public long getImmunityID() {
		return immunityID;
	}

	public void setImmunityID(long immunityID) {
		this.immunityID = immunityID;
	}

	public String getXubie() {
		return xubie;
	}

	public void setXubie(String xubie) {
		this.xubie = xubie;
	}

	public long getProductName() {
		return productName;
	}

	public void setProductName(long productName) {
		this.productName = productName;
	}

	public String getDongbie() {
		return dongbie;
	}

	public void setDongbie(String dongbie) {
		this.dongbie = dongbie;
	}

	public String getLanhao() {
		return lanhao;
	}

	public void setLanhao(String lanhao) {
		this.lanhao = lanhao;
	}

	public String getYufangAis() {
		return yufangAis;
	}

	public void setYufangAis(String yufangAis) {
		this.yufangAis = yufangAis;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}
	public String getUseYimiao() {
		return useYimiao;
	}

	public void setUseYimiao(String useYimiao) {
		this.useYimiao = useYimiao;
	}

	public String getJiLiang() {
		return jiLiang;
	}

	public void setJiLiang(String jiLiang) {
		this.jiLiang = jiLiang;
	}

	public String getTuJing() {
		return tuJing;
	}

	public void setTuJing(String tuJing) {
		this.tuJing = tuJing;
	}

	public String getReback() {
		return reback;
	}

	public void setReback(String reback) {
		this.reback = reback;
	}

	public String getImmu_name() {
		return immu_name;
	}

	public void setImmu_name(String immuName) {
		immu_name = immuName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
