package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Place;

public interface PlaceService {

	/**
	 * 增加或更新Place
	 * 
	 * @param place
	 * @return
	 */
	public boolean save(Place place);

	/**
	 * 批量增加或更新Place
	 * 
	 * @param places
	 * @return
	 */
	public boolean[] save(Place[] places);

	/**
	 * 删除Place
	 * 
	 * @param place
	 * @return
	 */
	public boolean remove(Place place);

	/**
	 * 批量删除Place
	 * 
	 * @param places
	 */
	public void remove(Place[] places);

	/**
	 * 根据主键删除Place
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Place数据记录集
	 * 
	 * @return
	 */
	public List<Place> findAll();

	/**
	 * 根据主键查询Place
	 * 
	 * @param l
	 * @return
	 */
	public Place findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Place searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Place> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}