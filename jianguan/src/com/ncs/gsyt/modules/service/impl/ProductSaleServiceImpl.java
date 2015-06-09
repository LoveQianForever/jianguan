package com.ncs.gsyt.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.dao.ProductSaleDao;
import com.ncs.gsyt.modules.model.ProductSale;
import com.ncs.gsyt.modules.service.ProductSaleService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProductSaleServiceImpl implements ProductSaleService{

	@Resource
	private ProductSaleDao productsaleDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(ProductSale productsale) {
		return productsaleDao.save(productsale);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(ProductSale[] productsales) {
		return productsaleDao.save(productsales);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(ProductSale productsale) {
		return productsaleDao.remove(productsale);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(ProductSale[] productsales) {
		productsaleDao.remove(productsales);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return productsaleDao.removeById(id);
	}

	@Override
	public List<ProductSale> findAll() {
		return productsaleDao.findAll();
	}

	@Override
	public ProductSale findById(long id) {
		return productsaleDao.find(id);
	}

	@Override
	public void flush() {
		productsaleDao.flush();
	}

	@Override
	public ProductSale searchUnique(Search search) {
		ProductSale productsale = productsaleDao.searchUnique(search);
		return productsale;
	}

	@Override
	public List<ProductSale> searchAll(Search search) {
		return productsaleDao.search(search);
	}

	@Override
	public int count(Search search) {
		return productsaleDao.count(search);
	}
}