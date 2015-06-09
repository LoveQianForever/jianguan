package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ImmunityRecord;

public interface ImmunityRecordService {

	/**
	 * 增加或更新ImmunityRecord
	 * 
	 * @param immunityrecord
	 * @return
	 */
	public boolean save(ImmunityRecord immunityrecord);

	/**
	 * 批量增加或更新ImmunityRecord
	 * 
	 * @param immunityrecords
	 * @return
	 */
	public boolean[] save(ImmunityRecord[] immunityrecords);

	/**
	 * 删除ImmunityRecord
	 * 
	 * @param immunityrecord
	 * @return
	 */
	public boolean remove(ImmunityRecord immunityrecord);

	/**
	 * 批量删除ImmunityRecord
	 * 
	 * @param immunityrecords
	 */
	public void remove(ImmunityRecord[] immunityrecords);

	/**
	 * 根据主键删除ImmunityRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ImmunityRecord数据记录集
	 * 
	 * @return
	 */
	public List<ImmunityRecord> findAll();

	/**
	 * 根据主键查询ImmunityRecord
	 * 
	 * @param l
	 * @return
	 */
	public ImmunityRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ImmunityRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ImmunityRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}