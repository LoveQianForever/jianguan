package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SeedManagerDao;
import com.ncs.gsyt.modules.model.SeedManager;
import com.ncs.gsyt.modules.service.SeedManagerService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SeedManagerServiceImpl implements SeedManagerService{

	@Resource
	private SeedManagerDao seedmanagerDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SeedManager seedmanager) {
		return seedmanagerDao.save(seedmanager);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SeedManager[] seedmanagers) {
		return seedmanagerDao.save(seedmanagers);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SeedManager seedmanager) {
		return seedmanagerDao.remove(seedmanager);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SeedManager[] seedmanagers) {
		seedmanagerDao.remove(seedmanagers);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return seedmanagerDao.removeById(id);
	}

	@Override
	public List<SeedManager> findAll() {
		return seedmanagerDao.findAll();
	}

	@Override
	public SeedManager findById(long id) {
		return seedmanagerDao.find(id);
	}

	@Override
	public void flush() {
		seedmanagerDao.flush();
	}

	@Override
	public SeedManager searchUnique(Search search) {
		SeedManager seedmanager = seedmanagerDao.searchUnique(search);
		return seedmanager;
	}

	@Override
	public List<SeedManager> searchAll(Search search) {
		return seedmanagerDao.search(search);
	}

	@Override
	public int count(Search search) {
		return seedmanagerDao.count(search);
	}
}