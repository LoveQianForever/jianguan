package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.NoHaiDealRecordDao;
import com.ncs.gsyt.modules.model.NoHaiDealRecord;
import com.ncs.gsyt.modules.service.NoHaiDealRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class NoHaiDealRecordServiceImpl implements NoHaiDealRecordService{

	@Resource
	private NoHaiDealRecordDao nohaidealrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(NoHaiDealRecord nohaidealrecord) {
		return nohaidealrecordDao.save(nohaidealrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(NoHaiDealRecord[] nohaidealrecords) {
		return nohaidealrecordDao.save(nohaidealrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(NoHaiDealRecord nohaidealrecord) {
		return nohaidealrecordDao.remove(nohaidealrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(NoHaiDealRecord[] nohaidealrecords) {
		nohaidealrecordDao.remove(nohaidealrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return nohaidealrecordDao.removeById(id);
	}

	@Override
	public List<NoHaiDealRecord> findAll() {
		return nohaidealrecordDao.findAll();
	}

	@Override
	public NoHaiDealRecord findById(long id) {
		return nohaidealrecordDao.find(id);
	}

	@Override
	public void flush() {
		nohaidealrecordDao.flush();
	}

	@Override
	public NoHaiDealRecord searchUnique(Search search) {
		NoHaiDealRecord nohaidealrecord = nohaidealrecordDao.searchUnique(search);
		return nohaidealrecord;
	}

	@Override
	public List<NoHaiDealRecord> searchAll(Search search) {
		return nohaidealrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return nohaidealrecordDao.count(search);
	}
}