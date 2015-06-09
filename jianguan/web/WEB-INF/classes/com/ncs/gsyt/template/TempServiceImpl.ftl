package ${package}.modules.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ${package}.core.base.search.Search;
import ${package}.modules.dao.${className}Dao;
import ${package}.modules.model.${className};
import ${package}.modules.service.${className}Service;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ${className}ServiceImpl implements ${className}Service{

	@Resource
	private ${className}Dao ${className1}Dao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean save(${className} ${className1}) {
		return ${className1}Dao.save(${className1});
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean[] save(${className}[] ${className1}s) {
		return ${className1}Dao.save(${className1}s);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean remove(${className} ${className1}) {
		return ${className1}Dao.remove(${className1});
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void remove(${className}[] ${className1}s) {
		${className1}Dao.remove(${className1}s);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public boolean removeById(long id) {
		return ${className1}Dao.removeById(id);
	}

	@Override
	public List<${className}> findAll() {
		return ${className1}Dao.findAll();
	}

	@Override
	public ${className} findById(long id) {
		return ${className1}Dao.find(id);
	}

	@Override
	public void flush() {
		${className1}Dao.flush();
	}

	@Override
	public ${className} searchUnique(Search search) {
		${className} ${className1} = ${className1}Dao.searchUnique(search);
		return ${className1};
	}

	@Override
	public List<${className}> searchAll(Search search) {
		return ${className1}Dao.search(search);
	}

	@Override
	public int count(Search search) {
		return ${className1}Dao.count(search);
	}
}