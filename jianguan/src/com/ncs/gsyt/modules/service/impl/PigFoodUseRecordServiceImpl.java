package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.PigFoodUseRecordDao;
import com.ncs.gsyt.modules.model.PigFoodUseRecord;
import com.ncs.gsyt.modules.service.PigFoodUseRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PigFoodUseRecordServiceImpl implements PigFoodUseRecordService{

	@Resource
	private PigFoodUseRecordDao pigfooduserecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(PigFoodUseRecord pigfooduserecord) {
		return pigfooduserecordDao.save(pigfooduserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(PigFoodUseRecord[] pigfooduserecords) {
		return pigfooduserecordDao.save(pigfooduserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(PigFoodUseRecord pigfooduserecord) {
		return pigfooduserecordDao.remove(pigfooduserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(PigFoodUseRecord[] pigfooduserecords) {
		pigfooduserecordDao.remove(pigfooduserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return pigfooduserecordDao.removeById(id);
	}

	@Override
	public List<PigFoodUseRecord> findAll() {
		return pigfooduserecordDao.findAll();
	}

	@Override
	public PigFoodUseRecord findById(long id) {
		return pigfooduserecordDao.find(id);
	}

	@Override
	public void flush() {
		pigfooduserecordDao.flush();
	}

	@Override
	public PigFoodUseRecord searchUnique(Search search) {
		PigFoodUseRecord pigfooduserecord = pigfooduserecordDao.searchUnique(search);
		return pigfooduserecord;
	}

	@Override
	public List<PigFoodUseRecord> searchAll(Search search) {
		return pigfooduserecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return pigfooduserecordDao.count(search);
	}
}