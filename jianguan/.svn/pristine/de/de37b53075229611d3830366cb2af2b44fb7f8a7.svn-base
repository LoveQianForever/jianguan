package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.MedicineUseRecordDao;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.service.MedicineUseRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class MedicineUseRecordServiceImpl implements MedicineUseRecordService{

	@Resource
	private MedicineUseRecordDao medicineuserecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(MedicineUseRecord medicineuserecord) {
		return medicineuserecordDao.save(medicineuserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(MedicineUseRecord[] medicineuserecords) {
		return medicineuserecordDao.save(medicineuserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(MedicineUseRecord medicineuserecord) {
		return medicineuserecordDao.remove(medicineuserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(MedicineUseRecord[] medicineuserecords) {
		medicineuserecordDao.remove(medicineuserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return medicineuserecordDao.removeById(id);
	}

	@Override
	public List<MedicineUseRecord> findAll() {
		return medicineuserecordDao.findAll();
	}

	@Override
	public MedicineUseRecord findById(long id) {
		return medicineuserecordDao.find(id);
	}

	@Override
	public void flush() {
		medicineuserecordDao.flush();
	}

	@Override
	public MedicineUseRecord searchUnique(Search search) {
		MedicineUseRecord medicineuserecord = medicineuserecordDao.searchUnique(search);
		return medicineuserecord;
	}

	@Override
	public List<MedicineUseRecord> searchAll(Search search) {
		return medicineuserecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return medicineuserecordDao.count(search);
	}
}