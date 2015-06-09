package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

//产区表
@Entity
@Table(name = "T_PLACE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Place implements Serializable{
	public Place(){
	super();
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long placeID;
	@Column(length=50)
	private String placeName;
	@Column(length=50)
	private String placeAddr;//地址
	@Column(length=50)
	private String placeScale;//规模
	@Column(length=50)
	private String placeStandard;//执行标准
	@Column(length=50)
	private String placeHead;//负责人
	@Column(length=50)
	private String placePhone;//负责人手机号码
	public String getPlacePhone() {
		return placePhone;
	}
	public void setPlacePhone(String placePhone) {
		this.placePhone = placePhone;
	}
	@Column(length=500)
	private String placePlan;//生产计划
	@Column(length=500)
	private String placeControl;//计量控制措施
	@Column(length=50)
	private String placeStatus;//状态
	@Column(length=50)
	private String type;//区域类型      如：   水产类，茶叶类，家禽类，大棚类

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(length=50)
	private String placejd;//经度
	
	@Column(length=50)
	private String placewd;//经度
	
	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;//对应企业
	
	
	@OneToMany(mappedBy = "place",cascade = { CascadeType.ALL },  fetch = FetchType.LAZY)
	private List<PlaceAtta> attalist = new ArrayList<PlaceAtta>();//产区附件
	@Transient
	private Map<String, String> typeMap;
	
	
	public Map<String, String> getTypeMap() {
		return typeMap;
	}
	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}
	@Transient
	private List<Enterprise> enterpriseList;//页面显示用下拉列表
	
	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}
	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	@Transient
	private String attachStr;//页面显示附件图片

	
	public String getPlacejd() {
		return placejd;
	}
	public void setPlacejd(String placejd) {
		this.placejd = placejd;
	}
	public String getPlacewd() {
		return placewd;
	}
	public void setPlacewd(String placewd) {
		this.placewd = placewd;
	}
	public long getPlaceID() {
		return placeID;
	}
	public void setPlaceID(long placeID) {
		this.placeID = placeID;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceAddr() {
		return placeAddr;
	}
	public void setPlaceAddr(String placeAddr) {
		this.placeAddr = placeAddr;
	}
	public String getPlaceScale() {
		return placeScale;
	}
	public void setPlaceScale(String placeScale) {
		this.placeScale = placeScale;
	}
	public String getPlaceStandard() {
		return placeStandard;
	}
	public void setPlaceStandard(String placeStandard) {
		this.placeStandard = placeStandard;
	}
	public String getPlaceHead() {
		return placeHead;
	}
	public void setPlaceHead(String placeHead) {
		this.placeHead = placeHead;
	}
	public String getPlacePlan() {
		return placePlan;
	}
	public void setPlacePlan(String placePlan) {
		this.placePlan = placePlan;
	}
	public String getPlaceControl() {
		return placeControl;
	}
	public void setPlaceControl(String placeControl) {
		this.placeControl = placeControl;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public List<PlaceAtta> getAttalist() {
		return attalist;
	}
	public void setAttalist(List<PlaceAtta> attalist) {
		this.attalist = attalist;
	}
	public String getAttachStr() {
		return attachStr;
	}
	public void setAttachStr(String attachStr) {
		this.attachStr = attachStr;
	}
	public void addPlaceAtta(PlaceAtta atta) {
		if (atta != null) {
			this.attalist.add(atta);
			atta.setPlace(this);
		}
	}
	public String getPlaceStatus() {
		return placeStatus;
	}
	public void setPlaceStatus(String placeStatus) {
		this.placeStatus = placeStatus;
	}
	
}
