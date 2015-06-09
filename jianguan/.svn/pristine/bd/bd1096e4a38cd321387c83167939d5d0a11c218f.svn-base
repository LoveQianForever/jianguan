package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SysParam;

public interface SysParamService {

	/**
	 * 增加或更新SysParam
	 * 
	 * @param sysparam
	 * @return
	 */
	public boolean save(SysParam sysparam);

	/**
	 * 批量增加或更新SysParam
	 * 
	 * @param sysparams
	 * @return
	 */
	public boolean[] save(SysParam[] sysparams);

	/**
	 * 删除SysParam
	 * 
	 * @param sysparam
	 * @return
	 */
	public boolean remove(SysParam sysparam);

	/**
	 * 批量删除SysParam
	 * 
	 * @param sysparams
	 */
	public void remove(SysParam[] sysparams);

	/**
	 * 根据主键删除SysParam
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SysParam数据记录集
	 * 
	 * @return
	 */
	public List<SysParam> findAll();

	/**
	 * 根据主键查询SysParam
	 * 
	 * @param l
	 * @return
	 */
	public SysParam findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SysParam searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SysParam> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}