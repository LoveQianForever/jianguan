package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InPigFoodMedicineDao;
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.service.InPigFoodMedicineService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InPigFoodMedicineServiceImpl implements InPigFoodMedicineService{

	@Resource
	private InPigFoodMedicineDao inpigfoodmedicineDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InPigFoodMedicine inpigfoodmedicine) {
		return inpigfoodmedicineDao.save(inpigfoodmedicine);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InPigFoodMedicine[] inpigfoodmedicines) {
		return inpigfoodmedicineDao.save(inpigfoodmedicines);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InPigFoodMedicine inpigfoodmedicine) {
		return inpigfoodmedicineDao.remove(inpigfoodmedicine);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InPigFoodMedicine[] inpigfoodmedicines) {
		inpigfoodmedicineDao.remove(inpigfoodmedicines);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return inpigfoodmedicineDao.removeById(id);
	}

	@Override
	public List<InPigFoodMedicine> findAll() {
		return inpigfoodmedicineDao.findAll();
	}

	@Override
	public InPigFoodMedicine findById(long id) {
		return inpigfoodmedicineDao.find(id);
	}

	@Override
	public void flush() {
		inpigfoodmedicineDao.flush();
	}

	@Override
	public InPigFoodMedicine searchUnique(Search search) {
		InPigFoodMedicine inpigfoodmedicine = inpigfoodmedicineDao.searchUnique(search);
		return inpigfoodmedicine;
	}

	@Override
	public List<InPigFoodMedicine> searchAll(Search search) {
		return inpigfoodmedicineDao.search(search);
	}

	@Override
	public int count(Search search) {
		return inpigfoodmedicineDao.count(search);
	}
}