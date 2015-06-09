package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;

public interface InFoodMedicineRecordService {

	/**
	 * 增加或更新InFoodMedicineRecord
	 * 
	 * @param infoodmedicinerecord
	 * @return
	 */
	public boolean save(InFoodMedicineRecord infoodmedicinerecord);

	/**
	 * 批量增加或更新InFoodMedicineRecord
	 * 
	 * @param infoodmedicinerecords
	 * @return
	 */
	public boolean[] save(InFoodMedicineRecord[] infoodmedicinerecords);

	/**
	 * 删除InFoodMedicineRecord
	 * 
	 * @param infoodmedicinerecord
	 * @return
	 */
	public boolean remove(InFoodMedicineRecord infoodmedicinerecord);

	/**
	 * 批量删除InFoodMedicineRecord
	 * 
	 * @param infoodmedicinerecords
	 */
	public void remove(InFoodMedicineRecord[] infoodmedicinerecords);

	/**
	 * 根据主键删除InFoodMedicineRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InFoodMedicineRecord数据记录集
	 * 
	 * @return
	 */
	public List<InFoodMedicineRecord> findAll();

	/**
	 * 根据主键查询InFoodMedicineRecord
	 * 
	 * @param l
	 * @return
	 */
	public InFoodMedicineRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InFoodMedicineRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InFoodMedicineRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}