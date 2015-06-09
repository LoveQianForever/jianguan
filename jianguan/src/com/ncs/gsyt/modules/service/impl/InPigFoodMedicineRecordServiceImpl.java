package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InPigFoodMedicineRecordDao;
import com.ncs.gsyt.modules.model.InPigFoodMedicineRecord;
import com.ncs.gsyt.modules.service.InPigFoodMedicineRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InPigFoodMedicineRecordServiceImpl implements InPigFoodMedicineRecordService{

	@Resource
	private InPigFoodMedicineRecordDao inpigfoodmedicinerecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InPigFoodMedicineRecord inpigfoodmedicinerecord) {
		return inpigfoodmedicinerecordDao.save(inpigfoodmedicinerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InPigFoodMedicineRecord[] inpigfoodmedicinerecords) {
		return inpigfoodmedicinerecordDao.save(inpigfoodmedicinerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InPigFoodMedicineRecord inpigfoodmedicinerecord) {
		return inpigfoodmedicinerecordDao.remove(inpigfoodmedicinerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InPigFoodMedicineRecord[] inpigfoodmedicinerecords) {
		inpigfoodmedicinerecordDao.remove(inpigfoodmedicinerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return inpigfoodmedicinerecordDao.removeById(id);
	}

	@Override
	public List<InPigFoodMedicineRecord> findAll() {
		return inpigfoodmedicinerecordDao.findAll();
	}

	@Override
	public InPigFoodMedicineRecord findById(long id) {
		return inpigfoodmedicinerecordDao.find(id);
	}

	@Override
	public void flush() {
		inpigfoodmedicinerecordDao.flush();
	}

	@Override
	public InPigFoodMedicineRecord searchUnique(Search search) {
		InPigFoodMedicineRecord inpigfoodmedicinerecord = inpigfoodmedicinerecordDao.searchUnique(search);
		return inpigfoodmedicinerecord;
	}

	@Override
	public List<InPigFoodMedicineRecord> searchAll(Search search) {
		return inpigfoodmedicinerecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return inpigfoodmedicinerecordDao.count(search);
	}
}