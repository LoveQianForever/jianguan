package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.InputPoulty;

public interface InputPoultyService {

	/**
	 * 增加或更新InputPoulty
	 * 
	 * @param inputpoulty
	 * @return
	 */
	public boolean save(InputPoulty inputpoulty);

	/**
	 * 批量增加或更新InputPoulty
	 * 
	 * @param inputpoultys
	 * @return
	 */
	public boolean[] save(InputPoulty[] inputpoultys);

	/**
	 * 删除InputPoulty
	 * 
	 * @param inputpoulty
	 * @return
	 */
	public boolean remove(InputPoulty inputpoulty);

	/**
	 * 批量删除InputPoulty
	 * 
	 * @param inputpoultys
	 */
	public void remove(InputPoulty[] inputpoultys);

	/**
	 * 根据主键删除InputPoulty
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询InputPoulty数据记录集
	 * 
	 * @return
	 */
	public List<InputPoulty> findAll();

	/**
	 * 根据主键查询InputPoulty
	 * 
	 * @param l
	 * @return
	 */
	public InputPoulty findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public InputPoulty searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<InputPoulty> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}