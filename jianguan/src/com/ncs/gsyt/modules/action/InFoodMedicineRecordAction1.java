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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.InFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InFoodMedicineService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InFoodMedicineRecordAction1 extends BaseAction implements ModelDriven<InFoodMedicineRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InFoodMedicineRecordService infoodmedicinerecordService;
	
	@Resource
	private InFoodMedicineService inFoodMedicineService;//购物品对象
	
	@Resource
	private EnterpriseService enterpriseService;//购物品对象
	private List<Enterprise> enterpriseList=new ArrayList<Enterprise>();//企业集合
	
	private List<InFoodMedicineRecord> inFoodMedicineRecordList=new ArrayList<InFoodMedicineRecord>();
	public List<InFoodMedicineRecord> getInFoodMedicineRecordList() {
		return inFoodMedicineRecordList;
	}

	public void setInFoodMedicineRecordList(
			List<InFoodMedicineRecord> inFoodMedicineRecordList) {
		this.inFoodMedicineRecordList = inFoodMedicineRecordList;
	}
	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}
	private Enterprise enterprise=new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	private InFoodMedicine inFoodMedicine=new InFoodMedicine();//购入品对象
	
	private List<InFoodMedicine> inFoodMedicineList=new ArrayList<InFoodMedicine>();//购入品结合
	
	public List<InFoodMedicine> getInFoodMedicineList() {
		return inFoodMedicineList;
	}

	public void setInFoodMedicineList(List<InFoodMedicine> inFoodMedicineList) {
		this.inFoodMedicineList = inFoodMedicineList;
	}

	public InFoodMedicine getInFoodMedicine() {
		return inFoodMedicine;
	}

	public void setInFoodMedicine(InFoodMedicine inFoodMedicine) {
		this.inFoodMedicine = inFoodMedicine;
	}
	private InFoodMedicineRecord infoodmedicinerecord = new InFoodMedicineRecord();
	
	
	public InFoodMedicineRecord getInfoodmedicinerecord() {
		return infoodmedicinerecord;
	}

	public void setInfoodmedicinerecord(InFoodMedicineRecord infoodmedicinerecord) {
		this.infoodmedicinerecord = infoodmedicinerecord;
	}

	@Override
	public InFoodMedicineRecord getModel() {
		return infoodmedicinerecord;
	}
	
	@Action(value = "/infoodmedicinerecord1", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/infoodmedicinerecordlist1.jsp"),
			@Result(name = "addinfmr", location = "/admin/poultry/addInFoodMedicineRecord.jsp"),//添加
			@Result(name = "modifyifmr", location = "/admin/poultry/modifyInFoodMedicineRecord.jsp")//修改
	})
	
	@Override
	public String execute() {
		
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		infoodmedicinerecord = new  InFoodMedicineRecord();
		infoodmedicinerecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
	
		*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(InFoodMedicineRecord.class);
		search = this.getSearch(search);
		//查询出，当前记录下，和登录用户user 相关的记录；
		search.addFilterEqual("enterpriseDI", enterpriseID);
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
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
	//产品名称
	String mf_name=StringUtil.isNull(httpServletRequest.getParameter("mf_name"));
	if (!"".equals(mf_name)) {
		search.addFilterILike("mf_name","%"+mf_name+"%");
	}
		

		int count = infoodmedicinerecordService.count(search);
		List<InFoodMedicineRecord> list = infoodmedicinerecordService.searchAll(search);
		List<Map<String, Object>> infoodmedicinerecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InFoodMedicineRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getInMFRecordID());
				row.put("cell",
						new Object[] { obj.getInMFRecordID(),null!=obj.getInFoodMedicine()?obj.getInFoodMedicine().getMf_name():""
							,obj.getCount(),obj.getBuyName(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),
							null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():null!=obj.getFoodMedicineSupply()?obj.getFoodMedicineSupply().getSupplyName():"",
							obj.getEnterpriseName()		});//其他属性需按页面需要填写
				infoodmedicinerecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, infoodmedicinerecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**-------------添加信息-----------------------**/
	public String addinFMRecord()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Enterprise enterprise=user.getEnterprise();
		Search search=new Search(InFoodMedicine.class);
		search.addFilterEqual("enterprise", enterprise);
		inFoodMedicineList=inFoodMedicineService.searchAll(search);//购入品的 结合
		//1 代表种子经营；2 代表农业投入品经营 3、种植类生产企业 4、水产类生产企业
		//5、生猪类生产企业 6、禽类生产企业； 
		//enterpriseList=enterpriseService.findAll();
		Search s1=new Search(Enterprise.class);
		s1.addFilterEqual("status", 2);
		enterpriseList=enterpriseService.searchAll(s1);//"2" 的企业集合
		
		return "addinfmr";
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAddInFMRecord()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		long enterpriseDI=user.getEnterprise().getEnterpriseID();
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		/**----------------------------------------------------------**/
		String id=httpServletRequest.getParameter("mf_name");
		inFoodMedicine=inFoodMedicineService.findById(Long.parseLong(id));//参数
		
		String count=httpServletRequest.getParameter("count");
		String buyName=httpServletRequest.getParameter("buyName");
		String input_time=httpServletRequest.getParameter("input_time");
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=formt.parse(input_time);
		
		String ids=httpServletRequest.getParameter("enterpriseName");
		enterprise=enterpriseService.findById(Long.parseLong(ids));//对应的其中一个供应商；
		
		
		
		InFoodMedicineRecord inFoodMedicineRecord=new InFoodMedicineRecord();
		inFoodMedicineRecord.setEnterpriseDI(enterpriseDI);
		inFoodMedicineRecord.setEnterpriseName(enterpriseName);
		inFoodMedicineRecord.setCount(count);
		inFoodMedicineRecord.setBuyName(buyName);
		inFoodMedicineRecord.setInFoodMedicine(inFoodMedicine);
		inFoodMedicineRecord.setInput_time(date);
		inFoodMedicineRecord.setEnterprise(enterprise);
		infoodmedicinerecordService.save(inFoodMedicineRecord);	
	
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modifyIFMR() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Enterprise enterprise=user.getEnterprise();
		Search search=new Search(InFoodMedicine.class);
		search.addFilterEqual("enterprise", enterprise);
		inFoodMedicineList=inFoodMedicineService.searchAll(search);//购入品的 结合
		//1 代表种子经营；2 代表农业投入品经营 3、种植类生产企业 4、水产类生产企业
		//5、生猪类生产企业 6、禽类生产企业； 
		//enterpriseList=enterpriseService.findAll();
		Search s1=new Search(Enterprise.class);
		s1.addFilterEqual("status", "2");
		enterpriseList=enterpriseService.searchAll(s1);//"2" 的企业集合
		
		
		String id=httpServletRequest.getParameter("ouc");
		infoodmedicinerecord=infoodmedicinerecordService.findById(Long.parseLong(id));
		
		return "modifyifmr";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		long enterpriseDI=user.getEnterprise().getEnterpriseID();
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		
		
		String id=httpServletRequest.getParameter("inMFRecordID");
		infoodmedicinerecord=infoodmedicinerecordService.findById(Long.parseLong(id));
		
		String ids=httpServletRequest.getParameter("mf_name");
		inFoodMedicine=inFoodMedicineService.findById(Long.parseLong(ids));//canshu
		String count=httpServletRequest.getParameter("count");//
		String buyName=httpServletRequest.getParameter("buyName");//
		String input_time=httpServletRequest.getParameter("input_time");//
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=formt.parse(input_time);
		
		String idd=httpServletRequest.getParameter("enterpriseName");
		Enterprise enterpise=enterpriseService.findById(Long.parseLong(idd));//对象
		
		
		infoodmedicinerecord.setInFoodMedicine(inFoodMedicine);
		infoodmedicinerecord.setBuyName(buyName);
		infoodmedicinerecord.setCount(count);
		
		infoodmedicinerecord.setEnterprise(enterpise);
		
		infoodmedicinerecord.setEnterpriseDI(enterpriseDI);
		infoodmedicinerecord.setEnterpriseName(enterpriseName);
		infoodmedicinerecord.setInput_time(date);
		
		infoodmedicinerecordService.save(infoodmedicinerecord);
		
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
			infoodmedicinerecord=infoodmedicinerecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			inFoodMedicineRecordList.add(infoodmedicinerecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("inFoodMedicineRecordList", inFoodMedicineRecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "infoodmedicinerecord.ftl";//销售记录ftl模板
		String docfilename =  "infoodmedicinerecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("投入品采购记录.doc","UTF-8"));
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