package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.XiaoDuRecord;

public interface XiaoDuRecordService {

	/**
	 * 增加或更新XiaoDuRecord
	 * 
	 * @param xiaodurecord
	 * @return
	 */
	public boolean save(XiaoDuRecord xiaodurecord);

	/**
	 * 批量增加或更新XiaoDuRecord
	 * 
	 * @param xiaodurecords
	 * @return
	 */
	public boolean[] save(XiaoDuRecord[] xiaodurecords);

	/**
	 * 删除XiaoDuRecord
	 * 
	 * @param xiaodurecord
	 * @return
	 */
	public boolean remove(XiaoDuRecord xiaodurecord);

	/**
	 * 批量删除XiaoDuRecord
	 * 
	 * @param xiaodurecords
	 */
	public void remove(XiaoDuRecord[] xiaodurecords);

	/**
	 * 根据主键删除XiaoDuRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询XiaoDuRecord数据记录集
	 * 
	 * @return
	 */
	public List<XiaoDuRecord> findAll();

	/**
	 * 根据主键查询XiaoDuRecord
	 * 
	 * @param l
	 * @return
	 */
	public XiaoDuRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public XiaoDuRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<XiaoDuRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}