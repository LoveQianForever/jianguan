package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.MuZhuPeiZhongRecord;

public interface MuZhuPeiZhongRecordService {

	/**
	 * 增加或更新MuZhuPeiZhongRecord
	 * 
	 * @param muzhupeizhongrecord
	 * @return
	 */
	public boolean save(MuZhuPeiZhongRecord muzhupeizhongrecord);

	/**
	 * 批量增加或更新MuZhuPeiZhongRecord
	 * 
	 * @param muzhupeizhongrecords
	 * @return
	 */
	public boolean[] save(MuZhuPeiZhongRecord[] muzhupeizhongrecords);

	/**
	 * 删除MuZhuPeiZhongRecord
	 * 
	 * @param muzhupeizhongrecord
	 * @return
	 */
	public boolean remove(MuZhuPeiZhongRecord muzhupeizhongrecord);

	/**
	 * 批量删除MuZhuPeiZhongRecord
	 * 
	 * @param muzhupeizhongrecords
	 */
	public void remove(MuZhuPeiZhongRecord[] muzhupeizhongrecords);

	/**
	 * 根据主键删除MuZhuPeiZhongRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询MuZhuPeiZhongRecord数据记录集
	 * 
	 * @return
	 */
	public List<MuZhuPeiZhongRecord> findAll();

	/**
	 * 根据主键查询MuZhuPeiZhongRecord
	 * 
	 * @param l
	 * @return
	 */
	public MuZhuPeiZhongRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public MuZhuPeiZhongRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<MuZhuPeiZhongRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}