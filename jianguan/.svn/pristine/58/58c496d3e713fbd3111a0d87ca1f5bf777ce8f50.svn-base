package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.User;

public interface UserService {

	/**
	 * 增加或更新User
	 * 
	 * @param User
	 * @return
	 */
	public boolean save(User User);

	/**
	 * 批量增加或更新User
	 * 
	 * @param User
	 * @return
	 */
	public boolean[] save(User[] Users);

	/**
	 * 删除User
	 * 
	 * @param User
	 * @return
	 */
	public boolean remove(User User);

	/**
	 * 批量删除User
	 * 
	 * @param Users
	 */
	public void remove(User[] Users);

	/**
	 * 根据主键删除User
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	// /**
	// * 批量根据主键删除User
	// *
	// * @param ids
	// */
	// public void removeByIds(long[] ids);

	/**
	 * 查询User数据记录集
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 根据主键查询User
	 * 
	 * @param l
	 * @return
	 */
	public User findById(long l);

	// /**
	// * 批量根据主键查询User记录集
	// *
	// * @param ids
	// * @return
	// */
	// public User[] findByIds(long[] ids);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public User searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<User> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

	/**
	 * 更新状态
	 */
	public int updateStatus(String hql);

	public User login(Search search,int sysType);

	/**
	 * 配置角色
	 * 
	 * @param user
	 * @param id_arr
	 * @return
	 */
	public boolean saveConfigs(User user, String id);
	
	/**
	 * 配置用户企业
	 * */
	public boolean saveUserEnterprise(String ids, String enterpriseID);

}
