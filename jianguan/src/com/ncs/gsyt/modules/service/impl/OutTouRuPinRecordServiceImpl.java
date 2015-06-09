package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.OutTouRuPinRecordDao;
import com.ncs.gsyt.modules.model.OutTouRuPinRecord;
import com.ncs.gsyt.modules.service.OutTouRuPinRecordService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OutTouRuPinRecordServiceImpl implements OutTouRuPinRecordService{

	@Resource
	private OutTouRuPinRecordDao outtourupinrecordDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(OutTouRuPinRecord outtourupinrecord) {
		return outtourupinrecordDao.save(outtourupinrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(OutTouRuPinRecord[] outtourupinrecords) {
		return outtourupinrecordDao.save(outtourupinrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(OutTouRuPinRecord outtourupinrecord) {
		return outtourupinrecordDao.remove(outtourupinrecord);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(OutTouRuPinRecord[] outtourupinrecords) {
		outtourupinrecordDao.remove(outtourupinrecords);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return outtourupinrecordDao.removeById(id);
	}

	@Override
	public List<OutTouRuPinRecord> findAll() {
		return outtourupinrecordDao.findAll();
	}

	@Override
	public OutTouRuPinRecord findById(long id) {
		return outtourupinrecordDao.find(id);
	}

	@Override
	public void flush() {
		outtourupinrecordDao.flush();
	}

	@Override
	public OutTouRuPinRecord searchUnique(Search search) {
		OutTouRuPinRecord outtourupinrecord = outtourupinrecordDao.searchUnique(search);
		return outtourupinrecord;
	}

	@Override
	public List<OutTouRuPinRecord> searchAll(Search search) {
		return outtourupinrecordDao.search(search);
	}

	@Override
	public int count(Search search) {
		return outtourupinrecordDao.count(search);
	}
}