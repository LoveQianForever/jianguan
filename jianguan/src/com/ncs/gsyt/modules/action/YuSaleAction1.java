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
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.model.YuSale;
import com.ncs.gsyt.modules.model.YuSiYang;
import com.ncs.gsyt.modules.service.YuSaleService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class YuSaleAction1 extends BaseAction implements ModelDriven<YuSale>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private YuSaleService yusaleService;
	private List<YuSale>  yusaleList=new ArrayList<YuSale>();
	public List<YuSale> getYusaleList() {
		return yusaleList;
	}

	public void setYusaleList(List<YuSale> yusaleList) {
		this.yusaleList = yusaleList;
	}



	private YuSale yusale = new YuSale();
	
	
	
	public YuSale getYusale() {
		return yusale;
	}

	public void setYusale(YuSale yusale) {
		this.yusale = yusale;
	}

	@Override
	public YuSale getModel() {
		return yusale;
	}
	
	@Action(value = "/yusale1", results = {
			@Result(name = SUCCESS, location = "/admin/yulei/yusalelist1.jsp"),
			@Result(name = "add", location = "/admin/yulei/addyusale.jsp"),
			@Result(name = "modify", location = "/admin/yulei/modifyyusale.jsp")
	})
	
	@Override
	public String execute() {
		
		String idd=httpServletRequest.getParameter("enterpriseID");
		yusale=new YuSale();
		yusale.setIdss(Long.parseLong(idd));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(YuSale.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID",enterpriseID);
		//search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		/*根据前台条件生成对应属性判断条件*/
		//配对日期查询
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
	//品名查询
	String  name=StringUtil.isNull(httpServletRequest.getParameter("name"));
	if (!"".equals(name)) {
		search.addFilterILike("name","%"+name+"%");
	}


		int count = yusaleService.count(search);
		List<YuSale> list = yusaleService.searchAll(search);
		List<Map<String, Object>> yusaleList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				YuSale obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getYusaleID());
				row.put("cell",
						new Object[] { obj.getYusaleID(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),obj.getName(),obj.getCount(),obj.getGuige(),obj.getFromPlace(),
						obj.getJingBanRen(),obj.getContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				yusaleList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, yusaleList);

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
		
		
		YuSale yuSale=new YuSale();
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String name=httpServletRequest.getParameter("name");
			String count=httpServletRequest.getParameter("count");
			String guige=httpServletRequest.getParameter("guige");
			String  fromPlace=httpServletRequest.getParameter("fromPlace");
			String jingBanRen=httpServletRequest.getParameter("jingBanRen");
			String content=httpServletRequest.getParameter("content");
			yuSale.setInput_time(date);
			yuSale.setName(name);
			yuSale.setCount(count);
			yuSale.setGuige(guige);
			yuSale.setFromPlace(fromPlace);
			yuSale.setJingBanRen(jingBanRen);
			yuSale.setContent(content);
			yuSale.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			yuSale.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			yusaleService.save(yuSale);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		yusale=yusaleService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String xiaoduRecordID=httpServletRequest.getParameter("xiaoduRecordID");
		YuSale yuSale=yusaleService.findById(Long.parseLong(xiaoduRecordID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String name=httpServletRequest.getParameter("name");
			String count=httpServletRequest.getParameter("count");
			String guige=httpServletRequest.getParameter("guige");
			String  fromPlace=httpServletRequest.getParameter("fromPlace");
			String jingBanRen=httpServletRequest.getParameter("jingBanRen");
			String content=httpServletRequest.getParameter("content");
			yuSale.setInput_time(date);
			yuSale.setName(name);
			yuSale.setCount(count);
			yuSale.setGuige(guige);
			yuSale.setFromPlace(fromPlace);
			yuSale.setJingBanRen(jingBanRen);
			yuSale.setContent(content);
			yuSale.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			yuSale.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			yusaleService.save(yuSale);
		
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
			yusale=yusaleService.findById(Long.parseLong(idss[i]));//获取sale记录
			yusaleList.add(yusale);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("yusaleList", yusaleList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "yusale.ftl";//销售记录ftl模板
		String docfilename =  "yusale.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("水产销售记录.doc","UTF-8"));
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