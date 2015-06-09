package com.ncs.gsyt.modules.action;

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
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.model.DisinfectionRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.PoultryKinds;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.DieRecordService;
import com.ncs.gsyt.modules.service.PoultryKindsService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class DieRecordAction extends BaseAction implements ModelDriven<DieRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private DieRecordService dierecordService;
	
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

	private DieRecord dierecord = new DieRecord();
	

	private List<DieRecord> dieRecordList=new ArrayList<DieRecord>();
	public List<DieRecord> getDieRecordList() {
		return dieRecordList;
	}

	public void setDieRecordList(List<DieRecord> dieRecordList) {
		this.dieRecordList = dieRecordList;
	}

	public DieRecord getDierecord() {
		return dierecord;
	}

	public void setDierecord(DieRecord dierecord) {
		this.dierecord = dierecord;
	}

	@Resource
	private PoultryKindsService poultrykindsService;//品种
	
	private List<PoultryKinds> poultryKindsList=new ArrayList<PoultryKinds>();
	public List<PoultryKinds> getPoultryKindsList() {
		return poultryKindsList;
	}

	public void setPoultryKindsList(List<PoultryKinds> poultryKindsList) {
		this.poultryKindsList = poultryKindsList;
	}

	private PoultryKinds poultryKinds=new PoultryKinds();//品种
	
	public PoultryKinds getPoultryKinds() {
		return poultryKinds;
	}

	public void setPoultryKinds(PoultryKinds poultryKinds) {
		this.poultryKinds = poultryKinds;
	}
	
	
	
	@Override
	public DieRecord getModel() {
		return dierecord;
	}
	
	@Action(value = "/dierecord", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/dierecordlist.jsp"),
			@Result(name = "adddie", location = "/admin/poultry/addDieRecord.jsp"),
			@Result(name = "addBatchdie", location = "/admin/poultry/addBatchDieRecord.jsp"),//添加批次概念
			@Result(name = "modifydie", location = "/admin/poultry/modifyDieRecord.jsp"),
			@Result(name = "modifyBatchdie", location = "/admin/poultry/modifyBatchDieRecord.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/poultry/modifyDieRecord1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/poultry/modifyBatchDieRecord1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		Search search = new Search(DieRecord.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", enterprise.getEnterpriseID());
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("record_time",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("record_time", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("record_time",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String poultryName=StringUtil.isNull(httpServletRequest.getParameter("poultryName"));
	if (!"".equals(poultryName)) {
		search.addFilterILike("poultryKinds.poultryName","%"+poultryName+"%");
	}
		
		

		int count = dierecordService.count(search);
		List<DieRecord> list = dierecordService.searchAll(search);
		List<Map<String, Object>> dierecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				DieRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getDieRecordID());
				row.put("cell",
						new Object[] { obj.getDieRecordID(),DateUtil.formatDate(obj.getRecord_time(), "yyyy-MM-dd"),null!=obj.getPoultryKinds()?obj.getPoultryKinds().getPoultryName():"",
						obj.getCount(),obj.getDieReason(),obj.getDealMethod(),obj.getDeal_name(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				dierecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, dierecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	

	/**-----------------------添加--------------------------------------**/
	public String addDie()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		
		
		Enterprise enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		poultryKindsList=poultrykindsService.searchAll(search);
		
		if(count1!=0)
		{
			batchList=batchService.searchAll(s1);
			return "addBatchdie";
		}
		else
		{
			return "adddie";
		}
	}
	/**--------------------保存添加的------------------------------------**/
	public String saveAddDie()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);

		
		long enterpriseID=user.getEnterprise().getEnterpriseID();//企业ID
		String enterpriseName=user.getEnterprise().getEnterpriseName();//企业名字
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String id=httpServletRequest.getParameter("poultryName");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));
		
		String record_time=httpServletRequest.getParameter("record_time");
		Date date=formt.parse(record_time);
		
		String count=httpServletRequest.getParameter("count");
		String dieReason=httpServletRequest.getParameter("dieReason");
		String dealMethod=httpServletRequest.getParameter("dealMethod");
		String deal_name=httpServletRequest.getParameter("deal_name");
		
		DieRecord dieRecord=new DieRecord();
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			dieRecord.setPiCi(batchID);
		}
		dieRecord.setPoultryKinds(poultryKinds);
		dieRecord.setRecord_time(date);
		dieRecord.setCount(count);
		dieRecord.setDieReason(dieReason);
		dieRecord.setDealMethod(dealMethod);
		dieRecord.setDeal_name(deal_name);
		dieRecord.setEnterpriseID(enterpriseID);
		dieRecord.setEnterpriseName(enterpriseName);
		
		dierecordService.save(dieRecord);
		
		
		return SUCCESS;
	}
	/**-----------------------修改----------------------------------------**/
	public String modifyDie()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		Enterprise enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		poultryKindsList=poultrykindsService.searchAll(search);
		
		/**-------------------------------------------------------**/
		String ids=httpServletRequest.getParameter("ouc");
		dierecord=dierecordService.findById(Long.parseLong(ids));
		
		
		Date curren=new Date();
		Date date=dierecord.getRecord_time();
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	
			if(count1==0)
			{
			return "modifydie";
			}
			else
			{
				batchList=batchService.searchAll(s1);
				return "modifyBatchdie";
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
	public String  saveModifyDie()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		
		long enterpriseID=user.getEnterprise().getEnterpriseID();//canshu
		String enterpriseName=user.getEnterprise().getEnterpriseName();//canshu
		//参数
		String ids=httpServletRequest.getParameter("dieRecordID");
		DieRecord dieRecord=dierecordService.findById(Long.parseLong(ids));
		
SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String id=httpServletRequest.getParameter("poultryName");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));
		
		String record_time=httpServletRequest.getParameter("record_time");
		Date date=formt.parse(record_time);
		
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			dieRecord.setPiCi(batchID);
		}
		String count=httpServletRequest.getParameter("count");
		String dieReason=httpServletRequest.getParameter("dieReason");
		String dealMethod=httpServletRequest.getParameter("dealMethod");
		String deal_name=httpServletRequest.getParameter("deal_name");
		dieRecord.setPoultryKinds(poultryKinds);
		dieRecord.setRecord_time(date);
		dieRecord.setCount(count);
		dieRecord.setDieReason(dieReason);
		dieRecord.setDealMethod(dealMethod);
		dieRecord.setDeal_name(deal_name);
		dieRecord.setEnterpriseID(enterpriseID);
		dieRecord.setEnterpriseName(enterpriseName);
		
		dierecordService.save(dieRecord);
		
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
			dierecord=dierecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			dieRecordList.add(dierecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("dieRecordList", dieRecordList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "dierecord.ftl";//销售记录ftl模板
		String docfilename =  "dierecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("病死处理记录.doc","UTF-8"));
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