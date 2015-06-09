package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.DieRecordDao;
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.service.DieRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DieRecordServiceImpl implements DieRecordService{

	@Resource
	private DieRecordDao dierecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(DieRecord dierecord) {
		return dierecordDao.save(dierecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(DieRecord[] dierecords) {
		return dierecordDao.save(dierecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(DieRecord dierecord) {
		return dierecordDao.remove(dierecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(DieRecord[] dierecords) {
		dierecordDao.remove(dierecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return dierecordDao.removeById(id);
	}

	@Override
	public List<DieRecord> findAll() {
		return dierecordDao.findAll();
	}

	@Override
	public DieRecord findById(long id) {
		return dierecordDao.find(id);
	}

	@Override
	public void flush() {
		dierecordDao.flush();
	}

	@Override
	public DieRecord searchUnique(Search search) {
		DieRecord dierecord = dierecordDao.searchUnique(search);
		return dierecord;
	}

	@Override
	public List<DieRecord> searchAll(Search search) {
		return dierecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return dierecordDao.count(search);
	}
}