package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.PigMedicineUseRecord;

public interface PigMedicineUseRecordService {

	/**
	 * 增加或更新PigMedicineUseRecord
	 * 
	 * @param pigmedicineuserecord
	 * @return
	 */
	public boolean save(PigMedicineUseRecord pigmedicineuserecord);

	/**
	 * 批量增加或更新PigMedicineUseRecord
	 * 
	 * @param pigmedicineuserecords
	 * @return
	 */
	public boolean[] save(PigMedicineUseRecord[] pigmedicineuserecords);

	/**
	 * 删除PigMedicineUseRecord
	 * 
	 * @param pigmedicineuserecord
	 * @return
	 */
	public boolean remove(PigMedicineUseRecord pigmedicineuserecord);

	/**
	 * 批量删除PigMedicineUseRecord
	 * 
	 * @param pigmedicineuserecords
	 */
	public void remove(PigMedicineUseRecord[] pigmedicineuserecords);

	/**
	 * 根据主键删除PigMedicineUseRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询PigMedicineUseRecord数据记录集
	 * 
	 * @return
	 */
	public List<PigMedicineUseRecord> findAll();

	/**
	 * 根据主键查询PigMedicineUseRecord
	 * 
	 * @param l
	 * @return
	 */
	public PigMedicineUseRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public PigMedicineUseRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<PigMedicineUseRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}