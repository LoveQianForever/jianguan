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
import com.ncs.gsyt.modules.model.InTouRuPinRecord;
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.TouRuPin;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.InTouRuPinRecordService;
import com.ncs.gsyt.modules.service.TouRuPinService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InTouRuPinRecordAction1 extends BaseAction implements ModelDriven<InTouRuPinRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InTouRuPinRecordService intourupinrecordService;
	@Resource
	private UserService userService;
	private User user=new User();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	private InTouRuPinRecord intourupinrecord = new InTouRuPinRecord();
	
	public InTouRuPinRecord getInTouRuPinRecord() {
		return intourupinrecord;
	}
	
	@Override
	public InTouRuPinRecord getModel() {
		return intourupinrecord;
	}
	
	@Action(value = "/intourupinrecord1", results = {
			@Result(name = SUCCESS, location = "/admin/tourupin/intourupinrecordlist1.jsp"),
			@Result(name ="addseedin", location = "/admin/tourupin/addInTouRuPinRecord.jsp"),
			@Result(name ="modifySeed", location = "/admin/tourupin/modifyInTouRuPinRecord1.jsp"),
			@Result(name ="stopModify", location = "/admin/tourupin/modifyInTouRuPinRecord2.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		intourupinrecord= new InTouRuPinRecord();
		intourupinrecord.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		Search search = new Search(InTouRuPinRecord.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterpriseID", Long.parseLong(enterpriseID));
		
		/*根据前台条件生成对应属性判断条件*/
		//进货查询时间
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
	//商品查询
	String name=httpServletRequest.getParameter("name");
	if(name!=null)
	{
		search.addFilterILike("touRuPin.name", "%"+name+"%");
	}
		
		

		int count = intourupinrecordService.count(search);
		List<InTouRuPinRecord> list = intourupinrecordService.searchAll(search);
		List<Map<String, Object>> intourupinrecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InTouRuPinRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getInrecordID());
				row.put("cell",
						new Object[] { obj.getInrecordID(),null!=obj.getTouRuPin()?obj.getTouRuPin().getName():"",obj.getCount(),
						obj.getSupplyName(),obj.getPhoneNumber(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd")});//其他属性需按页面需要填写
				intourupinrecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, intourupinrecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	
	

	
	@Resource
	private TouRuPinService tourupinService;
	private List<TouRuPin> tourupinList1=new ArrayList<TouRuPin>();
	public InTouRuPinRecord getIntourupinrecord() {
		return intourupinrecord;
	}

	public void setIntourupinrecord(InTouRuPinRecord intourupinrecord) {
		this.intourupinrecord = intourupinrecord;
	}

	public List<TouRuPin> getTourupinList1() {
		return tourupinList1;
	}

	public void setTourupinList1(List<TouRuPin> tourupinList1) {
		this.tourupinList1 = tourupinList1;
	}

	public List<TouRuPin> getTourupinlist() {
		return tourupinlist;
	}

	public void setTourupinlist(List<TouRuPin> tourupinlist) {
		this.tourupinlist = tourupinlist;
	}

	public TouRuPin getTourupin() {
		return tourupin;
	}

	public void setTourupin(TouRuPin tourupin) {
		this.tourupin = tourupin;
	}



	private List<TouRuPin> tourupinlist=new ArrayList<TouRuPin>();
	private TouRuPin tourupin=new TouRuPin();

	/**
	 * 此方法，用来实现---添加一个进货订单----信息
	 * **/
	public String addSeedIn()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		//查询出所有的商品
		tourupinList1=tourupinService.findAll();
		for(TouRuPin tourupin:tourupinList1)
		{
				if(tourupin.getEnterpriseID()==user.getEnterprise().getEnterpriseID())
				{
					tourupinlist.add(tourupin);
				}
			
		}
		return "addseedin";
	}
	
	
	/**
	 * 用来将--添加的进货单--，保存到数据库里去
	 * **/
	public String saveSeedIn()throws Exception
	{
		httpServletRequest.setCharacterEncoding("utf-8");

		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		/**---------------------保存进货单里 新商品---------------------------------------------**/
		String name1=httpServletRequest.getParameter("name1");
		String guige=httpServletRequest.getParameter("guige");
		String dengjiCode=httpServletRequest.getParameter("dengjiCode");
		String factory=httpServletRequest.getParameter("factory");
		String proDate=httpServletRequest.getParameter("proDate");
			if(name1!=null)
			{
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				TouRuPin touRuPin=new TouRuPin();
				touRuPin.setName(name1);
				touRuPin.setGuige(guige);
				touRuPin.setDengjiCode(dengjiCode);
				touRuPin.setFactory(factory);
				touRuPin.setProDate(format.parse(proDate));
				touRuPin.setEnterpriseID(user.getEnterprise().getEnterpriseID());
				touRuPin.setEnterpriseName(user.getEnterprise().getEnterpriseName());
				tourupinService.save(touRuPin);
	
	
				/**--------------------保存进货单-----------------------------------**/
				String count=httpServletRequest.getParameter("count");
				String supplyName=httpServletRequest.getParameter("supplyName");
				String phoneNumber=httpServletRequest.getParameter("phoneNumber");
				String input_time=httpServletRequest.getParameter("input_time");
						
				InTouRuPinRecord inTouRuPinRecord=new InTouRuPinRecord();
				inTouRuPinRecord.setCount(count);
				inTouRuPinRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
				inTouRuPinRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
				inTouRuPinRecord.setSupplyName(supplyName);
				inTouRuPinRecord.setPhoneNumber(phoneNumber);
				inTouRuPinRecord.setInput_time(format.parse(input_time));
				inTouRuPinRecord.setTouRuPin(touRuPin);
				intourupinrecordService.save(inTouRuPinRecord);
	
	
	
	
	}else
	{
		
	/**--------------------保存进货单-----------------------------------**/
	String count=httpServletRequest.getParameter("count");
	String supplyName=httpServletRequest.getParameter("supplyName");
	String phoneNumber=httpServletRequest.getParameter("phoneNumber");
	String input_time=httpServletRequest.getParameter("input_time");
	
	String tourupinID=httpServletRequest.getParameter("name");
	
		tourupin=tourupinService.findById(Long.parseLong(tourupinID));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//Date date=new Date();
		//String create=format.format(date);
			
		InTouRuPinRecord inTouRuPinRecord=new InTouRuPinRecord();
		inTouRuPinRecord.setCount(count);//
		inTouRuPinRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
		inTouRuPinRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
		inTouRuPinRecord.setSupplyName(supplyName);///
		inTouRuPinRecord.setPhoneNumber(phoneNumber);//
		inTouRuPinRecord.setInput_time(format.parse(input_time));//
		inTouRuPinRecord.setTouRuPin(tourupin);
		intourupinrecordService.save(inTouRuPinRecord);
		
	}
		return SUCCESS;
	}
	
	
	public String modifySeed()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		
		
		String ouc=httpServletRequest.getParameter("ouc");
		//curren 用来统计当前的时间
			Date curren=new Date();
			//找出需要进行修改的记录
		intourupinrecord=intourupinrecordService.findById(Long.parseLong(ouc));
		Date in_put=intourupinrecord.getInput_time();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		//用来限制，如果下单超过24小时不能进行修改操作
		if((curren.getTime()-in_put.getTime())/3600000<=24)
		{	
			
			//查询出所有的商品
			tourupinList1=tourupinService.findAll();
			for(TouRuPin tourupin:tourupinList1)
			{
					if(tourupin.getEnterpriseID()==user.getEnterprise().getEnterpriseID())
					{
						tourupinlist.add(tourupin);
					}
				
			}
			
			//intourupinrecord=intourupinrecordService.findById(Long.parseLong(ouc));
			//tourupinlist=tourupinService.findAll();
			return "modifySeed";	
		}
		else
		{
			//intourupinrecord=intourupinrecordService.findById(Long.parseLong(ouc));
			return "stopModify";
		}	
		
	}
	/**----------------------------------------------------------**/
	//保存修改的进货记录和商品
	public String  saveModifySeed()throws Exception
	{
		httpServletRequest.setCharacterEncoding("utf-8");
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		/**---------新商品的保存--------------**/
		String name1=httpServletRequest.getParameter("name1");
		String guige=httpServletRequest.getParameter("guige");
		String dengjiCode=httpServletRequest.getParameter("dengjiCode");
		String factory=httpServletRequest.getParameter("factory");
		String proDate=httpServletRequest.getParameter("proDate");
		if(name1!=null)
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			TouRuPin touRuPin=new TouRuPin();
			touRuPin.setName(name1);
			touRuPin.setGuige(guige);
			touRuPin.setDengjiCode(dengjiCode);
			touRuPin.setFactory(factory);
			touRuPin.setProDate(format.parse(proDate));
			touRuPin.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			touRuPin.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			tourupinService.save(touRuPin);


			/**--------------------保存进货单-----------------------------------**/
			String count=httpServletRequest.getParameter("count");
			String supplyName=httpServletRequest.getParameter("supplyName");
			String phoneNumber=httpServletRequest.getParameter("phoneNumber");
			String input_time=httpServletRequest.getParameter("input_time");
			String inrecordID=httpServletRequest.getParameter("inrecordID");
			
			InTouRuPinRecord inTouRuPinRecord=intourupinrecordService.findById(Long.parseLong(inrecordID));
			
			inTouRuPinRecord.setCount(count);
			inTouRuPinRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			inTouRuPinRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			inTouRuPinRecord.setSupplyName(supplyName);
			inTouRuPinRecord.setPhoneNumber(phoneNumber);
			inTouRuPinRecord.setInput_time(format.parse(input_time));
			inTouRuPinRecord.setTouRuPin(touRuPin);
			intourupinrecordService.save(inTouRuPinRecord);
			
		}else
		{
		String inrecordID=httpServletRequest.getParameter("inrecordID");
		InTouRuPinRecord inTouRuPinRecord=intourupinrecordService.findById(Long.parseLong(inrecordID));
		
		String count=httpServletRequest.getParameter("count");
		String supplyName=httpServletRequest.getParameter("supplyName");
		String phoneNumber=httpServletRequest.getParameter("phoneNumber");
		String input_time=httpServletRequest.getParameter("input_time");
		
		String tourupinID=httpServletRequest.getParameter("name");
		
			tourupin=tourupinService.findById(Long.parseLong(tourupinID));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			//Date date=new Date();
			//String create=format.format(date);
				
			
			inTouRuPinRecord.setCount(count);//
			inTouRuPinRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			inTouRuPinRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			inTouRuPinRecord.setSupplyName(supplyName);///
			inTouRuPinRecord.setPhoneNumber(phoneNumber);//
			inTouRuPinRecord.setInput_time(format.parse(input_time));//
			inTouRuPinRecord.setTouRuPin(tourupin);
			intourupinrecordService.save(inTouRuPinRecord);
			
			
		}
		
		return SUCCESS;
	}

	private List<InTouRuPinRecord> intourupinrecordList2=new ArrayList<InTouRuPinRecord>();

	public List<InTouRuPinRecord> getIntourupinrecordList2() {
		return intourupinrecordList2;
	}

	public void setIntourupinrecordList2(
			List<InTouRuPinRecord> intourupinrecordList2) {
		this.intourupinrecordList2 = intourupinrecordList2;
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
			intourupinrecord=intourupinrecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			intourupinrecordList2.add(intourupinrecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("intourupinrecordList2", intourupinrecordList2);
		//datamap.put("enterpriseName", enterpriseName);
		//datamap.put("yearth", yearth);
		
		String templatefile = "intourupinrecord.ftl";//销售记录ftl模板
		String docfilename =  "intourupinrecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("农业投入品（农药、肥料）进货记录.doc","UTF-8"));
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