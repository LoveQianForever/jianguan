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
import com.ncs.gsyt.modules.model.BuySeed;
import com.ncs.gsyt.modules.service.BuySeedService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class BuySeedAction extends BaseAction implements ModelDriven<BuySeed>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private BuySeedService buyseedService;
	
	private BuySeed buyseed = new BuySeed();
	
	public BuySeed getBuySeed() {
		return buyseed;
	}
	
	@Override
	public BuySeed getModel() {
		return buyseed;
	}
	
	@Action(value = "/buyseed", results = {
			@Result(name = SUCCESS, location = "/admin/buyseed/buyseedlist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(BuySeed.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = buyseedService.count(search);
		List<BuySeed> list = buyseedService.searchAll(search);
		List<Map<String, Object>> buyseedList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				BuySeed obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getEnter_id());
				row.put("cell",
						new Object[] { obj.getEnter_id() });//其他属性需按页面需要填写
				buyseedList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, buyseedList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}