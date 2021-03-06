﻿package com.ncs.gsyt.modules.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.CaiGou;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.model.YuMiao;
import com.ncs.gsyt.modules.service.CaiGouService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class CaiGouAction1 extends BaseAction implements ModelDriven<CaiGou>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private CaiGouService caigouService;
	
	private List<CaiGou> caigouList=new ArrayList<CaiGou>();
	
	public List<CaiGou> getCaigouList() {
		return caigouList;
	}

	public void setCaigouList(List<CaiGou> caigouList) {
		this.caigouList = caigouList;
	}



	private CaiGou caigou = new CaiGou();
	
	public CaiGou getCaigou() {
		return caigou;
	}

	public void setCaigou(CaiGou caigou) {
		this.caigou = caigou;
	}

	@Override
	public CaiGou getModel() {
		return caigou;
	}
	
	@Action(value = "/caigou1", results = {
			@Result(name = SUCCESS, location = "/admin/yulei/caigoulist1.jsp"),
			@Result(name = "add", location = "/admin/yulei/addcaigou.jsp"),
			@Result(name = "modify", location = "/admin/yulei/modifycaigou.jsp")
	})
	
	@Override
	public String execute() {
		String idd=httpServletRequest.getParameter("enterpriseID");
		caigou=new CaiGou();
		caigou.setIdss(Long.parseLong(idd));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(CaiGou.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID",enterpriseID);
		
		//search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		/*根据前台条件生成对应属性判断条件*/
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("input_time",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("input_time", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("input_time",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String  name=StringUtil.isNull(httpServletRequest.getParameter("name"));
	if (!"".equals(name)) {
		search.addFilterILike("name","%"+name+"%");
	}

		int count = caigouService.count(search);
		List<CaiGou> list = caigouService.searchAll(search);
		List<Map<String, Object>> caigouList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				CaiGou obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getCaigouID());
				row.put("cell",
						new Object[] { obj.getCaigouID(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),obj.getName(),obj.getInclude(),obj.getCount(),
						obj.getGuige(),obj.getDengjiCode(),obj.getProFactory(),obj.getSaleFactory(),obj.getPiaojuCode(),
						obj.getJingbanren(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				caigouList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, caigouList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	

	

	/**-------------添加信息-----------------------**/
	public String add()throws Exception
	{
		return "add";
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAdd()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		CaiGou caiGou=new CaiGou();
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String name=httpServletRequest.getParameter("name");
			String include=httpServletRequest.getParameter("include");
			String count=httpServletRequest.getParameter("count");
			String guige=httpServletRequest.getParameter("guige");
			String dengjiCode=httpServletRequest.getParameter("dengjiCode");
			String proFactory=httpServletRequest.getParameter("proFactory");
			String saleFactory=httpServletRequest.getParameter("saleFactory");
			String piaojuCode=httpServletRequest.getParameter("piaojuCode");
			String jingbanren=httpServletRequest.getParameter("jingbanren");
			caiGou.setInput_time(date);
			caiGou.setName(name);
			caiGou.setInclude(include);
			caiGou.setCount(count);
			caiGou.setGuige(guige);
			caiGou.setDengjiCode(dengjiCode);
			caiGou.setProFactory(proFactory);
			caiGou.setSaleFactory(saleFactory);
			caiGou.setPiaojuCode(piaojuCode);
			caiGou.setJingbanren(jingbanren);
			caiGou.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			caiGou.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			caigouService.save(caiGou);
			
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		caigou=caigouService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String caigouID=httpServletRequest.getParameter("caigouID");
		CaiGou caiGou=caigouService.findById(Long.parseLong(caigouID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String name=httpServletRequest.getParameter("name");
			String include=httpServletRequest.getParameter("include");
			String count=httpServletRequest.getParameter("count");
			String guige=httpServletRequest.getParameter("guige");
			String dengjiCode=httpServletRequest.getParameter("dengjiCode");
			String proFactory=httpServletRequest.getParameter("proFactory");
			String saleFactory=httpServletRequest.getParameter("saleFactory");
			String piaojuCode=httpServletRequest.getParameter("piaojuCode");
			String jingbanren=httpServletRequest.getParameter("jingbanren");
			caiGou.setInput_time(date);
			caiGou.setName(name);
			caiGou.setInclude(include);
			caiGou.setCount(count);
			caiGou.setGuige(guige);
			caiGou.setDengjiCode(dengjiCode);
			caiGou.setProFactory(proFactory);
			caiGou.setSaleFactory(saleFactory);
			caiGou.setPiaojuCode(piaojuCode);
			caiGou.setJingbanren(jingbanren);
			caiGou.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			caiGou.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			caigouService.save(caiGou);
			
		return SUCCESS;
	}
	
	

	/**-----------文档下载-------------------**/
	public String loadocc()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//String enterpriseName=user.getEnterprise().getEnterpriseName();
		String yearth="2014";
		String ids=httpServletRequest.getParameter("ouc");
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++)
		{
			caigou=caigouService.findById(Long.parseLong(idss[i]));//获取sale记录
			caigouList.add(caigou);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("caigouList", caigouList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "caigou.ftl";//销售记录ftl模板
		String docfilename =  "caigou.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("农业投入品（鱼药、铒料等）采购表.doc","UTF-8"));
		FileInputStream fis=new FileInputStream(file);
		BufferedInputStream buff=new BufferedInputStream(fis);
		byte [] b=new byte[1024];//相当于我们的缓存 
		long k=0;//该值用于计算当前实际下载了多少字节 
		OutputStream myout=httpServletResponse.getOutputStream();
		while(k<file.length()){
			int j=buff.read(b,0,1024);
			k+=j;
			myout.write(b,0,j);
		}
		myout.flush();
		myout.close();
		
		return null;
		
	}
	
}