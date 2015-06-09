package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.EnterpriseDao;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.service.EnterpriseService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class EnterpriseServiceImpl implements EnterpriseService{

	@Resource
	private EnterpriseDao enterpriseDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Enterprise enterprise) {
		return enterpriseDao.save(enterprise);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Enterprise[] enterprises) {
		return enterpriseDao.save(enterprises);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Enterprise enterprise) {
		return enterpriseDao.remove(enterprise);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Enterprise[] enterprises) {
		enterpriseDao.remove(enterprises);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return enterpriseDao.removeById(id);
	}

	@Override
	public List<Enterprise> findAll() {
		return enterpriseDao.findAll();
	}

	@Override
	public Enterprise findById(long id) {
		return enterpriseDao.find(id);
	}

	@Override
	public void flush() {
		enterpriseDao.flush();
	}

	@Override
	public Enterprise searchUnique(Search search) {
		Enterprise enterprise = enterpriseDao.searchUnique(search);
		return enterprise;
	}

	@Override
	public List<Enterprise> searchAll(Search search) {
		return enterpriseDao.search(search);
	}

	@Override
	public int count(Search search) {
		return enterpriseDao.count(search);
	}
}