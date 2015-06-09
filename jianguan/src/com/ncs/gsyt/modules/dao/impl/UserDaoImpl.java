package com.ncs.gsyt.modules.dao.impl;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ncs.gsyt.core.base.dao.BaseDAO;
import com.ncs.gsyt.modules.dao.UserDao;
import com.ncs.gsyt.modules.model.User;

@Repository
public class UserDaoImpl extends BaseDAO<User, Long> implements UserDao {

	public int updateStatus(String hql) {
		int ret = 0;
		Transaction trans = this.getSession().beginTransaction();
		Query query = this.getSession().createQuery(hql);
		ret = query.executeUpdate();
		trans.commit();
		return ret;
	}

}
