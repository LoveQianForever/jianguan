package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Warning;


public interface WarningService {

	/**
	 * 增加或更新Warning
	 * 
	 * @param warning
	 * @return
	 */
	public boolean save(Warning warning);

	/**
	 * 批量增加或更新Warning
	 * 
	 * @param warnings
	 * @return
	 */
	public boolean[] save(Warning[] warnings);

	/**
	 * 删除Warning
	 * 
	 * @param warning
	 * @return
	 */
	public boolean remove(Warning warning);

	/**
	 * 批量删除Warning
	 * 
	 * @param warnings
	 */
	public void remove(Warning[] warnings);

	/**
	 * 根据主键删除Warning
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Warning数据记录集
	 * 
	 * @return
	 */
	public List<Warning> findAll();

	/**
	 * 根据主键查询Warning
	 * 
	 * @param l
	 * @return
	 */
	public Warning findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Warning searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Warning> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}