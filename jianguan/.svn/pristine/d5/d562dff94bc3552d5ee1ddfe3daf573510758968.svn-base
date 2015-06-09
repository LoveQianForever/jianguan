package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.PigFoodUseRecord;

public interface PigFoodUseRecordService {

	/**
	 * 增加或更新PigFoodUseRecord
	 * 
	 * @param pigfooduserecord
	 * @return
	 */
	public boolean save(PigFoodUseRecord pigfooduserecord);

	/**
	 * 批量增加或更新PigFoodUseRecord
	 * 
	 * @param pigfooduserecords
	 * @return
	 */
	public boolean[] save(PigFoodUseRecord[] pigfooduserecords);

	/**
	 * 删除PigFoodUseRecord
	 * 
	 * @param pigfooduserecord
	 * @return
	 */
	public boolean remove(PigFoodUseRecord pigfooduserecord);

	/**
	 * 批量删除PigFoodUseRecord
	 * 
	 * @param pigfooduserecords
	 */
	public void remove(PigFoodUseRecord[] pigfooduserecords);

	/**
	 * 根据主键删除PigFoodUseRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询PigFoodUseRecord数据记录集
	 * 
	 * @return
	 */
	public List<PigFoodUseRecord> findAll();

	/**
	 * 根据主键查询PigFoodUseRecord
	 * 
	 * @param l
	 * @return
	 */
	public PigFoodUseRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public PigFoodUseRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<PigFoodUseRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}