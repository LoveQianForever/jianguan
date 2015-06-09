package com.ncs.gsyt.modules.action;

import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.PoultryKinds;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.PoultryKindsService;
import com.ncs.gsyt.modules.service.SaleRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SaleRecordAction extends BaseAction implements ModelDriven<SaleRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SaleRecordService salerecordService;
	
	
	private SaleRecord salerecord = new SaleRecord();
	
	@Resource
	private PoultryKindsService poultrykindsService;//品种
	@Resource
	private BatchService batchService;//品种
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

	private List<SaleRecord>  saleRecordList=new ArrayList<SaleRecord>();
	public List<SaleRecord> getSaleRecordList() {
		return saleRecordList;
	}

	public void setSaleRecordList(List<SaleRecord> saleRecordList) {
		this.saleRecordList = saleRecordList;
	}

	private List<PoultryKinds> poultryKindsList=new ArrayList<PoultryKinds>();
	public List<PoultryKinds> getPoultryKindsList() {
		return poultryKindsList;
	}

	public void setPoultryKindsList(List<PoultryKinds> poultryKindsList) {
		this.poultryKindsList = poultryKindsList;
	}

	private PoultryKinds poultryKinds=new PoultryKinds();//品种
	
	public PoultryKinds getPoultryKinds() {
		return poultryKinds;
	}

	public void setPoultryKinds(PoultryKinds poultryKinds) {
		this.poultryKinds = poultryKinds;
	}
	
	
	
	public SaleRecord getSalerecord() {
		return salerecord;
	}

	public void setSalerecord(SaleRecord salerecord) {
		this.salerecord = salerecord;
	}

	@Override
	public SaleRecord getModel() {
		return salerecord;
	}
	
	@Action(value = "/salerecord", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/salerecordlist.jsp"),
			@Result(name = "addSale", location = "/admin/poultry/addSaleRecord.jsp"),
			@Result(name = "addBatchSale", location = "/admin/poultry/addBatchSaleRecord.jsp"),//添加批次概念
			@Result(name = "modifySale", location = "/admin/poultry/modifySaleRecord.jsp"),
			@Result(name = "modifyBatchSale", location = "/admin/poultry/modifyBatchSaleRecord.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/poultry/modifySaleRecord1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/poultry/modifyBatchSaleRecord1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		Search search = new Search(SaleRecord.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", enterprise.getEnterpriseID());
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("sale_time",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("sale_time", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("sale_time",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String poultryName=StringUtil.isNull(httpServletRequest.getParameter("poultryName"));
	if (!"".equals(poultryName)) {
		search.addFilterILike("poultryKinds.poultryName","%"+poultryName+"%");
	}
		

		int count = salerecordService.count(search);
		List<SaleRecord> list = salerecordService.searchAll(search);
		List<Map<String, Object>> salerecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				SaleRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getSaleID());
				row.put("cell",
						new Object[] { obj.getSaleID(),DateUtil.formatDate(obj.getSale_time(),"yyyy-MM-dd"),null!=obj.getPoultryKinds()?obj.getPoultryKinds().getPoultryName():"",obj.getCount(),
						obj.getSalePlace(),obj.getBuyName(),obj.getBuyTelephone(),obj.getCheckout(),obj.getCheckName(),obj.getCheckCode(),obj.getEnterpriseName()});//其他属性需按页面需要填写
				salerecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, salerecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	

	/**-----------------------添加--------------------------------------**/
	public String addSale()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		
		Enterprise enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		poultryKindsList=poultrykindsService.searchAll(search);
		
		if(count1==0)
		{
		return "addSale";
		}
		else
		{
			batchList=batchService.searchAll(s1);
			return "addBatchSale";
		}
	}
	/**--------------------保存添加的------------------------------------**/
	public String saveAddSale()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		long enterpriseID=user.getEnterprise().getEnterpriseID();//企业ID
		String enterpriseName=user.getEnterprise().getEnterpriseName();//企业名字
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String id=httpServletRequest.getParameter("poultryName");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));//得到 家禽品种  结合
		
		
		String sale_time=httpServletRequest.getParameter("sale_time");
		String[] saleTime=sale_time.split("-");
		
		Date date=formt.parse(sale_time);//售出时间

		
		String count=httpServletRequest.getParameter("count");//
		String salePlace=httpServletRequest.getParameter("salePlace");//
		String buyName=httpServletRequest.getParameter("buyName");//
		String buyTelephone=httpServletRequest.getParameter("buyTelephone");//
		String checkout=httpServletRequest.getParameter("checkout");//
		String checkName=httpServletRequest.getParameter("checkName");//
		String checkCode=httpServletRequest.getParameter("checkCode");//
		
		SaleRecord saleRecord=new SaleRecord();
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			saleRecord.setPiCi(batchID);
		}
		
		saleRecord.setEnterpriseID(enterpriseID);
		saleRecord.setEnterpriseName(enterpriseName);
		saleRecord.setPoultryKinds(poultryKinds);
		saleRecord.setSale_time(date);
		saleRecord.setCount(count);
		saleRecord.setSalePlace(salePlace);
		saleRecord.setBuyName(buyName);
		saleRecord.setBuyTelephone(buyTelephone);
		saleRecord.setCheckout(checkout);
		saleRecord.setCheckName(checkName);
		saleRecord.setCheckCode(checkCode);
		saleRecord.setMonthh(saleTime[1]);
		saleRecord.setDayth(saleTime[2]);
		
		salerecordService.save(saleRecord);
		
		return SUCCESS;
	}
	/**-----------------------修改----------------------------------------**/
	public String modifySale()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		Enterprise enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		poultryKindsList=poultrykindsService.searchAll(search);
		
		/**-------------------------------------------------------**/
		String ids=httpServletRequest.getParameter("ouc");
		salerecord=salerecordService.findById(Long.parseLong(ids));
		
		
		Date curren=new Date();
		Date date=salerecord.getSale_time();
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	
			if(count1==0)
			{
			return "modifySale";
			}
			else
			{
				batchList=batchService.searchAll(s1);
				return "modifyBatchSale";
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
	/*************************保存修改的*************************************/
	public String  saveModifySale()throws Exception
	{
		
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		long enterpriseID=user.getEnterprise().getEnterpriseID();//企业ID
		String enterpriseName=user.getEnterprise().getEnterpriseName();//企业名字
		
		String ids=httpServletRequest.getParameter("saleID");
		SaleRecord saleRecord=salerecordService.findById(Long.parseLong(ids));
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String id=httpServletRequest.getParameter("poultryName");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));//得到 家禽品种  结合
		
		
		String sale_time=httpServletRequest.getParameter("sale_time");
		String[] saleTime=sale_time.split("-");
		Date date=formt.parse(sale_time);//售出时间
		
		String count=httpServletRequest.getParameter("count");//
		String salePlace=httpServletRequest.getParameter("salePlace");//
		String buyName=httpServletRequest.getParameter("buyName");//
		String buyTelephone=httpServletRequest.getParameter("buyTelephone");//
		String checkout=httpServletRequest.getParameter("checkout");//
		String checkName=httpServletRequest.getParameter("checkName");//
		String checkCode=httpServletRequest.getParameter("checkCode");//
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			saleRecord.setPiCi(batchID);
		}
		
		
		saleRecord.setEnterpriseID(enterpriseID);
		saleRecord.setEnterpriseName(enterpriseName);
		saleRecord.setPoultryKinds(poultryKinds);
		saleRecord.setSale_time(date);
		saleRecord.setCount(count);
		saleRecord.setSalePlace(salePlace);
		saleRecord.setBuyName(buyName);
		saleRecord.setBuyTelephone(buyTelephone);
		saleRecord.setCheckout(checkout);
		saleRecord.setCheckName(checkName);
		saleRecord.setCheckCode(checkCode);
		saleRecord.setDayth(saleTime[1]);
		saleRecord.setMonthh(saleTime[2]);
		
		salerecordService.save(saleRecord);
		
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
			salerecord=salerecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			saleRecordList.add(salerecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("saleRecordList", saleRecordList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "salerecord.ftl";//销售记录ftl模板
		String docfilename =  "salerecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("销售记录表.doc","UTF-8"));
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