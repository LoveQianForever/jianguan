package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.YuMiao;

public interface YuMiaoService {

	/**
	 * 增加或更新YuMiao
	 * 
	 * @param yumiao
	 * @return
	 */
	public boolean save(YuMiao yumiao);

	/**
	 * 批量增加或更新YuMiao
	 * 
	 * @param yumiaos
	 * @return
	 */
	public boolean[] save(YuMiao[] yumiaos);

	/**
	 * 删除YuMiao
	 * 
	 * @param yumiao
	 * @return
	 */
	public boolean remove(YuMiao yumiao);

	/**
	 * 批量删除YuMiao
	 * 
	 * @param yumiaos
	 */
	public void remove(YuMiao[] yumiaos);

	/**
	 * 根据主键删除YuMiao
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询YuMiao数据记录集
	 * 
	 * @return
	 */
	public List<YuMiao> findAll();

	/**
	 * 根据主键查询YuMiao
	 * 
	 * @param l
	 * @return
	 */
	public YuMiao findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public YuMiao searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<YuMiao> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}