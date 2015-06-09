package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.AreaDao;
import com.ncs.gsyt.modules.model.Area;
import com.ncs.gsyt.modules.service.AreaService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AreaServiceImpl implements AreaService{

	@Resource
	private AreaDao areaDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Area area) {
		return areaDao.save(area);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Area[] areas) {
		return areaDao.save(areas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Area area) {
		return areaDao.remove(area);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Area[] areas) {
		areaDao.remove(areas);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return areaDao.removeById(id);
	}

	@Override
	public List<Area> findAll() {
		return areaDao.findAll();
	}

	@Override
	public Area findById(long id) {
		return areaDao.find(id);
	}

	@Override
	public void flush() {
		areaDao.flush();
	}

	@Override
	public Area searchUnique(Search search) {
		Area area = areaDao.searchUnique(search);
		return area;
	}

	@Override
	public List<Area> searchAll(Search search) {
		return areaDao.search(search);
	}

	@Override
	public int count(Search search) {
		return areaDao.count(search);
	}
}