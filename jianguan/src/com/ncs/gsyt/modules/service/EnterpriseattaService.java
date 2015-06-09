package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Enterpriseatta;

public interface EnterpriseattaService {

	/**
	 * 增加或更新Enterpriseatta
	 * 
	 * @param enterpriseatta
	 * @return
	 */
	public boolean save(Enterpriseatta enterpriseatta);

	/**
	 * 批量增加或更新Enterpriseatta
	 * 
	 * @param enterpriseattas
	 * @return
	 */
	public boolean[] save(Enterpriseatta[] enterpriseattas);

	/**
	 * 删除Enterpriseatta
	 * 
	 * @param enterpriseatta
	 * @return
	 */
	public boolean remove(Enterpriseatta enterpriseatta);

	/**
	 * 批量删除Enterpriseatta
	 * 
	 * @param enterpriseattas
	 */
	public void remove(Enterpriseatta[] enterpriseattas);

	/**
	 * 根据主键删除Enterpriseatta
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询Enterpriseatta数据记录集
	 * 
	 * @return
	 */
	public List<Enterpriseatta> findAll();

	/**
	 * 根据主键查询Enterpriseatta
	 * 
	 * @param l
	 * @return
	 */
	public Enterpriseatta findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public Enterpriseatta searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<Enterpriseatta> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}