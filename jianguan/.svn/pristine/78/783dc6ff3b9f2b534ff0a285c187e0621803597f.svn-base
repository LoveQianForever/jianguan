package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.XuShuiChiClearDao;
import com.ncs.gsyt.modules.model.XuShuiChiClear;
import com.ncs.gsyt.modules.service.XuShuiChiClearService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class XuShuiChiClearServiceImpl implements XuShuiChiClearService{

	@Resource
	private XuShuiChiClearDao xushuichiclearDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(XuShuiChiClear xushuichiclear) {
		return xushuichiclearDao.save(xushuichiclear);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(XuShuiChiClear[] xushuichiclears) {
		return xushuichiclearDao.save(xushuichiclears);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(XuShuiChiClear xushuichiclear) {
		return xushuichiclearDao.remove(xushuichiclear);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(XuShuiChiClear[] xushuichiclears) {
		xushuichiclearDao.remove(xushuichiclears);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return xushuichiclearDao.removeById(id);
	}

	@Override
	public List<XuShuiChiClear> findAll() {
		return xushuichiclearDao.findAll();
	}

	@Override
	public XuShuiChiClear findById(long id) {
		return xushuichiclearDao.find(id);
	}

	@Override
	public void flush() {
		xushuichiclearDao.flush();
	}

	@Override
	public XuShuiChiClear searchUnique(Search search) {
		XuShuiChiClear xushuichiclear = xushuichiclearDao.searchUnique(search);
		return xushuichiclear;
	}

	@Override
	public List<XuShuiChiClear> searchAll(Search search) {
		return xushuichiclearDao.search(search);
	}

	@Override
	public int count(Search search) {
		return xushuichiclearDao.count(search);
	}
}