package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.YuSiYang;

public interface YuSiYangService {

	/**
	 * 增加或更新YuSiYang
	 * 
	 * @param yusiyang
	 * @return
	 */
	public boolean save(YuSiYang yusiyang);

	/**
	 * 批量增加或更新YuSiYang
	 * 
	 * @param yusiyangs
	 * @return
	 */
	public boolean[] save(YuSiYang[] yusiyangs);

	/**
	 * 删除YuSiYang
	 * 
	 * @param yusiyang
	 * @return
	 */
	public boolean remove(YuSiYang yusiyang);

	/**
	 * 批量删除YuSiYang
	 * 
	 * @param yusiyangs
	 */
	public void remove(YuSiYang[] yusiyangs);

	/**
	 * 根据主键删除YuSiYang
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询YuSiYang数据记录集
	 * 
	 * @return
	 */
	public List<YuSiYang> findAll();

	/**
	 * 根据主键查询YuSiYang
	 * 
	 * @param l
	 * @return
	 */
	public YuSiYang findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public YuSiYang searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<YuSiYang> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}