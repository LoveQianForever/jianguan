package com.ncs.gsyt.modules.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.ncs.gsyt.modules.model.SeedEnterprise;
import com.ncs.gsyt.modules.model.SeedManager;
import com.ncs.gsyt.modules.service.SeedManagerService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SeedManagerAction extends BaseAction implements ModelDriven<SeedManager>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SeedManagerService seedmanagerService;
	
	private SeedManager seedmanager = new SeedManager();
	
	public SeedManager getSeedManager() {
		return seedmanager;
	}
	
	@Override
	public SeedManager getModel() {
		return seedmanager;
	}
	
	@Action(value = "/seedmanager", results = {
			@Result(name = SUCCESS, location = "/admin/seedproduct/seedmanagerlist.jsp"),
			@Result(name = "addenter", location = "/admin/seedproduct/addEnter.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(SeedManager.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = seedmanagerService.count(search);
		List<SeedManager> list = seedmanagerService.searchAll(search);
		List<Map<String, Object>> seedmanagerList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				SeedManager obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				
				String seedinRecord="";
				String seedoutRecord="";
				seedinRecord= "<a href=\"javascript:void(0)\" onclick=\"seedinrecord("+obj.getSeedManagerID()
					 +")\">进货记录</a>";
				seedoutRecord= "<a href=\"javascript:void(0)\" onclick=\"sendoutrecord("
					+obj.getSeedManagerID()+ ")\">销售记录</a>";
				row.put("id", obj.getSeedManagerID());
				row.put("cell",
						new Object[] { obj.getSeedManagerID(),obj.getName(),
								obj.getLastCreatetime(),seedinRecord+ "&nbsp;&nbsp;&nbsp;&nbsp;"
								+seedoutRecord});//其他属性需按页面需要填写
				seedmanagerList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, seedmanagerList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	//添加企业信息
	public String addEnterprise()throws Exception
	{
		
		return "addenter";
	}
	//将 添加的企业信息，保存到监管表里
	public String saveAddEnterprise()throws Exception
	{

		String name=httpServletRequest.getParameter("name");
		String license_code=httpServletRequest.getParameter("license_code");
		String time=httpServletRequest.getParameter("senddate");
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formt.parse(time);
		
		SeedManager seedManager=new SeedManager();
		seedManager.setName(name);
		seedManager.setLicense_code(license_code);
		seedManager.setTime(date);
		seedmanagerService.save(seedManager);
		//return SUCCESS;
		return SUCCESS;
	}
}