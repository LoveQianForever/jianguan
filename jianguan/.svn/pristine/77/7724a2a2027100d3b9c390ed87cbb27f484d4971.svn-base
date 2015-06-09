package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.SeedEnterpriseDao;
import com.ncs.gsyt.modules.model.SeedEnterprise;
import com.ncs.gsyt.modules.service.SeedEnterpriseService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class SeedEnterpriseServiceImpl implements SeedEnterpriseService{

	@Resource
	private SeedEnterpriseDao seedenterpriseDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(SeedEnterprise seedenterprise) {
		return seedenterpriseDao.save(seedenterprise);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(SeedEnterprise[] seedenterprises) {
		return seedenterpriseDao.save(seedenterprises);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(SeedEnterprise seedenterprise) {
		return seedenterpriseDao.remove(seedenterprise);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(SeedEnterprise[] seedenterprises) {
		seedenterpriseDao.remove(seedenterprises);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return seedenterpriseDao.removeById(id);
	}

	@Override
	public List<SeedEnterprise> findAll() {
		return seedenterpriseDao.findAll();
	}

	@Override
	public SeedEnterprise findById(long id) {
		return seedenterpriseDao.find(id);
	}

	@Override
	public void flush() {
		seedenterpriseDao.flush();
	}

	@Override
	public SeedEnterprise searchUnique(Search search) {
		SeedEnterprise seedenterprise = seedenterpriseDao.searchUnique(search);
		return seedenterprise;
	}

	@Override
	public List<SeedEnterprise> searchAll(Search search) {
		return seedenterpriseDao.search(search);
	}

	@Override
	public int count(Search search) {
		return seedenterpriseDao.count(search);
	}
}