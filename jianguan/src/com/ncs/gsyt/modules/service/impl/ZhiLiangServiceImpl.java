package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ZhiLiangDao;
import com.ncs.gsyt.modules.model.ZhiLiang;
import com.ncs.gsyt.modules.service.ZhiLiangService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ZhiLiangServiceImpl implements ZhiLiangService{

	@Resource
	private ZhiLiangDao zhiliangDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ZhiLiang zhiliang) {
		return zhiliangDao.save(zhiliang);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ZhiLiang[] zhiliangs) {
		return zhiliangDao.save(zhiliangs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ZhiLiang zhiliang) {
		return zhiliangDao.remove(zhiliang);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ZhiLiang[] zhiliangs) {
		zhiliangDao.remove(zhiliangs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return zhiliangDao.removeById(id);
	}

	@Override
	public List<ZhiLiang> findAll() {
		return zhiliangDao.findAll();
	}

	@Override
	public ZhiLiang findById(long id) {
		return zhiliangDao.find(id);
	}

	@Override
	public void flush() {
		zhiliangDao.flush();
	}

	@Override
	public ZhiLiang searchUnique(Search search) {
		ZhiLiang zhiliang = zhiliangDao.searchUnique(search);
		return zhiliang;
	}

	@Override
	public List<ZhiLiang> searchAll(Search search) {
		return zhiliangDao.search(search);
	}

	@Override
	public int count(Search search) {
		return zhiliangDao.count(search);
	}
}