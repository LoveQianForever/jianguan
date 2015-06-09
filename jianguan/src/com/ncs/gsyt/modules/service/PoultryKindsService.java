package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.PoultryKinds;

public interface PoultryKindsService {

	/**
	 * 增加或更新PoultryKinds
	 * 
	 * @param poultrykinds
	 * @return
	 */
	public boolean save(PoultryKinds poultrykinds);

	/**
	 * 批量增加或更新PoultryKinds
	 * 
	 * @param poultrykindss
	 * @return
	 */
	public boolean[] save(PoultryKinds[] poultrykindss);

	/**
	 * 删除PoultryKinds
	 * 
	 * @param poultrykinds
	 * @return
	 */
	public boolean remove(PoultryKinds poultrykinds);

	/**
	 * 批量删除PoultryKinds
	 * 
	 * @param poultrykindss
	 */
	public void remove(PoultryKinds[] poultrykindss);

	/**
	 * 根据主键删除PoultryKinds
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询PoultryKinds数据记录集
	 * 
	 * @return
	 */
	public List<PoultryKinds> findAll();

	/**
	 * 根据主键查询PoultryKinds
	 * 
	 * @param l
	 * @return
	 */
	public PoultryKinds findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public PoultryKinds searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<PoultryKinds> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}