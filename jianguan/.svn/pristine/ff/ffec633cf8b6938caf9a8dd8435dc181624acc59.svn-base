package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.BuySeed;

public interface BuySeedService {

	/**
	 * 增加或更新BuySeed
	 * 
	 * @param buyseed
	 * @return
	 */
	public boolean save(BuySeed buyseed);

	/**
	 * 批量增加或更新BuySeed
	 * 
	 * @param buyseeds
	 * @return
	 */
	public boolean[] save(BuySeed[] buyseeds);

	/**
	 * 删除BuySeed
	 * 
	 * @param buyseed
	 * @return
	 */
	public boolean remove(BuySeed buyseed);

	/**
	 * 批量删除BuySeed
	 * 
	 * @param buyseeds
	 */
	public void remove(BuySeed[] buyseeds);

	/**
	 * 根据主键删除BuySeed
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询BuySeed数据记录集
	 * 
	 * @return
	 */
	public List<BuySeed> findAll();

	/**
	 * 根据主键查询BuySeed
	 * 
	 * @param l
	 * @return
	 */
	public BuySeed findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public BuySeed searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<BuySeed> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}