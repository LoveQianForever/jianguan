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
 * 禽类生产记录档案
 * 
 * 药品、饲料供应商表，对应实体类
 * （此表，记录着不在企业库的企业信息）；
 * **/

//产品表
@Entity
@Table(name = "T_FOODMSUPPLY")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FoodMedicineSupply  implements Serializable{

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long supplyID;//供应商ID
		
		@Column(length=50)
		private String supplyName;//供应商名称
		
		@Column(length=50)
		private String linkman;//联系人
		
		@Column(length=50)
		private String phoneNumber;//供应商联系电话
		
		@Column(length=1000)
		private String address;//供应商地址
			
		@ManyToOne
		@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
		private Enterprise enterprise;//对应禽类生产记录档案， 具体的 家禽企业；

		public long getSupplyID() {
			return supplyID;
		}

		public void setSupplyID(long supplyID) {
			this.supplyID = supplyID;
		}

		public String getSupplyName() {
			return supplyName;
		}

		public void setSupplyName(String supplyName) {
			this.supplyName = supplyName;
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

		public Enterprise getEnterprise() {
			return enterprise;
		}

		public void setEnterprise(Enterprise enterprise) {
			this.enterprise = enterprise;
		}
		
		
		
		
	

}
