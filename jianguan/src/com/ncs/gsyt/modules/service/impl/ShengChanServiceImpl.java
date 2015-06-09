package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ShengChanDao;
import com.ncs.gsyt.modules.model.ShengChan;
import com.ncs.gsyt.modules.service.ShengChanService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ShengChanServiceImpl implements ShengChanService{

	@Resource
	private ShengChanDao shengchanDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ShengChan shengchan) {
		return shengchanDao.save(shengchan);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ShengChan[] shengchans) {
		return shengchanDao.save(shengchans);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ShengChan shengchan) {
		return shengchanDao.remove(shengchan);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ShengChan[] shengchans) {
		shengchanDao.remove(shengchans);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return shengchanDao.removeById(id);
	}

	@Override
	public List<ShengChan> findAll() {
		return shengchanDao.findAll();
	}

	@Override
	public ShengChan findById(long id) {
		return shengchanDao.find(id);
	}

	@Override
	public void flush() {
		shengchanDao.flush();
	}

	@Override
	public ShengChan searchUnique(Search search) {
		ShengChan shengchan = shengchanDao.searchUnique(search);
		return shengchan;
	}

	@Override
	public List<ShengChan> searchAll(Search search) {
		return shengchanDao.search(search);
	}

	@Override
	public int count(Search search) {
		return shengchanDao.count(search);
	}
}