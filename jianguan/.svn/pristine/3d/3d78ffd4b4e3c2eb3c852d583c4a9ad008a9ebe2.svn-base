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
@Table(name = "T_ENTERPRISEATTA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Enterpriseatta implements Serializable {
	public Enterpriseatta() {
		super();
	}

	private static final long serialVersionUID = 1L;// 序列化兼容
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long annexID;// 附件ID
	@Column(length = 50)
	private String annexType;// 附件类型
	@Column(length = 50)
	private String annexName;// 附件名称
	@Column(length = 50)
	private String responseDepartment;// 负责单位
	@Column(length = 50)
	private String conclusion;// 结论
	@Column(length = 50)
	private String link;// 链接
	@Column(length = 200)
	private String attaFile; // 附件文件名
	
	//质量认证相关字段
	@Column(length = 50)
	private String zhiliang1;//名称
	@Column(length = 50)
	private String zhiliang2;//认证编号
	@Column(length = 50)
	private String zhiliang3;//认证机构
	@Column(length = 50)
	private String zhiliang4;//认证时间
	@Column(length = 50)
	private String zhiliang5;//期限
	//商标注册相关字段
	@Column(length = 50)
	private String shangbiao1;//名称
	//荣誉证书相关字段
	@Column(length = 50)
	private String zhengshu1;//证书名称
	@Column(length = 50)
	private String zhengshu2;//获证时间
	//包装信息
	@Column(length = 50)
	private String baozhuang1;//包装名称
	@Column(length = 50)
	private String baozhuang2;//包装材料

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

	@Column(length = 200)
	private String resizeFile; // 略缩图文件名

	@ManyToOne
	@JoinColumn(name = "enterpriseID", referencedColumnName = "enterpriseID")
	private Enterprise enterprise;// 所属企业

	public long getAnnexID() {
		return annexID;
	}

	public void setAnnexID(Integer annexID) {
		this.annexID = annexID;
	}

	public String getAnnexType() {
		return annexType;
	}

	public void setAnnexType(String annexType) {
		this.annexType = annexType;
	}

	public String getAnnexName() {
		return annexName;
	}

	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}

	public String getResponseDepartment() {
		return responseDepartment;
	}

	public void setResponseDepartment(String responseDepartment) {
		this.responseDepartment = responseDepartment;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public String getZhiliang1() {
		return zhiliang1;
	}

	public void setZhiliang1(String zhiliang1) {
		this.zhiliang1 = zhiliang1;
	}

	public String getZhiliang2() {
		return zhiliang2;
	}

	public void setZhiliang2(String zhiliang2) {
		this.zhiliang2 = zhiliang2;
	}

	public String getZhiliang3() {
		return zhiliang3;
	}

	public void setZhiliang3(String zhiliang3) {
		this.zhiliang3 = zhiliang3;
	}

	public String getZhiliang4() {
		return zhiliang4;
	}

	public void setZhiliang4(String zhiliang4) {
		this.zhiliang4 = zhiliang4;
	}

	public String getZhiliang5() {
		return zhiliang5;
	}

	public void setZhiliang5(String zhiliang5) {
		this.zhiliang5 = zhiliang5;
	}

	public String getShangbiao1() {
		return shangbiao1;
	}

	public void setShangbiao1(String shangbiao1) {
		this.shangbiao1 = shangbiao1;
	}

	public String getZhengshu1() {
		return zhengshu1;
	}

	public void setZhengshu1(String zhengshu1) {
		this.zhengshu1 = zhengshu1;
	}

	public String getZhengshu2() {
		return zhengshu2;
	}

	public void setZhengshu2(String zhengshu2) {
		this.zhengshu2 = zhengshu2;
	}

	public String getBaozhuang1() {
		return baozhuang1;
	}

	public void setBaozhuang1(String baozhuang1) {
		this.baozhuang1 = baozhuang1;
	}

	public String getBaozhuang2() {
		return baozhuang2;
	}

	public void setBaozhuang2(String baozhuang2) {
		this.baozhuang2 = baozhuang2;
	}

	public void setAnnexID(long annexID) {
		this.annexID = annexID;
	}

	
}
