package com.ncs.gsyt.modules.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.EnterpriseDao;
import com.ncs.gsyt.modules.dao.RoleDao;
import com.ncs.gsyt.modules.dao.UserDao;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Function;
import com.ncs.gsyt.modules.model.Menu;
import com.ncs.gsyt.modules.model.Role;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.UserService;

import edu.emory.mathcs.backport.java.util.Collections;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private RoleDao roleDao;
	@Resource
	private EnterpriseDao enterpriseDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(User[] users) {
		return userDao.save(users);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(User user) {
		return userDao.remove(user);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(User[] users) {
		userDao.remove(users);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return userDao.removeById(id);
	}

//	@Override
//	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
//	public void removeByIds(long[] ids) {
//		userDao.removeByIds(ids);
//	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findById(long id) {
		return userDao.find(id);
	}

//	@Override
//	public User[] findByIds(long[] ids) {
//		return userDao.find(ids);
//	}

	@Override
	public void flush() {
		userDao.flush();
	}

	@Override
	public User searchUnique(Search search) {
		User user = userDao.searchUnique(search);
		return user;
	}

	@Override
	public List<User> searchAll(Search search) {
		return userDao.search(search);
	}

	@Override
	public int count(Search search) {
		return userDao.count(search);
	}

	public int updateStatus(String hql) {
		return userDao.updateStatus(hql);
	}

	@Override
	public User login(Search search,int sysType) {
		User objUser = this.searchUnique(search);
		if (objUser != null) {
			Role role = objUser.getRole();
			List<Menu> menuList = new ArrayList<Menu>();
			List<Function> funcList = new ArrayList<Function>();
			Map<String, Menu> menuMap = new HashMap<String, Menu>();
			if (null != role && role.getRoleid() > 0) {
				for (Menu m : role.getMenus()) {
					if (sysType == m.getSysType()) {//sysType:系统类型 0溯源 1GIS 2水产 3家禽 4大田 5大棚 6茶叶
						funcList.addAll(m.getFuncs());
						menuMap.put(m.getLinkURL(), m);
						if ("0".equals(m.getViewSec())) {
							menuList.add(m);
						}
					}
					
				}
			}
			Collections.sort(menuList);
			Menu.functionINTOMenu(menuMap, funcList);
			objUser.setMenuMap(menuMap);
			objUser.setMenuList(menuList);
		}
		return objUser;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean saveConfigs(User user, String id) {
		boolean rlt = true;
		Role role = null;
		role = roleDao.find(Integer.parseInt(id));
		
		user.setRole(role);
		userDao.save(user);
		return rlt;
	}
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean saveUserEnterprise(String userids, String enterpriseID) {
		try {
			Search s1 = new Search(User.class);
			s1.addFilterIn("userID", userids.split(","));
			List<User> userlist = userDao.search(s1);
			Enterprise e = null;
			if (!"".equals(enterpriseID)) {
				e = enterpriseDao.find(Long.parseLong(enterpriseID));
			} 
			for (User u : userlist) {
				u.setEnterprise(e);
				userDao.save(u);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
