package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SysParamDao;
import com.ncs.gsyt.modules.model.SysParam;
import com.ncs.gsyt.modules.service.SysParamService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SysParamServiceImpl implements SysParamService{

	@Resource
	private SysParamDao sysparamDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SysParam sysparam) {
		return sysparamDao.save(sysparam);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SysParam[] sysparams) {
		return sysparamDao.save(sysparams);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SysParam sysparam) {
		return sysparamDao.remove(sysparam);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SysParam[] sysparams) {
		sysparamDao.remove(sysparams);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return sysparamDao.removeById(id);
	}

	@Override
	public List<SysParam> findAll() {
		return sysparamDao.findAll();
	}

	@Override
	public SysParam findById(long id) {
		return sysparamDao.find(id);
	}

	@Override
	public void flush() {
		sysparamDao.flush();
	}

	@Override
	public SysParam searchUnique(Search search) {
		SysParam sysparam = sysparamDao.searchUnique(search);
		return sysparam;
	}

	@Override
	public List<SysParam> searchAll(Search search) {
		return sysparamDao.search(search);
	}

	@Override
	public int count(Search search) {
		return sysparamDao.count(search);
	}
}