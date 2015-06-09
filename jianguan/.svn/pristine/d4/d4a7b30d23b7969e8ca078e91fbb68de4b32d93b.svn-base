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
import com.ncs.gsyt.modules.model.DisinfectionRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.DisinfectionRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class DisinfectionRecordAction1 extends BaseAction implements ModelDriven<DisinfectionRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private DisinfectionRecordService disinfectionrecordService;
	
private List<DisinfectionRecord> disinfectionRecordList=new ArrayList<DisinfectionRecord>();
	
	
	public List<DisinfectionRecord> getDisinfectionRecordList() {
		return disinfectionRecordList;
	}

	public void setDisinfectionRecordList(
			List<DisinfectionRecord> disinfectionRecordList) {
		this.disinfectionRecordList = disinfectionRecordList;
	}
	
	private DisinfectionRecord disinfectionrecord = new DisinfectionRecord();
	
	
	
	public DisinfectionRecord getDisinfectionrecord() {
		return disinfectionrecord;
	}

	public void setDisinfectionrecord(DisinfectionRecord disinfectionrecord) {
		this.disinfectionrecord = disinfectionrecord;
	}

	@Override
	public DisinfectionRecord getModel() {
		return disinfectionrecord;
	}
	
	@Action(value = "/disinfectionrecord1", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/disinfectionrecordlist1.jsp"),
			@Result(name = "adddisin", location = "/admin/poultry/addDisinfectionRecord.jsp"),
			@Result(name = "modifyfood", location = "/admin/poultry/modifyDisinfectionRecord.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		 disinfectionrecord = new DisinfectionRecord();
		 disinfectionrecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(DisinfectionRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterprise.enterpriseID", enterpriseID);
		/*根据前台条件生成对应属性判断条件*/
		
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("createtime",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createtime", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("createtime",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String proDisinf=StringUtil.isNull(httpServletRequest.getParameter("proDisinf"));
	if (!"".equals(proDisinf)) {
		search.addFilterILike("proDisinf","%"+proDisinf+"%");
	}

		int count = disinfectionrecordService.count(search);
		List<DisinfectionRecord> list = disinfectionrecordService.searchAll(search);
		List<Map<String, Object>> disinfectionrecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				DisinfectionRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getDisinfectionID());
				row.put("cell",
						new Object[] { obj.getDisinfectionID(),DateUtil.formatDate(obj.getCreatetime(), "yyyy-MM-dd"),obj.getScope(),obj.getMetho(),obj.getDisinf_name()
						,obj.getProFactory(),DateUtil.formatDate(obj.getPro_time(), "yyyy-MM-dd"),DateUtil.formatDate(obj.getLastTime(), "yyyy-MM-dd"),obj.getDisinf_name(),null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName()
								:""});//其他属性需按页面需要填写
				disinfectionrecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, disinfectionrecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**-----------------------添加--------------------------------------**/
	public String addDisin()throws Exception
	{
		return "adddisin";
	}
	/**--------------------保存添加的------------------------------------**/
	public String saveAddDisin()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String createtime=httpServletRequest.getParameter("createtime");
		Date date=formt.parse(createtime);
		
		String scope=httpServletRequest.getParameter("scope");
		String metho=httpServletRequest.getParameter("metho");
		String proDisinf=httpServletRequest.getParameter("proDisinf");
		String proFactory=httpServletRequest.getParameter("proFactory");
		String pro_time=httpServletRequest.getParameter("pro_time");
		Date date1=formt.parse(pro_time);
		
		String lastTime=httpServletRequest.getParameter("lastTime");
		Date date2=formt.parse(lastTime);
		
		String disinf_name=httpServletRequest.getParameter("disinf_name");
		DisinfectionRecord disinfectionRecord=new DisinfectionRecord();
		disinfectionRecord.setCreatetime(date);
		disinfectionRecord.setScope(scope);
		disinfectionRecord.setMetho(metho);
		disinfectionRecord.setProDisinf(proDisinf);
		disinfectionRecord.setProFactory(proFactory);
		disinfectionRecord.setPro_time(date1);
		disinfectionRecord.setLastTime(date2);
		disinfectionRecord.setEnterprise(enterprise);
		disinfectionRecord.setDisinf_name(disinf_name);
		disinfectionrecordService.save(disinfectionRecord);
		
		return SUCCESS;
	}
	/**-----------------------修改----------------------------------------**/
	public String modifyDisin()throws Exception
	{
		String ids=httpServletRequest.getParameter("ouc");
		disinfectionrecord=disinfectionrecordService.findById(Long.parseLong(ids));
		
		return "modifyfood";
		
	}
	/*************************保存修改的*************************************/
	public String  saveModifyDisin()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		//参数
		String ids=httpServletRequest.getParameter("disinfectionID");
		DisinfectionRecord disinfectionRecord=disinfectionrecordService.findById(Long.parseLong(ids));
		
		
SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String createtime=httpServletRequest.getParameter("createtime");
		Date date=formt.parse(createtime);
		
		String scope=httpServletRequest.getParameter("scope");
		String metho=httpServletRequest.getParameter("metho");
		String proDisinf=httpServletRequest.getParameter("proDisinf");
		String proFactory=httpServletRequest.getParameter("proFactory");
		String pro_time=httpServletRequest.getParameter("pro_time");
		Date date1=formt.parse(pro_time);
		
		String lastTime=httpServletRequest.getParameter("lastTime");
		Date date2=formt.parse(lastTime);
		
		String disinf_name=httpServletRequest.getParameter("disinf_name");
	
		disinfectionRecord.setCreatetime(date);
		disinfectionRecord.setScope(scope);
		disinfectionRecord.setMetho(metho);
		disinfectionRecord.setProDisinf(proDisinf);
		disinfectionRecord.setProFactory(proFactory);
		disinfectionRecord.setPro_time(date1);
		disinfectionRecord.setLastTime(date2);
		disinfectionRecord.setEnterprise(enterprise);
		disinfectionRecord.setDisinf_name(disinf_name);
		disinfectionrecordService.save(disinfectionRecord);
		
		
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
			disinfectionrecord=disinfectionrecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			disinfectionRecordList.add(disinfectionrecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("disinfectionRecordList", disinfectionRecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "disinfectionrecord.ftl";//销售记录ftl模板
		String docfilename =  "disinfectionrecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("防疫消毒记录.doc","UTF-8"));
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