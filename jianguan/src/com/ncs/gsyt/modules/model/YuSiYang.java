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
 * 水产生产档案记录
 * 
 * 渔业生产操作  ， 对应的实体类；
 * **/
//产品表
@Entity
@Table(name = "T_YUSIYANG")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class YuSiYang implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long yussiyangID;//引种记录ID
			
	@Column(length=50)
	private Date input_time;//时间
	
	@Column
	private String weather;//天气
	@Column	
	private String wendu;//温度
	
		
	@Column
	private String ph;//PH值

	@Column
	private String tizhong;//体重
	
	@Column
	private String siliao_name;//饲料名称
	
	@Column
	private String siliao_count;//投放饲料量
	
	@Column
	private String yuyao_name;//鱼药名称
	
	@Column
	private String nongdu;//鱼药浓度
	
	@Column
	private String yao_method;//用药方法
	
	@Column
	private String fangzhi_object;//防止对象
	
	@Column
	private String zhengzhuang;//症状
	
	@Column
	private String yu_huodong;//鱼类活动情况
	
	@Column
	private String chufangren;//处方人
	
	@Column
	private String caozuoren;//处方人
	
	/*@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应所属企业
*/
	private long enterpriseID;//所属企业ID
	
	@Column
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

	public long getYussiyangID() {
		return yussiyangID;
	}

	public void setYussiyangID(long yussiyangID) {
		this.yussiyangID = yussiyangID;
	}

	public Date getInput_time() {
		return input_time;
	}

	public void setInput_time(Date inputTime) {
		input_time = inputTime;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	

	public String getSiliao_name() {
		return siliao_name;
	}

	public void setSiliao_name(String siliaoName) {
		siliao_name = siliaoName;
	}
	

	public String getTizhong() {
		return tizhong;
	}

	public void setTizhong(String tizhong) {
		this.tizhong = tizhong;
	}

	public String getSiliao_count() {
		return siliao_count;
	}

	public void setSiliao_count(String siliao_count) {
		this.siliao_count = siliao_count;
	}

	public String getYuyao_name() {
		return yuyao_name;
	}

	public void setYuyao_name(String yuyaoName) {
		yuyao_name = yuyaoName;
	}

	public String getNongdu() {
		return nongdu;
	}

	public void setNongdu(String nongdu) {
		this.nongdu = nongdu;
	}

	public String getYao_method() {
		return yao_method;
	}

	public void setYao_method(String yaoMethod) {
		yao_method = yaoMethod;
	}

	public String getFangzhi_object() {
		return fangzhi_object;
	}

	public void setFangzhi_object(String fangzhiObject) {
		fangzhi_object = fangzhiObject;
	}

	public String getZhengzhuang() {
		return zhengzhuang;
	}

	public void setZhengzhuang(String zhengzhuang) {
		this.zhengzhuang = zhengzhuang;
	}

	public String getYu_huodong() {
		return yu_huodong;
	}

	public void setYu_huodong(String yuHuodong) {
		yu_huodong = yuHuodong;
	}

	public String getChufangren() {
		return chufangren;
	}

	public void setChufangren(String chufangren) {
		this.chufangren = chufangren;
	}

	public String getCaozuoren() {
		return caozuoren;
	}

	public void setCaozuoren(String caozuoren) {
		this.caozuoren = caozuoren;
	}
/*
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}*/

	
	

}
