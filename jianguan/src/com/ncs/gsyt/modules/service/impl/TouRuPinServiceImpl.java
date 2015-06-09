package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.TouRuPinDao;
import com.ncs.gsyt.modules.model.TouRuPin;
import com.ncs.gsyt.modules.service.TouRuPinService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TouRuPinServiceImpl implements TouRuPinService{

	@Resource
	private TouRuPinDao tourupinDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(TouRuPin tourupin) {
		return tourupinDao.save(tourupin);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(TouRuPin[] tourupins) {
		return tourupinDao.save(tourupins);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(TouRuPin tourupin) {
		return tourupinDao.remove(tourupin);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(TouRuPin[] tourupins) {
		tourupinDao.remove(tourupins);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return tourupinDao.removeById(id);
	}

	@Override
	public List<TouRuPin> findAll() {
		return tourupinDao.findAll();
	}

	@Override
	public TouRuPin findById(long id) {
		return tourupinDao.find(id);
	}

	@Override
	public void flush() {
		tourupinDao.flush();
	}

	@Override
	public TouRuPin searchUnique(Search search) {
		TouRuPin tourupin = tourupinDao.searchUnique(search);
		return tourupin;
	}

	@Override
	public List<TouRuPin> searchAll(Search search) {
		return tourupinDao.search(search);
	}

	@Override
	public int count(Search search) {
		return tourupinDao.count(search);
	}
}