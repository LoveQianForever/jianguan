package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InTouRuPinRecordDao;
import com.ncs.gsyt.modules.model.InTouRuPinRecord;
import com.ncs.gsyt.modules.service.InTouRuPinRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InTouRuPinRecordServiceImpl implements InTouRuPinRecordService{

	@Resource
	private InTouRuPinRecordDao intourupinrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InTouRuPinRecord intourupinrecord) {
		return intourupinrecordDao.save(intourupinrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InTouRuPinRecord[] intourupinrecords) {
		return intourupinrecordDao.save(intourupinrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InTouRuPinRecord intourupinrecord) {
		return intourupinrecordDao.remove(intourupinrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InTouRuPinRecord[] intourupinrecords) {
		intourupinrecordDao.remove(intourupinrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return intourupinrecordDao.removeById(id);
	}

	@Override
	public List<InTouRuPinRecord> findAll() {
		return intourupinrecordDao.findAll();
	}

	@Override
	public InTouRuPinRecord findById(long id) {
		return intourupinrecordDao.find(id);
	}

	@Override
	public void flush() {
		intourupinrecordDao.flush();
	}

	@Override
	public InTouRuPinRecord searchUnique(Search search) {
		InTouRuPinRecord intourupinrecord = intourupinrecordDao.searchUnique(search);
		return intourupinrecord;
	}

	@Override
	public List<InTouRuPinRecord> searchAll(Search search) {
		return intourupinrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return intourupinrecordDao.count(search);
	}
}