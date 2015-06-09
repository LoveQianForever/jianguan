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
import com.ncs.gsyt.modules.model.CaiGou;
import com.ncs.gsyt.modules.model.NongShi;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.ZhiLiang;
import com.ncs.gsyt.modules.service.NongShiService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class NongShiAction1 extends BaseAction implements ModelDriven<NongShi>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private NongShiService nongshiService;
	
	private NongShi nongshi = new NongShi();
	
	public NongShi getNongshi() {
		return nongshi;
	}

	public void setNongshi(NongShi nongshi) {
		this.nongshi = nongshi;
	}

	public NongShi getNongShi() {
		return nongshi;
	}
	
	private List<NongShi> nongshiList=new ArrayList<NongShi>();
	public List<NongShi> getNongshiList() {
		return nongshiList;
	}

	public void setNongshiList(List<NongShi> nongshiList) {
		this.nongshiList = nongshiList;
	}

	@Override
	public NongShi getModel() {
		return nongshi;
	}
	
	@Action(value = "/nongshi1", results = {
			@Result(name = SUCCESS, location = "/admin/zhongzhi/nongshilist1.jsp"),
			@Result(name = "add", location = "/admin/zhongzhi/addnongshi.jsp"),
			@Result(name = "modify", location = "/admin/zhongzhi/modifynongshi.jsp")
	})
	
	@Override
	public String execute() {
		
		String enterpriseID=httpServletRequest.getParameter("baseID");
		nongshi=new NongShi();
		nongshi.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(NongShi.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", enterpriseID);
		//search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
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
	String name=StringUtil.isNull(httpServletRequest.getParameter("name"));
	if (!"".equals(name)) {
		search.addFilterILike("name","%"+name+"%");
	}

		int count = nongshiService.count(search);
		List<NongShi> list = nongshiService.searchAll(search);
		List<Map<String, Object>> nongshiList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				NongShi obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getNongShiID());
				row.put("cell",
						new Object[] { obj.getNongShiID(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),obj.getCode(),obj.getName(),
						obj.getArea(),obj.getContent(),obj.getTouruPin(),obj.getCount(),obj.getTianQi(),
						obj.getJiLuRen(),obj.getSimpleContent(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				nongshiList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, nongshiList);

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
		
		
		NongShi nongShi=new NongShi();
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String code=httpServletRequest.getParameter("code");
			String name=httpServletRequest.getParameter("name");
			String area=httpServletRequest.getParameter("area");
			String content=httpServletRequest.getParameter("content");
			String touruPin=httpServletRequest.getParameter("touruPin");
			String count=httpServletRequest.getParameter("count");
			String tianQi=httpServletRequest.getParameter("tianQi");
			String jiLuRen=httpServletRequest.getParameter("jiLuRen");
			String simpleContent=httpServletRequest.getParameter("simpleContent");
			nongShi.setInput_time(date);
			nongShi.setCode(code);
			nongShi.setName(name);
			nongShi.setArea(area);
			nongShi.setContent(content);
			nongShi.setTouruPin(touruPin);
			nongShi.setCount(count);
			nongShi.setTianQi(tianQi);
			nongShi.setJiLuRen(jiLuRen);
			nongShi.setSimpleContent(simpleContent);
			nongShi.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			nongShi.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			nongshiService.save(nongShi);
				
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		nongshi=nongshiService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String nongShiID=httpServletRequest.getParameter("nongShiID");
		NongShi nongShi=nongshiService.findById(Long.parseLong(nongShiID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			String code=httpServletRequest.getParameter("code");
			String name=httpServletRequest.getParameter("name");
			String area=httpServletRequest.getParameter("area");
			String content=httpServletRequest.getParameter("content");
			String touruPin=httpServletRequest.getParameter("touruPin");
			String count=httpServletRequest.getParameter("count");
			String tianQi=httpServletRequest.getParameter("tianQi");
			String jiLuRen=httpServletRequest.getParameter("jiLuRen");
			String simpleContent=httpServletRequest.getParameter("simpleContent");
			nongShi.setInput_time(date);
			nongShi.setCode(code);
			nongShi.setName(name);
			nongShi.setArea(area);
			nongShi.setContent(content);
			nongShi.setTouruPin(touruPin);
			nongShi.setCount(count);
			nongShi.setTianQi(tianQi);
			nongShi.setJiLuRen(jiLuRen);
			nongShi.setSimpleContent(simpleContent);
			nongShi.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			nongShi.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			nongshiService.save(nongShi);
				
			
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
			nongshi=nongshiService.findById(Long.parseLong(idss[i]));//获取sale记录
			nongshiList.add(nongshi);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("nongshiList", nongshiList);
	//	datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "nongshi.ftl";//销售记录ftl模板
		String docfilename =  "nongshi.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("农事操作记录.doc","UTF-8"));
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