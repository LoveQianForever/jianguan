package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SeedOut;

public interface SeedOutService {

	/**
	 * 增加或更新SeedOut
	 * 
	 * @param seedout
	 * @return
	 */
	public boolean save(SeedOut seedout);

	/**
	 * 批量增加或更新SeedOut
	 * 
	 * @param seedouts
	 * @return
	 */
	public boolean[] save(SeedOut[] seedouts);

	/**
	 * 删除SeedOut
	 * 
	 * @param seedout
	 * @return
	 */
	public boolean remove(SeedOut seedout);

	/**
	 * 批量删除SeedOut
	 * 
	 * @param seedouts
	 */
	public void remove(SeedOut[] seedouts);

	/**
	 * 根据主键删除SeedOut
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SeedOut数据记录集
	 * 
	 * @return
	 */
	public List<SeedOut> findAll();

	/**
	 * 根据主键查询SeedOut
	 * 
	 * @param l
	 * @return
	 */
	public SeedOut findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SeedOut searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SeedOut> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}