package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.YuSale;

public interface YuSaleService {

	/**
	 * 增加或更新YuSale
	 * 
	 * @param yusale
	 * @return
	 */
	public boolean save(YuSale yusale);

	/**
	 * 批量增加或更新YuSale
	 * 
	 * @param yusales
	 * @return
	 */
	public boolean[] save(YuSale[] yusales);

	/**
	 * 删除YuSale
	 * 
	 * @param yusale
	 * @return
	 */
	public boolean remove(YuSale yusale);

	/**
	 * 批量删除YuSale
	 * 
	 * @param yusales
	 */
	public void remove(YuSale[] yusales);

	/**
	 * 根据主键删除YuSale
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询YuSale数据记录集
	 * 
	 * @return
	 */
	public List<YuSale> findAll();

	/**
	 * 根据主键查询YuSale
	 * 
	 * @param l
	 * @return
	 */
	public YuSale findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public YuSale searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<YuSale> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}