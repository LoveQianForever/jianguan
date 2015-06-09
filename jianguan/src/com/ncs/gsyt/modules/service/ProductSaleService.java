package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ProductSale;

public interface ProductSaleService {

	/**
	 * 增加或更新ProductSale
	 * 
	 * @param productsale
	 * @return
	 */
	public boolean save(ProductSale productsale);

	/**
	 * 批量增加或更新ProductSale
	 * 
	 * @param productsales
	 * @return
	 */
	public boolean[] save(ProductSale[] productsales);

	/**
	 * 删除ProductSale
	 * 
	 * @param productsale
	 * @return
	 */
	public boolean remove(ProductSale productsale);

	/**
	 * 批量删除ProductSale
	 * 
	 * @param productsales
	 */
	public void remove(ProductSale[] productsales);

	/**
	 * 根据主键删除ProductSale
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ProductSale数据记录集
	 * 
	 * @return
	 */
	public List<ProductSale> findAll();

	/**
	 * 根据主键查询ProductSale
	 * 
	 * @param l
	 * @return
	 */
	public ProductSale findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ProductSale searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ProductSale> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}