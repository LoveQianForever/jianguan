package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Area;

public interface AreaService {

	/**
	 * 增加或更新Area
	 * 
	 * @param area
	 * @return
	 */
	public boolean save(Area area);

	/**
	 * 批量增加或更新Area
	 * 
	 * @param areas
	 * @return
	 */
	public boolean[] save(Area[] areas);

	/**
	 * 删除Area
	 * 
	 * @param area
	 * @return
	 */
	public boolean remove(Area area);

	/**
	 * 批量删除Area
	 * 
	 * @param areas
	 */
	public void remove(Area[] areas);

	/**
	 * 根据主键删除Area
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Area数据记录集
	 * 
	 * @return
	 */
	public List<Area> findAll();

	/**
	 * 根据主键查询Area
	 * 
	 * @param l
	 * @return
	 */
	public Area findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Area searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Area> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}