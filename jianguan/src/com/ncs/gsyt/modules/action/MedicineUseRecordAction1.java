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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.InFoodMedicineService;
import com.ncs.gsyt.modules.service.MedicineUseRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class MedicineUseRecordAction1 extends BaseAction implements ModelDriven<MedicineUseRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private MedicineUseRecordService medicineuserecordService;
	
	private MedicineUseRecord medicineuserecord = new MedicineUseRecord();
	
	@Resource
	private InFoodMedicineService inFoodMedicineService;//
	private List<MedicineUseRecord> medicineUseRecordList=new ArrayList<MedicineUseRecord>();
	public List<MedicineUseRecord> getMedicineUseRecordList() {
		return medicineUseRecordList;
	}

	public void setMedicineUseRecordList(
			List<MedicineUseRecord> medicineUseRecordList) {
		this.medicineUseRecordList = medicineUseRecordList;
	}
	private InFoodMedicine inFoodMedicine=new InFoodMedicine();
	
	public InFoodMedicine getInFoodMedicine() {
		return inFoodMedicine;
	}

	public void setInFoodMedicine(InFoodMedicine inFoodMedicine) {
		this.inFoodMedicine = inFoodMedicine;
	}
	private List<InFoodMedicine> inFoodMedicineList=new ArrayList<InFoodMedicine>();//
	
	public List<InFoodMedicine> getInFoodMedicineList() {
		return inFoodMedicineList;
	}

	public void setInFoodMedicineList(List<InFoodMedicine> inFoodMedicineList) {
		this.inFoodMedicineList = inFoodMedicineList;
	}
	private Enterprise enterprise=new Enterprise();
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	
	
	public MedicineUseRecord getMedicineuserecord() {
		return medicineuserecord;
	}

	public void setMedicineuserecord(MedicineUseRecord medicineuserecord) {
		this.medicineuserecord = medicineuserecord;
	}

	@Override
	public MedicineUseRecord getModel() {
		return medicineuserecord;
	}
	
	@Action(value = "/medicineuserecord1", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/medicineuserecordlist1.jsp"),
			@Result(name = "add", location = "/admin/poultry/addMedicineUseRecord.jsp"),
			@Result(name = "modify", location = "/admin/poultry/modifyMedicineUseRecord.jsp")
	})
	
	@Override
	public String execute() {
		

		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		 medicineuserecord = new  MedicineUseRecord();
		 medicineuserecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(MedicineUseRecord.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", enterpriseID);
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("use_time",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("use_time", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("use_time",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String mf_name=StringUtil.isNull(httpServletRequest.getParameter("mf_name"));
	if (!"".equals(mf_name)) {
		search.addFilterILike("mf_name","%"+mf_name+"%");
	}


		int count = medicineuserecordService.count(search);
		List<MedicineUseRecord> list = medicineuserecordService.searchAll(search);
		List<Map<String, Object>> medicineuserecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				MedicineUseRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getUseMedicineID());
				row.put("cell",
						new Object[] { obj.getUseMedicineID(),null!=obj.getInFoodMedicine()?obj.getInFoodMedicine().getMf_name():"",
								obj.getUse_name(),DateUtil.formatDate(obj.getUse_time(), "yyyy-MM-dd"),obj.getUse_count(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				medicineuserecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, medicineuserecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**----------添加--------------------**/
	public String addMedicineR()throws Exception
	{

		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Enterprise enterprise=user.getEnterprise();
		Search search=new Search(InFoodMedicine.class);
		search.addFilterEqual("enterprise", enterprise);
		inFoodMedicineList=inFoodMedicineService.searchAll(search);
		
		return "add";
	}
	
	/**---------保存添加的-------------------------**/
	public String saveAddMedicineR()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		long enterpriseID=user.getEnterprise().getEnterpriseID();
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		
		String use_name=httpServletRequest.getParameter("use_name");
		String use_time=httpServletRequest.getParameter("use_time");
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=formt.parse(use_time);
		
		String use_count=httpServletRequest.getParameter("use_count");
		
		String ids=httpServletRequest.getParameter("mf_name");
		inFoodMedicine=inFoodMedicineService.findById(Long.parseLong(ids));
		
		MedicineUseRecord medicineUseRecord=new MedicineUseRecord();
		medicineUseRecord.setEnterpriseID(enterpriseID);
		medicineUseRecord.setEnterpriseName(enterpriseName);
		medicineUseRecord.setUse_name(use_name);
		medicineUseRecord.setUse_time(date);
		medicineUseRecord.setUse_count(use_count);
		medicineUseRecord.setInFoodMedicine(inFoodMedicine);
		medicineuserecordService.save(medicineUseRecord);
		
		
		return SUCCESS;
		
	}
	/**-----------修改--------------------------------**/

	public String modifyMedicine()throws Exception
	{
		
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		Search search=new Search(InFoodMedicine.class);
		search.addFilterEqual("enterprise", enterprise);
		inFoodMedicineList=inFoodMedicineService.searchAll(search);
		/**--------------------------------------------------------------**/
		String ids=httpServletRequest.getParameter("ouc");
		medicineuserecord=medicineuserecordService.findById(Long.parseLong(ids));
		return "modify";
	}
	
	public String saveModifyMedicine()throws Exception
	{
		String id=httpServletRequest.getParameter("useMedicineID");
		MedicineUseRecord medicineUseRecord=medicineuserecordService.findById(Long.parseLong(id));
		
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		long enterpriseID=user.getEnterprise().getEnterpriseID();//
		String enterpriseName=user.getEnterprise().getEnterpriseName();//
		
		String use_name=httpServletRequest.getParameter("use_name");//
		String use_time=httpServletRequest.getParameter("use_time");//
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=formt.parse(use_time);
		
		String use_count=httpServletRequest.getParameter("use_count");//
		
		String ids=httpServletRequest.getParameter("mf_name");//
		inFoodMedicine=inFoodMedicineService.findById(Long.parseLong(ids));//
		
		
		medicineUseRecord.setEnterpriseID(enterpriseID);
		medicineUseRecord.setEnterpriseName(enterpriseName);
		medicineUseRecord.setUse_name(use_name);
		medicineUseRecord.setUse_time(date);
		medicineUseRecord.setUse_count(use_count);
		medicineUseRecord.setInFoodMedicine(inFoodMedicine);
		medicineuserecordService.save(medicineUseRecord);
		
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
			medicineuserecord=medicineuserecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			medicineUseRecordList.add(medicineuserecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("medicineUseRecordList", medicineUseRecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "medicineuserecord.ftl";//销售记录ftl模板
		String docfilename =  "medicineuserecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("兽药使用记录.doc","UTF-8"));
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