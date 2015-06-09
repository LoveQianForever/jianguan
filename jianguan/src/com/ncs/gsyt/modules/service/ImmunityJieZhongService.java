package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.ImmunityJieZhong;

public interface ImmunityJieZhongService {

	/**
	 * 增加或更新ImmunityJieZhong
	 * 
	 * @param immunityjiezhong
	 * @return
	 */
	public boolean save(ImmunityJieZhong immunityjiezhong);

	/**
	 * 批量增加或更新ImmunityJieZhong
	 * 
	 * @param immunityjiezhongs
	 * @return
	 */
	public boolean[] save(ImmunityJieZhong[] immunityjiezhongs);

	/**
	 * 删除ImmunityJieZhong
	 * 
	 * @param immunityjiezhong
	 * @return
	 */
	public boolean remove(ImmunityJieZhong immunityjiezhong);

	/**
	 * 批量删除ImmunityJieZhong
	 * 
	 * @param immunityjiezhongs
	 */
	public void remove(ImmunityJieZhong[] immunityjiezhongs);

	/**
	 * 根据主键删除ImmunityJieZhong
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询ImmunityJieZhong数据记录集
	 * 
	 * @return
	 */
	public List<ImmunityJieZhong> findAll();

	/**
	 * 根据主键查询ImmunityJieZhong
	 * 
	 * @param l
	 * @return
	 */
	public ImmunityJieZhong findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ImmunityJieZhong searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<ImmunityJieZhong> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}