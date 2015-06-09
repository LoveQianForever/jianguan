package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SeedOutDao;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.service.SeedOutService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SeedOutServiceImpl implements SeedOutService{

	@Resource
	private SeedOutDao seedoutDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SeedOut seedout) {
		return seedoutDao.save(seedout);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SeedOut[] seedouts) {
		return seedoutDao.save(seedouts);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SeedOut seedout) {
		return seedoutDao.remove(seedout);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SeedOut[] seedouts) {
		seedoutDao.remove(seedouts);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return seedoutDao.removeById(id);
	}

	@Override
	public List<SeedOut> findAll() {
		return seedoutDao.findAll();
	}

	@Override
	public SeedOut findById(long id) {
		return seedoutDao.find(id);
	}

	@Override
	public void flush() {
		seedoutDao.flush();
	}

	@Override
	public SeedOut searchUnique(Search search) {
		SeedOut seedout = seedoutDao.searchUnique(search);
		return seedout;
	}

	@Override
	public List<SeedOut> searchAll(Search search) {
		return seedoutDao.search(search);
	}

	@Override
	public int count(Search search) {
		return seedoutDao.count(search);
	}
}