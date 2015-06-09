package com.ncs.gsyt.modules.dao.impl;

import org.springframework.stereotype.Repository;

import com.ncs.gsyt.core.base.dao.BaseDAO;
import com.ncs.gsyt.modules.dao.SeedDao;
import com.ncs.gsyt.modules.model.Seed;

@Repository
public class SeedDaoImpl extends BaseDAO<Seed, Long> implements SeedDao{

}