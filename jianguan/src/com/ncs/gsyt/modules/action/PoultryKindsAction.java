package com.ncs.gsyt.modules.action;

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
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.PoultryKinds;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.DieRecordService;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.InputPoultyService;
import com.ncs.gsyt.modules.service.PoultryKindsService;
import com.ncs.gsyt.modules.service.SaleRecordService;
import com.ncs.gsyt.modules.util.StringUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class PoultryKindsAction extends BaseAction implements ModelDriven<PoultryKinds>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private PoultryKindsService poultrykindsService;
	@Resource
	private SaleRecordService salerecordService;
	
	@Resource
	private EnterpriseService enterpriseService;//企业对象
	
	@Resource
	private InputPoultyService inputpoultyService;//企业对象
	@Resource
	private DieRecordService dierecordService;//企业对象
	
	private Enterprise enterprise=new Enterprise();//企业对象信息
	
	private PoultryKinds poultryKinds=new PoultryKinds();//品种对象
	

	public PoultryKinds getPoultryKinds() {
		return poultryKinds;
	}

	public void setPoultryKinds(PoultryKinds poultryKinds) {
		this.poultryKinds = poultryKinds;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	

	
	@Action(value = "/poultrykinds", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/poultrykindslist.jsp"),
			//用来做 添加 信息
			@Result(name = "addpoultry", location = "/admin/poultry/addPoultryKinds.jsp"),
			@Result(name = "modifyP", location = "/admin/poultry/modifyPoultryKinds.jsp"),
			@Result(name = "stopModify", location = "/admin/poultry/modifyPoultryKinds1.jsp"),
			@Result(name = "stopDelete", location = "/admin/poultry/modifyPoultryKinds2.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();
		Search search = new Search(PoultryKinds.class);
		search = this.getSearch(search);
		//帅选 禽类品种列表下，与当前企业相关的；禽类品种
		search.addFilterEqual("enterprise", enterprise);
		
		/*根据前台条件生成对应属性判断条件*/
		//产品名称
		String poultryName=StringUtil.isNull(httpServletRequest.getParameter("poultryName"));
		if (!"".equals(poultryName)) {
			search.addFilterILike("poultryName","%"+poultryName+"%");
		}

		int count = poultrykindsService.count(search);
		List<PoultryKinds> list = poultrykindsService.searchAll(search);
		List<Map<String, Object>> poultrykindsList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				PoultryKinds obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPoultryID());
				row.put("cell",
						new Object[] { obj.getPoultryID(),obj.getPoultryName(),
						null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():""});//其他属性需按页面需要填写
				poultrykindsList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, poultrykindsList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	/**---------添加 操作函数--------------------**/
	public String addPoultry() throws Exception
	{
		return "addpoultry";
	}
	
	
	/**-----------保存 添加的 信息 函数------------------------------**/
	public String saveAddPoultry() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		Enterprise enterprise=user.getEnterprise();
		
		String poultryName=httpServletRequest.getParameter("poultryName");
		
		poultryKinds.setEnterprise(enterprise);
		poultryKinds.setPoultryName(poultryName);
		poultrykindsService.save(poultryKinds);
		
		return SUCCESS;
	}
	
	
	/**----------------修改 记录信息 函数------------------------**/
	public String modifyPoultry() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//获得要修改的商品
		String id=httpServletRequest.getParameter("ouc");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));
		//查询销售表，有没有此类商品的销售记录
		Search search11=new Search(SaleRecord.class);
		search11.addFilterEqual("poultryKinds",poultryKinds);
		//System.out.println(seedoutService.count(search11)+"----");
		int count=salerecordService.count(search11);
		if(count==0)
		{
		return "modifyP";
		}
		else
		{
			return "stopModify";
		}
	}
	
	/**--------------------保存修改的信息 函数------------------------------------------**/
	public String saveModifyPoultry()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();
		String id=httpServletRequest.getParameter("poultryID");
		String name=httpServletRequest.getParameter("poultryName");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));
		poultryKinds.setPoultryName(name);
		poultryKinds.setEnterprise(enterprise);
		poultrykindsService.save(poultryKinds);
		return SUCCESS;
	}
	
	
	/**-------------------删除 选择的记录---------------------------**/
	public String deletePoultry()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//获得要修改的商品
		String id=httpServletRequest.getParameter("ouc");
		poultryKinds=poultrykindsService.findById(Long.parseLong(id));
		
		//查询引种记录表，有没有此类商品的引种记录
		Search search1=new Search(InputPoulty.class);
		search1.addFilterEqual("poultryKinds",poultryKinds);
		int count=inputpoultyService.count(search1);
		//查询病死处理记录，有没有此类商品的病死记录
		Search search2=new Search(DieRecord.class);
		search2.addFilterEqual("poultryKinds",poultryKinds);
		int count2=dierecordService.count(search2);
		//查询销售记录表，有没有此类商品的销售记录
		Search search3=new Search(SaleRecord.class);
		search3.addFilterEqual("poultryKinds",poultryKinds);
		int count3=salerecordService.count(search3);
		if(count==0&&count2==0&&count3==0)
		{
		poultrykindsService.remove(poultryKinds);
		return SUCCESS;
		}else
		{
		return "stopDelete";
		}
	}

	@Override
	public PoultryKinds getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}