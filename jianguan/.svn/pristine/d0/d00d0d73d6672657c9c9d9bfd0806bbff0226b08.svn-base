package com.ncs.gsyt.modules.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.FunctionDao;
import com.ncs.gsyt.modules.dao.MenuDao;
import com.ncs.gsyt.modules.dao.RoleDao;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.service.RoleService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	@Resource
	private FunctionDao funcDao;
	@Resource
	private MenuDao menuDao;

	@Override
	public int count(Search search) {
		return roleDao.count(search);
	}

	@Override
	public List<Role> searchAll(Search search) {
		List<Role> list = roleDao.search(search);
		
		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Role role) {
		return roleDao.save(role);
	}

	@Override
	public Role findRoleById(int roleid) {
		return roleDao.find(roleid);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean saveConfigs(Role role) {
		Menu menu = null;
		Function func = null;
		List<Function> funcs = new ArrayList<Function>();
		List<Menu> menus = new ArrayList<Menu>();
		for (String nodeCode : role.getNodeCodes()) {
			if (nodeCode.startsWith("F_")) {
				func = funcDao.find(Integer.parseInt(nodeCode.substring(2)));
				funcs.add(func);
			} else {
				menu = menuDao.find(nodeCode);
				menus.add(menu);
			}
		}
		role.setMenus(menus);
		role.setFuncs(funcs);
		roleDao.save(role);

		return true;
	}
	
	
	public int updateStatus(String hql) {
		return roleDao.updateStatus(hql);
	}

}
