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
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.model.YuSiYang;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.YuSiYangService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class YuSiYangAction extends BaseAction implements ModelDriven<YuSiYang>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private YuSiYangService yusiyangService;
	
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



	private List<YuSiYang> yusiyangList=new ArrayList<YuSiYang>();
	
	public List<YuSiYang> getYusiyangList() {
		return yusiyangList;
	}

	public void setYusiyangList(List<YuSiYang> yusiyangList) {
		this.yusiyangList = yusiyangList;
	}



	private YuSiYang yusiyang = new YuSiYang();
	
	public YuSiYang getYusiyang() {
		return yusiyang;
	}

	public void setYusiyang(YuSiYang yusiyang) {
		this.yusiyang = yusiyang;
	}

	public YuSiYang getYuSiYang() {
		return yusiyang;
	}
	
	@Override
	public YuSiYang getModel() {
		return yusiyang;
	}
	
	@Action(value = "/yusiyang", results = {
			@Result(name = SUCCESS, location = "/admin/yulei/yusiyanglist.jsp"),
			@Result(name = "add", location = "/admin/yulei/addyusiyang.jsp"),
			@Result(name = "addBatch", location = "/admin/yulei/addBatchyusiyang.jsp"),//添加批次概念
			@Result(name = "modify", location = "/admin/yulei/modifyyusiyang.jsp"),
			@Result(name = "modifyBatch", location = "/admin/yulei/modifyBatchyusiyang.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/yulei/modifyyusiyang1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/yulei/modifyBatchyusiyang1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Search search = new Search(YuSiYang.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
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

		int count = yusiyangService.count(search);
		List<YuSiYang> list = yusiyangService.searchAll(search);
		List<Map<String, Object>> yusiyangList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				YuSiYang obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getYussiyangID());
				row.put("cell",
						new Object[] { obj.getYussiyangID(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),obj.getWeather(),obj.getWendu(),obj.getPh(),obj.getTizhong(),
						obj.getSiliao_name(),obj.getSiliao_count(),obj.getYuyao_name(),obj.getNongdu(),obj.getYao_method(),obj.getFangzhi_object(),
						obj.getZhengzhuang(),obj.getYu_huodong(),obj.getChufangren(),obj.getCaozuoren(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				yusiyangList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, yusiyangList);

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
		
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		YuSiYang yuSiYang=new YuSiYang();
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			//溯源：count1等于0情况下
			if(count1!=0)
			{
				//溯源：将批次值，保存到当前记录表里；
				String batchID=httpServletRequest.getParameter("batchID");	
				yuSiYang.setPiCi(batchID);
			}
			
			String weather=httpServletRequest.getParameter("weather");
			String wendu=httpServletRequest.getParameter("wendu");
			String ph=httpServletRequest.getParameter("ph");
			String  tizhong=httpServletRequest.getParameter("tizhong");
			String siliao_name=httpServletRequest.getParameter("siliao_name");
			String siliao_count=httpServletRequest.getParameter("siliao_count");
			String yuyao_name=httpServletRequest.getParameter("yuyao_name");
			String  nongdu=httpServletRequest.getParameter("nongdu");
			String yao_method=httpServletRequest.getParameter("yao_method");
			String fangzhi_object=httpServletRequest.getParameter("fangzhi_object");
			String zhengzhuang=httpServletRequest.getParameter("zhengzhuang");
			String  yu_huodong=httpServletRequest.getParameter("yu_huodong");
			String chufangren=httpServletRequest.getParameter("chufangren");
			String caozuoren=httpServletRequest.getParameter("caozuoren");
			yuSiYang.setInput_time(date);
			yuSiYang.setWeather(weather);
			yuSiYang.setWendu(wendu);
			yuSiYang.setPh(ph);
			yuSiYang.setTizhong(tizhong);
			yuSiYang.setSiliao_name(siliao_name);
			yuSiYang.setSiliao_count(siliao_count);
			yuSiYang.setYuyao_name(yuyao_name);
			yuSiYang.setNongdu(nongdu);
			yuSiYang.setYao_method(yao_method);
			yuSiYang.setFangzhi_object(fangzhi_object);
			yuSiYang.setZhengzhuang(zhengzhuang);
			yuSiYang.setYu_huodong(yu_huodong);
			yuSiYang.setChufangren(chufangren);
			yuSiYang.setCaozuoren(caozuoren);
			yuSiYang.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			yuSiYang.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			yusiyangService.save(yuSiYang);
			
			
			
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
		yusiyang=yusiyangService.findById(Long.parseLong(id));
		
		Date curren=new Date();
		Date date=yusiyang.getInput_time();
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
		String yussiyangID=httpServletRequest.getParameter("yussiyangID");
		YuSiYang yuSiYang=yusiyangService.findById(Long.parseLong(yussiyangID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String input_time=httpServletRequest.getParameter("input_time");
			Date date=fomt.parse(input_time);
			
			
			//溯源：count1等于0情况下
			if(count1!=0)
			{
				//溯源：将批次值，保存到当前记录表里；
				String batchID=httpServletRequest.getParameter("batchID");	
				yuSiYang.setPiCi(batchID);
			}
			String weather=httpServletRequest.getParameter("weather");
			String wendu=httpServletRequest.getParameter("wendu");
			String ph=httpServletRequest.getParameter("ph");
			String  tizhong=httpServletRequest.getParameter("tizhong");
			String siliao_name=httpServletRequest.getParameter("siliao_name");
			String siliao_count=httpServletRequest.getParameter("siliao_count");
			String yuyao_name=httpServletRequest.getParameter("yuyao_name");
			String  nongdu=httpServletRequest.getParameter("nongdu");
			String yao_method=httpServletRequest.getParameter("yao_method");
			String fangzhi_object=httpServletRequest.getParameter("fangzhi_object");
			String zhengzhuang=httpServletRequest.getParameter("zhengzhuang");
			String  yu_huodong=httpServletRequest.getParameter("yu_huodong");
			String chufangren=httpServletRequest.getParameter("chufangren");
			String caozuoren=httpServletRequest.getParameter("caozuoren");
			yuSiYang.setInput_time(date);
			yuSiYang.setWeather(weather);
			yuSiYang.setWendu(wendu);
			yuSiYang.setPh(ph);
			yuSiYang.setTizhong(tizhong);
			yuSiYang.setSiliao_name(siliao_name);
			yuSiYang.setSiliao_count(siliao_count);
			yuSiYang.setYuyao_name(yuyao_name);
			yuSiYang.setNongdu(nongdu);
			yuSiYang.setYao_method(yao_method);
			yuSiYang.setFangzhi_object(fangzhi_object);
			yuSiYang.setZhengzhuang(zhengzhuang);
			yuSiYang.setYu_huodong(yu_huodong);
			yuSiYang.setChufangren(chufangren);
			yuSiYang.setCaozuoren(caozuoren);
			yuSiYang.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			yuSiYang.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			yusiyangService.save(yuSiYang);
		
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
			yusiyang=yusiyangService.findById(Long.parseLong(idss[i]));//获取sale记录
			yusiyangList.add(yusiyang);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("yusiyangList", yusiyangList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "yusiyang.ftl";//销售记录ftl模板
		String docfilename =  "yusiyang.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("渔业生产操作记录.doc","UTF-8"));
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