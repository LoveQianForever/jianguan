package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.BatchDao;
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.service.BatchService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BatchServiceImpl implements BatchService{

	@Resource
	private BatchDao batchDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Batch batch) {
		return batchDao.save(batch);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Batch[] batchs) {
		return batchDao.save(batchs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Batch batch) {
		return batchDao.remove(batch);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Batch[] batchs) {
		batchDao.remove(batchs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return batchDao.removeById(id);
	}

	@Override
	public List<Batch> findAll() {
		return batchDao.findAll();
	}

	@Override
	public Batch findById(long id) {
		return batchDao.find(id);
	}

	@Override
	public void flush() {
		batchDao.flush();
	}

	@Override
	public Batch searchUnique(Search search) {
		Batch batch = batchDao.searchUnique(search);
		return batch;
	}

	@Override
	public List<Batch> searchAll(Search search) {
		return batchDao.search(search);
	}

	@Override
	public int count(Search search) {
		return batchDao.count(search);
	}
}