package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InFoodMedicineRecordDao;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.service.InFoodMedicineRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InFoodMedicineRecordServiceImpl implements InFoodMedicineRecordService{

	@Resource
	private InFoodMedicineRecordDao infoodmedicinerecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InFoodMedicineRecord infoodmedicinerecord) {
		return infoodmedicinerecordDao.save(infoodmedicinerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InFoodMedicineRecord[] infoodmedicinerecords) {
		return infoodmedicinerecordDao.save(infoodmedicinerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InFoodMedicineRecord infoodmedicinerecord) {
		return infoodmedicinerecordDao.remove(infoodmedicinerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InFoodMedicineRecord[] infoodmedicinerecords) {
		infoodmedicinerecordDao.remove(infoodmedicinerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return infoodmedicinerecordDao.removeById(id);
	}

	@Override
	public List<InFoodMedicineRecord> findAll() {
		return infoodmedicinerecordDao.findAll();
	}

	@Override
	public InFoodMedicineRecord findById(long id) {
		return infoodmedicinerecordDao.find(id);
	}

	@Override
	public void flush() {
		infoodmedicinerecordDao.flush();
	}

	@Override
	public InFoodMedicineRecord searchUnique(Search search) {
		InFoodMedicineRecord infoodmedicinerecord = infoodmedicinerecordDao.searchUnique(search);
		return infoodmedicinerecord;
	}

	@Override
	public List<InFoodMedicineRecord> searchAll(Search search) {
		return infoodmedicinerecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return infoodmedicinerecordDao.count(search);
	}
}