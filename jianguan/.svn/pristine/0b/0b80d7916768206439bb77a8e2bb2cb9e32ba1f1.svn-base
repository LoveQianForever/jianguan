package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SaleRecord;

public interface SaleRecordService {

	/**
	 * 增加或更新SaleRecord
	 * 
	 * @param salerecord
	 * @return
	 */
	public boolean save(SaleRecord salerecord);

	/**
	 * 批量增加或更新SaleRecord
	 * 
	 * @param salerecords
	 * @return
	 */
	public boolean[] save(SaleRecord[] salerecords);

	/**
	 * 删除SaleRecord
	 * 
	 * @param salerecord
	 * @return
	 */
	public boolean remove(SaleRecord salerecord);

	/**
	 * 批量删除SaleRecord
	 * 
	 * @param salerecords
	 */
	public void remove(SaleRecord[] salerecords);

	/**
	 * 根据主键删除SaleRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SaleRecord数据记录集
	 * 
	 * @return
	 */
	public List<SaleRecord> findAll();

	/**
	 * 根据主键查询SaleRecord
	 * 
	 * @param l
	 * @return
	 */
	public SaleRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SaleRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SaleRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}