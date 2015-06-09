package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SeedInDao;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.service.SeedInService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SeedInServiceImpl implements SeedInService{

	@Resource
	private SeedInDao seedinDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SeedIn seedin) {
		return seedinDao.save(seedin);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SeedIn[] seedins) {
		return seedinDao.save(seedins);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SeedIn seedin) {
		return seedinDao.remove(seedin);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SeedIn[] seedins) {
		seedinDao.remove(seedins);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return seedinDao.removeById(id);
	}

	@Override
	public List<SeedIn> findAll() {
		return seedinDao.findAll();
	}

	@Override
	public SeedIn findById(long id) {
		return seedinDao.find(id);
	}

	@Override
	public void flush() {
		seedinDao.flush();
	}

	@Override
	public SeedIn searchUnique(Search search) {
		SeedIn seedin = seedinDao.searchUnique(search);
		return seedin;
	}

	@Override
	public List<SeedIn> searchAll(Search search) {
		return seedinDao.search(search);
	}

	@Override
	public int count(Search search) {
		return seedinDao.count(search);
	}
}