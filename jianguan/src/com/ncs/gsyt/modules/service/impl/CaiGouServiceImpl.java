package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.CaiGouDao;
import com.ncs.gsyt.modules.model.CaiGou;
import com.ncs.gsyt.modules.service.CaiGouService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class CaiGouServiceImpl implements CaiGouService{

	@Resource
	private CaiGouDao caigouDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(CaiGou caigou) {
		return caigouDao.save(caigou);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(CaiGou[] caigous) {
		return caigouDao.save(caigous);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(CaiGou caigou) {
		return caigouDao.remove(caigou);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(CaiGou[] caigous) {
		caigouDao.remove(caigous);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return caigouDao.removeById(id);
	}

	@Override
	public List<CaiGou> findAll() {
		return caigouDao.findAll();
	}

	@Override
	public CaiGou findById(long id) {
		return caigouDao.find(id);
	}

	@Override
	public void flush() {
		caigouDao.flush();
	}

	@Override
	public CaiGou searchUnique(Search search) {
		CaiGou caigou = caigouDao.searchUnique(search);
		return caigou;
	}

	@Override
	public List<CaiGou> searchAll(Search search) {
		return caigouDao.search(search);
	}

	@Override
	public int count(Search search) {
		return caigouDao.count(search);
	}
}