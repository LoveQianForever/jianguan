package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.InFoodMedicineDao;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.service.InFoodMedicineService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class InFoodMedicineServiceImpl implements InFoodMedicineService{

	@Resource
	private InFoodMedicineDao infoodmedicineDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(InFoodMedicine infoodmedicine) {
		return infoodmedicineDao.save(infoodmedicine);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(InFoodMedicine[] infoodmedicines) {
		return infoodmedicineDao.save(infoodmedicines);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(InFoodMedicine infoodmedicine) {
		return infoodmedicineDao.remove(infoodmedicine);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(InFoodMedicine[] infoodmedicines) {
		infoodmedicineDao.remove(infoodmedicines);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return infoodmedicineDao.removeById(id);
	}

	@Override
	public List<InFoodMedicine> findAll() {
		return infoodmedicineDao.findAll();
	}

	@Override
	public InFoodMedicine findById(long id) {
		return infoodmedicineDao.find(id);
	}

	@Override
	public void flush() {
		infoodmedicineDao.flush();
	}

	@Override
	public InFoodMedicine searchUnique(Search search) {
		InFoodMedicine infoodmedicine = infoodmedicineDao.searchUnique(search);
		return infoodmedicine;
	}

	@Override
	public List<InFoodMedicine> searchAll(Search search) {
		return infoodmedicineDao.search(search);
	}

	@Override
	public int count(Search search) {
		return infoodmedicineDao.count(search);
	}
}