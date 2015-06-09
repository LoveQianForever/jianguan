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
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.PigMedicineUseRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.service.XiaoDuRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class XiaoDuRecordAction1 extends BaseAction implements ModelDriven<XiaoDuRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private XiaoDuRecordService xiaodurecordService;
	
	private XiaoDuRecord xiaodurecord = new XiaoDuRecord();
	
	public XiaoDuRecord getXiaodurecord() {
		return xiaodurecord;
	}

	public void setXiaodurecord(XiaoDuRecord xiaodurecord) {
		this.xiaodurecord = xiaodurecord;
	}



	private List<XiaoDuRecord> xiaodurecordList=new ArrayList<XiaoDuRecord>();
	
	public List<XiaoDuRecord> getXiaodurecordList() {
		return xiaodurecordList;
	}

	public void setXiaodurecordList(List<XiaoDuRecord> xiaodurecordList) {
		this.xiaodurecordList = xiaodurecordList;
	}

	public XiaoDuRecord getXiaoDuRecord() {
		return xiaodurecord;
	}
	
	@Override
	public XiaoDuRecord getModel() {
		return xiaodurecord;
	}
	
	@Action(value = "/xiaodurecord1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/xiaodurecordlist1.jsp"),
			@Result(name = "add", location = "/admin/pig/addxiaodurecord.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifyxiaodurecord.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		xiaodurecord=new XiaoDuRecord();
		xiaodurecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(XiaoDuRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", enterpriseID);
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
	String productName=StringUtil.isNull(httpServletRequest.getParameter("productName"));
	if (!"".equals(productName)) {
		search.addFilterILike("productName","%"+productName+"%");
	}
		

		int count = xiaodurecordService.count(search);
		List<XiaoDuRecord> list = xiaodurecordService.searchAll(search);
		List<Map<String, Object>> xiaodurecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				XiaoDuRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getXiaoduRecordID());
				row.put("cell",
						new Object[] { obj.getXiaoduRecordID(),DateUtil.formatDate(obj.getCreateDate(), "yyyy-MM-dd"),obj.getProObject(),obj.getProductName(),
						obj.getCount(),obj.getXiaoDuFa(),obj.getCarry_name(),obj.getContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				xiaodurecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, xiaodurecordList);

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
		
		
		XiaoDuRecord xiaoDuRecord=new XiaoDuRecord();
			String createDate=httpServletRequest.getParameter("createDate");
			Date date=fomt.parse(createDate);
			
			String proObject=httpServletRequest.getParameter("proObject");
			String productName=httpServletRequest.getParameter("productName");
			String count=httpServletRequest.getParameter("count");
			String  xiaoDuFa=httpServletRequest.getParameter("xiaoDuFa");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			xiaoDuRecord.setCreateDate(date);
			xiaoDuRecord.setProObject(proObject);
			xiaoDuRecord.setProductName(productName);
			xiaoDuRecord.setCount(count);
			xiaoDuRecord.setXiaoDuFa(xiaoDuFa);
			xiaoDuRecord.setCarry_name(carry_name);
			xiaoDuRecord.setContent(content);
			xiaoDuRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			xiaoDuRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			String[] created=createDate.split("-");
			xiaoDuRecord.setYear1(created[0]);
			xiaoDuRecord.setMonth1(created[1]);
			xiaoDuRecord.setDay1(created[2]);
			xiaodurecordService.save(xiaoDuRecord);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		xiaodurecord=xiaodurecordService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String xiaoduRecordID=httpServletRequest.getParameter("xiaoduRecordID");
		XiaoDuRecord xiaoDuRecord=xiaodurecordService.findById(Long.parseLong(xiaoduRecordID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String createDate=httpServletRequest.getParameter("createDate");
			Date date=fomt.parse(createDate);
			
			String proObject=httpServletRequest.getParameter("proObject");
			String productName=httpServletRequest.getParameter("productName");
			String count=httpServletRequest.getParameter("count");
			String  xiaoDuFa=httpServletRequest.getParameter("xiaoDuFa");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			xiaoDuRecord.setCreateDate(date);
			xiaoDuRecord.setProObject(proObject);
			xiaoDuRecord.setProductName(productName);
			xiaoDuRecord.setCount(count);
			xiaoDuRecord.setXiaoDuFa(xiaoDuFa);
			xiaoDuRecord.setCarry_name(carry_name);
			xiaoDuRecord.setContent(content);
			xiaoDuRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			xiaoDuRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			String[] created=createDate.split("-");
			xiaoDuRecord.setYear1(created[0]);
			xiaoDuRecord.setMonth1(created[1]);
			xiaoDuRecord.setDay1(created[2]);
			xiaodurecordService.save(xiaoDuRecord);
		
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
			xiaodurecord=xiaodurecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			xiaodurecordList.add(xiaodurecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("xiaodurecordList", xiaodurecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "xiaodurecord.ftl";//销售记录ftl模板
		String docfilename =  "xiaodurecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("日常消毒记录.doc","UTF-8"));
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