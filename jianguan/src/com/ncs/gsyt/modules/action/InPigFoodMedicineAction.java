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
import com.ncs.gsyt.modules.model.InPigFoodMedicine;
import com.ncs.gsyt.modules.model.MuZhuPeiZhongRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.InPigFoodMedicineService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InPigFoodMedicineAction extends BaseAction implements ModelDriven<InPigFoodMedicine>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InPigFoodMedicineService inpigfoodmedicineService;
	
	private InPigFoodMedicine inpigfoodmedicine = new InPigFoodMedicine();
	
	public InPigFoodMedicine getInpigfoodmedicine() {
		return inpigfoodmedicine;
	}

	public void setInpigfoodmedicine(InPigFoodMedicine inpigfoodmedicine) {
		this.inpigfoodmedicine = inpigfoodmedicine;
	}



	private List<InPigFoodMedicine> inpigfoodmedicineList=new ArrayList<InPigFoodMedicine>();
	
	public List<InPigFoodMedicine> getInpigfoodmedicineList() {
		return inpigfoodmedicineList;
	}

	public void setInpigfoodmedicineList(
			List<InPigFoodMedicine> inpigfoodmedicineList) {
		this.inpigfoodmedicineList = inpigfoodmedicineList;
	}

	public InPigFoodMedicine getInPigFoodMedicine() {
		return inpigfoodmedicine;
	}
	
	@Override
	public InPigFoodMedicine getModel() {
		return inpigfoodmedicine;
	}
	
	@Action(value = "/inpigfoodmedicine", results = {
			@Result(name = SUCCESS, location = "/admin/pig/inpigfoodmedicinelist.jsp"),
			@Result(name = "add", location = "/admin/pig/addinpigfoodmedicine.jsp"),
			@Result(name = "modify", location = "/admin/pig/modifyinpigfoodmedicine.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Search search = new Search(InPigFoodMedicine.class);
		search = this.getSearch(search);
		//帅选出当前企业下的，记录；
		search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("lastTime",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("lastTime", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("lastTime",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//品名查询
	String name=StringUtil.isNull(httpServletRequest.getParameter("name"));
	if (!"".equals(name)) {
		search.addFilterILike("name","%"+name+"%");
	}
		
		/*根据前台条件生成对应属性判断条件*/

		int count = inpigfoodmedicineService.count(search);
		List<InPigFoodMedicine> list = inpigfoodmedicineService.searchAll(search);
		List<Map<String, Object>> inpigfoodmedicineList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InPigFoodMedicine obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPigFoodMedicineID());
				row.put("cell",
						new Object[] { obj.getPigFoodMedicineID(),obj.getName(),obj.getProFactory(),
						obj.getPiWenPiHao(),obj.getGuige(),obj.getSinglePrice(),DateUtil.formatDate(obj.getLastTime(), "yyyy-MM-dd"),obj.getEnterpriseName()});//其他属性需按页面需要填写
				inpigfoodmedicineList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, inpigfoodmedicineList);

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
		
		
		InPigFoodMedicine inPigFoodMedicine=new InPigFoodMedicine();
			String name=httpServletRequest.getParameter("name");
			String proFactory=httpServletRequest.getParameter("proFactory");
			String piWenPiHao=httpServletRequest.getParameter("piWenPiHao");
			String guige=httpServletRequest.getParameter("guige");
			String singlePrice=httpServletRequest.getParameter("singlePrice");
			String lastTime=httpServletRequest.getParameter("lastTime");
			Date date=fomt.parse(lastTime);
			inPigFoodMedicine.setName(name);
			inPigFoodMedicine.setProFactory(proFactory);
			inPigFoodMedicine.setPiWenPiHao(piWenPiHao);
			inPigFoodMedicine.setGuige(guige);
			inPigFoodMedicine.setSinglePrice(singlePrice);
			inPigFoodMedicine.setLastTime(date);
			inPigFoodMedicine.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			inPigFoodMedicine.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			inpigfoodmedicineService.save(inPigFoodMedicine);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(id));
		
		return "modify";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String pigFoodMedicineID=httpServletRequest.getParameter("pigFoodMedicineID");
		InPigFoodMedicine inPigFoodMedicine=inpigfoodmedicineService.findById(Long.parseLong(pigFoodMedicineID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String name=httpServletRequest.getParameter("name");
			String proFactory=httpServletRequest.getParameter("proFactory");
			String piWenPiHao=httpServletRequest.getParameter("piWenPiHao");
			String guige=httpServletRequest.getParameter("guige");
			String singlePrice=httpServletRequest.getParameter("singlePrice");
			String lastTime=httpServletRequest.getParameter("lastTime");
			Date date=fomt.parse(lastTime);
			inPigFoodMedicine.setName(name);
			inPigFoodMedicine.setProFactory(proFactory);
			inPigFoodMedicine.setPiWenPiHao(piWenPiHao);
			inPigFoodMedicine.setGuige(guige);
			inPigFoodMedicine.setSinglePrice(singlePrice);
			inPigFoodMedicine.setLastTime(date);
			inPigFoodMedicine.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			inPigFoodMedicine.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			inpigfoodmedicineService.save(inPigFoodMedicine);
		
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
			inpigfoodmedicine=inpigfoodmedicineService.findById(Long.parseLong(idss[i]));//获取sale记录
			inpigfoodmedicineList.add(inpigfoodmedicine);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("inpigfoodmedicineList", inpigfoodmedicineList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "inpigfoodmedicine.ftl";//销售记录ftl模板
		String docfilename =  "inpigfoodmedicine.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("投入品记录.doc","UTF-8"));
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