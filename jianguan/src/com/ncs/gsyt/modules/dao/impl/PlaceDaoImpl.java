package com.ncs.gsyt.modules.dao.impl;

import org.springframework.stereotype.Repository;

import com.ncs.gsyt.core.base.dao.BaseDAO;
import com.ncs.gsyt.modules.dao.PlaceDao;
import com.ncs.gsyt.modules.model.Place;

@Repository
public class PlaceDaoImpl extends BaseDAO<Place, Long> implements PlaceDao{

}