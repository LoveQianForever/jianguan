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
import com.ncs.gsyt.modules.model.NoHaiDealRecord;
import com.ncs.gsyt.modules.model.PigSaleRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.PigSaleRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class PigSaleRecordAction1 extends BaseAction implements ModelDriven<PigSaleRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private PigSaleRecordService pigsalerecordService;
	
	private List<PigSaleRecord> pigsalerecordList= new ArrayList<PigSaleRecord>();
	public List<PigSaleRecord> getPigsalerecordList() {
		return pigsalerecordList;
	}

	public void setPigsalerecordList(List<PigSaleRecord> pigsalerecordList) {
		this.pigsalerecordList = pigsalerecordList;
	}



	private PigSaleRecord pigsalerecord = new PigSaleRecord();
	
	public PigSaleRecord getPigsalerecord() {
		return pigsalerecord;
	}

	public void setPigsalerecord(PigSaleRecord pigsalerecord) {
		this.pigsalerecord = pigsalerecord;
	}

	public PigSaleRecord getPigSaleRecord() {
		return pigsalerecord;
	}
	
	@Override
	public PigSaleRecord getModel() {
		return pigsalerecord;
	}
	
	@Action(value = "/pigsalerecord1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/pigsalerecordlist1.jsp"),
			@Result(name = "add", location = "/admin/pig/addpigsalerecord.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifypigsalerecord.jsp")
	})
	
	@Override
	public String execute() {
		
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		pigsalerecord=new PigSaleRecord();
		pigsalerecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(PigSaleRecord.class);
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
		search.addFilterGreaterOrEqual("saleDate",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("saleDate", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("saleDate",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String  count1=StringUtil.isNull(httpServletRequest.getParameter("count"));
	if (!"".equals( count1)) {
		search.addFilterILike("count","%"+Integer.parseInt(count1)+"%");
	}

		int count = pigsalerecordService.count(search);
		List<PigSaleRecord> list = pigsalerecordService.searchAll(search);
		List<Map<String, Object>> pigsalerecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				PigSaleRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPigSaleID());
				row.put("cell",
						new Object[] { obj.getPigSaleID(),DateUtil.formatDate(obj.getSaleDate(), "yyyy-MM-dd"),obj.getLeiBie(),obj.getCount(),
						obj.getErBiao(),obj.getSinglePrice(),obj.getWeight(),obj.getSalePlace(),obj.getCarry_name(),
						obj.getContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				pigsalerecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, pigsalerecordList);

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
		
		
		PigSaleRecord pigSaleRecord=new PigSaleRecord();
			String saleDate=httpServletRequest.getParameter("saleDate");
			Date date=fomt.parse(saleDate);
			
			String leiBie=httpServletRequest.getParameter("leiBie");
			String count=httpServletRequest.getParameter("count");
			String erBiao=httpServletRequest.getParameter("erBiao");
			String singlePrice=httpServletRequest.getParameter("singlePrice");
			String weight=httpServletRequest.getParameter("weight");
			
			String salePlace=httpServletRequest.getParameter("salePlace");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			pigSaleRecord.setSaleDate(date);
			pigSaleRecord.setLeiBie(leiBie);
			pigSaleRecord.setCount(Integer.parseInt(count));
			pigSaleRecord.setErBiao(erBiao);
			pigSaleRecord.setSinglePrice(singlePrice);
			pigSaleRecord.setWeight(weight);
			pigSaleRecord.setSalePlace(salePlace);
			pigSaleRecord.setCarry_name(carry_name);
			pigSaleRecord.setContent(content);
			pigSaleRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			pigSaleRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			pigsalerecordService.save(pigSaleRecord);
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		pigsalerecord=pigsalerecordService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String pigSaleID=httpServletRequest.getParameter("pigSaleID");
		PigSaleRecord pigSaleRecord=pigsalerecordService.findById(Long.parseLong(pigSaleID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String saleDate=httpServletRequest.getParameter("saleDate");
			Date date=fomt.parse(saleDate);
			
			String leiBie=httpServletRequest.getParameter("leiBie");
			String count=httpServletRequest.getParameter("count");
			String erBiao=httpServletRequest.getParameter("erBiao");
			String singlePrice=httpServletRequest.getParameter("singlePrice");
			String weight=httpServletRequest.getParameter("weight");
			
			String salePlace=httpServletRequest.getParameter("salePlace");
			String carry_name=httpServletRequest.getParameter("carry_name");
			String content=httpServletRequest.getParameter("content");
			
			pigSaleRecord.setSaleDate(date);
			pigSaleRecord.setLeiBie(leiBie);
			pigSaleRecord.setCount(Integer.parseInt(count));
			pigSaleRecord.setErBiao(erBiao);
			pigSaleRecord.setSinglePrice(singlePrice);
			pigSaleRecord.setWeight(weight);
			pigSaleRecord.setSalePlace(salePlace);
			pigSaleRecord.setCarry_name(carry_name);
			pigSaleRecord.setContent(content);
			pigSaleRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			pigSaleRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			pigsalerecordService.save(pigSaleRecord);
		
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
			pigsalerecord=pigsalerecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			pigsalerecordList.add(pigsalerecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("pigsalerecordList", pigsalerecordList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "pigsalerecord.ftl";//销售记录ftl模板
		String docfilename =  "pigsalerecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("销售记录.doc","UTF-8"));
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