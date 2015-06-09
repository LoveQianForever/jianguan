package com.ncs.gsyt.modules.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.service.BatchService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class BatchAction extends BaseAction implements ModelDriven<Batch>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private BatchService batchService;
	
	private Batch batch = new Batch();
	
	public Batch getBatch() {
		return batch;
	}
	
	@Override
	public Batch getModel() {
		return batch;
	}
	
	@Action(value = "/batch", results = {
			@Result(name = SUCCESS, location = "/admin/batch/batchlist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(Batch.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = batchService.count(search);
		List<Batch> list = batchService.searchAll(search);
		List<Map<String, Object>> batchList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Batch obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getBatchID());
				row.put("cell",
						new Object[] { obj.getBatchID()});//其他属性需按页面需要填写
				batchList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, batchList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}