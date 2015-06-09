package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Role;

public interface RoleService {
	/**
	 * 根据条件查询所有记录
	 */
	public List<Role> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

	/**
	 * 保存
	 * 
	 * @param role
	 */
	public boolean save(Role role);

	/**
	 * 根据主键查找角色
	 * 
	 * @param roleid
	 * @return
	 */
	public Role findRoleById(int roleid);

	/**
	 * 保存配置
	 * 
	 * @param role
	 * @return
	 */
	boolean saveConfigs(Role role);
	
	
	
	/**
	 * 更新状态
	 */
	public int updateStatus(String hql);

}
