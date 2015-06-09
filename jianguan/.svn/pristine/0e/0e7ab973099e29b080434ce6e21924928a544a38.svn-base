package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InTouRuPinRecord;

public interface InTouRuPinRecordService {

	/**
	 * 增加或更新InTouRuPinRecord
	 * 
	 * @param intourupinrecord
	 * @return
	 */
	public boolean save(InTouRuPinRecord intourupinrecord);

	/**
	 * 批量增加或更新InTouRuPinRecord
	 * 
	 * @param intourupinrecords
	 * @return
	 */
	public boolean[] save(InTouRuPinRecord[] intourupinrecords);

	/**
	 * 删除InTouRuPinRecord
	 * 
	 * @param intourupinrecord
	 * @return
	 */
	public boolean remove(InTouRuPinRecord intourupinrecord);

	/**
	 * 批量删除InTouRuPinRecord
	 * 
	 * @param intourupinrecords
	 */
	public void remove(InTouRuPinRecord[] intourupinrecords);

	/**
	 * 根据主键删除InTouRuPinRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InTouRuPinRecord数据记录集
	 * 
	 * @return
	 */
	public List<InTouRuPinRecord> findAll();

	/**
	 * 根据主键查询InTouRuPinRecord
	 * 
	 * @param l
	 * @return
	 */
	public InTouRuPinRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InTouRuPinRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InTouRuPinRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}