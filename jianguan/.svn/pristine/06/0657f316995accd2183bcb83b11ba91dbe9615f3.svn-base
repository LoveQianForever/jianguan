package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.TouRuPin;

public interface TouRuPinService {

	/**
	 * 增加或更新TouRuPin
	 * 
	 * @param tourupin
	 * @return
	 */
	public boolean save(TouRuPin tourupin);

	/**
	 * 批量增加或更新TouRuPin
	 * 
	 * @param tourupins
	 * @return
	 */
	public boolean[] save(TouRuPin[] tourupins);

	/**
	 * 删除TouRuPin
	 * 
	 * @param tourupin
	 * @return
	 */
	public boolean remove(TouRuPin tourupin);

	/**
	 * 批量删除TouRuPin
	 * 
	 * @param tourupins
	 */
	public void remove(TouRuPin[] tourupins);

	/**
	 * 根据主键删除TouRuPin
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询TouRuPin数据记录集
	 * 
	 * @return
	 */
	public List<TouRuPin> findAll();

	/**
	 * 根据主键查询TouRuPin
	 * 
	 * @param l
	 * @return
	 */
	public TouRuPin findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public TouRuPin searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<TouRuPin> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}