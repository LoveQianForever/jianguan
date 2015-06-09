package com.ncs.gsyt.modules.dao.impl;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ncs.gsyt.core.base.dao.BaseDAO;
import com.ncs.gsyt.modules.dao.RoleDao;
import com.ncs.gsyt.modules.model.Role;

@Repository
public class RoleDaoImpl extends BaseDAO<Role, Integer> implements RoleDao {

	@Override
	public boolean mergeRole(Role role) {
		_merge(role);
		return true;
	}

	public int updateStatus(String hql) {
		int ret = 0;
		Transaction trans = this.getSession().beginTransaction();
		Query query = null;
		query = this.getSession().createQuery(hql);
		ret = query.executeUpdate();
		trans.commit();
		return ret;
	}
}
