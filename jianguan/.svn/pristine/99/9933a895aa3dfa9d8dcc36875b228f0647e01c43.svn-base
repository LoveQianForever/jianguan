package com.ncs.gsyt.modules.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//产品批次表
@Entity
@Table(name = "T_BATCH")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Batch implements Serializable{

	public Batch() {
		super();
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long batchID;//产品批次ID
	
	@Temporal(TemporalType.DATE)
	private Date plantDate;//种植养殖日期
	
	@Temporal(TemporalType.DATE)
	private Date marketDate;//上市日期
	
	@ManyToOne
	@JoinColumn(name = "productID", referencedColumnName = "productID")
	private Product product;//对应产品
	
	private int state;//状态 0未生成 1已生成 2作废
	
	@Column(length = 200)
	private String batchURL;//溯源页面地址
	
	private long placeID;//对应产区 不建关联，需要时手工获取
	@Column(length=50)
	private String placeName;//对应产区名称
	
	@Column(length = 200)
	private String qrCodeURL;//二维码地址
	
	@Transient
	private List<Product> productList;//页面显示用下拉列表
	
	@Transient
	private List<Place> placeList;//页面显示用下拉列表

	public long getBatchID() {
		return batchID;
	}

	public void setBatchID(long batchID) {
		this.batchID = batchID;
	}

	public Date getPlantDate() {
		return plantDate;
	}

	public void setPlantDate(Date plantDate) {
		this.plantDate = plantDate;
	}

	public Date getMarketDate() {
		return marketDate;
	}

	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getBatchURL() {
		return batchURL;
	}

	public void setBatchURL(String batchURL) {
		this.batchURL = batchURL;
	}

	public long getPlaceID() {
		return placeID;
	}

	public void setPlaceID(long placeID) {
		this.placeID = placeID;
	}

	public String getQrCodeURL() {
		return qrCodeURL;
	}

	public void setQrCodeURL(String qrCodeURL) {
		this.qrCodeURL = qrCodeURL;
	}

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
}
