package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.FoodMedicineSupply;

public interface FoodMedicineSupplyService {

	/**
	 * 增加或更新FoodMedicineSupply
	 * 
	 * @param foodmedicinesupply
	 * @return
	 */
	public boolean save(FoodMedicineSupply foodmedicinesupply);

	/**
	 * 批量增加或更新FoodMedicineSupply
	 * 
	 * @param foodmedicinesupplys
	 * @return
	 */
	public boolean[] save(FoodMedicineSupply[] foodmedicinesupplys);

	/**
	 * 删除FoodMedicineSupply
	 * 
	 * @param foodmedicinesupply
	 * @return
	 */
	public boolean remove(FoodMedicineSupply foodmedicinesupply);

	/**
	 * 批量删除FoodMedicineSupply
	 * 
	 * @param foodmedicinesupplys
	 */
	public void remove(FoodMedicineSupply[] foodmedicinesupplys);

	/**
	 * 根据主键删除FoodMedicineSupply
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询FoodMedicineSupply数据记录集
	 * 
	 * @return
	 */
	public List<FoodMedicineSupply> findAll();

	/**
	 * 根据主键查询FoodMedicineSupply
	 * 
	 * @param l
	 * @return
	 */
	public FoodMedicineSupply findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public FoodMedicineSupply searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<FoodMedicineSupply> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}