package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.XuShuiChiClear;

public interface XuShuiChiClearService {

	/**
	 * 增加或更新XuShuiChiClear
	 * 
	 * @param xushuichiclear
	 * @return
	 */
	public boolean save(XuShuiChiClear xushuichiclear);

	/**
	 * 批量增加或更新XuShuiChiClear
	 * 
	 * @param xushuichiclears
	 * @return
	 */
	public boolean[] save(XuShuiChiClear[] xushuichiclears);

	/**
	 * 删除XuShuiChiClear
	 * 
	 * @param xushuichiclear
	 * @return
	 */
	public boolean remove(XuShuiChiClear xushuichiclear);

	/**
	 * 批量删除XuShuiChiClear
	 * 
	 * @param xushuichiclears
	 */
	public void remove(XuShuiChiClear[] xushuichiclears);

	/**
	 * 根据主键删除XuShuiChiClear
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询XuShuiChiClear数据记录集
	 * 
	 * @return
	 */
	public List<XuShuiChiClear> findAll();

	/**
	 * 根据主键查询XuShuiChiClear
	 * 
	 * @param l
	 * @return
	 */
	public XuShuiChiClear findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public XuShuiChiClear searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<XuShuiChiClear> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}