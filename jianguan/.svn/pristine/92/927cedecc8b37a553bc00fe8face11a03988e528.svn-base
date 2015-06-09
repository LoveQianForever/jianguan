package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.FoodUseRecordDao;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.service.FoodUseRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class FoodUseRecordServiceImpl implements FoodUseRecordService{

	@Resource
	private FoodUseRecordDao fooduserecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(FoodUseRecord fooduserecord) {
		return fooduserecordDao.save(fooduserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(FoodUseRecord[] fooduserecords) {
		return fooduserecordDao.save(fooduserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(FoodUseRecord fooduserecord) {
		return fooduserecordDao.remove(fooduserecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(FoodUseRecord[] fooduserecords) {
		fooduserecordDao.remove(fooduserecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return fooduserecordDao.removeById(id);
	}

	@Override
	public List<FoodUseRecord> findAll() {
		return fooduserecordDao.findAll();
	}

	@Override
	public FoodUseRecord findById(long id) {
		return fooduserecordDao.find(id);
	}

	@Override
	public void flush() {
		fooduserecordDao.flush();
	}

	@Override
	public FoodUseRecord searchUnique(Search search) {
		FoodUseRecord fooduserecord = fooduserecordDao.searchUnique(search);
		return fooduserecord;
	}

	@Override
	public List<FoodUseRecord> searchAll(Search search) {
		return fooduserecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return fooduserecordDao.count(search);
	}
}