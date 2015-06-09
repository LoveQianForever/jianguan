package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ShengChanBase;

public interface ShengChanBaseService {

	/**
	 * 增加或更新ShengChanBase
	 * 
	 * @param shengchanbase
	 * @return
	 */
	public boolean save(ShengChanBase shengchanbase);

	/**
	 * 批量增加或更新ShengChanBase
	 * 
	 * @param shengchanbases
	 * @return
	 */
	public boolean[] save(ShengChanBase[] shengchanbases);

	/**
	 * 删除ShengChanBase
	 * 
	 * @param shengchanbase
	 * @return
	 */
	public boolean remove(ShengChanBase shengchanbase);

	/**
	 * 批量删除ShengChanBase
	 * 
	 * @param shengchanbases
	 */
	public void remove(ShengChanBase[] shengchanbases);

	/**
	 * 根据主键删除ShengChanBase
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ShengChanBase数据记录集
	 * 
	 * @return
	 */
	public List<ShengChanBase> findAll();

	/**
	 * 根据主键查询ShengChanBase
	 * 
	 * @param l
	 * @return
	 */
	public ShengChanBase findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ShengChanBase searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ShengChanBase> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}