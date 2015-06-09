package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.EnterpriseattaDao;
import com.ncs.gsyt.modules.model.Enterpriseatta;
import com.ncs.gsyt.modules.service.EnterpriseattaService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class EnterpriseattaServiceImpl implements EnterpriseattaService{

	@Resource
	private EnterpriseattaDao enterpriseattaDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Enterpriseatta enterpriseatta) {
		return enterpriseattaDao.save(enterpriseatta);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Enterpriseatta[] enterpriseattas) {
		return enterpriseattaDao.save(enterpriseattas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Enterpriseatta enterpriseatta) {
		return enterpriseattaDao.remove(enterpriseatta);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Enterpriseatta[] enterpriseattas) {
		enterpriseattaDao.remove(enterpriseattas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return enterpriseattaDao.removeById(id);
	}

	@Override
	public List<Enterpriseatta> findAll() {
		return enterpriseattaDao.findAll();
	}

	@Override
	public Enterpriseatta findById(long id) {
		return enterpriseattaDao.find(id);
	}

	@Override
	public void flush() {
		enterpriseattaDao.flush();
	}

	@Override
	public Enterpriseatta searchUnique(Search search) {
		Enterpriseatta enterpriseatta = enterpriseattaDao.searchUnique(search);
		return enterpriseatta;
	}

	@Override
	public List<Enterpriseatta> searchAll(Search search) {
		return enterpriseattaDao.search(search);
	}

	@Override
	public int count(Search search) {
		return enterpriseattaDao.count(search);
	}
}