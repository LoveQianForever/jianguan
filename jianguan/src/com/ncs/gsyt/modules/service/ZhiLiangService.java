package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ZhiLiang;

public interface ZhiLiangService {

	/**
	 * 增加或更新ZhiLiang
	 * 
	 * @param zhiliang
	 * @return
	 */
	public boolean save(ZhiLiang zhiliang);

	/**
	 * 批量增加或更新ZhiLiang
	 * 
	 * @param zhiliangs
	 * @return
	 */
	public boolean[] save(ZhiLiang[] zhiliangs);

	/**
	 * 删除ZhiLiang
	 * 
	 * @param zhiliang
	 * @return
	 */
	public boolean remove(ZhiLiang zhiliang);

	/**
	 * 批量删除ZhiLiang
	 * 
	 * @param zhiliangs
	 */
	public void remove(ZhiLiang[] zhiliangs);

	/**
	 * 根据主键删除ZhiLiang
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ZhiLiang数据记录集
	 * 
	 * @return
	 */
	public List<ZhiLiang> findAll();

	/**
	 * 根据主键查询ZhiLiang
	 * 
	 * @param l
	 * @return
	 */
	public ZhiLiang findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ZhiLiang searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ZhiLiang> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}