package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.FoodUseRecord;

public interface FoodUseRecordService {

	/**
	 * 增加或更新FoodUseRecord
	 * 
	 * @param fooduserecord
	 * @return
	 */
	public boolean save(FoodUseRecord fooduserecord);

	/**
	 * 批量增加或更新FoodUseRecord
	 * 
	 * @param fooduserecords
	 * @return
	 */
	public boolean[] save(FoodUseRecord[] fooduserecords);

	/**
	 * 删除FoodUseRecord
	 * 
	 * @param fooduserecord
	 * @return
	 */
	public boolean remove(FoodUseRecord fooduserecord);

	/**
	 * 批量删除FoodUseRecord
	 * 
	 * @param fooduserecords
	 */
	public void remove(FoodUseRecord[] fooduserecords);

	/**
	 * 根据主键删除FoodUseRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询FoodUseRecord数据记录集
	 * 
	 * @return
	 */
	public List<FoodUseRecord> findAll();

	/**
	 * 根据主键查询FoodUseRecord
	 * 
	 * @param l
	 * @return
	 */
	public FoodUseRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public FoodUseRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<FoodUseRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}