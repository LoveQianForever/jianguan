package com.ncs.gsyt.modules.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_WARNING")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Warning implements Serializable{

	public Warning() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long warnID;//预警ID
	
	@Column(length=500)
	private String note;//预警信息

	@Column(length=10)   
	private String type;//类型 
	
	private int state;//是否已读 0未读 1已读 
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	private long boxID;
	private long sensorsID;
	public long getBoxID() {
		return boxID;
	}

	public void setBoxID(long boxID) {
		this.boxID = boxID;
	}

	public long getSensorsID() {
		return sensorsID;
	}

	public void setSensorsID(long sensorsID) {
		this.sensorsID = sensorsID;
	}
	private long detailID;
	
	public long getDetailID() {
		return detailID;
	}

	public void setDetailID(long detailID) {
		this.detailID = detailID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column(length=50)   
	private String time;//时间

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getWarnID() {
		return warnID;
	}

	public void setWarnID(long warnID) {
		this.warnID = warnID;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
