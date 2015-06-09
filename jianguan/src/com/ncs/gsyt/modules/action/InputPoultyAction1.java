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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.PoultryKinds;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.InputPoultyService;
import com.ncs.gsyt.modules.service.PoultryKindsService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InputPoultyAction1 extends BaseAction implements ModelDriven<InputPoulty>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InputPoultyService inputpoultyService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private PoultryKindsService poultrykindsService;//品种
	

	private List<InputPoulty> inputPoultyList=new ArrayList<InputPoulty>();
	public List<InputPoulty> getInputPoultyList() {
		return inputPoultyList;
	}

	public void setInputPoultyList(List<InputPoulty> inputPoultyList) {
		this.inputPoultyList = inputPoultyList;
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

	private Enterprise enterprise=new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	private InputPoulty inputpoulty = new InputPoulty();
	

	
	public InputPoulty getInputpoulty() {
		return inputpoulty;
	}

	public void setInputpoulty(InputPoulty inputpoulty) {
		this.inputpoulty = inputpoulty;
	}

	@Override
	public InputPoulty getModel() {
		return inputpoulty;
	}
	
	@Action(value = "/inputpoulty1", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/inputpoultylist1.jsp"),
			@Result(name = "addinput", location = "/admin/poultry/addInputPoulty.jsp"),//添加
			@Result(name = "modify", location = "/admin/poultry/modifyInputPoulty.jsp")//修改
	})
	
	@Override
	public String execute() {
		
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		inputpoulty = new  InputPoulty();
		inputpoulty.setIdss(Long.parseLong(enterpriseID));
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		Search search = new Search(InputPoulty.class);
		search = this.getSearch(search);
		//查询出，引种记录下，和当前企业 相关的，引种记录；
		search.addFilterEqual("enterpriseID", enterpriseID);
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
	String poultryName=StringUtil.isNull(httpServletRequest.getParameter("poultryName"));
	if (!"".equals(poultryName)) {
		search.addFilterILike("poultryKinds.poultryName","%"+poultryName+"%");
	}
		
		
		

		int count = inputpoultyService.count(search);
		List<InputPoulty> list = inputpoultyService.searchAll(search);
		List<Map<String, Object>> inputpoultyList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InputPoulty obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getInPoultyID());
				row.put("cell",
						new Object[] { obj.getInPoultyID(),DateUtil.formatDate(obj.getInput_time(), "yyyy-MM-dd"),
						null!=obj.getPoultryKinds()?obj.getPoultryKinds().getPoultryName():""
							,obj.getCount(),obj.getProFactory(),obj.getProplace(),obj.getPhoneNumber(),obj.getKindCode(),
							obj.getCheckCode(),obj.getEnterpriseName()
								});//其他属性需按页面需要填写
				inputpoultyList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, inputpoultyList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**------------------添加 ------------------------------**/
	public String addInputP()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		poultryKindsList=poultrykindsService.searchAll(search);
		return "addinput";
	}
	
	/**-------------------保存添加的--------------------------------------**/
	public String saveAddInputP()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		String  poultryName1=httpServletRequest.getParameter("poultryName1");
		
	if(poultryName1!=null&&!"".equals(poultryName1)){
		Enterprise enterprise=user.getEnterprise();
		//poultryName1=httpServletRequest.getParameter("poultryName");
		
		poultryKinds.setEnterprise(enterprise);
		poultryKinds.setPoultryName(poultryName1);
		poultrykindsService.save(poultryKinds);
		/**------------------------------------------**/
		SimpleDateFormat formt= new SimpleDateFormat("yyyy-MM-dd");
		
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		long enterpriseID=user.getEnterprise().getEnterpriseID();
		String input_time=httpServletRequest.getParameter("input_time");//引种时间
		Date date=formt.parse(input_time);
		
		String count=httpServletRequest.getParameter("count");//数量
		String proFactory=httpServletRequest.getParameter("proFactory");//生产厂
		String proplace=httpServletRequest.getParameter("proplace");//地址
		String phoneNumber=httpServletRequest.getParameter("phoneNumber");//联系电话
		String kindCode=httpServletRequest.getParameter("kindCode");//品种证号
		String checkCode=httpServletRequest.getParameter("checkCode");//检疫证号
		
		InputPoulty inputPoulty=new InputPoulty();
		inputPoulty.setInput_time(date);
		inputPoulty.setPoultryKinds(poultryKinds);
		inputPoulty.setCount(count);
		inputPoulty.setProFactory(proFactory);
		inputPoulty.setProplace(proplace);
		inputPoulty.setPhoneNumber(phoneNumber);
		inputPoulty.setKindCode(kindCode);
		inputPoulty.setCheckCode(checkCode);
		inputPoulty.setEnterpriseID(enterpriseID);
		inputPoulty.setEnterpriseName(enterpriseName);
		inputpoultyService.save(inputPoulty);
		
	}
	else{	
		SimpleDateFormat formt= new SimpleDateFormat("yyyy-MM-dd");
		
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		long enterpriseID=user.getEnterprise().getEnterpriseID();
		String input_time=httpServletRequest.getParameter("input_time");//引种时间
		Date date=formt.parse(input_time);
		
		String poultryID=httpServletRequest.getParameter("poultryName");//这是品种里的商品 ID
		poultryKinds=poultrykindsService.findById(Long.parseLong(poultryID));//品种
		
		String count=httpServletRequest.getParameter("count");//数量
		String proFactory=httpServletRequest.getParameter("proFactory");//生产厂
		String proplace=httpServletRequest.getParameter("proplace");//地址
		String phoneNumber=httpServletRequest.getParameter("phoneNumber");//联系电话
		String kindCode=httpServletRequest.getParameter("kindCode");//品种证号
		String checkCode=httpServletRequest.getParameter("checkCode");//检疫证号
		
		InputPoulty inputPoulty=new InputPoulty();
		inputPoulty.setInput_time(date);
		inputPoulty.setPoultryKinds(poultryKinds);
		inputPoulty.setCount(count);
		inputPoulty.setProFactory(proFactory);
		inputPoulty.setProplace(proplace);
		inputPoulty.setPhoneNumber(phoneNumber);
		inputPoulty.setKindCode(kindCode);
		inputPoulty.setCheckCode(checkCode);
		inputPoulty.setEnterpriseID(enterpriseID);
		inputPoulty.setEnterpriseName(enterpriseName);
		inputpoultyService.save(inputPoulty);
		
	}
		return SUCCESS;
	}
	/**---------------------修改--------------------------------------------**/
	public String modifyInput()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise =user.getEnterprise();
		Search search=new Search(PoultryKinds.class);
		search.addFilterEqual("enterprise", enterprise);
		//获得当前企业下的商品记录；
		 poultryKindsList=poultrykindsService.searchAll(search);
		
		String id=httpServletRequest.getParameter("ouc");
		inputpoulty=inputpoultyService.findById(Long.parseLong(id));
		
		return "modify";
	}
	
	/**---------------保存修改的--------------------------------**/
	
	public String saveModify()throws Exception
	{
		
		SimpleDateFormat formt= new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		String  poultryName1=httpServletRequest.getParameter("poultryName1");
		
		if(poultryName1!=null&&!"".equals(poultryName1))
		{
			Enterprise enterprise=user.getEnterprise();
			//poultryName1=httpServletRequest.getParameter("poultryName");
			
			poultryKinds.setEnterprise(enterprise);
			poultryKinds.setPoultryName(poultryName1);
			poultrykindsService.save(poultryKinds);
			/**------------------------------------------**/
			String enterpriseName=user.getEnterprise().getEnterpriseName();
			long enterpriseID=user.getEnterprise().getEnterpriseID();
			
			String id=httpServletRequest.getParameter("inPoultyID");
			inputpoulty=inputpoultyService.findById(Long.parseLong(id));//获取需要修改的对象信息；
			
			String input_time=httpServletRequest.getParameter("input_time");//引种时间
			Date date=formt.parse(input_time);
			
			
			String count=httpServletRequest.getParameter("count");//数量
			String proFactory=httpServletRequest.getParameter("proFactory");//生产厂
			String proplace=httpServletRequest.getParameter("proplace");//地址
			String phoneNumber=httpServletRequest.getParameter("phoneNumber");//联系电话
			String kindCode=httpServletRequest.getParameter("kindCode");//品种证号
			String checkCode=httpServletRequest.getParameter("checkCode");//检疫证号
			
			//InputPoulty inputPoulty=new InputPoulty();
			inputpoulty.setInput_time(date);
			inputpoulty.setPoultryKinds(poultryKinds);
			inputpoulty.setCount(count);
			inputpoulty.setProFactory(proFactory);
			inputpoulty.setProplace(proplace);
			inputpoulty.setPhoneNumber(phoneNumber);
			inputpoulty.setKindCode(kindCode);
			inputpoulty.setCheckCode(checkCode);
			inputpoulty.setEnterpriseID(enterpriseID);
			inputpoulty.setEnterpriseName(enterpriseName);
			inputpoultyService.save(inputpoulty);
			
			
		}else
		{
		
		String enterpriseName=user.getEnterprise().getEnterpriseName();
		long enterpriseID=user.getEnterprise().getEnterpriseID();
		
		String id=httpServletRequest.getParameter("inPoultyID");
		inputpoulty=inputpoultyService.findById(Long.parseLong(id));//获取需要修改的对象信息；
		
		String input_time=httpServletRequest.getParameter("input_time");//引种时间
		Date date=formt.parse(input_time);
		
		String poultryID=httpServletRequest.getParameter("poultryName");//这是品种里的商品 ID
		poultryKinds=poultrykindsService.findById(Long.parseLong(poultryID));//品种
		
		String count=httpServletRequest.getParameter("count");//数量
		String proFactory=httpServletRequest.getParameter("proFactory");//生产厂
		String proplace=httpServletRequest.getParameter("proplace");//地址
		String phoneNumber=httpServletRequest.getParameter("phoneNumber");//联系电话
		String kindCode=httpServletRequest.getParameter("kindCode");//品种证号
		String checkCode=httpServletRequest.getParameter("checkCode");//检疫证号
		
		//InputPoulty inputPoulty=new InputPoulty();
		inputpoulty.setInput_time(date);
		inputpoulty.setPoultryKinds(poultryKinds);
		inputpoulty.setCount(count);
		inputpoulty.setProFactory(proFactory);
		inputpoulty.setProplace(proplace);
		inputpoulty.setPhoneNumber(phoneNumber);
		inputpoulty.setKindCode(kindCode);
		inputpoulty.setCheckCode(checkCode);
		inputpoulty.setEnterpriseID(enterpriseID);
		inputpoulty.setEnterpriseName(enterpriseName);
		inputpoultyService.save(inputpoulty);
		
		}
		return SUCCESS;
	}
	
	

	/**-----------文档下载-------------------**/
	public String loadocc()throws Exception
	{
		//HttpSession session=httpServletRequest.getSession(true);
		//User user=(User)session.getAttribute("ADMIN_USER");
		//String enterpriseName=user.getEnterprise().getEnterpriseName();
		String yearth="2014";
		
		
		String ids=httpServletRequest.getParameter("ouc");
		String[] idss=ids.split(",");
		for(int i=0;i<idss.length;i++)
		{
			inputpoulty=inputpoultyService.findById(Long.parseLong(idss[i]));//获取sale记录
			inputPoultyList.add(inputpoulty);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("inputPoultyList", inputPoultyList);
		//datamap.put("enterpriseName", enterpriseName);
		//datamap.put("yearth", yearth);
		
		String templatefile = "inputpoulty.ftl";//销售记录ftl模板
		String docfilename =  "inputpoulty.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("引种记录表.doc","UTF-8"));
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