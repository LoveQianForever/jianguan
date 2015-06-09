package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ImmunityRecordDao;
import com.ncs.gsyt.modules.model.ImmunityRecord;
import com.ncs.gsyt.modules.service.ImmunityRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ImmunityRecordServiceImpl implements ImmunityRecordService{

	@Resource
	private ImmunityRecordDao immunityrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ImmunityRecord immunityrecord) {
		return immunityrecordDao.save(immunityrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ImmunityRecord[] immunityrecords) {
		return immunityrecordDao.save(immunityrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ImmunityRecord immunityrecord) {
		return immunityrecordDao.remove(immunityrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ImmunityRecord[] immunityrecords) {
		immunityrecordDao.remove(immunityrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return immunityrecordDao.removeById(id);
	}

	@Override
	public List<ImmunityRecord> findAll() {
		return immunityrecordDao.findAll();
	}

	@Override
	public ImmunityRecord findById(long id) {
		return immunityrecordDao.find(id);
	}

	@Override
	public void flush() {
		immunityrecordDao.flush();
	}

	@Override
	public ImmunityRecord searchUnique(Search search) {
		ImmunityRecord immunityrecord = immunityrecordDao.searchUnique(search);
		return immunityrecord;
	}

	@Override
	public List<ImmunityRecord> searchAll(Search search) {
		return immunityrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return immunityrecordDao.count(search);
	}
}