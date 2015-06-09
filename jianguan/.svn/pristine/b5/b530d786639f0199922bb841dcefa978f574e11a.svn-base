package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ImmunityJieZhongDao;
import com.ncs.gsyt.modules.model.ImmunityJieZhong;
import com.ncs.gsyt.modules.service.ImmunityJieZhongService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ImmunityJieZhongServiceImpl implements ImmunityJieZhongService{

	@Resource
	private ImmunityJieZhongDao immunityjiezhongDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ImmunityJieZhong immunityjiezhong) {
		return immunityjiezhongDao.save(immunityjiezhong);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ImmunityJieZhong[] immunityjiezhongs) {
		return immunityjiezhongDao.save(immunityjiezhongs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ImmunityJieZhong immunityjiezhong) {
		return immunityjiezhongDao.remove(immunityjiezhong);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ImmunityJieZhong[] immunityjiezhongs) {
		immunityjiezhongDao.remove(immunityjiezhongs);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return immunityjiezhongDao.removeById(id);
	}

	@Override
	public List<ImmunityJieZhong> findAll() {
		return immunityjiezhongDao.findAll();
	}

	@Override
	public ImmunityJieZhong findById(long id) {
		return immunityjiezhongDao.find(id);
	}

	@Override
	public void flush() {
		immunityjiezhongDao.flush();
	}

	@Override
	public ImmunityJieZhong searchUnique(Search search) {
		ImmunityJieZhong immunityjiezhong = immunityjiezhongDao.searchUnique(search);
		return immunityjiezhong;
	}

	@Override
	public List<ImmunityJieZhong> searchAll(Search search) {
		return immunityjiezhongDao.search(search);
	}

	@Override
	public int count(Search search) {
		return immunityjiezhongDao.count(search);
	}
}