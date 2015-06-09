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

@Entity
@Table(name = "T_PLACE_ATTA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PlaceAtta implements Serializable{

	public PlaceAtta() {
		super();
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long attaID;//附件ID
	@Column(length=50)
	private String attaName; //附件名称
	@Column(length=200)
	private String attaFile; //附件文件名
	@Column(length=200)
	private String resizeFile; //略缩图文件名
	@Column(length=50)
	private String  charge;//负责单位
	@Column(length=50)
	private String  Conclusion;//结论
	@ManyToOne
	@JoinColumn(name = "placeID", referencedColumnName = "placeID")
	private Place place;//所属产区
	public long getAttaID() {
		return attaID;
	}
	public void setAttaID(long attaID) {
		this.attaID = attaID;
	}
	public String getAttaName() {
		return attaName;
	}
	public void setAttaName(String attaName) {
		this.attaName = attaName;
	}
	public String getAttaFile() {
		return attaFile;
	}
	public void setAttaFile(String attaFile) {
		this.attaFile = attaFile;
	}
	public String getResizeFile() {
		return resizeFile;
	}
	public void setResizeFile(String resizeFile) {
		this.resizeFile = resizeFile;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getConclusion() {
		return Conclusion;
	}
	public void setConclusion(String conclusion) {
		Conclusion = conclusion;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	
	
}
