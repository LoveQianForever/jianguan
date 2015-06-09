package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.FoodProRecord;

public interface FoodProRecordService {

	/**
	 * 增加或更新FoodProRecord
	 * 
	 * @param foodprorecord
	 * @return
	 */
	public boolean save(FoodProRecord foodprorecord);

	/**
	 * 批量增加或更新FoodProRecord
	 * 
	 * @param foodprorecords
	 * @return
	 */
	public boolean[] save(FoodProRecord[] foodprorecords);

	/**
	 * 删除FoodProRecord
	 * 
	 * @param foodprorecord
	 * @return
	 */
	public boolean remove(FoodProRecord foodprorecord);

	/**
	 * 批量删除FoodProRecord
	 * 
	 * @param foodprorecords
	 */
	public void remove(FoodProRecord[] foodprorecords);

	/**
	 * 根据主键删除FoodProRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询FoodProRecord数据记录集
	 * 
	 * @return
	 */
	public List<FoodProRecord> findAll();

	/**
	 * 根据主键查询FoodProRecord
	 * 
	 * @param l
	 * @return
	 */
	public FoodProRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public FoodProRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<FoodProRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}