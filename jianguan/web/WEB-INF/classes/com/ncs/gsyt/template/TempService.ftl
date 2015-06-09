package ${package}.modules.service;

import java.util.List;

import ${package}.core.base.search.Search;
import ${package}.modules.model.${className};

public interface ${className}Service {

	/**
	 * 增加或更新${className}
	 * 
	 * @param ${className1}
	 * @return
	 */
	public boolean save(${className} ${className1});

	/**
	 * 批量增加或更新${className}
	 * 
	 * @param ${className1}s
	 * @return
	 */
	public boolean[] save(${className}[] ${className1}s);

	/**
	 * 删除${className}
	 * 
	 * @param ${className1}
	 * @return
	 */
	public boolean remove(${className} ${className1});

	/**
	 * 批量删除${className}
	 * 
	 * @param ${className1}s
	 */
	public void remove(${className}[] ${className1}s);

	/**
	 * 根据主键删除${className}
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询${className}数据记录集
	 * 
	 * @return
	 */
	public List<${className}> findAll();

	/**
	 * 根据主键查询${className}
	 * 
	 * @param l
	 * @return
	 */
	public ${className} findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public ${className} searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<${className}> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}