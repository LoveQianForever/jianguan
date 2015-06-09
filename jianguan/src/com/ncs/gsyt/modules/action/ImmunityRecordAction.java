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
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.model.ImmunityRecord;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.ImmunityRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class ImmunityRecordAction extends BaseAction implements ModelDriven<ImmunityRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ImmunityRecordService immunityrecordService;
	
	@Resource
	private BatchService batchService;
	private List<Batch> batchList=new ArrayList<Batch>();
	private Batch batch=new Batch();
	
	
	public List<Batch> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}



	private ImmunityRecord immunityrecord = new ImmunityRecord();
	
	private List<ImmunityRecord> immunityRecordList=new ArrayList<ImmunityRecord>();
	
	public List<ImmunityRecord> getImmunityRecordList() {
		return immunityRecordList;
	}

	public void setImmunityRecordList(List<ImmunityRecord> immunityRecordList) {
		this.immunityRecordList = immunityRecordList;
	}



	private Enterprise enterprise=new Enterprise();
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	
	public ImmunityRecordService getImmunityrecordService() {
		return immunityrecordService;
	}

	public void setImmunityrecordService(ImmunityRecordService immunityrecordService) {
		this.immunityrecordService = immunityrecordService;
	}

	public ImmunityRecord getImmunityrecord() {
		return immunityrecord;
	}

	public void setImmunityrecord(ImmunityRecord immunityrecord) {
		this.immunityrecord = immunityrecord;
	}

	@Override
	public ImmunityRecord getModel() {
		return immunityrecord;
	}
	
	@Action(value = "/immunityrecord", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/immunityrecordlist.jsp"),
			@Result(name = "addImmunity", location = "/admin/poultry/addImmunityRecord.jsp"),
			@Result(name = "addBatchImmunity", location = "/admin/poultry/addBatchImmunityRecord.jsp"),//添加批次概念
			@Result(name = "modifyfood", location = "/admin/poultry/modifyImmunityRecord.jsp"),
			@Result(name = "modifyBatchfood", location = "/admin/poultry/modifyBatchImmunityRecord.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/poultry/modifyImmunityRecord1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/poultry/modifyBatchImmunityRecord1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise =user.getEnterprise();
		Search search = new Search(ImmunityRecord.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterprise", enterprise);
		
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("immunity_time",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("immunity_time", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("immunity_time",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String immunity_ais=StringUtil.isNull(httpServletRequest.getParameter("immunity_ais"));
	if (!"".equals(immunity_ais)) {
		search.addFilterILike("immunity_ais","%"+immunity_ais+"%");
	}
		
		

		int count = immunityrecordService.count(search);
		List<ImmunityRecord> list = immunityrecordService.searchAll(search);
		List<Map<String, Object>> immunityrecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				ImmunityRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getImmunityID());
				row.put("cell",
						new Object[] { obj.getImmunityID(),DateUtil.formatDate(obj.getImmunity_time(), "yyyy-MM-dd"),obj.getImmunity_ais(),obj.getCount(),
						obj.getImmunity_f(),obj.getProFactory(),obj.getImmunity_Code(),obj.getImmunity_count(),obj.getImm_because(),
						obj.getNumber(),obj.getImm_name(),null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():""});//其他属性需按页面需要填写
				immunityrecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, immunityrecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**-----------------------添加--------------------------------------**/
	public String addImmunity()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		if(count1!=0)
		{
			batchList=batchService.searchAll(s1);
			return "addBatchImmunity";
		}
		else
		{
			return "addImmunity";
		}
	}
	/**--------------------保存添加的------------------------------------**/
	public String saveAddImmunity()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();//所属企业
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
//溯源：count1等于0情况下
if(count1==0)
{
		String immunity_time=httpServletRequest.getParameter("immunity_time");//免疫时间
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formt.parse(immunity_time);
		
		String immunity_ais=httpServletRequest.getParameter("immunity_ais");//免疫病种
		String count=httpServletRequest.getParameter("count");//免疫数量
		String immunity_f=httpServletRequest.getParameter("immunity_f");//免疫方法
		String proFactory=httpServletRequest.getParameter("proFactory");//疫苗生产厂家
		String immunity_Code=httpServletRequest.getParameter("immunity_Code");//疫苗批号
		String immunity_count=httpServletRequest.getParameter("immunity_count");//未免疫数
		String imm_because=httpServletRequest.getParameter("imm_because");//未免疫原因
		String number=httpServletRequest.getParameter("number");//未免室编号
		String imm_name=httpServletRequest.getParameter("imm_name");//防疫人
		
		ImmunityRecord immunityRecord=new ImmunityRecord();
		immunityRecord.setEnterprise(enterprise);
		immunityRecord.setCount(count);
		immunityRecord.setImm_because(imm_because);
		immunityRecord.setImmunity_ais(immunity_ais);
		immunityRecord.setImmunity_f(immunity_f);
		immunityRecord.setProFactory(proFactory);
		immunityRecord.setImmunity_Code(immunity_Code);
		immunityRecord.setImmunity_count(Integer.parseInt(immunity_count));
		immunityRecord.setNumber(number);
		immunityRecord.setImm_name(imm_name);
		immunityRecord.setImmunity_time(date);
		
		immunityrecordService.save(immunityRecord);
}
//溯源
else
{
	String immunity_time=httpServletRequest.getParameter("immunity_time");//免疫时间
	SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
	Date date=formt.parse(immunity_time);
	
	String immunity_ais=httpServletRequest.getParameter("immunity_ais");//免疫病种
	String count=httpServletRequest.getParameter("count");//免疫数量
	String immunity_f=httpServletRequest.getParameter("immunity_f");//免疫方法
	String proFactory=httpServletRequest.getParameter("proFactory");//疫苗生产厂家
	String immunity_Code=httpServletRequest.getParameter("immunity_Code");//疫苗批号
	String immunity_count=httpServletRequest.getParameter("immunity_count");//未免疫数
	String imm_because=httpServletRequest.getParameter("imm_because");//未免疫原因
	String number=httpServletRequest.getParameter("number");//未免室编号
	String imm_name=httpServletRequest.getParameter("imm_name");//防疫人
	//溯源：将批次值，保存到当前记录表里；
	String batchID=httpServletRequest.getParameter("batchID");	
	
	ImmunityRecord immunityRecord=new ImmunityRecord();
	immunityRecord.setPiCi(batchID);
	
	immunityRecord.setEnterprise(enterprise);
	immunityRecord.setCount(count);
	immunityRecord.setImm_because(imm_because);
	immunityRecord.setImmunity_ais(immunity_ais);
	immunityRecord.setImmunity_f(immunity_f);
	immunityRecord.setProFactory(proFactory);
	immunityRecord.setImmunity_Code(immunity_Code);
	immunityRecord.setImmunity_count(Integer.parseInt(immunity_count));
	immunityRecord.setNumber(number);
	immunityRecord.setImm_name(imm_name);
	immunityRecord.setImmunity_time(date);
	
	immunityrecordService.save(immunityRecord);
	
	}
		
		return SUCCESS;
	}
	/**-----------------------修改----------------------------------------**/
	public String modifyImmunity()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		/**---------------------------------------------------------**/
		
		String ids=httpServletRequest.getParameter("ouc");
		immunityrecord=immunityrecordService.findById(Long.parseLong(ids));
		
		Date curren=new Date();
		Date date=immunityrecord.getImmunity_time();
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	
			if(count1==0)
			{
			return "modifyfood";
			}else
			{
				batchList=batchService.searchAll(s1);
				return "modifyBatchfood";
			}
		}
		else
		{
			if(count1==0)
			{
			return "stopModify";
			}
			else
			{
				batchList=batchService.searchAll(s1);
				return "stopBatchModify";
			}
		}
		
		
		
	}
	/*************************保存修改的*************************************/
	public String  saveModifyImmunity()throws Exception
	{
		String  ids=httpServletRequest.getParameter("immunityID");
		ImmunityRecord immunityRecord=immunityrecordService.findById(Long.parseLong(ids));
		
		
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();//所属企业
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		/**---------------------------------------------------------**/
		
//溯源：count1等于0
if(count1!=0)
{
	//溯源：将批次值，保存到当前记录表里；
	String batchID=httpServletRequest.getParameter("batchID");	
	immunityRecord.setPiCi(batchID);
}		
	
		String immunity_time=httpServletRequest.getParameter("immunity_time");//免疫时间
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formt.parse(immunity_time);
		
		String immunity_ais=httpServletRequest.getParameter("immunity_ais");//免疫病种
		String count=httpServletRequest.getParameter("count");//免疫数量
		String immunity_f=httpServletRequest.getParameter("immunity_f");//免疫方法
		String proFactory=httpServletRequest.getParameter("proFactory");//疫苗生产厂家
		String immunity_Code=httpServletRequest.getParameter("immunity_Code");//疫苗批号
		String immunity_count=httpServletRequest.getParameter("immunity_count");//未免疫数
		String imm_because=httpServletRequest.getParameter("imm_because");//未免疫原因
		String number=httpServletRequest.getParameter("number");//未免室编号
		String imm_name=httpServletRequest.getParameter("imm_name");//防疫人
		
		
		immunityRecord.setEnterprise(enterprise);
		immunityRecord.setCount(count);
		immunityRecord.setImm_because(imm_because);
		immunityRecord.setImmunity_ais(immunity_ais);
		immunityRecord.setImmunity_f(immunity_f);
		immunityRecord.setProFactory(proFactory);
		immunityRecord.setImmunity_Code(immunity_Code);
		immunityRecord.setImmunity_count(Integer.parseInt(immunity_count));
		immunityRecord.setNumber(number);
		immunityRecord.setImm_name(imm_name);
		immunityRecord.setImmunity_time(date);
		
		immunityrecordService.save(immunityRecord);
		
		return SUCCESS;
	}
	
	

	/**-----------文档下载-------------------**/
	public String loadocc()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		String yearth="2014";
		String ids=httpServletRequest.getParameter("ouc");
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++)
		{
			immunityrecord=immunityrecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			immunityRecordList.add(immunityrecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("immunityRecordList",immunityRecordList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "immunityrecord.ftl";//销售记录ftl模板
		String docfilename =  "immunityrecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("免疫记录.doc","UTF-8"));
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