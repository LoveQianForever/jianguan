package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ShengChanBaseDao;
import com.ncs.gsyt.modules.model.ShengChanBase;
import com.ncs.gsyt.modules.service.ShengChanBaseService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ShengChanBaseServiceImpl implements ShengChanBaseService{

	@Resource
	private ShengChanBaseDao shengchanbaseDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ShengChanBase shengchanbase) {
		return shengchanbaseDao.save(shengchanbase);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ShengChanBase[] shengchanbases) {
		return shengchanbaseDao.save(shengchanbases);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ShengChanBase shengchanbase) {
		return shengchanbaseDao.remove(shengchanbase);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ShengChanBase[] shengchanbases) {
		shengchanbaseDao.remove(shengchanbases);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return shengchanbaseDao.removeById(id);
	}

	@Override
	public List<ShengChanBase> findAll() {
		return shengchanbaseDao.findAll();
	}

	@Override
	public ShengChanBase findById(long id) {
		return shengchanbaseDao.find(id);
	}

	@Override
	public void flush() {
		shengchanbaseDao.flush();
	}

	@Override
	public ShengChanBase searchUnique(Search search) {
		ShengChanBase shengchanbase = shengchanbaseDao.searchUnique(search);
		return shengchanbase;
	}

	@Override
	public List<ShengChanBase> searchAll(Search search) {
		return shengchanbaseDao.search(search);
	}

	@Override
	public int count(Search search) {
		return shengchanbaseDao.count(search);
	}
}