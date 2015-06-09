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
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.InPigFoodMedicineRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.InPigFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InPigFoodMedicineService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InPigFoodMedicineRecordAction1 extends BaseAction implements ModelDriven<InPigFoodMedicineRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InPigFoodMedicineRecordService inpigfoodmedicinerecordService;
	
	@Resource
	private InPigFoodMedicineService inpigfoodmedicineService;//投入品管理
	private List<InPigFoodMedicine> inpigfoodmedicineList=new ArrayList<InPigFoodMedicine>();//投入品集合
	private InPigFoodMedicine inpigfoodmedicine=new InPigFoodMedicine();
	
	private List<InPigFoodMedicineRecord> inpigfoodmedicinerecordList=new ArrayList<InPigFoodMedicineRecord>();
	public List<InPigFoodMedicineRecord> getInpigfoodmedicinerecordList() {
		return inpigfoodmedicinerecordList;
	}

	public void setInpigfoodmedicinerecordList(
			List<InPigFoodMedicineRecord> inpigfoodmedicinerecordList) {
		this.inpigfoodmedicinerecordList = inpigfoodmedicinerecordList;
	}

	public InPigFoodMedicine getInpigfoodmedicine() {
		return inpigfoodmedicine;
	}

	public void setInpigfoodmedicine(InPigFoodMedicine inpigfoodmedicine) {
		this.inpigfoodmedicine = inpigfoodmedicine;
	}

	public List<InPigFoodMedicine> getInpigfoodmedicineList() {
		return inpigfoodmedicineList;
	}

	public void setInpigfoodmedicineList(
			List<InPigFoodMedicine> inpigfoodmedicineList) {
		this.inpigfoodmedicineList = inpigfoodmedicineList;
	}



	private InPigFoodMedicineRecord inpigfoodmedicinerecord = new InPigFoodMedicineRecord();
	
	
	public InPigFoodMedicineRecord getInpigfoodmedicinerecord() {
		return inpigfoodmedicinerecord;
	}

	public void setInpigfoodmedicinerecord(
			InPigFoodMedicineRecord inpigfoodmedicinerecord) {
		this.inpigfoodmedicinerecord = inpigfoodmedicinerecord;
	}

	public InPigFoodMedicineRecord getInPigFoodMedicineRecord() {
		return inpigfoodmedicinerecord;
	}
	
	@Override
	public InPigFoodMedicineRecord getModel() {
		return inpigfoodmedicinerecord;
	}
	
	@Action(value = "/inpigfoodmedicinerecord1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/inpigfoodmedicinerecordlist1.jsp"),
			@Result(name = "add", location = "/admin/pig/addinpigfoodmedicinerecord.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifyinpigfoodmedicinerecord.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		inpigfoodmedicinerecord=new InPigFoodMedicineRecord();
		inpigfoodmedicinerecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(InPigFoodMedicineRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseDI", enterpriseID);
		
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
	String name=StringUtil.isNull(httpServletRequest.getParameter("name"));
	if (!"".equals(name)) {
		search.addFilterILike("inPigFoodMedicine.name","%"+name+"%");
	}
		
		

		int count = inpigfoodmedicinerecordService.count(search);
		List<InPigFoodMedicineRecord> list = inpigfoodmedicinerecordService.searchAll(search);
		List<Map<String, Object>> inpigfoodmedicinerecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InPigFoodMedicineRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getIpigFoodMedicineID());
				row.put("cell",
						new Object[] { obj.getIpigFoodMedicineID(),DateUtil.formatDate(obj.getCreateTime(), "yyyy-MM-dd"),
						null!=obj.getInPigFoodMedicine()?obj.getInPigFoodMedicine().getName():"",
								obj.getCount(),obj.getBuy_name(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				inpigfoodmedicinerecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, inpigfoodmedicinerecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	


	/**-------------添加信息-----------------------**/
	public String add()throws Exception
	{
	inpigfoodmedicineList=inpigfoodmedicineService.findAll();
		return "add";
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAdd()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		InPigFoodMedicineRecord inPigFoodMedicineRecord=new InPigFoodMedicineRecord();
			String createTime=httpServletRequest.getParameter("createTime");
			Date date=fomt.parse(createTime);
			String count=httpServletRequest.getParameter("count");
			String buy_name=httpServletRequest.getParameter("buy_name");
			
			String ids=httpServletRequest.getParameter("name");
			inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(ids));
			inPigFoodMedicineRecord.setCreateTime(date);
			inPigFoodMedicineRecord.setCount(count);
			inPigFoodMedicineRecord.setBuy_name(buy_name);
			inPigFoodMedicineRecord.setInPigFoodMedicine(inpigfoodmedicine);
			inPigFoodMedicineRecord.setEnterpriseDI(user.getEnterprise().getEnterpriseID());
			inPigFoodMedicineRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			inpigfoodmedicinerecordService.save(inPigFoodMedicineRecord);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Search s=new Search(InPigFoodMedicine.class);
		s.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		inpigfoodmedicineList=inpigfoodmedicineService.searchAll(s);
		String id=httpServletRequest.getParameter("ouc");
		inpigfoodmedicinerecord=inpigfoodmedicinerecordService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String ipigFoodMedicineID=httpServletRequest.getParameter("ipigFoodMedicineID");
		InPigFoodMedicineRecord inPigFoodMedicineRecord=inpigfoodmedicinerecordService.findById(Long.parseLong(ipigFoodMedicineID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String createTime=httpServletRequest.getParameter("createTime");
			Date date=fomt.parse(createTime);
			String count=httpServletRequest.getParameter("count");
			String buy_name=httpServletRequest.getParameter("buy_name");
			
			String ids=httpServletRequest.getParameter("name");
			inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(ids));
			inPigFoodMedicineRecord.setCreateTime(date);
			inPigFoodMedicineRecord.setCount(count);
			inPigFoodMedicineRecord.setBuy_name(buy_name);
			inPigFoodMedicineRecord.setInPigFoodMedicine(inpigfoodmedicine);
			inPigFoodMedicineRecord.setEnterpriseDI(user.getEnterprise().getEnterpriseID());
			inPigFoodMedicineRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			inpigfoodmedicinerecordService.save(inPigFoodMedicineRecord);
		
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
			inpigfoodmedicinerecord=inpigfoodmedicinerecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			inpigfoodmedicinerecordList.add(inpigfoodmedicinerecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("inpigfoodmedicinerecordList", inpigfoodmedicinerecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "inpigfoodmedicinerecord.ftl";//销售记录ftl模板
		String docfilename =  "inpigfoodmedicinerecord.doc";
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