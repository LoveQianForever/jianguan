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
import com.ncs.gsyt.modules.model.FoodMedicineSupply;
import com.ncs.gsyt.modules.service.FoodMedicineSupplyService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class FoodMedicineSupplyAction extends BaseAction implements ModelDriven<FoodMedicineSupply>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private FoodMedicineSupplyService foodmedicinesupplyService;
	
	private FoodMedicineSupply foodmedicinesupply = new FoodMedicineSupply();
	
	public FoodMedicineSupply getFoodMedicineSupply() {
		return foodmedicinesupply;
	}
	
	@Override
	public FoodMedicineSupply getModel() {
		return foodmedicinesupply;
	}
	
	@Action(value = "/foodmedicinesupply", results = {
			@Result(name = SUCCESS, location = "/admin/foodmedicinesupply/foodmedicinesupplylist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(FoodMedicineSupply.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = foodmedicinesupplyService.count(search);
		List<FoodMedicineSupply> list = foodmedicinesupplyService.searchAll(search);
		List<Map<String, Object>> foodmedicinesupplyList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				FoodMedicineSupply obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getSupplyID());
				row.put("cell",
						new Object[] { obj.getSupplyID() });//其他属性需按页面需要填写
				foodmedicinesupplyList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, foodmedicinesupplyList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}