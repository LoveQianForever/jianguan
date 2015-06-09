package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Batch;

public interface BatchService {

	/**
	 * 增加或更新Batch
	 * 
	 * @param batch
	 * @return
	 */
	public boolean save(Batch batch);

	/**
	 * 批量增加或更新Batch
	 * 
	 * @param batchs
	 * @return
	 */
	public boolean[] save(Batch[] batchs);

	/**
	 * 删除Batch
	 * 
	 * @param batch
	 * @return
	 */
	public boolean remove(Batch batch);

	/**
	 * 批量删除Batch
	 * 
	 * @param batchs
	 */
	public void remove(Batch[] batchs);

	/**
	 * 根据主键删除Batch
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Batch数据记录集
	 * 
	 * @return
	 */
	public List<Batch> findAll();

	/**
	 * 根据主键查询Batch
	 * 
	 * @param l
	 * @return
	 */
	public Batch findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Batch searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Batch> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}