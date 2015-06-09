package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.PigSaleRecordDao;
import com.ncs.gsyt.modules.model.PigSaleRecord;
import com.ncs.gsyt.modules.service.PigSaleRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PigSaleRecordServiceImpl implements PigSaleRecordService{

	@Resource
	private PigSaleRecordDao pigsalerecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(PigSaleRecord pigsalerecord) {
		return pigsalerecordDao.save(pigsalerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(PigSaleRecord[] pigsalerecords) {
		return pigsalerecordDao.save(pigsalerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(PigSaleRecord pigsalerecord) {
		return pigsalerecordDao.remove(pigsalerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(PigSaleRecord[] pigsalerecords) {
		pigsalerecordDao.remove(pigsalerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return pigsalerecordDao.removeById(id);
	}

	@Override
	public List<PigSaleRecord> findAll() {
		return pigsalerecordDao.findAll();
	}

	@Override
	public PigSaleRecord findById(long id) {
		return pigsalerecordDao.find(id);
	}

	@Override
	public void flush() {
		pigsalerecordDao.flush();
	}

	@Override
	public PigSaleRecord searchUnique(Search search) {
		PigSaleRecord pigsalerecord = pigsalerecordDao.searchUnique(search);
		return pigsalerecord;
	}

	@Override
	public List<PigSaleRecord> searchAll(Search search) {
		return pigsalerecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return pigsalerecordDao.count(search);
	}
}