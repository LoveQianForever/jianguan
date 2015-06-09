package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.CaiGou;

public interface CaiGouService {

	/**
	 * 增加或更新CaiGou
	 * 
	 * @param caigou
	 * @return
	 */
	public boolean save(CaiGou caigou);

	/**
	 * 批量增加或更新CaiGou
	 * 
	 * @param caigous
	 * @return
	 */
	public boolean[] save(CaiGou[] caigous);

	/**
	 * 删除CaiGou
	 * 
	 * @param caigou
	 * @return
	 */
	public boolean remove(CaiGou caigou);

	/**
	 * 批量删除CaiGou
	 * 
	 * @param caigous
	 */
	public void remove(CaiGou[] caigous);

	/**
	 * 根据主键删除CaiGou
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询CaiGou数据记录集
	 * 
	 * @return
	 */
	public List<CaiGou> findAll();

	/**
	 * 根据主键查询CaiGou
	 * 
	 * @param l
	 * @return
	 */
	public CaiGou findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public CaiGou searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<CaiGou> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}