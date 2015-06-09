package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SeedIn;

public interface SeedInService {

	/**
	 * 增加或更新SeedIn
	 * 
	 * @param seedin
	 * @return
	 */
	public boolean save(SeedIn seedin);

	/**
	 * 批量增加或更新SeedIn
	 * 
	 * @param seedins
	 * @return
	 */
	public boolean[] save(SeedIn[] seedins);

	/**
	 * 删除SeedIn
	 * 
	 * @param seedin
	 * @return
	 */
	public boolean remove(SeedIn seedin);

	/**
	 * 批量删除SeedIn
	 * 
	 * @param seedins
	 */
	public void remove(SeedIn[] seedins);

	/**
	 * 根据主键删除SeedIn
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SeedIn数据记录集
	 * 
	 * @return
	 */
	public List<SeedIn> findAll();

	/**
	 * 根据主键查询SeedIn
	 * 
	 * @param l
	 * @return
	 */
	public SeedIn findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SeedIn searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SeedIn> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}