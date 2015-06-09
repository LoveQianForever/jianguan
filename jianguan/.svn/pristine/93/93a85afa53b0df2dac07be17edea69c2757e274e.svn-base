package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.NongShiDao;
import com.ncs.gsyt.modules.model.NongShi;
import com.ncs.gsyt.modules.service.NongShiService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class NongShiServiceImpl implements NongShiService{

	@Resource
	private NongShiDao nongshiDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(NongShi nongshi) {
		return nongshiDao.save(nongshi);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(NongShi[] nongshis) {
		return nongshiDao.save(nongshis);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(NongShi nongshi) {
		return nongshiDao.remove(nongshi);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(NongShi[] nongshis) {
		nongshiDao.remove(nongshis);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return nongshiDao.removeById(id);
	}

	@Override
	public List<NongShi> findAll() {
		return nongshiDao.findAll();
	}

	@Override
	public NongShi findById(long id) {
		return nongshiDao.find(id);
	}

	@Override
	public void flush() {
		nongshiDao.flush();
	}

	@Override
	public NongShi searchUnique(Search search) {
		NongShi nongshi = nongshiDao.searchUnique(search);
		return nongshi;
	}

	@Override
	public List<NongShi> searchAll(Search search) {
		return nongshiDao.search(search);
	}

	@Override
	public int count(Search search) {
		return nongshiDao.count(search);
	}
}