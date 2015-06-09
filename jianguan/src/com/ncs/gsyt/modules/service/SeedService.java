package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Seed;

public interface SeedService {

	/**
	 * 增加或更新Seed
	 * 
	 * @param seed
	 * @return
	 */
	public boolean save(Seed seed);

	/**
	 * 批量增加或更新Seed
	 * 
	 * @param seeds
	 * @return
	 */
	public boolean[] save(Seed[] seeds);

	/**
	 * 删除Seed
	 * 
	 * @param seed
	 * @return
	 */
	public boolean remove(Seed seed);

	/**
	 * 批量删除Seed
	 * 
	 * @param seeds
	 */
	public void remove(Seed[] seeds);

	/**
	 * 根据主键删除Seed
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Seed数据记录集
	 * 
	 * @return
	 */
	public List<Seed> findAll();

	/**
	 * 根据主键查询Seed
	 * 
	 * @param l
	 * @return
	 */
	public Seed findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Seed searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Seed> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}