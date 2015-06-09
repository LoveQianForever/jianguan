package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.DisinfectionRecordDao;
import com.ncs.gsyt.modules.model.DisinfectionRecord;
import com.ncs.gsyt.modules.service.DisinfectionRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class DisinfectionRecordServiceImpl implements DisinfectionRecordService{

	@Resource
	private DisinfectionRecordDao disinfectionrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(DisinfectionRecord disinfectionrecord) {
		return disinfectionrecordDao.save(disinfectionrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(DisinfectionRecord[] disinfectionrecords) {
		return disinfectionrecordDao.save(disinfectionrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(DisinfectionRecord disinfectionrecord) {
		return disinfectionrecordDao.remove(disinfectionrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(DisinfectionRecord[] disinfectionrecords) {
		disinfectionrecordDao.remove(disinfectionrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return disinfectionrecordDao.removeById(id);
	}

	@Override
	public List<DisinfectionRecord> findAll() {
		return disinfectionrecordDao.findAll();
	}

	@Override
	public DisinfectionRecord findById(long id) {
		return disinfectionrecordDao.find(id);
	}

	@Override
	public void flush() {
		disinfectionrecordDao.flush();
	}

	@Override
	public DisinfectionRecord searchUnique(Search search) {
		DisinfectionRecord disinfectionrecord = disinfectionrecordDao.searchUnique(search);
		return disinfectionrecord;
	}

	@Override
	public List<DisinfectionRecord> searchAll(Search search) {
		return disinfectionrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return disinfectionrecordDao.count(search);
	}
}