package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.SeedEnterprise;

public interface SeedEnterpriseService {

	/**
	 * 增加或更新SeedEnterprise
	 * 
	 * @param seedenterprise
	 * @return
	 */
	public boolean save(SeedEnterprise seedenterprise);

	/**
	 * 批量增加或更新SeedEnterprise
	 * 
	 * @param seedenterprises
	 * @return
	 */
	public boolean[] save(SeedEnterprise[] seedenterprises);

	/**
	 * 删除SeedEnterprise
	 * 
	 * @param seedenterprise
	 * @return
	 */
	public boolean remove(SeedEnterprise seedenterprise);

	/**
	 * 批量删除SeedEnterprise
	 * 
	 * @param seedenterprises
	 */
	public void remove(SeedEnterprise[] seedenterprises);

	/**
	 * 根据主键删除SeedEnterprise
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询SeedEnterprise数据记录集
	 * 
	 * @return
	 */
	public List<SeedEnterprise> findAll();

	/**
	 * 根据主键查询SeedEnterprise
	 * 
	 * @param l
	 * @return
	 */
	public SeedEnterprise findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public SeedEnterprise searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<SeedEnterprise> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}