package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.NongShi;

public interface NongShiService {

	/**
	 * 增加或更新NongShi
	 * 
	 * @param nongshi
	 * @return
	 */
	public boolean save(NongShi nongshi);

	/**
	 * 批量增加或更新NongShi
	 * 
	 * @param nongshis
	 * @return
	 */
	public boolean[] save(NongShi[] nongshis);

	/**
	 * 删除NongShi
	 * 
	 * @param nongshi
	 * @return
	 */
	public boolean remove(NongShi nongshi);

	/**
	 * 批量删除NongShi
	 * 
	 * @param nongshis
	 */
	public void remove(NongShi[] nongshis);

	/**
	 * 根据主键删除NongShi
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询NongShi数据记录集
	 * 
	 * @return
	 */
	public List<NongShi> findAll();

	/**
	 * 根据主键查询NongShi
	 * 
	 * @param l
	 * @return
	 */
	public NongShi findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public NongShi searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<NongShi> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}