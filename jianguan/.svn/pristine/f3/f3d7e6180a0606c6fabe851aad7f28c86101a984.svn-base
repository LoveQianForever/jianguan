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
import com.ncs.gsyt.modules.model.Enterpriseatta;
import com.ncs.gsyt.modules.service.EnterpriseattaService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class EnterpriseattaAction extends BaseAction implements ModelDriven<Enterpriseatta>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseattaService enterpriseattaService;
	
	private Enterpriseatta enterpriseatta = new Enterpriseatta();
	
	public Enterpriseatta getEnterpriseatta() {
		return enterpriseatta;
	}
	
	@Override
	public Enterpriseatta getModel() {
		return enterpriseatta;
	}
	
	@Action(value = "/enterpriseatta", results = {
			@Result(name = SUCCESS, location = "/admin/enterpriseatta/enterpriseattalist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(Enterpriseatta.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = enterpriseattaService.count(search);
		List<Enterpriseatta> list = enterpriseattaService.searchAll(search);
		List<Map<String, Object>> enterpriseattaList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Enterpriseatta obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getAnnexID());
				row.put("cell",
						new Object[] { obj.getAnnexID() });//其他属性需按页面需要填写
				enterpriseattaList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseattaList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}