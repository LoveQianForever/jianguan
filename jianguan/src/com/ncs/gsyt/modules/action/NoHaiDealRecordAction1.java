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
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.NoHaiDealRecord;
import com.ncs.gsyt.modules.model.PigFoodUseRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.NoHaiDealRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class NoHaiDealRecordAction1 extends BaseAction implements ModelDriven<NoHaiDealRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private NoHaiDealRecordService nohaidealrecordService;
	
	private NoHaiDealRecord nohaidealrecord = new NoHaiDealRecord();
	
	public NoHaiDealRecord getNohaidealrecord() {
		return nohaidealrecord;
	}

	public void setNohaidealrecord(NoHaiDealRecord nohaidealrecord) {
		this.nohaidealrecord = nohaidealrecord;
	}



	private List<NoHaiDealRecord> nohaidealrecordList=new ArrayList<NoHaiDealRecord>();
	public List<NoHaiDealRecord> getNohaidealrecordList() {
		return nohaidealrecordList;
	}

	public void setNohaidealrecordList(List<NoHaiDealRecord> nohaidealrecordList) {
		this.nohaidealrecordList = nohaidealrecordList;
	}

	public NoHaiDealRecord getNoHaiDealRecord() {
		return nohaidealrecord;
	}
	
	@Override
	public NoHaiDealRecord getModel() {
		return nohaidealrecord;
	}
	
	@Action(value = "/nohaidealrecord1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/nohaidealrecordlist1.jsp"),
			@Result(name = "add", location = "/admin/pig/addnohaidealrecord.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifynohaidealrecord.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		nohaidealrecord=new NoHaiDealRecord();
		nohaidealrecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		
		Search search = new Search(NoHaiDealRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", enterpriseID);
		//search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		/*根据前台条件生成对应属性判断条件*/
		
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("createDate",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createDate", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createDate",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String dealObject=StringUtil.isNull(httpServletRequest.getParameter("dealObject"));
	if (!"".equals(dealObject)) {
		search.addFilterILike("dealObject","%"+dealObject+"%");
	}
		

		int count = nohaidealrecordService.count(search);
		List<NoHaiDealRecord> list = nohaidealrecordService.searchAll(search);
		List<Map<String, Object>> nohaidealrecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				NoHaiDealRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getDealRecordID());
				row.put("cell",
						new Object[] { obj.getDealRecordID(),DateUtil.formatDate(obj.getCreateDate(), "yyyy-MM-dd"),obj.getDealObject(),obj.getDealReason(),
						obj.getDealCount(),obj.getDealMethod(),obj.getCarry_name(),obj.getContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				nohaidealrecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, nohaidealrecordList);

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
		
		
		NoHaiDealRecord noHaiDealRecord=new NoHaiDealRecord();
			String createDate=httpServletRequest.getParameter("createDate");
			Date date=fomt.parse(createDate);
			
			String dealObject=httpServletRequest.getParameter("dealObject");
			String dealReason=httpServletRequest.getParameter("dealReason");
			String dealCount=httpServletRequest.getParameter("dealCount");
			String dealMethod=httpServletRequest.getParameter("dealMethod");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			noHaiDealRecord.setCreateDate(date);
			noHaiDealRecord.setDealObject(dealObject);
			noHaiDealRecord.setDealReason(dealReason);
			noHaiDealRecord.setDealCount(dealCount);
			noHaiDealRecord.setDealMethod(dealMethod);
			noHaiDealRecord.setCarry_name(carry_name);
			noHaiDealRecord.setContent(content);
			noHaiDealRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			noHaiDealRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			nohaidealrecordService.save(noHaiDealRecord);
			
			
			
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		nohaidealrecord=nohaidealrecordService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String dealRecordID=httpServletRequest.getParameter("dealRecordID");
		NoHaiDealRecord noHaiDealRecord=nohaidealrecordService.findById(Long.parseLong(dealRecordID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String createDate=httpServletRequest.getParameter("createDate");
			Date date=fomt.parse(createDate);
			
			String dealObject=httpServletRequest.getParameter("dealObject");
			String dealReason=httpServletRequest.getParameter("dealReason");
			String dealCount=httpServletRequest.getParameter("dealCount");
			String dealMethod=httpServletRequest.getParameter("dealMethod");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			noHaiDealRecord.setCreateDate(date);
			noHaiDealRecord.setDealObject(dealObject);
			noHaiDealRecord.setDealReason(dealReason);
			noHaiDealRecord.setDealCount(dealCount);
			noHaiDealRecord.setDealMethod(dealMethod);
			noHaiDealRecord.setCarry_name(carry_name);
			noHaiDealRecord.setContent(content);
			noHaiDealRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			noHaiDealRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			nohaidealrecordService.save(noHaiDealRecord);
		
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
			nohaidealrecord=nohaidealrecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			nohaidealrecordList.add(nohaidealrecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("nohaidealrecordList", nohaidealrecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "nohaidealrecord.ftl";//销售记录ftl模板
		String docfilename =  "nohaidealrecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("无害化处理记录.doc","UTF-8"));
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