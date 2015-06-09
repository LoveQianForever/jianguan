package com.ncs.gsyt.modules.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.ncs.gsyt.modules.model.Warning;
import com.ncs.gsyt.modules.service.WarningService;
import com.ncs.gsyt.modules.util.StringUtil;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class WarningAction extends BaseAction implements ModelDriven<Warning>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private WarningService warningService;
	
	private Warning warning = new Warning();
	
	public Warning getWarning() {
		return warning;
	}
	
	@Override
	public Warning getModel() {
		return warning;
	}
	
	@Action(value = "/warning", results = {
			@Result(name = SUCCESS, location = "/admin/region/warninglist.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		String type=httpServletRequest.getParameter("Type");
		Search search = new Search(Warning.class);
		search = this.getSearch(search);
		search.addFilterEqual("type", type);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = warningService.count(search);
		List<Warning> list = warningService.searchAll(search);
		List<Map<String, Object>> warningList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Warning obj = list.get(i);
				String po="<a href=\"javascript:void(0)\" onclick=\"deletemes("+obj.getWarnID()+")\">删除</a>";
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getWarnID());
				row.put("cell",
						new Object[] { obj.getWarnID(),obj.getNote(),obj.getTime(),po });//其他属性需按页面需要填写
				warningList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, warningList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	public String deletems(){
		Warning warn=warningService.findById(warning.getWarnID());
		warningService.remove(warn);
		return this.execute();
	}
	
	
	/**
	 * 手机端接口，获取状态栏消息
	 * */
	public String getMessagesByMobile() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		try {
			Search s1 = new Search(Warning.class);
			s1.addFilterEqual("state", 0);
			List<Warning> messagelist = warningService.searchAll(s1);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			for (Warning m : messagelist) {
				Map<String, Object> row = new LinkedHashMap<String, Object>();
				row.put("message_content", m.getNote());
				row.put("time", m.getTime());
				row.put("messageID", m.getWarnID());
				list.add(row);
			}
			result.put("list", list);
			result.put("stat", "1");
			result.put("msg", "ok");
		} catch (NumberFormatException nfe) {
			result.clear();
			result.put("stat", "100");
			result.put("msg", "参数类型错误");
		} catch (NullPointerException npe) {
			result.clear();
			result.put("stat", "101");
			result.put("msg", "缺少必备参数");
		} catch (Exception e) {
			e.printStackTrace();
			String rsult = "其他错误";
			result.clear();
			result.put("stat", "-1");
			result.put("msg", rsult);
		}
		JSONObject json = new JSONObject(result);
		String resultStr = json.toString().replaceAll("\\\\n", "").replaceAll("\\\\r", "").replaceAll("\\\\t", "");
		out.print(resultStr);
		
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 手机端接口，提交手机已读的状态信息
	 * */
	public String postMessageStatusByMobile() throws Exception {
		httpServletResponse.setContentType("application/json;");
		httpServletResponse.setCharacterEncoding("UTF-8");
		PrintWriter out = httpServletResponse.getWriter();
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		
		try {
			String[] messageID = StringUtil.isNull(httpServletRequest.getParameter("message_id").toString()).split(",");
			for (String mid : messageID) {
				warning=warningService.findById(Long.parseLong(mid));
				warning.setState(1);
				warningService.save(warning);
			}
			
			result.put("stat", "1");
			result.put("msg", "ok");
		} catch (NumberFormatException nfe) {
			result.clear();
			result.put("stat", "100");
			result.put("msg", "参数类型错误");
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			result.clear();
			result.put("stat", "101");
			result.put("msg", "缺少必备参数");
		} catch (Exception e) {
			e.printStackTrace();
			result.clear();
			result.put("stat", "-1");
			result.put("msg", e.getMessage());
		}
		JSONObject json = new JSONObject(result);
		
		out.print(json.toString());
		
		out.flush();
		out.close();
		return null;
	}
	
}