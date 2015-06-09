package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.FoodMedicineSupplyDao;
import com.ncs.gsyt.modules.model.FoodMedicineSupply;
import com.ncs.gsyt.modules.service.FoodMedicineSupplyService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class FoodMedicineSupplyServiceImpl implements FoodMedicineSupplyService{

	@Resource
	private FoodMedicineSupplyDao foodmedicinesupplyDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(FoodMedicineSupply foodmedicinesupply) {
		return foodmedicinesupplyDao.save(foodmedicinesupply);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(FoodMedicineSupply[] foodmedicinesupplys) {
		return foodmedicinesupplyDao.save(foodmedicinesupplys);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(FoodMedicineSupply foodmedicinesupply) {
		return foodmedicinesupplyDao.remove(foodmedicinesupply);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(FoodMedicineSupply[] foodmedicinesupplys) {
		foodmedicinesupplyDao.remove(foodmedicinesupplys);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return foodmedicinesupplyDao.removeById(id);
	}

	@Override
	public List<FoodMedicineSupply> findAll() {
		return foodmedicinesupplyDao.findAll();
	}

	@Override
	public FoodMedicineSupply findById(long id) {
		return foodmedicinesupplyDao.find(id);
	}

	@Override
	public void flush() {
		foodmedicinesupplyDao.flush();
	}

	@Override
	public FoodMedicineSupply searchUnique(Search search) {
		FoodMedicineSupply foodmedicinesupply = foodmedicinesupplyDao.searchUnique(search);
		return foodmedicinesupply;
	}

	@Override
	public List<FoodMedicineSupply> searchAll(Search search) {
		return foodmedicinesupplyDao.search(search);
	}

	@Override
	public int count(Search search) {
		return foodmedicinesupplyDao.count(search);
	}
}