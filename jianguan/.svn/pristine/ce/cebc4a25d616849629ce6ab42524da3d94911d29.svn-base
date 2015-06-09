package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Enterprise;

public interface EnterpriseService {

	/**
	 * 增加或更新Enterprise
	 * 
	 * @param enterprise
	 * @return
	 */
	public boolean save(Enterprise enterprise);

	/**
	 * 批量增加或更新Enterprise
	 * 
	 * @param enterprises
	 * @return
	 */
	public boolean[] save(Enterprise[] enterprises);

	/**
	 * 删除Enterprise
	 * 
	 * @param enterprise
	 * @return
	 */
	public boolean remove(Enterprise enterprise);

	/**
	 * 批量删除Enterprise
	 * 
	 * @param enterprises
	 */
	public void remove(Enterprise[] enterprises);

	/**
	 * 根据主键删除Enterprise
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Enterprise数据记录集
	 * 
	 * @return
	 */
	public List<Enterprise> findAll();

	/**
	 * 根据主键查询Enterprise
	 * 
	 * @param l
	 * @return
	 */
	public Enterprise findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Enterprise searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Enterprise> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}