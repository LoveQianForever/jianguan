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
import com.ncs.gsyt.modules.model.XuShuiChiClear;
import com.ncs.gsyt.modules.service.InPigFoodMedicineService;
import com.ncs.gsyt.modules.service.PigMedicineUseRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class PigMedicineUseRecordAction1 extends BaseAction implements ModelDriven<PigMedicineUseRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private PigMedicineUseRecordService pigmedicineuserecordService;
	
	@Resource
	private InPigFoodMedicineService inpigfoodmedicineService;//投入品对象
	
	private List<PigMedicineUseRecord>  pigmedicineuserecordList=new ArrayList<PigMedicineUseRecord>();
	public List<PigMedicineUseRecord> getPigmedicineuserecordList() {
		return pigmedicineuserecordList;
	}

	public void setPigmedicineuserecordList(
			List<PigMedicineUseRecord> pigmedicineuserecordList) {
		this.pigmedicineuserecordList = pigmedicineuserecordList;
	}



	private InPigFoodMedicine inpigfoodmedicine=new InPigFoodMedicine();
	public InPigFoodMedicine getInpigfoodmedicine() {
		return inpigfoodmedicine;
	}

	public void setInpigfoodmedicine(InPigFoodMedicine inpigfoodmedicine) {
		this.inpigfoodmedicine = inpigfoodmedicine;
	}



	private List<InPigFoodMedicine> inpigfoodmedicineList=new ArrayList<InPigFoodMedicine>();
	public List<InPigFoodMedicine> getInpigfoodmedicineList() {
		return inpigfoodmedicineList;
	}

	public void setInpigfoodmedicineList(
			List<InPigFoodMedicine> inpigfoodmedicineList) {
		this.inpigfoodmedicineList = inpigfoodmedicineList;
	}



	private PigMedicineUseRecord pigmedicineuserecord = new PigMedicineUseRecord();
	
	public PigMedicineUseRecord getPigmedicineuserecord() {
		return pigmedicineuserecord;
	}

	public void setPigmedicineuserecord(PigMedicineUseRecord pigmedicineuserecord) {
		this.pigmedicineuserecord = pigmedicineuserecord;
	}

	public PigMedicineUseRecord getPigMedicineUseRecord() {
		return pigmedicineuserecord;
	}
	
	@Override
	public PigMedicineUseRecord getModel() {
		return pigmedicineuserecord;
	}
	
	@Action(value = "/pigmedicineuserecord1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/pigmedicineuserecordlist1.jsp"),
			@Result(name = "add", location = "/admin/pig/addpigmedicineuserecord.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifypigmedicineuserecord.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		pigmedicineuserecord=new PigMedicineUseRecord();
		pigmedicineuserecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		
		Search search = new Search(PigMedicineUseRecord.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseDI", enterpriseID);
		
		/*根据前台条件生成对应属性判断条件*/
		
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("useDate",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("useDate", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("useDate",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String use_Object=StringUtil.isNull(httpServletRequest.getParameter("use_Object"));
	if (!"".equals(use_Object)) {
		search.addFilterILike("use_Object","%"+use_Object+"%");
	}

		int count = pigmedicineuserecordService.count(search);
		List<PigMedicineUseRecord> list = pigmedicineuserecordService.searchAll(search);
		List<Map<String, Object>> pigmedicineuserecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				PigMedicineUseRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPigMedicineUseID());
				row.put("cell",
						new Object[] { obj.getPigMedicineUseID(),obj.getInPigFoodMedicine().getName(),DateUtil.formatDate(obj.getUseDate(), "yyyy-MM-dd"),
						obj.getUse_Object(),obj.getZhengZhuang(),obj.getJiYaoTuJing(),obj.getJiYaocount(),obj.getEffect(),
						obj.getCarry_name(),DateUtil.formatDate(obj.getSleepDate(), "yyyy-MM-dd"),obj.getContent()
						});//其他属性需按页面需要填写
				pigmedicineuserecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, pigmedicineuserecordList);

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
		
		
		PigMedicineUseRecord pigMedicineUseRecord=new PigMedicineUseRecord();//
			String useDate=httpServletRequest.getParameter("useDate");
			Date date=fomt.parse(useDate);
			
			String use_Object=httpServletRequest.getParameter("use_Object");
			String zhengZhuang=httpServletRequest.getParameter("zhengZhuang");
			String jiYaoTuJing=httpServletRequest.getParameter("jiYaoTuJing");
			String jiYaocount=httpServletRequest.getParameter("jiYaocount");
			String effect=httpServletRequest.getParameter("effect");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String sleepDate=httpServletRequest.getParameter("sleepDate");
			Date date1=fomt.parse(sleepDate);
			String content=httpServletRequest.getParameter("content");
			
			String ids=httpServletRequest.getParameter("name");
			inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(ids));
			
			pigMedicineUseRecord.setUseDate(date);
			pigMedicineUseRecord.setUse_Object(use_Object);
			pigMedicineUseRecord.setZhengZhuang(zhengZhuang);
			pigMedicineUseRecord.setJiYaoTuJing(jiYaoTuJing);
			pigMedicineUseRecord.setJiYaocount(jiYaocount);
			pigMedicineUseRecord.setEffect(effect);
			pigMedicineUseRecord.setCarry_name(carry_name);
			pigMedicineUseRecord.setSleepDate(date1);
			pigMedicineUseRecord.setContent(content);
			pigMedicineUseRecord.setInPigFoodMedicine(inpigfoodmedicine);
			pigMedicineUseRecord.setEnterpriseDI(user.getEnterprise().getEnterpriseID());
			pigMedicineUseRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			pigmedicineuserecordService.save(pigMedicineUseRecord);
			
			
			
			 return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		pigmedicineuserecord=pigmedicineuserecordService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String pigMedicineUseID=httpServletRequest.getParameter("pigMedicineUseID");
		PigMedicineUseRecord pigMedicineUseRecord=pigmedicineuserecordService.findById(Long.parseLong(pigMedicineUseID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String useDate=httpServletRequest.getParameter("useDate");
			Date date=fomt.parse(useDate);
			
			String use_Object=httpServletRequest.getParameter("use_Object");
			String zhengZhuang=httpServletRequest.getParameter("zhengZhuang");
			String jiYaoTuJing=httpServletRequest.getParameter("jiYaoTuJing");
			String jiYaocount=httpServletRequest.getParameter("jiYaocount");
			String effect=httpServletRequest.getParameter("effect");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String sleepDate=httpServletRequest.getParameter("sleepDate");
			Date date1=fomt.parse(sleepDate);
			String content=httpServletRequest.getParameter("content");
			
			String ids=httpServletRequest.getParameter("name");
			inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(ids));
			
			pigMedicineUseRecord.setUseDate(date);
			pigMedicineUseRecord.setUse_Object(use_Object);
			pigMedicineUseRecord.setZhengZhuang(zhengZhuang);
			pigMedicineUseRecord.setJiYaoTuJing(jiYaoTuJing);
			pigMedicineUseRecord.setJiYaocount(jiYaocount);
			pigMedicineUseRecord.setEffect(effect);
			pigMedicineUseRecord.setCarry_name(carry_name);
			pigMedicineUseRecord.setSleepDate(date1);
			pigMedicineUseRecord.setContent(content);
			pigMedicineUseRecord.setInPigFoodMedicine(inpigfoodmedicine);
			pigMedicineUseRecord.setEnterpriseDI(user.getEnterprise().getEnterpriseID());
			pigMedicineUseRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			pigmedicineuserecordService.save(pigMedicineUseRecord);
			
		
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
			pigmedicineuserecord=pigmedicineuserecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			pigmedicineuserecordList.add(pigmedicineuserecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("pigmedicineuserecordList", pigmedicineuserecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "pigmedicineuserecord.ftl";//销售记录ftl模板
		String docfilename =  "pigmedicineuserecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("药物使用记录.doc","UTF-8"));
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