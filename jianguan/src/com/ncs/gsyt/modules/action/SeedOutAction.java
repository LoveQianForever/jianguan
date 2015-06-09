﻿package com.ncs.gsyt.modules.action;

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
import com.ncs.gsyt.modules.model.BuySeed;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.BuySeedService;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.SeedOutService;
import com.ncs.gsyt.modules.service.SeedService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SeedOutAction extends BaseAction implements ModelDriven<SeedOut>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SeedOutService seedoutService;
	
	@Resource
	private SeedService seedService;//种子商品
	
	@Resource
	private BatchService batchService;//batch
	
	private List<Batch> batchList=new ArrayList<Batch>();
	private Batch batch=new Batch();
	
	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<Batch> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}


	@Resource
	private BuySeedService buySeedService;//种子商品
	@Resource
	private EnterpriseService enterpriseService;//种子商品
	
	private List<SeedOut> seedOutList=new ArrayList<SeedOut>();
	public List<SeedOut> getSeedOutList() {
		return seedOutList;
	}

	public void setSeedOutList(List<SeedOut> seedOutList) {
		this.seedOutList = seedOutList;
	}


	private BuySeed buySeed=new BuySeed();
	public BuySeed getBuySeed() {
		return buySeed;
	}

	public void setBuySeed(BuySeed buySeed) {
		this.buySeed = buySeed;
	}


	private List<Seed> seedList=new ArrayList<Seed>();//种子商品集合
	
	private List<Enterprise> enterpriseList=new ArrayList<Enterprise>();
	
	private List<Enterprise> enterpriseList1=new ArrayList<Enterprise>();
	public List<Enterprise> getEnterpriseList1() {
		return enterpriseList1;
	}

	public void setEnterpriseList1(List<Enterprise> enterpriseList1) {
		this.enterpriseList1 = enterpriseList1;
	}

	public List<Enterprise> getEnterpriseList() {
		return enterpriseList;
	}

	public void setEnterpriseList(List<Enterprise> enterpriseList) {
		this.enterpriseList = enterpriseList;
	}


	private List<Seed> seedList1=new ArrayList<Seed>();
	public List<Seed> getSeedList1() {
		return seedList1;
	}

	public void setSeedList1(List<Seed> seedList1) {
		this.seedList1 = seedList1;
	}


	private Seed seed=new Seed();//种子对象
	private Enterprise enterprise=new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}


	private User user=new User();//用户对象
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	public List<Seed> getSeedList() {
		return seedList;
	}

	public void setSeedList(List<Seed> seedList) {
		this.seedList = seedList;
	}


	private SeedOut seedout = new SeedOut();
	
	
	
	public SeedOut getSeedout() {
		return seedout;
	}

	public void setSeedout(SeedOut seedout) {
		this.seedout = seedout;
	}

	@Override
	public SeedOut getModel() {
		return seedout;
	}
	
	@Action(value = "/seedout", results = {
			@Result(name = SUCCESS, location = "/admin/seedproduct/seedoutlist.jsp"),//"addBatchseedout"
			@Result(name = "addseedout", location = "/admin/seedproduct/addSeedOut.jsp"),
			@Result(name = "addBatchseedout", location = "/admin/seedproduct/addBatchSeedOut.jsp"),//添加批次概念
			@Result(name = "modifySeed", location = "/admin/seedproduct/modifySeedOut.jsp"),//"modifyBatchSeed"
			@Result(name = "modifyBatchSeed", location = "/admin/seedproduct/modifyBatchSeedOut.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/seedproduct/stopModifySeedOut.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/seedproduct/stopBatchModifySeedOut.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {

		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		//enterprise=user.getEnterprise();
		
		Search search = new Search(SeedOut.class);
		search = this.getSearch(search);
		search.addFilterEqual("user", user);
		
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("output_time",begindate);
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("output_time", enddate);
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("output_time",enddate);
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String seed_name=StringUtil.isNull(httpServletRequest.getParameter("seed_name"));
	if (!"".equals(seed_name)) {
		search.addFilterILike("seed.seed_name","%"+seed_name+"%");
	}
		
		

		int count = seedoutService.count(search);
		List<SeedOut> list = seedoutService.searchAll(search);
		List<Map<String, Object>> seedoutList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				SeedOut obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				String pro= "<a href=\"javascript:void(0)\" onclick=\"seedshow("
					+ obj.getSeed().getSeed_id() + ")\">"+obj.getSeed().getSeed_name()+"</a>";
				row.put("id", obj.getSeedout_id());
				row.put("cell",
						new Object[] { obj.getSeedout_id(),
						null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():null!=obj.getBuySeed1()?obj.getBuySeed1().getName_enter():""
							,obj.getSeed().getSeed_name(),
						obj.getCount(),obj.getContract_id(),obj.getOutput_time(),obj.getStore_number(),
						obj.getWater(),obj.getNeatness(),obj.getSprout(),obj.getPure(),obj.getContent(),
						obj.getUser().getEnterprise().getEnterpriseName()});//其他属性需按页面需要填写
				seedoutList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, seedoutList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**
	 * 此方法，用来实现---添加一个出货单----信息
	 * **/
	public String addSeedOut()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		//查询出所有的商品
		seedList1=seedService.findAll();
		for(Seed seed:seedList1)
		{
			if(null!=seed.getEnterprise())
			{
				if(seed.getEnterprise().getEnterpriseID()==user.getEnterprise().getEnterpriseID())
				{
					seedList.add(seed);
				}
			}
		}
		
		enterpriseList=enterpriseService.findAll();
		for(Enterprise enterprise:enterpriseList)
		{
			if(enterprise.getStatus()!=null)
			{
				if(enterprise.getStatus().equals("3"))
				{
					System.out.println(enterprise.getEnterpriseName());
					enterpriseList1.add(enterprise);
				}
			}
				
		}
		
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段
		if(count1!=0)
		{
			batchList=batchService.searchAll(s1);
			return "addBatchseedout";
		}
		//count1等于0情况下，说明溯源批次表，没有该企业相关的批次记录，因此添加记录的时候，没有选择批次字段；
		else
		{
			return "addseedout";
		}
		
		
	}
	
	
	/**
	 * 用来将--添加的出货单--，保存到数据库里去
	 * **/
	public String saveSeedOut()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		/**--------------------------添加新进货商的参数获取------------------------------------------**/
		String name_enter=httpServletRequest.getParameter("name_enter");
		String linkman=httpServletRequest.getParameter("linkman");
		String phoneNumber=httpServletRequest.getParameter("phoneNumber");
		String address=httpServletRequest.getParameter("address");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
//溯源：count1等于0情况下
if(count1==0)
{
		if(name_enter!=null&&linkman!=null&&phoneNumber!=null)
		{
			buySeed.setName_enter(name_enter);
			buySeed.setAddress(linkman);
			buySeed.setPhoneNumber(phoneNumber);
			buySeed.setAddress(address);
			buySeedService.save(buySeed);
			/**------------------------**/
			
			/**-------------这是在不需要添加  新进货商的情况下--------------------------------**/
			httpServletRequest.setCharacterEncoding("utf-8");
			/*HttpSession session=httpServletRequest.getSession(true);
			user=(User)session.getAttribute("ADMIN_USER");	*/
		
		String buy_company=httpServletRequest.getParameter("seed_company");
		String seedin_id=httpServletRequest.getParameter("seed_name");
		String count=httpServletRequest.getParameter("count");
		String contract_id=httpServletRequest.getParameter("contract_id");
		
		String store_id=httpServletRequest.getParameter("store_number");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String content=httpServletRequest.getParameter("content");
		String output_time=httpServletRequest.getParameter("output_time");
			seed=seedService.findById(Long.parseLong(seedin_id));
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date date=new Date();
			//String create=format.format(date);
				
			SeedOut seedOut=new SeedOut();
			//seedOut.setEnterprise(enterprise);
			seedOut.setSeed(seed);
			seedOut.setCount(count);
			seedOut.setContract_id(contract_id);
			seedOut.setStore_number(store_id);
			seedOut.setWater(water);
			seedOut.setNeatness(neatness);
			seedOut.setSprout(sprout);
			seedOut.setPure(pure);
			seedOut.setContent(content);
			seedOut.setOutput_time(output_time);
			seedOut.setUser(user);//登录用户对象
			seedOut.setBuySeed1(buySeed);
			
			seedoutService.save(seedOut);
		}
		else
		{
		
		
		/**-------------这是在不需要添加  新进货商的情况下--------------------------------**/
		httpServletRequest.setCharacterEncoding("utf-8");
		/*HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");	*/
	
	String buy_company=httpServletRequest.getParameter("seed_company");
	String seedin_id=httpServletRequest.getParameter("seed_name");
	String count=httpServletRequest.getParameter("count");
	String contract_id=httpServletRequest.getParameter("contract_id");
	
	String store_id=httpServletRequest.getParameter("store_number");
	String water=httpServletRequest.getParameter("water");
	String neatness=httpServletRequest.getParameter("neatness");
	String sprout=httpServletRequest.getParameter("sprout");
	String pure=httpServletRequest.getParameter("pure");
	String content=httpServletRequest.getParameter("content");
	String enterpriseID=httpServletRequest.getParameter("enterpriseName");
	String output_time=httpServletRequest.getParameter("output_time");
		enterprise=enterpriseService.findById(Long.parseLong(enterpriseID));
		seed=seedService.findById(Long.parseLong(seedin_id));
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date date=new Date();
		//String create=format.format(date);
			
		SeedOut seedOut=new SeedOut();
		//seedOut.setEnterprise(enterprise);
		seedOut.setSeed(seed);
		seedOut.setCount(count);
		seedOut.setContract_id(contract_id);
		seedOut.setStore_number(store_id);
		seedOut.setWater(water);
		seedOut.setNeatness(neatness);
		seedOut.setSprout(sprout);
		seedOut.setPure(pure);
		seedOut.setContent(content);
		seedOut.setOutput_time(output_time);
		seedOut.setUser(user);//登录用户对象
		seedOut.setEnterprise(enterprise);
		
		seedoutService.save(seedOut);
		}
		return SUCCESS;
}
//溯源：count1不等于0情况下
else
{

	if(name_enter!=null&&linkman!=null&&phoneNumber!=null)
	{
		buySeed.setName_enter(name_enter);
		buySeed.setAddress(linkman);
		buySeed.setPhoneNumber(phoneNumber);
		buySeed.setAddress(address);
		buySeedService.save(buySeed);
		/**------------------------**/
		
		/**-------------这是在不需要添加  新进货商的情况下--------------------------------**/
		httpServletRequest.setCharacterEncoding("utf-8");
		/*HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");*/	
	
		String buy_company=httpServletRequest.getParameter("seed_company");
		String seedin_id=httpServletRequest.getParameter("seed_name");
		String count=httpServletRequest.getParameter("count");
		String contract_id=httpServletRequest.getParameter("contract_id");
	
		String store_id=httpServletRequest.getParameter("store_number");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String content=httpServletRequest.getParameter("content");
		String output_time=httpServletRequest.getParameter("output_time");
		seed=seedService.findById(Long.parseLong(seedin_id));
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//溯源：将批次值，保存到当前记录表里；
		String batchID=httpServletRequest.getParameter("batchID");	
		
		SeedOut seedOut=new SeedOut();
		//溯源：保存批次值
		seedOut.setPiCi(batchID);
		
		seedOut.setSeed(seed);
		seedOut.setCount(count);
		seedOut.setContract_id(contract_id);
		seedOut.setStore_number(store_id);
		seedOut.setWater(water);
		seedOut.setNeatness(neatness);
		seedOut.setSprout(sprout);
		seedOut.setPure(pure);
		seedOut.setContent(content);
		seedOut.setOutput_time(output_time);
		seedOut.setUser(user);//登录用户对象
		seedOut.setBuySeed1(buySeed);
		
		seedoutService.save(seedOut);
	}
	else
	{
	
	
	/**-------------这是在不需要添加  新进货商的情况下--------------------------------**/
		httpServletRequest.setCharacterEncoding("utf-8");
		/*HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");	*/

		String buy_company=httpServletRequest.getParameter("seed_company");
		String seedin_id=httpServletRequest.getParameter("seed_name");
		String count=httpServletRequest.getParameter("count");
		String contract_id=httpServletRequest.getParameter("contract_id");

		String store_id=httpServletRequest.getParameter("store_number");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String content=httpServletRequest.getParameter("content");
		String enterpriseID=httpServletRequest.getParameter("enterpriseName");
		String output_time=httpServletRequest.getParameter("output_time");
			enterprise=enterpriseService.findById(Long.parseLong(enterpriseID));
			seed=seedService.findById(Long.parseLong(seedin_id));
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date date=new Date();
			//String create=format.format(date);
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			
			SeedOut seedOut=new SeedOut();
			//溯源：保存批次值
			seedOut.setPiCi(batchID);
			//seedOut.setEnterprise(enterprise);
			seedOut.setSeed(seed);
			seedOut.setCount(count);
			seedOut.setContract_id(contract_id);
			seedOut.setStore_number(store_id);
			seedOut.setWater(water);
			seedOut.setNeatness(neatness);
			seedOut.setSprout(sprout);
			seedOut.setPure(pure);
			seedOut.setContent(content);
			seedOut.setOutput_time(output_time);
			seedOut.setUser(user);//登录用户对象
			seedOut.setEnterprise(enterprise);
	
			seedoutService.save(seedOut);
		}
	return SUCCESS;
	
	}
}
	
	
	/**
	 * 修改出货单
	 * **/
	
	public String modifySeedOut()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		/**---------------------------------------------------------**/
		String ouc=httpServletRequest.getParameter("ouc");
	
			Date curren=new Date();
			
		seedout=seedoutService.findById(Long.parseLong(ouc));
		String in_put=seedout.getOutput_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(in_put);
		System.out.println((curren.getTime()-date.getTime())/60000+"chaosh");
		if((curren.getTime()-date.getTime())/3600000 <=24)
		{	
			if(count1==0)
			{
			seedout=seedoutService.findById(Long.parseLong(ouc));
			seedList=seedService.findAll();
			return "modifySeed";
			}else
			{
				//溯源：批次
				batchList=batchService.searchAll(s1);
				seedout=seedoutService.findById(Long.parseLong(ouc));
				seedList=seedService.findAll();
				return "modifyBatchSeed";
			}
		}
		else
		{
			if(count1==0)
			{
			seedout=seedoutService.findById(Long.parseLong(ouc));
			return "stopModify";
			}else
			{
				//溯源：批次
				batchList=batchService.searchAll(s1);
				seedout=seedoutService.findById(Long.parseLong(ouc));
				return "stopBatchModify";
			}
		}
			
			
	}
	
	/**___________保存修改的出货单_____________________________**/
	public String saveModifySeedOut()throws Exception
	{
		httpServletRequest.setCharacterEncoding("utf-8");
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		/**---------------------------------------------------------**/
//溯源：count1等于0
if(count1==0)
{
		
		
		String id=httpServletRequest.getParameter("seedout_id");
		String buy_company=httpServletRequest.getParameter("seed_company");
		String seedin_id=httpServletRequest.getParameter("seed_name");
		String count=httpServletRequest.getParameter("count");
		String contract_id=httpServletRequest.getParameter("contract_id");
		
		String store_id=httpServletRequest.getParameter("store_number");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String content=httpServletRequest.getParameter("content");
		String output_time=httpServletRequest.getParameter("output_time");
			seed=seedService.findById(Long.parseLong(seedin_id));
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
			//Date date=new Date();
			//String create=format.format(date);
				
			SeedOut seedOut=seedoutService.findById(Long.parseLong(id));
			seedOut.setSeed_company(buy_company);
			seedOut.setSeed(seed);
			seedOut.setCount(count);
			seedOut.setContract_id(contract_id);
			seedOut.setStore_number(store_id);
			seedOut.setWater(water);
			seedOut.setNeatness(neatness);
			seedOut.setSprout(sprout);
			seedOut.setPure(pure);
			seedOut.setContent(content);
			seedOut.setOutput_time(output_time);
			seedOut.setEnterprise(user.getEnterprise());
			
			
			seedoutService.save(seedOut);
}
//溯源：count1不等于0
else
{
	
	
	String id=httpServletRequest.getParameter("seedout_id");
	String buy_company=httpServletRequest.getParameter("seed_company");
	String seedin_id=httpServletRequest.getParameter("seed_name");
	String count=httpServletRequest.getParameter("count");
	String contract_id=httpServletRequest.getParameter("contract_id");
	
	String store_id=httpServletRequest.getParameter("store_number");
	String water=httpServletRequest.getParameter("water");
	String neatness=httpServletRequest.getParameter("neatness");
	String sprout=httpServletRequest.getParameter("sprout");
	String pure=httpServletRequest.getParameter("pure");
	String content=httpServletRequest.getParameter("content");
	String output_time=httpServletRequest.getParameter("output_time");
		seed=seedService.findById(Long.parseLong(seedin_id));
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
		//Date date=new Date();
	
		//溯源：将批次值，保存到当前记录表里；
		String batchID=httpServletRequest.getParameter("batchID");	
		
		SeedOut seedOut=seedoutService.findById(Long.parseLong(id));
		
		seedOut.setPiCi(batchID);
		seedOut.setSeed_company(buy_company);
		seedOut.setSeed(seed);
		seedOut.setCount(count);
		seedOut.setContract_id(contract_id);
		seedOut.setStore_number(store_id);
		seedOut.setWater(water);
		seedOut.setNeatness(neatness);
		seedOut.setSprout(sprout);
		seedOut.setPure(pure);
		seedOut.setContent(content);
		seedOut.setOutput_time(output_time);
		seedOut.setEnterprise(user.getEnterprise());
		
		
		seedoutService.save(seedOut);
	
	}
			
		return SUCCESS;
	}
	
	
	

	/**-----------文档下载-------------------**/
	public String loadocc()throws Exception
	{
		///HttpSession session=httpServletRequest.getSession(true);
		//User user=(User)session.getAttribute("ADMIN_USER");
	//	String enterpriseName=user.getEnterprise().getEnterpriseName();
		//String yearth="2014";
		
		String ids=httpServletRequest.getParameter("ouc");
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++)
		{
			seedout=seedoutService.findById(Long.parseLong(idss[i]));//获取sale记录
			seedOutList.add(seedout);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("seedOutList", seedOutList);
		//datamap.put("enterpriseName", enterpriseName);
		//datamap.put("yearth", yearth);
		
		String templatefile = "seedout.ftl";//销售记录ftl模板
		String docfilename =  "seedout.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("种子经营档案（批发）.doc","UTF-8"));
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