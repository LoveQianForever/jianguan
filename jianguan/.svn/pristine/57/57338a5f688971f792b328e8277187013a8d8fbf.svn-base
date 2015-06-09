package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.PigMedicineUseRecordDao;
import com.ncs.gsyt.modules.model.PigMedicineUseRecord;
import com.ncs.gsyt.modules.service.PigMedicineUseRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PigMedicineUseRecordServiceImpl implements PigMedicineUseRecordService{

	@Resource
	private PigMedicineUseRecordDao pigmedicineuserecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(PigMedicineUseRecord pigmedicineuserecord) {
		return pigmedicineuserecordDao.save(pigmedicineuserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(PigMedicineUseRecord[] pigmedicineuserecords) {
		return pigmedicineuserecordDao.save(pigmedicineuserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(PigMedicineUseRecord pigmedicineuserecord) {
		return pigmedicineuserecordDao.remove(pigmedicineuserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(PigMedicineUseRecord[] pigmedicineuserecords) {
		pigmedicineuserecordDao.remove(pigmedicineuserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return pigmedicineuserecordDao.removeById(id);
	}

	@Override
	public List<PigMedicineUseRecord> findAll() {
		return pigmedicineuserecordDao.findAll();
	}

	@Override
	public PigMedicineUseRecord findById(long id) {
		return pigmedicineuserecordDao.find(id);
	}

	@Override
	public void flush() {
		pigmedicineuserecordDao.flush();
	}

	@Override
	public PigMedicineUseRecord searchUnique(Search search) {
		PigMedicineUseRecord pigmedicineuserecord = pigmedicineuserecordDao.searchUnique(search);
		return pigmedicineuserecord;
	}

	@Override
	public List<PigMedicineUseRecord> searchAll(Search search) {
		return pigmedicineuserecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return pigmedicineuserecordDao.count(search);
	}
}