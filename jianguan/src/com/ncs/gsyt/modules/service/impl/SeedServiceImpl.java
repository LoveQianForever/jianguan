package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SeedDao;
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.service.SeedService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SeedServiceImpl implements SeedService{

	@Resource
	private SeedDao seedDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Seed seed) {
		return seedDao.save(seed);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Seed[] seeds) {
		return seedDao.save(seeds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Seed seed) {
		return seedDao.remove(seed);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Seed[] seeds) {
		seedDao.remove(seeds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return seedDao.removeById(id);
	}

	@Override
	public List<Seed> findAll() {
		return seedDao.findAll();
	}

	@Override
	public Seed findById(long id) {
		return seedDao.find(id);
	}

	@Override
	public void flush() {
		seedDao.flush();
	}

	@Override
	public Seed searchUnique(Search search) {
		Seed seed = seedDao.searchUnique(search);
		return seed;
	}

	@Override
	public List<Seed> searchAll(Search search) {
		return seedDao.search(search);
	}

	@Override
	public int count(Search search) {
		return seedDao.count(search);
	}
}