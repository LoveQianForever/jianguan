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
import com.ncs.gsyt.modules.model.NongShi;
import com.ncs.gsyt.modules.model.ShengChanBase;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.ShengChanBaseService;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class ShengChanBaseAction extends BaseAction implements ModelDriven<ShengChanBase>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ShengChanBaseService shengchanbaseService;
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



	private ShengChanBase shengchanbase = new ShengChanBase();
	public ShengChanBase getShengchanbase() {
		return shengchanbase;
	}

	public void setShengchanbase(ShengChanBase shengchanbase) {
		this.shengchanbase = shengchanbase;
	}



	private List<ShengChanBase> shengchanbaseList=new ArrayList<ShengChanBase>();
	public List<ShengChanBase> getShengchanbaseList() {
		return shengchanbaseList;
	}

	public void setShengchanbaseList(List<ShengChanBase> shengchanbaseList) {
		this.shengchanbaseList = shengchanbaseList;
	}

	public ShengChanBase getShengChanBase() {
		return shengchanbase;
	}
	
	@Override
	public ShengChanBase getModel() {
		return shengchanbase;
	}
	
	@Action(value = "/shengchanbase", results = {
			@Result(name = SUCCESS, location = "/admin/zhongzhi/shengchanbaselist.jsp"),
			@Result(name = "add", location = "/admin/zhongzhi/addshengchanbase.jsp"),
			@Result(name = "addBatch", location = "/admin/zhongzhi/addBatchshengchanbase.jsp"),//添加批次概念
			@Result(name = "modify", location = "/admin/zhongzhi/modifyshengchanbase.jsp"),
			@Result(name = "modifyBatch", location = "/admin/zhongzhi/modifyBatchshengchanbase.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Search search = new Search(ShengChanBase.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		/*根据前台条件生成对应属性判断条件*/
		//基地地址查询
		String address=StringUtil.isNull(httpServletRequest.getParameter("address"));
		if (!"".equals(address)) {
			search.addFilterILike("address","%"+address+"%");
		}
		//种植方式查询
		String zhongzhiMethod=StringUtil.isNull(httpServletRequest.getParameter("zhongzhiMethod"));
		if (!"".equals(zhongzhiMethod)) {
			search.addFilterILike("zhongzhiMethod","%"+zhongzhiMethod+"%");
		}
		int count = shengchanbaseService.count(search);
		List<ShengChanBase> list = shengchanbaseService.searchAll(search);
		List<Map<String, Object>> shengchanbaseList = new ArrayList<Map<String, Object>>();
		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				ShengChanBase obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				String atta = "<a href=\"javascript:void(0);\" onclick=\"javascript:getForm1("+obj.getBaseID()+");return false;\">田间农事操作记录</a></br>"
						+"<a href=\"javascript:void(0);\" onclick=\"javascript:getForm2("+obj.getBaseID()+");return false;\">农产品质量检测记录</a></br>"
						+"<a href=\"javascript:void(0);\" onclick=\"javascript:getForm3("+obj.getBaseID()+");return false;\">产品销售记录</a></br>";
				row.put("id", obj.getBaseID());
				row.put("cell",
						new Object[] { obj.getBaseID(),obj.getAddress(),obj.getArea(),obj.getTurang(),
						obj.getShuiyuanName(),obj.getHuanjing(),atta,obj.getNoHaiBase(),obj.getCode(),obj.getZhongzhiMethod()
						,obj.getContent()});//其他属性需按页面需要填写
				shengchanbaseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, shengchanbaseList);

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
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		ShengChanBase shengChanBase=new ShengChanBase();
		
			String address=httpServletRequest.getParameter("address");
			
			//溯源：count1等于0情况下
			if(count1!=0)
			{
				//溯源：将批次值，保存到当前记录表里；
				String batchID=httpServletRequest.getParameter("batchID");	
				shengChanBase.setPiCi(batchID);
			}
			
			String area=httpServletRequest.getParameter("area");
			String turang=httpServletRequest.getParameter("turang");
			String shuiyuanName=httpServletRequest.getParameter("shuiyuanName");
			String huanjing=httpServletRequest.getParameter("huanjing");
			String noHaiBase=httpServletRequest.getParameter("noHaiBase");
			String code=httpServletRequest.getParameter("code");
			if(code==null)
			{
				code="";
			}
			String zhongzhiMethod=httpServletRequest.getParameter("zhongzhiMethod");
			String content=httpServletRequest.getParameter("content");
			shengChanBase.setAddress(address);
			shengChanBase.setArea(area);
			shengChanBase.setTurang(turang);
			shengChanBase.setShuiyuanName(shuiyuanName);
			shengChanBase.setHuanjing(huanjing);
			shengChanBase.setNoHaiBase(noHaiBase);
			shengChanBase.setCode(code);
			shengChanBase.setZhongzhiMethod(zhongzhiMethod);
			shengChanBase.setContent(content);
			shengChanBase.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			shengChanBase.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			shengchanbaseService.save(shengChanBase);
			
				
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
		shengchanbase=shengchanbaseService.findById(Long.parseLong(id));
		if(count1==0)
		{
		return "modify";
		}else
		{
			batchList=batchService.searchAll(s1);
			return "modifyBatch";
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
		String baseID=httpServletRequest.getParameter("baseID");
		ShengChanBase shengChanBase=shengchanbaseService.findById(Long.parseLong(baseID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			
String address=httpServletRequest.getParameter("address");
			
if(count1!=0)
{
	//溯源：将批次值，保存到当前记录表里；
	String batchID=httpServletRequest.getParameter("batchID");	
	shengChanBase.setPiCi(batchID);
}

			
			String area=httpServletRequest.getParameter("area");
			String turang=httpServletRequest.getParameter("turang");
			String shuiyuanName=httpServletRequest.getParameter("shuiyuanName");
			String huanjing=httpServletRequest.getParameter("huanjing");
			String noHaiBase=httpServletRequest.getParameter("noHaiBase");
			String code=httpServletRequest.getParameter("code");
			if(code==null)
			{
				code="";
			}
			String zhongzhiMethod=httpServletRequest.getParameter("zhongzhiMethod");
			String content=httpServletRequest.getParameter("content");
			shengChanBase.setAddress(address);
			shengChanBase.setArea(area);
			shengChanBase.setTurang(turang);
			shengChanBase.setShuiyuanName(shuiyuanName);
			shengChanBase.setHuanjing(huanjing);
			shengChanBase.setNoHaiBase(noHaiBase);
			shengChanBase.setCode(code);
			shengChanBase.setZhongzhiMethod(zhongzhiMethod);
			shengChanBase.setContent(content);
			shengChanBase.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			shengChanBase.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			shengchanbaseService.save(shengChanBase);
			
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
			shengchanbase=shengchanbaseService.findById(Long.parseLong(idss[i]));//获取sale记录
			shengchanbaseList.add(shengchanbase);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("shengchanbaseList", shengchanbaseList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "shengchanbase.ftl";//销售记录ftl模板
		String docfilename =  "shengchanbase.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("生产基地信息.doc","UTF-8"));
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