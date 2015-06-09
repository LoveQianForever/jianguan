package com.ncs.gsyt.core.base.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.gsyt.core.base.dao.hibernate.GenericDAOImpl;

public class BaseDAO<T, ID extends Serializable> extends GenericDAOImpl<T, ID> {

	private static Logger logger = org.slf4j.LoggerFactory
			.getLogger(BaseDAO.class);

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 保存对象
	 */
	public void saveObject(T t) {
		Session session = getSession();
		Transaction tx = beginTransaction(session);
		try {
			session.saveOrUpdate(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			logger.error("保存对象失败");
		}
	}

	
	/**
	 * 创建事务
	 */
	private Transaction beginTransaction(Session session) {
		return session.beginTransaction();
	}
}
