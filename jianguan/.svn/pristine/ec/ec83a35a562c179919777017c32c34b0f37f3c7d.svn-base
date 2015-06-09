package com.ncs.gsyt.modules.service;

import java.util.List;

import net.sf.json.JSON;

import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.Role;

public interface MenuService {

	/**
	 * 查找所有的菜单
	 * 
	 * @return
	 */
	List<Menu> findMenuTreeByPId();

	/**
	 * 根据主键查找菜单
	 * 
	 * @param nodeCode
	 * @return
	 */
	Menu findById(String nodeCode);

	/**
	 * 查找菜单树形
	 * 
	 * @param contexPath
	 * @return
	 */
	JSON findMenuTreeJSON(String contexPath);

	/**
	 * 查找菜单、方法树形
	 * 
	 * @param contexPath
	 * @return
	 */
	JSON findMenuTreeAhor(String contexPath,Role role);


}
