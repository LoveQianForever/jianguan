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
import com.ncs.gsyt.modules.model.Place;
import com.ncs.gsyt.modules.service.PlaceService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class PlaceAction extends BaseAction implements ModelDriven<Place>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private PlaceService placeService;
	
	private Place place = new Place();
	
	public Place getPlace() {
		return place;
	}
	
	@Override
	public Place getModel() {
		return place;
	}
	
	@Action(value = "/place", results = {
			@Result(name = SUCCESS, location = "/admin/place/placelist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(Place.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = placeService.count(search);
		List<Place> list = placeService.searchAll(search);
		List<Map<String, Object>> placeList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Place obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPlaceID());
				row.put("cell",
						new Object[] { obj.getPlaceID() });//其他属性需按页面需要填写
				placeList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, placeList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
}