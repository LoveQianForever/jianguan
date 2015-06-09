package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.DieRecord;

public interface DieRecordService {

	/**
	 * 增加或更新DieRecord
	 * 
	 * @param dierecord
	 * @return
	 */
	public boolean save(DieRecord dierecord);

	/**
	 * 批量增加或更新DieRecord
	 * 
	 * @param dierecords
	 * @return
	 */
	public boolean[] save(DieRecord[] dierecords);

	/**
	 * 删除DieRecord
	 * 
	 * @param dierecord
	 * @return
	 */
	public boolean remove(DieRecord dierecord);

	/**
	 * 批量删除DieRecord
	 * 
	 * @param dierecords
	 */
	public void remove(DieRecord[] dierecords);

	/**
	 * 根据主键删除DieRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询DieRecord数据记录集
	 * 
	 * @return
	 */
	public List<DieRecord> findAll();

	/**
	 * 根据主键查询DieRecord
	 * 
	 * @param l
	 * @return
	 */
	public DieRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public DieRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<DieRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}