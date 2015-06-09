package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SaleRecordDao;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.service.SaleRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SaleRecordServiceImpl implements SaleRecordService{

	@Resource
	private SaleRecordDao salerecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SaleRecord salerecord) {
		return salerecordDao.save(salerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SaleRecord[] salerecords) {
		return salerecordDao.save(salerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SaleRecord salerecord) {
		return salerecordDao.remove(salerecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SaleRecord[] salerecords) {
		salerecordDao.remove(salerecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return salerecordDao.removeById(id);
	}

	@Override
	public List<SaleRecord> findAll() {
		return salerecordDao.findAll();
	}

	@Override
	public SaleRecord findById(long id) {
		return salerecordDao.find(id);
	}

	@Override
	public void flush() {
		salerecordDao.flush();
	}

	@Override
	public SaleRecord searchUnique(Search search) {
		SaleRecord salerecord = salerecordDao.searchUnique(search);
		return salerecord;
	}

	@Override
	public List<SaleRecord> searchAll(Search search) {
		return salerecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return salerecordDao.count(search);
	}
}