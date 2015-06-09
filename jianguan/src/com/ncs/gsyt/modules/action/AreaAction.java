package com.ncs.gsyt.modules.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.json.util.JSONObject;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Area;
import com.ncs.gsyt.modules.service.AreaService;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class AreaAction extends BaseAction implements ModelDriven<Area>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private AreaService areaService;
	
	private Area area = new Area();
	
	public Area getArea() {
		return area;
	}
	
	@Override
	public Area getModel() {
		return area;
	}
	
	@Action(value = "/area", results = {
			@Result(name = SUCCESS, location = "/admin/area/areatree.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(Area.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = areaService.count(search);
		List<Area> list = areaService.searchAll(search);
		List<Map<String, Object>> areaList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Area obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getAreaID());
				row.put("cell",
						new Object[] { obj.getAreaID() });//其他属性需按页面需要填写
				areaList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, areaList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**
	 * 获取节点树
	 * */
	public String getAreaTree() {
		Search search = new Search();
		List<Area> areas = areaService.searchAll(search);
		List<Map<String, Object>> areaList = new ArrayList<Map<String, Object>>();
		Map<String, Object> first = new HashMap<String, Object>();
		first.put("id", "0");
		first.put("pId", "-1");
		first.put("name", "宁国");
		first.put("type", "0");
		areaList.add(first);
		if (null != areas) {
			for (int i = 0; i < areas.size(); i++) {
				Area area = areas.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", area.getAreaID());
				row.put("pId", area.getParentID());
				row.put("name", area.getAreaName());
				areaList.add(row);
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", areaList);
		JSONObject json = new JSONObject(result);
		try {
			httpServletResponse.getWriter().write(json.toString());
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 增加节点
	 */
	public String addArea() {
		String msg = "";
		try {
			area.setAreaName(URLDecoder.decode(area.getAreaName(),"UTF-8"));
			areaService.save(area);
			msg = "[{\"id\":" + area.getAreaID() + ",\"pId\":"
					+ area.getParentID() + ",\"name\":\""
					+ area.getAreaName() + "\"}]";
		} catch (Exception e) {
			msg = "err";
		}
		try {
			httpServletResponse.getWriter().write(msg);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新节点
	 */
	public String updateArea() {
		String msg = "";
		try {
			String areaName = URLDecoder.decode(area.getAreaName(),"UTF-8");
			area = areaService.findById(area.getAreaID());
			area.setAreaName(areaName);
			areaService.save(area);
			msg = "ok";
		} catch (Exception e) {
			msg = "err";
		}
		try {
			httpServletResponse.getWriter().write(msg);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除节点
	 */
	public String removeArea() {
		boolean bool = areaService.remove(area);
		String msg = "";
		if (bool)
			msg = "ok";
		else
			msg = "err";
		try {
			httpServletResponse.getWriter().write(msg);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
