package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.BuySeedDao;
import com.ncs.gsyt.modules.model.BuySeed;
import com.ncs.gsyt.modules.service.BuySeedService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BuySeedServiceImpl implements BuySeedService{

	@Resource
	private BuySeedDao buyseedDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(BuySeed buyseed) {
		return buyseedDao.save(buyseed);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(BuySeed[] buyseeds) {
		return buyseedDao.save(buyseeds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(BuySeed buyseed) {
		return buyseedDao.remove(buyseed);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(BuySeed[] buyseeds) {
		buyseedDao.remove(buyseeds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return buyseedDao.removeById(id);
	}

	@Override
	public List<BuySeed> findAll() {
		return buyseedDao.findAll();
	}

	@Override
	public BuySeed findById(long id) {
		return buyseedDao.find(id);
	}

	@Override
	public void flush() {
		buyseedDao.flush();
	}

	@Override
	public BuySeed searchUnique(Search search) {
		BuySeed buyseed = buyseedDao.searchUnique(search);
		return buyseed;
	}

	@Override
	public List<BuySeed> searchAll(Search search) {
		return buyseedDao.search(search);
	}

	@Override
	public int count(Search search) {
		return buyseedDao.count(search);
	}
}