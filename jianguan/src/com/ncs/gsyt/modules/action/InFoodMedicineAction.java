package com.ncs.gsyt.modules.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.model.InFoodMedicine;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.FoodUseRecordService;
import com.ncs.gsyt.modules.service.InFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InFoodMedicineService;
import com.ncs.gsyt.modules.service.MedicineUseRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class InFoodMedicineAction extends BaseAction implements ModelDriven<InFoodMedicine>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private InFoodMedicineService infoodmedicineService;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private InFoodMedicineRecordService infoodmedicinerecordService;
	
	@Resource
	private FoodUseRecordService fooduserecordService;
	
	@Resource
	private MedicineUseRecordService medicineuserecordService;
	
	private Enterprise enterprise=new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	private InFoodMedicine infoodmedicine = new InFoodMedicine();

	
	public InFoodMedicine getInfoodmedicine() {
		return infoodmedicine;
	}

	public void setInfoodmedicine(InFoodMedicine infoodmedicine) {
		this.infoodmedicine = infoodmedicine;
	}

	@Override
	public InFoodMedicine getModel() {
		return infoodmedicine;
	}
	
	@Action(value = "/infoodmedicine", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/infoodmedicinelist.jsp"),
			@Result(name = "addFoodM", location = "/admin/poultry/addInFoodMedicine.jsp"),
			@Result(name = "modifyF", location = "/admin/poultry/modifyInFoodMedicine.jsp"),
			@Result(name = "stopModify", location = "/admin/poultry/modifyInFoodMedicine1.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(InFoodMedicine.class);
		search = this.getSearch(search);
		
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise =user.getEnterprise();
		//查询出，当前记录下，和当前企业相关的，投入品信息；
		search.addFilterEqual("enterprise", enterprise);
		
		/*根据前台条件生成对应属性判断条件*/
		//日期查询
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
	//产品名称
	String mf_name=StringUtil.isNull(httpServletRequest.getParameter("mf_name"));
	if (!"".equals(mf_name)) {
		search.addFilterILike("mf_name","%"+mf_name+"%");
	}
		
		
		

		int count = infoodmedicineService.count(search);
		List<InFoodMedicine> list = infoodmedicineService.searchAll(search);
		List<Map<String, Object>> infoodmedicineList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				InFoodMedicine obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getInmedicienfoodID());
				row.put("cell",
						new Object[] { obj.getInmedicienfoodID(),obj.getMf_name(),obj.getProFactory(),
						obj.getAcceptCode(),obj.getPackag(),
						obj.getSiglePrice(),(null!=obj.getLastTime()&&!"".equals(obj.getLastTime()))?DateUtil.formatDate(formt.parse(obj.getLastTime()), "yyyy-MM-dd"):"",
						null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():""});//其他属性需按页面需要填写
				infoodmedicineList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, infoodmedicineList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	
	/**---------添加 操作函数--------------------**/
	public String addFoodM() throws Exception
	{
		return "addFoodM";
	}
	
	
	/**-----------保存 添加的 信息 函数------------------------------**/
	public String saveAddFoodM() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		
		String mf_name=httpServletRequest.getParameter("mf_name");
		String proFactory=httpServletRequest.getParameter("proFactory");
		String acceptCode=httpServletRequest.getParameter("acceptCode");
		String packag=httpServletRequest.getParameter("packag");
		String siglePrice=httpServletRequest.getParameter("siglePrice");
		String lastTime=httpServletRequest.getParameter("lastTime");
		
		InFoodMedicine infoodMedicine=new InFoodMedicine();
		infoodMedicine.setMf_name(mf_name);
		infoodMedicine.setProFactory(proFactory);
		infoodMedicine.setAcceptCode(acceptCode);
		infoodMedicine.setPackag(packag);
		infoodMedicine.setSiglePrice(siglePrice);
		infoodMedicine.setLastTime(lastTime);
		infoodMedicine.setEnterprise(enterprise);
		infoodmedicineService.save(infoodMedicine);
		return SUCCESS;
	}
	
	
	/**----------------修改 记录信息 函数------------------------**/
	public String modifyFoodM() throws Exception
	{
		String id=httpServletRequest.getParameter("ouc");
		infoodmedicine=infoodmedicineService.findById(Long.parseLong(id));
		return "modifyF";
	}
	
	/**--------------------保存修改的信息 函数------------------------------------------**/
	public String saveModifyFoodM()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		
		String id=httpServletRequest.getParameter("inmedicienfoodID");
		infoodmedicine=infoodmedicineService.findById(Long.parseLong(id));
		
		String mf_name=httpServletRequest.getParameter("mf_name");
		String proFactory=httpServletRequest.getParameter("proFactory");
		String acceptCode=httpServletRequest.getParameter("acceptCode");
		String packag=httpServletRequest.getParameter("packag");
		String siglePrice=httpServletRequest.getParameter("siglePrice");
		String lastTime=httpServletRequest.getParameter("lastTime");
		
		//InFoodMedicine infoodMedicine=new InFoodMedicine();
		infoodmedicine.setMf_name(mf_name);
		infoodmedicine.setProFactory(proFactory);
		infoodmedicine.setAcceptCode(acceptCode);
		infoodmedicine.setPackag(packag);
		infoodmedicine.setSiglePrice(siglePrice);
		infoodmedicine.setLastTime(lastTime);
		infoodmedicine.setEnterprise(enterprise);
		infoodmedicineService.save(infoodmedicine);
		return SUCCESS;
	}
	
	
	/**-------------------删除 选择的记录---------------------------**/
	public String deleteFoodM()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//获得要修改的商品
		String id=httpServletRequest.getParameter("ouc");
		infoodmedicine=infoodmedicineService.findById(Long.parseLong(id));
		//查询投入品采购表，有没有此类商品的记录
		Search search1=new Search(InFoodMedicineRecord.class);
		search1.addFilterEqual("inFoodMedicine",infoodmedicine);
		int count=infoodmedicinerecordService.count(search1);
		//查询饲料使用记录，有没有此类商品记录
		Search search2=new Search(FoodUseRecord.class);
		search2.addFilterEqual("inFoodMedicine",infoodmedicine);
		int count2=fooduserecordService.count(search2);
		//查询兽药记录表，有没有此类商品的销售记录
		Search search3=new Search(MedicineUseRecord.class);
		search3.addFilterEqual("inFoodMedicine",infoodmedicine);
		int count3=medicineuserecordService.count(search3);
		if(count==0&&count2==0&&count3==0)
		{
			infoodmedicineService.remove(infoodmedicine);
			return SUCCESS;
		}else
		{
			return "stopModify";
		}
		
		
	}
}