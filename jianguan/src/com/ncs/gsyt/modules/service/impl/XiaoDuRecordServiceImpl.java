package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.XiaoDuRecordDao;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.service.XiaoDuRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class XiaoDuRecordServiceImpl implements XiaoDuRecordService{

	@Resource
	private XiaoDuRecordDao xiaodurecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(XiaoDuRecord xiaodurecord) {
		return xiaodurecordDao.save(xiaodurecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(XiaoDuRecord[] xiaodurecords) {
		return xiaodurecordDao.save(xiaodurecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(XiaoDuRecord xiaodurecord) {
		return xiaodurecordDao.remove(xiaodurecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(XiaoDuRecord[] xiaodurecords) {
		xiaodurecordDao.remove(xiaodurecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return xiaodurecordDao.removeById(id);
	}

	@Override
	public List<XiaoDuRecord> findAll() {
		return xiaodurecordDao.findAll();
	}

	@Override
	public XiaoDuRecord findById(long id) {
		return xiaodurecordDao.find(id);
	}

	@Override
	public void flush() {
		xiaodurecordDao.flush();
	}

	@Override
	public XiaoDuRecord searchUnique(Search search) {
		XiaoDuRecord xiaodurecord = xiaodurecordDao.searchUnique(search);
		return xiaodurecord;
	}

	@Override
	public List<XiaoDuRecord> searchAll(Search search) {
		return xiaodurecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return xiaodurecordDao.count(search);
	}
}