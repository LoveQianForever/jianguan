package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.YuMiaoDao;
import com.ncs.gsyt.modules.model.YuMiao;
import com.ncs.gsyt.modules.service.YuMiaoService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class YuMiaoServiceImpl implements YuMiaoService{

	@Resource
	private YuMiaoDao yumiaoDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(YuMiao yumiao) {
		return yumiaoDao.save(yumiao);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(YuMiao[] yumiaos) {
		return yumiaoDao.save(yumiaos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(YuMiao yumiao) {
		return yumiaoDao.remove(yumiao);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(YuMiao[] yumiaos) {
		yumiaoDao.remove(yumiaos);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return yumiaoDao.removeById(id);
	}

	@Override
	public List<YuMiao> findAll() {
		return yumiaoDao.findAll();
	}

	@Override
	public YuMiao findById(long id) {
		return yumiaoDao.find(id);
	}

	@Override
	public void flush() {
		yumiaoDao.flush();
	}

	@Override
	public YuMiao searchUnique(Search search) {
		YuMiao yumiao = yumiaoDao.searchUnique(search);
		return yumiao;
	}

	@Override
	public List<YuMiao> searchAll(Search search) {
		return yumiaoDao.search(search);
	}

	@Override
	public int count(Search search) {
		return yumiaoDao.count(search);
	}
}