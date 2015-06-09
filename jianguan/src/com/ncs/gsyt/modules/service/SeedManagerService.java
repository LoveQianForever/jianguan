package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SeedManager;

public interface SeedManagerService {

	/**
	 * 增加或更新SeedManager
	 * 
	 * @param seedmanager
	 * @return
	 */
	public boolean save(SeedManager seedmanager);

	/**
	 * 批量增加或更新SeedManager
	 * 
	 * @param seedmanagers
	 * @return
	 */
	public boolean[] save(SeedManager[] seedmanagers);

	/**
	 * 删除SeedManager
	 * 
	 * @param seedmanager
	 * @return
	 */
	public boolean remove(SeedManager seedmanager);

	/**
	 * 批量删除SeedManager
	 * 
	 * @param seedmanagers
	 */
	public void remove(SeedManager[] seedmanagers);

	/**
	 * 根据主键删除SeedManager
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SeedManager数据记录集
	 * 
	 * @return
	 */
	public List<SeedManager> findAll();

	/**
	 * 根据主键查询SeedManager
	 * 
	 * @param l
	 * @return
	 */
	public SeedManager findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SeedManager searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SeedManager> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}