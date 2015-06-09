package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InPigFoodMedicine;

public interface InPigFoodMedicineService {

	/**
	 * 增加或更新InPigFoodMedicine
	 * 
	 * @param inpigfoodmedicine
	 * @return
	 */
	public boolean save(InPigFoodMedicine inpigfoodmedicine);

	/**
	 * 批量增加或更新InPigFoodMedicine
	 * 
	 * @param inpigfoodmedicines
	 * @return
	 */
	public boolean[] save(InPigFoodMedicine[] inpigfoodmedicines);

	/**
	 * 删除InPigFoodMedicine
	 * 
	 * @param inpigfoodmedicine
	 * @return
	 */
	public boolean remove(InPigFoodMedicine inpigfoodmedicine);

	/**
	 * 批量删除InPigFoodMedicine
	 * 
	 * @param inpigfoodmedicines
	 */
	public void remove(InPigFoodMedicine[] inpigfoodmedicines);

	/**
	 * 根据主键删除InPigFoodMedicine
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InPigFoodMedicine数据记录集
	 * 
	 * @return
	 */
	public List<InPigFoodMedicine> findAll();

	/**
	 * 根据主键查询InPigFoodMedicine
	 * 
	 * @param l
	 * @return
	 */
	public InPigFoodMedicine findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InPigFoodMedicine searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InPigFoodMedicine> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}