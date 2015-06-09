package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.DisinfectionRecord;

public interface DisinfectionRecordService {

	/**
	 * 增加或更新DisinfectionRecord
	 * 
	 * @param disinfectionrecord
	 * @return
	 */
	public boolean save(DisinfectionRecord disinfectionrecord);

	/**
	 * 批量增加或更新DisinfectionRecord
	 * 
	 * @param disinfectionrecords
	 * @return
	 */
	public boolean[] save(DisinfectionRecord[] disinfectionrecords);

	/**
	 * 删除DisinfectionRecord
	 * 
	 * @param disinfectionrecord
	 * @return
	 */
	public boolean remove(DisinfectionRecord disinfectionrecord);

	/**
	 * 批量删除DisinfectionRecord
	 * 
	 * @param disinfectionrecords
	 */
	public void remove(DisinfectionRecord[] disinfectionrecords);

	/**
	 * 根据主键删除DisinfectionRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询DisinfectionRecord数据记录集
	 * 
	 * @return
	 */
	public List<DisinfectionRecord> findAll();

	/**
	 * 根据主键查询DisinfectionRecord
	 * 
	 * @param l
	 * @return
	 */
	public DisinfectionRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public DisinfectionRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<DisinfectionRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}