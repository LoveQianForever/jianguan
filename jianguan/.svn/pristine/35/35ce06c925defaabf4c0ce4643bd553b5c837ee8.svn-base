package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.PigSaleRecord;

public interface PigSaleRecordService {

	/**
	 * 增加或更新PigSaleRecord
	 * 
	 * @param pigsalerecord
	 * @return
	 */
	public boolean save(PigSaleRecord pigsalerecord);

	/**
	 * 批量增加或更新PigSaleRecord
	 * 
	 * @param pigsalerecords
	 * @return
	 */
	public boolean[] save(PigSaleRecord[] pigsalerecords);

	/**
	 * 删除PigSaleRecord
	 * 
	 * @param pigsalerecord
	 * @return
	 */
	public boolean remove(PigSaleRecord pigsalerecord);

	/**
	 * 批量删除PigSaleRecord
	 * 
	 * @param pigsalerecords
	 */
	public void remove(PigSaleRecord[] pigsalerecords);

	/**
	 * 根据主键删除PigSaleRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询PigSaleRecord数据记录集
	 * 
	 * @return
	 */
	public List<PigSaleRecord> findAll();

	/**
	 * 根据主键查询PigSaleRecord
	 * 
	 * @param l
	 * @return
	 */
	public PigSaleRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public PigSaleRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<PigSaleRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}