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
 * 
 * 种子商品表
 * 
 *  t_seed**/
@Entity
@Table(name = "T_BUYSEED")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class BuySeed implements Serializable{
	
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long enter_id;//企业ID
					
@Column(length=50)
private String name_enter;//企业名称
				
@Column(length=50)
private String linkman;//联系人
		
@Column(length=50)
private String phoneNumber;//联系方式
		
@Column(length=200)
private String address;//地址

public long getEnter_id() {
	return enter_id;
}

public void setEnter_id(long enterId) {
	enter_id = enterId;
}

public String getName_enter() {
	return name_enter;
}

public void setName_enter(String nameEnter) {
	name_enter = nameEnter;
}

public String getLinkman() {
	return linkman;
}

public void setLinkman(String linkman) {
	this.linkman = linkman;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
		
		

}
