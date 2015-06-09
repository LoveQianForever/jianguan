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
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.model.FoodProRecord;
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.FoodProRecordService;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class FoodProRecordAction extends BaseAction implements ModelDriven<FoodProRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private FoodProRecordService foodprorecordService;
	
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



	private FoodProRecord foodprorecord = new FoodProRecord();
	
	public FoodProRecord getFoodprorecord() {
		return foodprorecord;
	}

	public void setFoodprorecord(FoodProRecord foodprorecord) {
		this.foodprorecord = foodprorecord;
	}



	private List<FoodProRecord> foodprorecordList=new ArrayList<FoodProRecord>();
	public List<FoodProRecord> getFoodprorecordList() {
		return foodprorecordList;
	}

	public void setFoodprorecordList(List<FoodProRecord> foodprorecordList) {
		this.foodprorecordList = foodprorecordList;
	}

	public FoodProRecord getFoodProRecord() {
		return foodprorecord;
	}
	
	@Override
	public FoodProRecord getModel() {
		return foodprorecord;
	}
	
	@Action(value = "/foodprorecord", results = {
			@Result(name = SUCCESS, location = "/admin/pig/foodprorecordlist.jsp"),
			@Result(name = "add", location = "/admin/pig/addfoodprorecord.jsp"),
			@Result(name = "addBatch", location = "/admin/pig/addBatchfoodprorecord.jsp"),//添加批次概念
			@Result(name = "modify", location = "/admin/pig/modifyfoodprorecord.jsp"),
			@Result(name = "modifyBatch", location = "/admin/pig/modifyBatchfoodprorecord.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Search search = new Search(FoodProRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		/*根据前台条件生成对应属性判断条件*/
		//品名查询
		String xingHao=StringUtil.isNull(httpServletRequest.getParameter("xingHao"));
		if (!"".equals(xingHao)) {
			search.addFilterILike("xingHao","%"+xingHao+"%");
		}
		
		//品名查询
		String proCount=StringUtil.isNull(httpServletRequest.getParameter("proCount"));
		if (!"".equals(proCount)) {
			search.addFilterILike("proCount","%"+proCount+"%");
		}

		int count = foodprorecordService.count(search);
		List<FoodProRecord> list = foodprorecordService.searchAll(search);
		List<Map<String, Object>> foodprorecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				FoodProRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getFoodProRecordID());
				row.put("cell",
						new Object[] { obj.getFoodProRecordID(),obj.getXingHao(),obj.getProCount(),obj.getYuMicount(),
						obj.getDouBcount(),obj.getMaiSuiCount(),obj.getDaDouCount(),obj.getXiKangCount(),obj.getCaiZiCount(),obj.getYuFenCount()
						,obj.getZaYuCount(),obj.getHunLiaoCount(),obj.getProName1(),obj.getProCount1(),
						obj.getProName2(),obj.getProCount2(),obj.getProName3(),obj.getProCount3(),obj.getSampleContent()});//其他属性需按页面需要填写
				foodprorecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, foodprorecordList);

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
	//	SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		FoodProRecord foodProRecord=new FoodProRecord();
		
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			foodProRecord.setPiCi(batchID);
		}
		
			String xingHao=httpServletRequest.getParameter("xingHao");
			String proCount=httpServletRequest.getParameter("proCount");
			String yuMicount=httpServletRequest.getParameter("yuMicount");
			String douBcount=httpServletRequest.getParameter("douBcount");
			String maiSuiCount=httpServletRequest.getParameter("maiSuiCount");
			String daDouCount=httpServletRequest.getParameter("daDouCount");
			
			foodProRecord.setXingHao(xingHao);
			foodProRecord.setProCount(proCount);
			foodProRecord.setYuMicount(yuMicount);
			foodProRecord.setDouBcount(douBcount);
			foodProRecord.setMaiSuiCount(maiSuiCount);
			foodProRecord.setDaDouCount(daDouCount);
			
			String xiKangCount=httpServletRequest.getParameter("xiKangCount");
			String caiZiCount=httpServletRequest.getParameter("caiZiCount");
			String yuFenCount=httpServletRequest.getParameter("yuFenCount");
			String zaYuCount=httpServletRequest.getParameter("zaYuCount");
			String hunLiaoCount=httpServletRequest.getParameter("hunLiaoCount");
			
			foodProRecord.setXiKangCount(xiKangCount);
			foodProRecord.setCaiZiCount(caiZiCount);
			foodProRecord.setYuFenCount(yuFenCount);
			foodProRecord.setZaYuCount(zaYuCount);
			foodProRecord.setHunLiaoCount(hunLiaoCount);
			
			String proName1=httpServletRequest.getParameter("proName1");
			String proCount1=httpServletRequest.getParameter("proCount1");
			String proName2=httpServletRequest.getParameter("proName2");
			String proCount2=httpServletRequest.getParameter("proCount2");
			String proName3=httpServletRequest.getParameter("proName3");
			String proCount3=httpServletRequest.getParameter("proCount3");
			String sampleContent=httpServletRequest.getParameter("sampleContent");
			
			foodProRecord.setProName1(proName1);
			foodProRecord.setProCount1(proCount1);
			foodProRecord.setProName2(proName2);
			foodProRecord.setProCount2(proCount2);
			foodProRecord.setProName3(proName3);
			foodProRecord.setProCount3(proCount3);
			foodProRecord.setSampleContent(sampleContent);
			foodProRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			foodProRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			foodprorecordService.save(foodProRecord);
				
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
		foodprorecord=foodprorecordService.findById(Long.parseLong(id));
		
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
		String foodProRecordID=httpServletRequest.getParameter("foodProRecordID");
		FoodProRecord foodProRecord=foodprorecordService.findById(Long.parseLong(foodProRecordID));
		
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			foodProRecord.setPiCi(batchID);
		}
			//SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
		String xingHao=httpServletRequest.getParameter("xingHao");
		String proCount=httpServletRequest.getParameter("proCount");
		String yuMicount=httpServletRequest.getParameter("yuMicount");
		String douBcount=httpServletRequest.getParameter("douBcount");
		String maiSuiCount=httpServletRequest.getParameter("maiSuiCount");
		String daDouCount=httpServletRequest.getParameter("daDouCount");
		
		foodProRecord.setXingHao(xingHao);
		foodProRecord.setProCount(proCount);
		foodProRecord.setYuMicount(yuMicount);
		foodProRecord.setDouBcount(douBcount);
		foodProRecord.setMaiSuiCount(maiSuiCount);
		foodProRecord.setDaDouCount(daDouCount);
		
		String xiKangCount=httpServletRequest.getParameter("xiKangCount");
		String caiZiCount=httpServletRequest.getParameter("caiZiCount");
		String yuFenCount=httpServletRequest.getParameter("yuFenCount");
		String zaYuCount=httpServletRequest.getParameter("zaYuCount");
		String hunLiaoCount=httpServletRequest.getParameter("hunLiaoCount");
		
		foodProRecord.setXiKangCount(xiKangCount);
		foodProRecord.setCaiZiCount(caiZiCount);
		foodProRecord.setYuFenCount(yuFenCount);
		foodProRecord.setZaYuCount(zaYuCount);
		foodProRecord.setHunLiaoCount(hunLiaoCount);
		
		String proName1=httpServletRequest.getParameter("proName1");
		String proCount1=httpServletRequest.getParameter("proCount1");
		String proName2=httpServletRequest.getParameter("proName2");
		String proCount2=httpServletRequest.getParameter("proCount2");
		String proName3=httpServletRequest.getParameter("proName3");
		String proCount3=httpServletRequest.getParameter("proCount3");
		String sampleContent=httpServletRequest.getParameter("sampleContent");
		
		foodProRecord.setProName1(proName1);
		foodProRecord.setProCount1(proCount1);
		foodProRecord.setProName2(proName2);
		foodProRecord.setProCount2(proCount2);
		foodProRecord.setProName3(proName3);
		foodProRecord.setProCount3(proCount3);
		foodProRecord.setSampleContent(sampleContent);
		foodProRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
		foodProRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
		foodprorecordService.save(foodProRecord);
		
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
			foodprorecord=foodprorecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			foodprorecordList.add(foodprorecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("foodprorecordList", foodprorecordList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "foodprorecord.ftl";//销售记录ftl模板
		String docfilename =  "foodprorecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("饲料车间生产记录.doc","UTF-8"));
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