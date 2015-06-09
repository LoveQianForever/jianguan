package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InFoodMedicine;

public interface InFoodMedicineService {

	/**
	 * 增加或更新InFoodMedicine
	 * 
	 * @param infoodmedicine
	 * @return
	 */
	public boolean save(InFoodMedicine infoodmedicine);

	/**
	 * 批量增加或更新InFoodMedicine
	 * 
	 * @param infoodmedicines
	 * @return
	 */
	public boolean[] save(InFoodMedicine[] infoodmedicines);

	/**
	 * 删除InFoodMedicine
	 * 
	 * @param infoodmedicine
	 * @return
	 */
	public boolean remove(InFoodMedicine infoodmedicine);

	/**
	 * 批量删除InFoodMedicine
	 * 
	 * @param infoodmedicines
	 */
	public void remove(InFoodMedicine[] infoodmedicines);

	/**
	 * 根据主键删除InFoodMedicine
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InFoodMedicine数据记录集
	 * 
	 * @return
	 */
	public List<InFoodMedicine> findAll();

	/**
	 * 根据主键查询InFoodMedicine
	 * 
	 * @param l
	 * @return
	 */
	public InFoodMedicine findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InFoodMedicine searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InFoodMedicine> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}