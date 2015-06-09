package com.ncs.gsyt.modules.dao.impl;

import org.springframework.stereotype.Repository;

import com.ncs.gsyt.core.base.dao.BaseDAO;
import com.ncs.gsyt.modules.dao.ProductSaleDao;
import com.ncs.gsyt.modules.model.ProductSale;

@Repository
public class ProductSaleDaoImpl extends BaseDAO<ProductSale, Long> implements ProductSaleDao{

}