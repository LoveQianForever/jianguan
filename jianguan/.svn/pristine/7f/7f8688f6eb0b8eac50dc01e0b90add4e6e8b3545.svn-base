package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.FoodProRecordDao;
import com.ncs.gsyt.modules.model.FoodProRecord;
import com.ncs.gsyt.modules.service.FoodProRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class FoodProRecordServiceImpl implements FoodProRecordService{

	@Resource
	private FoodProRecordDao foodprorecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(FoodProRecord foodprorecord) {
		return foodprorecordDao.save(foodprorecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(FoodProRecord[] foodprorecords) {
		return foodprorecordDao.save(foodprorecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(FoodProRecord foodprorecord) {
		return foodprorecordDao.remove(foodprorecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(FoodProRecord[] foodprorecords) {
		foodprorecordDao.remove(foodprorecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return foodprorecordDao.removeById(id);
	}

	@Override
	public List<FoodProRecord> findAll() {
		return foodprorecordDao.findAll();
	}

	@Override
	public FoodProRecord findById(long id) {
		return foodprorecordDao.find(id);
	}

	@Override
	public void flush() {
		foodprorecordDao.flush();
	}

	@Override
	public FoodProRecord searchUnique(Search search) {
		FoodProRecord foodprorecord = foodprorecordDao.searchUnique(search);
		return foodprorecord;
	}

	@Override
	public List<FoodProRecord> searchAll(Search search) {
		return foodprorecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return foodprorecordDao.count(search);
	}
}