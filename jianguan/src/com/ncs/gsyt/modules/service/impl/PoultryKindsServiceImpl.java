package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.PoultryKindsDao;
import com.ncs.gsyt.modules.model.PoultryKinds;
import com.ncs.gsyt.modules.service.PoultryKindsService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PoultryKindsServiceImpl implements PoultryKindsService{

	@Resource
	private PoultryKindsDao poultrykindsDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(PoultryKinds poultrykinds) {
		return poultrykindsDao.save(poultrykinds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(PoultryKinds[] poultrykindss) {
		return poultrykindsDao.save(poultrykindss);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(PoultryKinds poultrykinds) {
		return poultrykindsDao.remove(poultrykinds);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(PoultryKinds[] poultrykindss) {
		poultrykindsDao.remove(poultrykindss);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return poultrykindsDao.removeById(id);
	}

	@Override
	public List<PoultryKinds> findAll() {
		return poultrykindsDao.findAll();
	}

	@Override
	public PoultryKinds findById(long id) {
		return poultrykindsDao.find(id);
	}

	@Override
	public void flush() {
		poultrykindsDao.flush();
	}

	@Override
	public PoultryKinds searchUnique(Search search) {
		PoultryKinds poultrykinds = poultrykindsDao.searchUnique(search);
		return poultrykinds;
	}

	@Override
	public List<PoultryKinds> searchAll(Search search) {
		return poultrykindsDao.search(search);
	}

	@Override
	public int count(Search search) {
		return poultrykindsDao.count(search);
	}
}