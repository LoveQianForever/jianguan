package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InPigFoodMedicineRecord;

public interface InPigFoodMedicineRecordService {

	/**
	 * 增加或更新InPigFoodMedicineRecord
	 * 
	 * @param inpigfoodmedicinerecord
	 * @return
	 */
	public boolean save(InPigFoodMedicineRecord inpigfoodmedicinerecord);

	/**
	 * 批量增加或更新InPigFoodMedicineRecord
	 * 
	 * @param inpigfoodmedicinerecords
	 * @return
	 */
	public boolean[] save(InPigFoodMedicineRecord[] inpigfoodmedicinerecords);

	/**
	 * 删除InPigFoodMedicineRecord
	 * 
	 * @param inpigfoodmedicinerecord
	 * @return
	 */
	public boolean remove(InPigFoodMedicineRecord inpigfoodmedicinerecord);

	/**
	 * 批量删除InPigFoodMedicineRecord
	 * 
	 * @param inpigfoodmedicinerecords
	 */
	public void remove(InPigFoodMedicineRecord[] inpigfoodmedicinerecords);

	/**
	 * 根据主键删除InPigFoodMedicineRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InPigFoodMedicineRecord数据记录集
	 * 
	 * @return
	 */
	public List<InPigFoodMedicineRecord> findAll();

	/**
	 * 根据主键查询InPigFoodMedicineRecord
	 * 
	 * @param l
	 * @return
	 */
	public InPigFoodMedicineRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InPigFoodMedicineRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InPigFoodMedicineRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}