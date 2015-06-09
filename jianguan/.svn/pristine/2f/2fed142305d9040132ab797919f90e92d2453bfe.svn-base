package com.ncs.gsyt.modules.service;

import java.util.List;

import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.OutTouRuPinRecord;

public interface OutTouRuPinRecordService {

	/**
	 * 增加或更新OutTouRuPinRecord
	 * 
	 * @param outtourupinrecord
	 * @return
	 */
	public boolean save(OutTouRuPinRecord outtourupinrecord);

	/**
	 * 批量增加或更新OutTouRuPinRecord
	 * 
	 * @param outtourupinrecords
	 * @return
	 */
	public boolean[] save(OutTouRuPinRecord[] outtourupinrecords);

	/**
	 * 删除OutTouRuPinRecord
	 * 
	 * @param outtourupinrecord
	 * @return
	 */
	public boolean remove(OutTouRuPinRecord outtourupinrecord);

	/**
	 * 批量删除OutTouRuPinRecord
	 * 
	 * @param outtourupinrecords
	 */
	public void remove(OutTouRuPinRecord[] outtourupinrecords);

	/**
	 * 根据主键删除OutTouRuPinRecord
	 * 
	 * @param id
	 * @return
	 */
	public boolean removeById(long id);

	/**
	 * 查询OutTouRuPinRecord数据记录集
	 * 
	 * @return
	 */
	public List<OutTouRuPinRecord> findAll();

	/**
	 * 根据主键查询OutTouRuPinRecord
	 * 
	 * @param l
	 * @return
	 */
	public OutTouRuPinRecord findById(long id);

	/**
	 * 持久化session数据到数据库
	 */
	public void flush();

	/**
	 * 根据条件查询一条记录
	 */
	public OutTouRuPinRecord searchUnique(Search search);

	/**
	 * 根据条件查询所有记录
	 */
	public List<OutTouRuPinRecord> searchAll(Search search);

	/**
	 * 获取记录总数
	 */
	public int count(Search search);

}