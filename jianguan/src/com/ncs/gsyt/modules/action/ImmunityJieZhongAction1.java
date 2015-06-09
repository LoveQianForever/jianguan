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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.FoodMedicineSupply;
import com.ncs.gsyt.modules.model.ImmunityJieZhong;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.PigSaleRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.ImmunityJieZhongService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class ImmunityJieZhongAction1 extends BaseAction implements ModelDriven<ImmunityJieZhong>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private ImmunityJieZhongService immunityjiezhongService;
	
	private List<ImmunityJieZhong> immunityjiezhongList=new ArrayList<ImmunityJieZhong>();
	public List<ImmunityJieZhong> getImmunityjiezhongList() {
		return immunityjiezhongList;
	}

	public void setImmunityjiezhongList(List<ImmunityJieZhong> immunityjiezhongList) {
		this.immunityjiezhongList = immunityjiezhongList;
	}



	private ImmunityJieZhong immunityjiezhong = new ImmunityJieZhong();
	
	public ImmunityJieZhong getImmunityjiezhong() {
		return immunityjiezhong;
	}

	public void setImmunityjiezhong(ImmunityJieZhong immunityjiezhong) {
		this.immunityjiezhong = immunityjiezhong;
	}

	public ImmunityJieZhong getImmunityJieZhong() {
		return immunityjiezhong;
	}
	
	@Override
	public ImmunityJieZhong getModel() {
		return immunityjiezhong;
	}
	
	@Action(value = "/immunityjiezhong1", results = {
			@Result(name = SUCCESS, location = "/admin/pig/immunityjiezhonglist1.jsp"),
			@Result(name = "addjiezhong", location = "/admin/pig/addImmunityjiezhongedit.jsp"),
			@Result(name = "modifyjiezhong", location = "/admin/pig/modifyImmunityjiezhongedit.jsp")
	})
	
	@Override
	public String execute() {
		String enterpriseID=httpServletRequest.getParameter("enterpriseID");
		immunityjiezhong=new ImmunityJieZhong();
		immunityjiezhong.setIdss(Long.parseLong(enterpriseID));
		
		
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		/*HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");*/
		long enterpriseID=Long.parseLong(httpServletRequest.getParameter("enterpriseID"));
		
		Search search = new Search(ImmunityJieZhong.class);
		search = this.getSearch(search);
		
		search.addFilterEqual("enterpriseID", enterpriseID);
		//search.addFilterEqual("enterpriseID", user.getEnterprise().getEnterpriseID());
		
		/*根据前台条件生成对应属性判断条件*/

		//前次日期查询
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
//本次日期
	
	String gaptime1="";
	String begindate1 =StringUtil.isNull(httpServletRequest.getParameter("begindate1"));

	String enddate1 =StringUtil.isNull(httpServletRequest.getParameter("enddate1"));
if (!"".equals(begindate1)) {         //起始条件不为空
	search.addFilterGreaterOrEqual("nowTime",formt.parse(begindate1+" 00:00:00"));
	gaptime=begindate+"后";
	if (!"".equals(enddate1)) {
		search.addFilterLessOrEqual("nowTime", formt.parse(enddate1+" 23:59:59"));
		gaptime=begindate1+"到"+enddate1;
	}
	
}else{
	if (!"".equals(enddate1)) {
		search.addFilterLessOrEqual("nowTime",formt.parse(enddate1+" 23:59:59"));
		gaptime1=enddate1+"之前";
	}
	gaptime1="所有日期";
}
		
		

		int count = immunityjiezhongService.count(search);
		List<ImmunityJieZhong> list = immunityjiezhongService.searchAll(search);
		List<Map<String, Object>> immunityjiezhongList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				ImmunityJieZhong obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getImmunityID());
				row.put("cell",
						new Object[] { obj.getImmunityID(),obj.getXubie(),obj.getProductName(),
						obj.getDongbie(),obj.getLanhao(),obj.getYufangAis(),DateUtil.formatDate(obj.getLastTime(), "yyyy-MM-dd"),
						DateUtil.formatDate(obj.getNowTime(), "yyyy-MM-dd"),obj.getCount(),obj.getUseYimiao(),obj.getJiLiang(),
						obj.getTuJing(),obj.getNumber(),obj.getReback(),obj.getImmu_name()});//其他属性需按页面需要填写
				immunityjiezhongList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, immunityjiezhongList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	
	

	/**-------------添加信息-----------------------**/
	public String addJieZhong()throws Exception
	{
		
		return "addjiezhong";
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAddJieZhong()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		ImmunityJieZhong immunityJieZhong=new ImmunityJieZhong();
			String xubie=httpServletRequest.getParameter("xubie");
			String productName=httpServletRequest.getParameter("productName");
			String dongbie=httpServletRequest.getParameter("dongbie");
			String lanhao=httpServletRequest.getParameter("lanhao");
			String yufangAis=httpServletRequest.getParameter("yufangAis");
			
			String lastTime=httpServletRequest.getParameter("lastTime");
			/**分割 日期，以便获取到年、月、日 的值**/
			String[] lastt=lastTime.split("-");

			String nowTime=httpServletRequest.getParameter("nowTime");
			/**分割 日期，以便获取到年、月、日 的值**/
			String[] nowt=nowTime.split("-");
			String count=httpServletRequest.getParameter("count");
			String useYimiao=httpServletRequest.getParameter("useYimiao");
			String jiLiang=httpServletRequest.getParameter("jiLiang");
			String tuJing=httpServletRequest.getParameter("tuJing");
			String number=httpServletRequest.getParameter("number");
			String reback=httpServletRequest.getParameter("reback");
			String immu_name=httpServletRequest.getParameter("immu_name");
			
			immunityJieZhong.setXubie(xubie);
			immunityJieZhong.setProductName(Long.parseLong(productName));
			immunityJieZhong.setDongbie(dongbie);
			immunityJieZhong.setLanhao(lanhao);
			immunityJieZhong.setYufangAis(yufangAis);
			immunityJieZhong.setLastTime(fomt.parse(lastTime));
			immunityJieZhong.setNowTime(fomt.parse(nowTime));
			immunityJieZhong.setCount(count);
			immunityJieZhong.setUseYimiao(useYimiao);
			immunityJieZhong.setJiLiang(jiLiang);
			immunityJieZhong.setTuJing(tuJing);
			immunityJieZhong.setNumber(number);
			immunityJieZhong.setReback(reback);
			immunityJieZhong.setImmu_name(immu_name);
			immunityJieZhong.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			immunityJieZhong.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			immunityJieZhong.setYear1(lastt[0]);
			immunityJieZhong.setMonth1(lastt[1]);
			immunityJieZhong.setDay1(lastt[2]);
			immunityJieZhong.setYear2(nowt[0]);
			immunityJieZhong.setMonth2(nowt[1]);
			immunityJieZhong.setDay2(nowt[2]);
			immunityjiezhongService.save(immunityJieZhong);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modifyJieZhong() throws Exception
	{
		
		String id=httpServletRequest.getParameter("ouc");
		immunityjiezhong=immunityjiezhongService.findById(Long.parseLong(id));
		
		
		return "modifyjiezhong";
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModifyJieZhong() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//参数
		String immunityID=httpServletRequest.getParameter("immunityID");
		immunityjiezhong=immunityjiezhongService.findById(Long.parseLong(immunityID));
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		//ImmunityJieZhong immunityJieZhong=new ImmunityJieZhong();
			String xubie=httpServletRequest.getParameter("xubie");
			String productName=httpServletRequest.getParameter("productName");
			String dongbie=httpServletRequest.getParameter("dongbie");
			String lanhao=httpServletRequest.getParameter("lanhao");
			String yufangAis=httpServletRequest.getParameter("yufangAis");
			
			String lastTime=httpServletRequest.getParameter("lastTime");
			/**分割 日期，以便获取到年、月、日 的值**/
			String[] lastt=lastTime.split("-");

			String nowTime=httpServletRequest.getParameter("nowTime");
			/**分割 日期，以便获取到年、月、日 的值**/
			String[] nowt=nowTime.split("-");
			String count=httpServletRequest.getParameter("count");
			String useYimiao=httpServletRequest.getParameter("useYimiao");
			String jiLiang=httpServletRequest.getParameter("jiLiang");
			String tuJing=httpServletRequest.getParameter("tuJing");
			String number=httpServletRequest.getParameter("number");
			String reback=httpServletRequest.getParameter("reback");
			String immu_name=httpServletRequest.getParameter("immu_name");
			
			immunityjiezhong.setXubie(xubie);
			immunityjiezhong.setProductName(Long.parseLong(productName));
			immunityjiezhong.setDongbie(dongbie);
			immunityjiezhong.setLanhao(lanhao);
			immunityjiezhong.setYufangAis(yufangAis);
			immunityjiezhong.setLastTime(fomt.parse(lastTime));
			immunityjiezhong.setNowTime(fomt.parse(nowTime));
			immunityjiezhong.setCount(count);
			immunityjiezhong.setUseYimiao(useYimiao);
			immunityjiezhong.setJiLiang(jiLiang);
			immunityjiezhong.setTuJing(tuJing);
			immunityjiezhong.setNumber(number);
			immunityjiezhong.setReback(reback);
			immunityjiezhong.setImmu_name(immu_name);
			immunityjiezhong.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			immunityjiezhong.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			immunityjiezhong.setYear1(lastt[0]);
			immunityjiezhong.setMonth1(lastt[1]);
			immunityjiezhong.setDay1(lastt[2]);
			immunityjiezhong.setYear2(nowt[0]);
			immunityjiezhong.setMonth2(nowt[1]);
			immunityjiezhong.setDay2(nowt[2]);
			immunityjiezhongService.save(immunityjiezhong);
		
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
			immunityjiezhong=immunityjiezhongService.findById(Long.parseLong(idss[i]));//获取sale记录
			immunityjiezhongList.add(immunityjiezhong);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("immunityjiezhongList", immunityjiezhongList);
		//datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "immunityjiezhong.ftl";//销售记录ftl模板
		String docfilename =  "immunityjiezhong.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("免疫接种记录.doc","UTF-8"));
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