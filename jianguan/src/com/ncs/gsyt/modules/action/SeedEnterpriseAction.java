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
import com.ncs.gsyt.modules.service.SeedEnterpriseService;
import com.ncs.gsyt.modules.service.SeedManagerService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SeedEnterpriseAction extends BaseAction implements ModelDriven<SeedEnterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SeedEnterpriseService seedenterpriseService;
	
	@Resource
	private SeedManagerService seedmanagerService;
	
	private List<SeedManager> seedManagerList=new ArrayList<SeedManager>();
	public List<SeedManager> getSeedManagerList() {
		return seedManagerList;
	}

	public void setSeedManagerList(List<SeedManager> seedManagerList) {
		this.seedManagerList = seedManagerList;
	}
	private SeedManager seedManager=new SeedManager();
	public SeedManager getSeedManager() {
		return seedManager;
	}

	public void setSeedManager(SeedManager seedManager) {
		this.seedManager = seedManager;
	}
	private SeedEnterprise seedenterprise = new SeedEnterprise();
	
	private List<SeedEnterprise> seedenterpriseList=new ArrayList<SeedEnterprise>();//企业集合
	
	public List<SeedEnterprise> getSeedenterpriseList() {
		return seedenterpriseList;
	}

	public void setSeedenterpriseList(List<SeedEnterprise> seedenterpriseList) {
		this.seedenterpriseList = seedenterpriseList;
	}

	public SeedEnterprise getSeedenterprise() {
		return seedenterprise;
	}

	public void setSeedenterprise(SeedEnterprise seedenterprise) {
		this.seedenterprise = seedenterprise;
	}

	@Override
	public SeedEnterprise getModel() {
		return seedenterprise;
	}
	
	@Action(value = "/seedenterprise", results = {
			@Result(name = SUCCESS, location = "/admin/seedproduct/seedenterpriselist.jsp"),
			@Result(name = "addenter", location = "/admin/seedproduct/addEnter.jsp"),
			@Result(name = "addenterprise", location = "/admin/seedproduct/addEnterPrise.jsp"),
			@Result(name = "modifyenter", location = "/admin/seedproduct/modifyEnter.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(SeedEnterprise.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = seedenterpriseService.count(search);
		List<SeedEnterprise> list = seedenterpriseService.searchAll(search);
		List<Map<String, Object>> seedenterpriseList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				SeedEnterprise obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getEnid());
				row.put("cell",
						new Object[] { obj.getEnid(),obj.getName(),obj.getLicense_code(),obj.getTime() });//其他属性需按页面需要填写
				seedenterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, seedenterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**-----------添加企业信息------------------**/
	public String addEnterp()throws Exception
	{
		/*seedManagerList=seedmanagerService.findAll();
		if(seedenterpriseList.size()==0)
		{*/
			return "addenter";
		/*}
		else
		{
			seedenterpriseList=seedenterpriseService.findAll();
			return "addenterprise";
		}*/
	}
	
	/**------------保存 添加的企业信息--------------------------------**/
	public String saveAddEnterp()throws Exception
	{
		seedManagerList=seedmanagerService.findAll();
		for(SeedManager seedManager:seedManagerList)
		{
			
		}
		String name=httpServletRequest.getParameter("name");
		String license_code=httpServletRequest.getParameter("license_code");
		String time=httpServletRequest.getParameter("senddate");
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formt.parse(time);
		
		
		seedManager.setName(name);
		seedManager.setLicense_code(license_code);
		seedManager.setTime(date);
		seedmanagerService.save(seedManager);
		/*
		SeedEnterprise seedEnterprise=new SeedEnterprise();
		seedEnterprise.setName(name);
		seedEnterprise.setLicense_code(license_code);
		seedEnterprise.setTime(date);
		seedenterpriseService.save(seedEnterprise);*/
		return SUCCESS;
	}
	/**------------------修改企业信息-----------------------------**/
	public String modifyEnterp()throws Exception
	{
		String id=httpServletRequest.getParameter("ouc");
		seedenterprise=seedenterpriseService.findById(Long.parseLong(id));
		
		return "modifyenter";
	}
	/**-------------------保存修改的企业信息-----------------------------------**/
	public String saveModifyEnterp()throws Exception
	{
		String id=httpServletRequest.getParameter("enterprise_id");
		String name=httpServletRequest.getParameter("name");
		String license_code=httpServletRequest.getParameter("license_code");
		String time=httpServletRequest.getParameter("senddate");
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(time);
		
		seedenterprise=seedenterpriseService.findById(Long.parseLong(id));
		seedenterprise.setName(name);
		seedenterprise.setLicense_code(license_code);
		seedenterprise.setTime(date);
		seedenterpriseService.save(seedenterprise);
		
		return SUCCESS;
	}


}