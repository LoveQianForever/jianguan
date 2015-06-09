package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.PlaceDao;
import com.ncs.gsyt.modules.model.Place;
import com.ncs.gsyt.modules.service.PlaceService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PlaceServiceImpl implements PlaceService{

	@Resource
	private PlaceDao placeDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(Place place) {
		return placeDao.save(place);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(Place[] places) {
		return placeDao.save(places);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(Place place) {
		return placeDao.remove(place);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(Place[] places) {
		placeDao.remove(places);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return placeDao.removeById(id);
	}

	@Override
	public List<Place> findAll() {
		return placeDao.findAll();
	}

	@Override
	public Place findById(long id) {
		return placeDao.find(id);
	}

	@Override
	public void flush() {
		placeDao.flush();
	}

	@Override
	public Place searchUnique(Search search) {
		Place place = placeDao.searchUnique(search);
		return place;
	}

	@Override
	public List<Place> searchAll(Search search) {
		return placeDao.search(search);
	}

	@Override
	public int count(Search search) {
		return placeDao.count(search);
	}
}