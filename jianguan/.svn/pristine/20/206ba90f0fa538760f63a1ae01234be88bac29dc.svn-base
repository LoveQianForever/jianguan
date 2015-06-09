package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InputPoultyDao;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.service.InputPoultyService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InputPoultyServiceImpl implements InputPoultyService{

	@Resource
	private InputPoultyDao inputpoultyDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InputPoulty inputpoulty) {
		return inputpoultyDao.save(inputpoulty);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InputPoulty[] inputpoultys) {
		return inputpoultyDao.save(inputpoultys);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InputPoulty inputpoulty) {
		return inputpoultyDao.remove(inputpoulty);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InputPoulty[] inputpoultys) {
		inputpoultyDao.remove(inputpoultys);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return inputpoultyDao.removeById(id);
	}

	@Override
	public List<InputPoulty> findAll() {
		return inputpoultyDao.findAll();
	}

	@Override
	public InputPoulty findById(long id) {
		return inputpoultyDao.find(id);
	}

	@Override
	public void flush() {
		inputpoultyDao.flush();
	}

	@Override
	public InputPoulty searchUnique(Search search) {
		InputPoulty inputpoulty = inputpoultyDao.searchUnique(search);
		return inputpoulty;
	}

	@Override
	public List<InputPoulty> searchAll(Search search) {
		return inputpoultyDao.search(search);
	}

	@Override
	public int count(Search search) {
		return inputpoultyDao.count(search);
	}
}