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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "T_ENTERPRISE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Enterprise implements Serializable {
	public Enterprise() {
		super();
	}

	private static final long serialVersionUID = 1L;// 序列化兼容
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long enterpriseID;// 企业ID
	@Column(length = 50)
	private String enterpriseName;// 企业名称
	@Column(length = 30)
	private String businessLicense;// 营业执照
	@Column(length = 30)
	private String jgdm;//组织机构代码
	@Column(length = 30)
	private String qylx;//企业类型
	@Column(length = 30)
	private String enterpriseNature;// 企业性质
	@Temporal(TemporalType.DATE)
	private Date createTime;// 成立时间
	@Column(length = 50)
	private String legalPerson;// 企业法人
	@Column(length = 50)
	private String enterpriseIndustry;// 所属行业
	@Column(length = 50)
	private String registeredCapital;// 注册资金
	@Column(length = 50)
	private String contactPerson;// 联系人
	@Column(length = 50)
	private String contactTelephone;// 联系电话
	@Column(length = 50)
	private String phoneNumber;// 手机电话
	@Column(length = 50)
	private String fax;// 传真
	@Column(length = 50)
	private String email;//
	@Column(length = 50)
	private String mailingAddress;// 通信地址
	@Column(length = 50)
	private String zipCode;// 邮编
	@Column(length = 50)
	private String homePage;// 主页
	@Column(length = 1000)
	private String enterpriseDescription;// 公司描述

	@OneToMany(mappedBy = "enterprise", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Enterpriseatta> attalist = new ArrayList<Enterpriseatta>();// 企业附件

	@Transient
	private String attachStr;// 页面显示附件图片
	
	@Column(length = 50)
	private String status;//1 代表种子经营；2 代表农业投入品经营 3、种植类生产企业 4、水产类生产企业
	//5、生猪类生产企业 6、禽类生产企业； 
	
	@Column(length = 50)
	private String culturePlace;//养殖地点
	

	@Column(length = 50)
	private String cultureKinds;//养殖类别
	
	@Column(length = 50)
	private String cultureModel;//养殖规模

	public String getCulturePlace() {
		return culturePlace;
	}

	public void setCulturePlace(String culturePlace) {
		this.culturePlace = culturePlace;
	}

	public String getCultureKinds() {
		return cultureKinds;
	}

	public void setCultureKinds(String cultureKinds) {
		this.cultureKinds = cultureKinds;
	}

	public String getCultureModel() {
		return cultureModel;
	}

	public void setCultureModel(String cultureModel) {
		this.cultureModel = cultureModel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getAttachStr() {
		return attachStr;
	}

	public void setAttachStr(String attachStr) {
		this.attachStr = attachStr;
	}

	public List<Enterpriseatta> getAttalist() {
		return attalist;
	}

	public void setAttalist(List<Enterpriseatta> attalist) {
		this.attalist = attalist;
	}

	

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getEnterpriseNature() {
		return enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getEnterpriseIndustry() {
		return enterpriseIndustry;
	}

	public void setEnterpriseIndustry(String enterpriseIndustry) {
		this.enterpriseIndustry = enterpriseIndustry;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getEnterpriseDescription() {
		return enterpriseDescription;
	}

	public void setEnterpriseDescription(String enterpriseDescription) {
		this.enterpriseDescription = enterpriseDescription;
	}

	public void addEnterpriseatta(Enterpriseatta atta) {
		if (atta != null) {//
			this.attalist.add(atta);
			atta.setEnterprise(this);
		}
	}

	public long getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(long enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getQylx() {
		return qylx;
	}

	public void setQylx(String qylx) {
		this.qylx = qylx;
	}

	
}
