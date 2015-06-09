package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ShengChan;

public interface ShengChanService {

	/**
	 * 增加或更新ShengChan
	 * 
	 * @param shengchan
	 * @return
	 */
	public boolean save(ShengChan shengchan);

	/**
	 * 批量增加或更新ShengChan
	 * 
	 * @param shengchans
	 * @return
	 */
	public boolean[] save(ShengChan[] shengchans);

	/**
	 * 删除ShengChan
	 * 
	 * @param shengchan
	 * @return
	 */
	public boolean remove(ShengChan shengchan);

	/**
	 * 批量删除ShengChan
	 * 
	 * @param shengchans
	 */
	public void remove(ShengChan[] shengchans);

	/**
	 * 根据主键删除ShengChan
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ShengChan数据记录集
	 * 
	 * @return
	 */
	public List<ShengChan> findAll();

	/**
	 * 根据主键查询ShengChan
	 * 
	 * @param l
	 * @return
	 */
	public ShengChan findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ShengChan searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ShengChan> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}