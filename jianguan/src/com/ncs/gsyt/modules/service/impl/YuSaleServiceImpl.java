package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.YuSaleDao;
import com.ncs.gsyt.modules.model.YuSale;
import com.ncs.gsyt.modules.service.YuSaleService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class YuSaleServiceImpl implements YuSaleService{

	@Resource
	private YuSaleDao yusaleDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(YuSale yusale) {
		return yusaleDao.save(yusale);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(YuSale[] yusales) {
		return yusaleDao.save(yusales);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(YuSale yusale) {
		return yusaleDao.remove(yusale);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(YuSale[] yusales) {
		yusaleDao.remove(yusales);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return yusaleDao.removeById(id);
	}

	@Override
	public List<YuSale> findAll() {
		return yusaleDao.findAll();
	}

	@Override
	public YuSale findById(long id) {
		return yusaleDao.find(id);
	}

	@Override
	public void flush() {
		yusaleDao.flush();
	}

	@Override
	public YuSale searchUnique(Search search) {
		YuSale yusale = yusaleDao.searchUnique(search);
		return yusale;
	}

	@Override
	public List<YuSale> searchAll(Search search) {
		return yusaleDao.search(search);
	}

	@Override
	public int count(Search search) {
		return yusaleDao.count(search);
	}
}