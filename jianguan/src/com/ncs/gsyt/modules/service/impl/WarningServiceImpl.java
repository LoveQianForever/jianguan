package com.ncs.gsyt.modules.service.impl;

import java.util.List;






import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.WarningDao;
import com.ncs.gsyt.modules.model.Warning;
import com.ncs.gsyt.modules.service.WarningService;


@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class WarningServiceImpl implements WarningService{

	@Resource
	private WarningDao warningDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Warning warning) {
		return warningDao.save(warning);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Warning[] warnings) {
		return warningDao.save(warnings);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Warning warning) {
		return warningDao.remove(warning);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Warning[] warnings) {
		warningDao.remove(warnings);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return warningDao.removeById(id);
	}

	@Override
	public List<Warning> findAll() {
		return warningDao.findAll();
	}

	@Override
	public Warning findById(long id) {
		return warningDao.find(id);
	}

	@Override
	public void flush() {
		warningDao.flush();
	}

	@Override
	public Warning searchUnique(Search search) {
		Warning warning = warningDao.searchUnique(search);
		return warning;
	}

	@Override
	public List<Warning> searchAll(Search search) {
		return warningDao.search(search);
	}

	@Override
	public int count(Search search) {
		return warningDao.count(search);
	}
}