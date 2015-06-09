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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.SeedInService;
import com.ncs.gsyt.modules.service.SeedService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SeedInAction extends BaseAction implements ModelDriven<SeedIn>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SeedInService seedinService;

	@Resource
	private BatchService batchService;
	@Resource
	private SeedService seedService;//种子商品service
	
	@Resource
	private UserService userService;
	
	private List<Batch> batchList=new ArrayList<Batch>();//
	
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


	private List<Seed> seedlist=new ArrayList<Seed>();//商品集合
	
	private List<Seed> seedList1=new ArrayList<Seed>();//商品集合
	private List<SeedIn> seedInList2=new ArrayList<SeedIn>();//商品集合
	
	

	public List<SeedIn> getSeedInList2() {
		return seedInList2;
	}

	public void setSeedInList2(List<SeedIn> seedInList2) {
		this.seedInList2 = seedInList2;
	}

	public List<Seed> getSeedList1() {
		return seedList1;
	}

	public void setSeedList1(List<Seed> seedList1) {
		this.seedList1 = seedList1;
	}


	private Enterprise enterprise=new Enterprise();//企业对象
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

	public List<Seed> getSeedlist() {
		return seedlist;
	}

	public void setSeedlist(List<Seed> seedlist) {
		this.seedlist = seedlist;
	}


	private Seed seed=new Seed();//商品对象
	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}


	private SeedIn seedin = new SeedIn();
	
	
	
	public SeedIn getSeedin() {
		return seedin;
	}

	public void setSeedin(SeedIn seedin) {
		this.seedin = seedin;
	}

	@Action(value = "/seedin", results = {
			@Result(name = SUCCESS, location = "/admin/seedproduct/seedinlist.jsp"),
			@Result(name = "addseedin", location = "/admin/seedproduct/addSeedIn.jsp"),
			@Result(name = "addbatch", location = "/admin/seedproduct/addBatchSeedIn.jsp"),//添加批次概念
			@Result(name = "modifySeed", location = "/admin/seedproduct/modifySeedIn.jsp"),//"modifyBactchSeed"
			@Result(name = "modifyBatchSeed", location = "/admin/seedproduct/modifyBatchSeedIn.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/seedproduct/stopModifySeedIn.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/seedproduct/stopBatchModifySeedIn.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		//String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();
		
		Search search = new Search(SeedIn.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterprise", enterprise);
		
		
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));

		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("input_time",begindate);
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("input_time", enddate);
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("input_time",enddate);
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//产品名称
	String seed_name=StringUtil.isNull(httpServletRequest.getParameter("seed_name"));
	if (!"".equals(seed_name)) {
		search.addFilterILike("seed.seed_name","%"+seed_name+"%");
	}

		int count = seedinService.count(search);
		List<SeedIn> list = seedinService.searchAll(search);
		List<Map<String, Object>> seedinList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				SeedIn obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				String pro= "<a href=\"javascript:void(0)\" onclick=\"seedshow("
					+ obj.getSeed().getSeed_id() + ")\">"+obj.getSeed().getSeed_name()+"</a>";
				row.put("id", obj.getSeedin_id());
				row.put("cell",
						new Object[] { obj.getSeedin_id(),obj.getBuy_company(),null!=obj.getSeed()?pro:"",
						obj.getS_count(),obj.getContract_id(),obj.getInput_time(),obj.getStore_id(),
						obj.getWater(),obj.getNeatness(),obj.getSprout(),obj.getPure(),obj.getCheckCode(),
						obj.getEnterprise().getEnterpriseName()});//其他属性需按页面需要填写
				seedinList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, seedinList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**
	 * 此方法，用来实现---添加一个进货订单----信息
	 * **/
	public String addSeedIn()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		//查询出所有的商品
		seedList1=seedService.findAll();
		for(Seed seed:seedList1)
		{
			//System.out.println(user.getEnterprise().getEnterpriseName()+"useer");
			//System.out.println(seed.getEnterprise().getEnterpriseName()+"seed");
			if(seed.getEnterprise()!=null)
			{
				if(seed.getEnterprise().getEnterpriseID()==user.getEnterprise().getEnterpriseID())
				{
					seedlist.add(seed);
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
			return "addbatch";
		}
		//count1等于0情况下，说明溯源批次表，没有该企业相关的批次记录，因此添加记录的时候，没有选择批次字段；
		else
		{
		return "addseedin";
		}
	}
	
	
	/**
	 * 用来将--添加的进货单--，保存到数据库里去
	 * **/
	public String saveSeedIn()throws Exception
	{
		httpServletRequest.setCharacterEncoding("utf-8");

		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
//溯源：count1等于0情况下
if(count1==0)
{
		/**---------------------保存进货单里 新商品---------------------------------------------**/
		String seed_name=httpServletRequest.getParameter("seedname");
		String seed_group=httpServletRequest.getParameter("seed_group");
		String seed_place=httpServletRequest.getParameter("seed_place");
		String seed_code=httpServletRequest.getParameter("seed_code");
		String seed_pack=httpServletRequest.getParameter("seed_pack");
		String store_condition=httpServletRequest.getParameter("store_condition");
		if(seed_name!=null&&seed_place!=null)
		{
			Seed seed=new Seed();
			seed.setSeed_name(seed_name);
			seed.setSeed_group(seed_group);
			seed.setSeed_place(seed_place);
			seed.setSeed_code(seed_code);
			seed.setSeed_pack(seed_pack);
			seed.setStore_condition(store_condition);
			seed.setEnterprise(user.getEnterprise());
			seedService.save(seed);
	/**-------------------保存进货单-----------------------------------**/
	
			String buy_company=httpServletRequest.getParameter("buy_company");
			String s_count=httpServletRequest.getParameter("s_count");
			String contract_id=httpServletRequest.getParameter("contract_id");
	
			String store_id=httpServletRequest.getParameter("store_id");
			String water=httpServletRequest.getParameter("water");
			String neatness=httpServletRequest.getParameter("neatness");
			String sprout=httpServletRequest.getParameter("sprout");
			String pure=httpServletRequest.getParameter("pure");
			String checkCode=httpServletRequest.getParameter("checkCode");
			String input_time=httpServletRequest.getParameter("input_time");
	
	

		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//String create=format.format(input_time);
			
			SeedIn seedIn=new SeedIn();
		
		
			seedIn.setBuy_company(buy_company);
			seedIn.setInput_time(input_time);
			seedIn.setSeed(seed);
			seedIn.setS_count(s_count);
			seedIn.setContract_id(contract_id);
			seedIn.setStore_id(store_id);
			seedIn.setWater(water);
			seedIn.setNeatness(neatness);
			seedIn.setSprout(sprout);
			seedIn.setPure(pure);
			seedIn.setCheckCode(checkCode);
			seedIn.setEnterprise(user.getEnterprise());
			seedinService.save(seedIn);
	
	
		}else
		{
		
	/**--------------------保存进货单-----------------------------------**/
			String buy_company=httpServletRequest.getParameter("buy_company");
			String seedin_id=httpServletRequest.getParameter("seed_name");
			String s_count=httpServletRequest.getParameter("s_count");
			String contract_id=httpServletRequest.getParameter("contract_id");
	
			String store_id=httpServletRequest.getParameter("store_id");
			String water=httpServletRequest.getParameter("water");
			String neatness=httpServletRequest.getParameter("neatness");
			String sprout=httpServletRequest.getParameter("sprout");
			String pure=httpServletRequest.getParameter("pure");
			String checkCode=httpServletRequest.getParameter("checkCode");
			String input_time=httpServletRequest.getParameter("input_time");
			seed=seedService.findById(Long.parseLong(seedin_id));
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date date=new Date();
		//String create=format.format(date);
		
		
		SeedIn seedIn=new SeedIn();
		
		seedIn.setBuy_company(buy_company);
		seedIn.setInput_time(input_time);
		seedIn.setSeed(seed);
		seedIn.setS_count(s_count);
		seedIn.setContract_id(contract_id);
		seedIn.setStore_id(store_id);
		seedIn.setWater(water);
		seedIn.setNeatness(neatness);
		seedIn.setSprout(sprout);
		seedIn.setPure(pure);
		seedIn.setCheckCode(checkCode);
		seedIn.setEnterprise(user.getEnterprise());
		seedinService.save(seedIn);
	
	}
		return SUCCESS;
		}
//溯源：count1不等于0的情况下
		else
		{
			/**---------------------保存进货单里 新商品---------------------------------------------**/
			String seed_name=httpServletRequest.getParameter("seedname");
		String seed_group=httpServletRequest.getParameter("seed_group");
		String seed_place=httpServletRequest.getParameter("seed_place");
		String seed_code=httpServletRequest.getParameter("seed_code");
		String seed_pack=httpServletRequest.getParameter("seed_pack");
		String store_condition=httpServletRequest.getParameter("store_condition");
		if(seed_name!=null&&seed_place!=null)
		{
		Seed seed=new Seed();
		seed.setSeed_name(seed_name);
		seed.setSeed_group(seed_group);
		seed.setSeed_place(seed_place);
		seed.setSeed_code(seed_code);
		seed.setSeed_pack(seed_pack);
		seed.setStore_condition(store_condition);
		seed.setEnterprise(user.getEnterprise());
		seedService.save(seed);
		/**-------------------保存进货单-----------------------------------**/
		
		String buy_company=httpServletRequest.getParameter("buy_company");
		String s_count=httpServletRequest.getParameter("s_count");
		String contract_id=httpServletRequest.getParameter("contract_id");
		
		String store_id=httpServletRequest.getParameter("store_id");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String checkCode=httpServletRequest.getParameter("checkCode");
		String input_time=httpServletRequest.getParameter("input_time");

		//溯源：将批次值，保存到当前记录表里；
		String batchID=httpServletRequest.getParameter("batchID");	
			SeedIn seedIn=new SeedIn();
			//溯源：保存批次值
			seedIn.setPiCi(batchID);
			
			seedIn.setBuy_company(buy_company);
			seedIn.setInput_time(input_time);
			seedIn.setSeed(seed);
			seedIn.setS_count(s_count);
			seedIn.setContract_id(contract_id);
			seedIn.setStore_id(store_id);
			seedIn.setWater(water);
			seedIn.setNeatness(neatness);
			seedIn.setSprout(sprout);
			seedIn.setPure(pure);
			seedIn.setCheckCode(checkCode);
			seedIn.setEnterprise(user.getEnterprise());
			seedinService.save(seedIn);
		
		
		}else
		{
			
		/**--------------------保存进货单-----------------------------------**/
		String buy_company=httpServletRequest.getParameter("buy_company");
		String seedin_id=httpServletRequest.getParameter("seed_name");
		String s_count=httpServletRequest.getParameter("s_count");
		String contract_id=httpServletRequest.getParameter("contract_id");
		
		String store_id=httpServletRequest.getParameter("store_id");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String checkCode=httpServletRequest.getParameter("checkCode");
		String input_time=httpServletRequest.getParameter("input_time");
			seed=seedService.findById(Long.parseLong(seedin_id));
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date date=new Date();
			//String create=format.format(date);
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			
				SeedIn seedIn=new SeedIn();
				//溯源：保存批次值
				seedIn.setPiCi(batchID);
				
			seedIn.setBuy_company(buy_company);
			seedIn.setInput_time(input_time);
			seedIn.setSeed(seed);
			seedIn.setS_count(s_count);
			seedIn.setContract_id(contract_id);
			seedIn.setStore_id(store_id);
			seedIn.setWater(water);
			seedIn.setNeatness(neatness);
			seedIn.setSprout(sprout);
			seedIn.setPure(pure);
			seedIn.setCheckCode(checkCode);
			seedIn.setEnterprise(user.getEnterprise());
			seedinService.save(seedIn);
		
		}
			return SUCCESS;
		}
	}
	
	/**----------------------修改记录--------------------------------**/
	public String modifySeed()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		/**---------------------------------------------------------**/
		
		String ouc=httpServletRequest.getParameter("ouc");
		seedin=seedinService.findById(Long.parseLong(ouc));
			Date curren=new Date();
		
		String in_put=seedin.getInput_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse(in_put);
		//用来限制，如果下单超过24小时不能进行修改操作
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	if(count1!=0)
			{//说明批次存在
			/**添加批次，让溯源系统获取到监管里的农事操作记录**/
			batchList=batchService.searchAll(s1);
			
				seedin=seedinService.findById(Long.parseLong(ouc));
				seedlist=seedService.findAll();
				return "modifyBatchSeed";
			}else
			{//说明批次不存在
			seedin=seedinService.findById(Long.parseLong(ouc));
			seedlist=seedService.findAll();
			return "modifySeed";	
			}
		}
		else
		{
			if(count1!=0)
			{//说明批次存在
				/**添加批次，让溯源系统获取到监管里的农事操作记录**/
				batchList=batchService.searchAll(s1);
				
			seedin=seedinService.findById(Long.parseLong(ouc));
			return "stopBatchModify";
			}else
			{//说明批次不存在
				seedin=seedinService.findById(Long.parseLong(ouc));
				return "stopModify";
			}
		}	
		
	}
	
	/**----------------------保存修改记录--------------------------------**/
	public String  saveModifySeed()throws Exception
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
		
		
		String buy_company=httpServletRequest.getParameter("buy_company");
		String seedin_id=httpServletRequest.getParameter("seedin_id");//进货id
		String seed_id=httpServletRequest.getParameter("seed_name");//商品id
		String s_count=httpServletRequest.getParameter("s_count");
		String contract_id=httpServletRequest.getParameter("contract_id");
		
		String store_id=httpServletRequest.getParameter("store_id");
		String water=httpServletRequest.getParameter("water");
		String neatness=httpServletRequest.getParameter("neatness");
		String sprout=httpServletRequest.getParameter("sprout");
		String pure=httpServletRequest.getParameter("pure");
		String checkCode=httpServletRequest.getParameter("checkCode");
		String input_time=httpServletRequest.getParameter("input_time");
			seed=seedService.findById(Long.parseLong(seed_id));
			seedin=seedinService.findById(Long.parseLong(seedin_id));
			//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date date=new Date();
			//String create=format.format(date);
				
			seedin.setBuy_company(buy_company);
			seedin.setInput_time(input_time);
			seedin.setSeed(seed);
			seedin.setS_count(s_count);
			seedin.setContract_id(contract_id);
			seedin.setStore_id(store_id);
			seedin.setWater(water);
			seedin.setNeatness(neatness);
			seedin.setSprout(sprout);
			seedin.setPure(pure);
			seedin.setCheckCode(checkCode);
			seedin.setEnterprise(user.getEnterprise());
			seedinService.save(seedin);
}else
//溯源：count1不等于0
{
	
	
	String buy_company=httpServletRequest.getParameter("buy_company");
	String seedin_id=httpServletRequest.getParameter("seedin_id");//进货id
	String seed_id=httpServletRequest.getParameter("seed_name");//商品id
	String s_count=httpServletRequest.getParameter("s_count");
	String contract_id=httpServletRequest.getParameter("contract_id");
	//溯源：将批次值，保存到当前记录表里；
	String batchID=httpServletRequest.getParameter("batchID");	
	
	String store_id=httpServletRequest.getParameter("store_id");
	String water=httpServletRequest.getParameter("water");
	String neatness=httpServletRequest.getParameter("neatness");
	String sprout=httpServletRequest.getParameter("sprout");
	String pure=httpServletRequest.getParameter("pure");
	String checkCode=httpServletRequest.getParameter("checkCode");
	String input_time=httpServletRequest.getParameter("input_time");
		seed=seedService.findById(Long.parseLong(seed_id));
		seedin=seedinService.findById(Long.parseLong(seedin_id));
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date date=new Date();
		//String create=format.format(date);
			seedin.setPiCi(batchID);
		seedin.setBuy_company(buy_company);
		seedin.setInput_time(input_time);
		seedin.setSeed(seed);
		seedin.setS_count(s_count);
		seedin.setContract_id(contract_id);
		seedin.setStore_id(store_id);
		seedin.setWater(water);
		seedin.setNeatness(neatness);
		seedin.setSprout(sprout);
		seedin.setPure(pure);
		seedin.setCheckCode(checkCode);
		seedin.setEnterprise(user.getEnterprise());
		seedinService.save(seedin);
	}
		
		
		return SUCCESS;
	}

	@Override
	public SeedIn getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	

	/**-----------文档下载-------------------**/
	public String loadocc()throws Exception
	{
		//HttpSession session=httpServletRequest.getSession(true);
		//User user=(User)session.getAttribute("ADMIN_USER");
		//String enterpriseName=user.getEnterprise().getEnterpriseName();
		//String yearth="2014";
		String ids=httpServletRequest.getParameter("ouc");
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++)
		{
			seedin=seedinService.findById(Long.parseLong(idss[i]));//获取sale记录
			seedInList2.add(seedin);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("seedInList2", seedInList2);
		//datamap.put("enterpriseName", enterpriseName);
		//datamap.put("yearth", yearth);
		
		String templatefile = "seedin.ftl";//销售记录ftl模板
		String docfilename =  "seedin.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("种子经营档案（调入种子）.doc","UTF-8"));
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