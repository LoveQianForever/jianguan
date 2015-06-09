package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.YuSiYangDao;
import com.ncs.gsyt.modules.model.YuSiYang;
import com.ncs.gsyt.modules.service.YuSiYangService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class YuSiYangServiceImpl implements YuSiYangService{

	@Resource
	private YuSiYangDao yusiyangDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(YuSiYang yusiyang) {
		return yusiyangDao.save(yusiyang);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(YuSiYang[] yusiyangs) {
		return yusiyangDao.save(yusiyangs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(YuSiYang yusiyang) {
		return yusiyangDao.remove(yusiyang);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(YuSiYang[] yusiyangs) {
		yusiyangDao.remove(yusiyangs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return yusiyangDao.removeById(id);
	}

	@Override
	public List<YuSiYang> findAll() {
		return yusiyangDao.findAll();
	}

	@Override
	public YuSiYang findById(long id) {
		return yusiyangDao.find(id);
	}

	@Override
	public void flush() {
		yusiyangDao.flush();
	}

	@Override
	public YuSiYang searchUnique(Search search) {
		YuSiYang yusiyang = yusiyangDao.searchUnique(search);
		return yusiyang;
	}

	@Override
	public List<YuSiYang> searchAll(Search search) {
		return yusiyangDao.search(search);
	}

	@Override
	public int count(Search search) {
		return yusiyangDao.count(search);
	}
}