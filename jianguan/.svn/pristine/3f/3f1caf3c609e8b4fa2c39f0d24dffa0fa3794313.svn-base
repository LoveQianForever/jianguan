package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.MuZhuPeiZhongRecordDao;
import com.ncs.gsyt.modules.model.MuZhuPeiZhongRecord;
import com.ncs.gsyt.modules.service.MuZhuPeiZhongRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class MuZhuPeiZhongRecordServiceImpl implements MuZhuPeiZhongRecordService{

	@Resource
	private MuZhuPeiZhongRecordDao muzhupeizhongrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(MuZhuPeiZhongRecord muzhupeizhongrecord) {
		return muzhupeizhongrecordDao.save(muzhupeizhongrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(MuZhuPeiZhongRecord[] muzhupeizhongrecords) {
		return muzhupeizhongrecordDao.save(muzhupeizhongrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(MuZhuPeiZhongRecord muzhupeizhongrecord) {
		return muzhupeizhongrecordDao.remove(muzhupeizhongrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(MuZhuPeiZhongRecord[] muzhupeizhongrecords) {
		muzhupeizhongrecordDao.remove(muzhupeizhongrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return muzhupeizhongrecordDao.removeById(id);
	}

	@Override
	public List<MuZhuPeiZhongRecord> findAll() {
		return muzhupeizhongrecordDao.findAll();
	}

	@Override
	public MuZhuPeiZhongRecord findById(long id) {
		return muzhupeizhongrecordDao.find(id);
	}

	@Override
	public void flush() {
		muzhupeizhongrecordDao.flush();
	}

	@Override
	public MuZhuPeiZhongRecord searchUnique(Search search) {
		MuZhuPeiZhongRecord muzhupeizhongrecord = muzhupeizhongrecordDao.searchUnique(search);
		return muzhupeizhongrecord;
	}

	@Override
	public List<MuZhuPeiZhongRecord> searchAll(Search search) {
		return muzhupeizhongrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return muzhupeizhongrecordDao.count(search);
	}
}