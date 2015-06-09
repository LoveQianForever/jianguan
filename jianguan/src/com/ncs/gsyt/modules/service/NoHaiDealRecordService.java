package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.NoHaiDealRecord;

public interface NoHaiDealRecordService {

	/**
	 * 增加或更新NoHaiDealRecord
	 * 
	 * @param nohaidealrecord
	 * @return
	 */
	public boolean save(NoHaiDealRecord nohaidealrecord);

	/**
	 * 批量增加或更新NoHaiDealRecord
	 * 
	 * @param nohaidealrecords
	 * @return
	 */
	public boolean[] save(NoHaiDealRecord[] nohaidealrecords);

	/**
	 * 删除NoHaiDealRecord
	 * 
	 * @param nohaidealrecord
	 * @return
	 */
	public boolean remove(NoHaiDealRecord nohaidealrecord);

	/**
	 * 批量删除NoHaiDealRecord
	 * 
	 * @param nohaidealrecords
	 */
	public void remove(NoHaiDealRecord[] nohaidealrecords);

	/**
	 * 根据主键删除NoHaiDealRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询NoHaiDealRecord数据记录集
	 * 
	 * @return
	 */
	public List<NoHaiDealRecord> findAll();

	/**
	 * 根据主键查询NoHaiDealRecord
	 * 
	 * @param l
	 * @return
	 */
	public NoHaiDealRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public NoHaiDealRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<NoHaiDealRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}