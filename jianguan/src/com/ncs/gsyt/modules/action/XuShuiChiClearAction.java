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
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XuShuiChiClear;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.XuShuiChiClearService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class XuShuiChiClearAction extends BaseAction implements ModelDriven<XuShuiChiClear>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private XuShuiChiClearService xushuichiclearService;
	
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



	private XuShuiChiClear xushuichiclear = new XuShuiChiClear();
	
	public XuShuiChiClear getXushuichiclear() {
		return xushuichiclear;
	}

	public void setXushuichiclear(XuShuiChiClear xushuichiclear) {
		this.xushuichiclear = xushuichiclear;
	}



	private List<XuShuiChiClear> xushuichiclearList=new ArrayList<XuShuiChiClear>();
	public List<XuShuiChiClear> getXushuichiclearList() {
		return xushuichiclearList;
	}

	public void setXushuichiclearList(List<XuShuiChiClear> xushuichiclearList) {
		this.xushuichiclearList = xushuichiclearList;
	}

	public XuShuiChiClear getXuShuiChiClear() {
		return xushuichiclear;
	}
	
	@Override
	public XuShuiChiClear getModel() {
		return xushuichiclear;
	}
	
	@Action(value = "/xushuichiclear", results = {
			@Result(name = SUCCESS, location = "/admin/pig/xushuichiclearlist.jsp"),
			@Result(name = "add", location = "/admin/pig/addxushuichiclear.jsp"),
			@Result(name = "addBatch", location = "/admin/pig/addBatchxushuichiclear.jsp"),//添加批次概念
			@Result(name = "modify", location = "/admin/pig/modifyxushuichiclear.jsp"),
			@Result(name = "modifyBatch", location = "/admin/pig/modifyBatchxushuichiclear.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/pig/modifyxushuichiclear1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/pig/modifyBatchxushuichiclear1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Search search = new Search(XuShuiChiClear.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		/*根据前台条件生成对应属性判断条件*/
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("createTime",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createTime", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createTime",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String carry_name=StringUtil.isNull(httpServletRequest.getParameter("carry_name"));
	if (!"".equals(carry_name)) {
		search.addFilterILike("carry_name","%"+carry_name+"%");
	}
		
		
		
		

		int count = xushuichiclearService.count(search);
		List<XuShuiChiClear> list = xushuichiclearService.searchAll(search);
		List<Map<String, Object>> xushuichiclearList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				XuShuiChiClear obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getClearID());
				row.put("cell",
						new Object[] { obj.getClearID(),DateUtil.formatDate(obj.getCreateTime(), "yyyy-MM-dd"),obj.getClearObject(),obj.getAttach(),
						obj.getClearMethod(),obj.getCarry_name(),obj.getContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				xushuichiclearList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, xushuichiclearList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	

	

	/**-------------添加信息-----------------------**/
	public String add()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		if(count1==0)
		{
		return "add";
		}
		else
		{
			batchList=batchService.searchAll(s1);
			return "addBatch";
		}
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAdd()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		XuShuiChiClear xuShuiChiClear=new XuShuiChiClear();
			String createTime=httpServletRequest.getParameter("createTime");
			Date date=fomt.parse(createTime);
			
			//溯源：count1等于0情况下
			if(count1!=0)
			{
				//溯源：将批次值，保存到当前记录表里；
				String batchID=httpServletRequest.getParameter("batchID");	
				xuShuiChiClear.setPiCi(batchID);
			}
			
			String clearObject=httpServletRequest.getParameter("clearObject");
			String attach=httpServletRequest.getParameter("attach");
			String clearMethod=httpServletRequest.getParameter("clearMethod");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			 xuShuiChiClear.setCreateTime(date);
			 xuShuiChiClear.setAttach(attach);
			 xuShuiChiClear.setClearObject(clearObject);
			 xuShuiChiClear.setClearMethod(clearMethod);
			 xuShuiChiClear.setCarry_name(carry_name);
			 xuShuiChiClear.setContent(content);
			 xuShuiChiClear.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			 xuShuiChiClear.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			 xushuichiclearService.save(xuShuiChiClear);
			 return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		String id=httpServletRequest.getParameter("ouc");
		xushuichiclear=xushuichiclearService.findById(Long.parseLong(id));
		
		Date curren=new Date();
		Date date=xushuichiclear.getCreateTime();
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	
			if(count1==0)
			{
			return "modify";
			}
			else
			{
				batchList=batchService.searchAll(s1);
				return "modifyBatch";
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
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//参数
		String clearID=httpServletRequest.getParameter("clearID");
		XuShuiChiClear xuShuiChiClear=xushuichiclearService.findById(Long.parseLong(clearID));
		
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			xuShuiChiClear.setPiCi(batchID);
		}
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String createTime=httpServletRequest.getParameter("createTime");
			Date date=fomt.parse(createTime);
			
			String clearObject=httpServletRequest.getParameter("clearObject");
			String attach=httpServletRequest.getParameter("attach");
			String clearMethod=httpServletRequest.getParameter("clearMethod");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			 xuShuiChiClear.setCreateTime(date);
			 xuShuiChiClear.setAttach(attach);
			 xuShuiChiClear.setClearObject(clearObject);
			 xuShuiChiClear.setClearMethod(clearMethod);
			 xuShuiChiClear.setCarry_name(carry_name);
			 xuShuiChiClear.setContent(content);
			 xuShuiChiClear.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			 xuShuiChiClear.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			 xushuichiclearService.save(xuShuiChiClear);
			
		
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
			xushuichiclear=xushuichiclearService.findById(Long.parseLong(idss[i]));//获取sale记录
			xushuichiclearList.add(xushuichiclear);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("xushuichiclearList", xushuichiclearList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "xushuichiclear.ftl";//销售记录ftl模板
		String docfilename =  "xushuichiclear.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("蓄水设施清洗记录.doc","UTF-8"));
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