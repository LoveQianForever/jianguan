package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.MedicineUseRecord;

public interface MedicineUseRecordService {

	/**
	 * 增加或更新MedicineUseRecord
	 * 
	 * @param medicineuserecord
	 * @return
	 */
	public boolean save(MedicineUseRecord medicineuserecord);

	/**
	 * 批量增加或更新MedicineUseRecord
	 * 
	 * @param medicineuserecords
	 * @return
	 */
	public boolean[] save(MedicineUseRecord[] medicineuserecords);

	/**
	 * 删除MedicineUseRecord
	 * 
	 * @param medicineuserecord
	 * @return
	 */
	public boolean remove(MedicineUseRecord medicineuserecord);

	/**
	 * 批量删除MedicineUseRecord
	 * 
	 * @param medicineuserecords
	 */
	public void remove(MedicineUseRecord[] medicineuserecords);

	/**
	 * 根据主键删除MedicineUseRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询MedicineUseRecord数据记录集
	 * 
	 * @return
	 */
	public List<MedicineUseRecord> findAll();

	/**
	 * 根据主键查询MedicineUseRecord
	 * 
	 * @param l
	 * @return
	 */
	public MedicineUseRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public MedicineUseRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<MedicineUseRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}