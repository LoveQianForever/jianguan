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
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.model.TouRuPin;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.TouRuPinService;
import com.ncs.gsyt.modules.service.UserService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class TouRuPinAction1 extends BaseAction implements ModelDriven<TouRuPin>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private TouRuPinService tourupinService;
	
	private TouRuPin tourupin = new TouRuPin();
	@Resource
	private UserService userService;
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TouRuPin getTourupin() {
		return tourupin;
	}

	public void setTourupin(TouRuPin tourupin) {
		this.tourupin = tourupin;
	}

	public TouRuPin getTouRuPin() {
		return tourupin;
	}
	
	@Override
	public TouRuPin getModel() {
		return tourupin;
	}
	
	@Action(value = "/tourupin1", results = {
			@Result(name = SUCCESS, location = "/admin/tourupin/tourupinlist1.jsp"),
			@Result(name = "addSeed", location = "/admin/tourupin/addtourupin.jsp"),
			@Result(name = "modifySeed", location = "/admin/tourupin/modifytourupin.jsp"),
			@Result(name = "seedshow", location = "/admin/tourupin/tourupinshow.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		Search search = new Search(TouRuPin.class);
		search = this.getSearch(search);
		
		/*根据前台条件生成对应属性判断条件*/

		int count = tourupinService.count(search);
		List<TouRuPin> list = tourupinService.searchAll(search);
		List<Map<String, Object>> tourupinList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				TouRuPin obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getTourupinID());
				row.put("cell",
						new Object[] { obj.getTourupinID(),obj.getName(),obj.getGuige(),obj.getDengjiCode(),obj.getFactory()
						,obj.getProDate()});//其他属性需按页面需要填写
				tourupinList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, tourupinList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	

	/**-------------增加商品--------------------**/
	public String addSeed()throws Exception
	{
		
		return "addSeed";
	}
	
	//保存添加 的商品信息
	public String saveAddSeed()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		 user=(User)session.getAttribute("ADMIN_USER");
		httpServletRequest.setCharacterEncoding("utf-8");
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String name=httpServletRequest.getParameter("name");
		String guige=httpServletRequest.getParameter("guige");
		String dengjiCode=httpServletRequest.getParameter("dengjiCode");
		String factory=httpServletRequest.getParameter("factory");
		String proDate=httpServletRequest.getParameter("proDate");
		TouRuPin touRuPin=new TouRuPin();
		 touRuPin.setName(name);
		 touRuPin.setGuige(guige);
		 touRuPin.setDengjiCode(dengjiCode);
		 touRuPin.setFactory(factory);
		 touRuPin.setProDate(formt.parse(proDate));
		 touRuPin.setEnterpriseID(user.getEnterprise().getEnterpriseID());
		 touRuPin.setEnterpriseName(user.getEnterprise().getEnterpriseName());
		 tourupinService.save(touRuPin);
		
		
		return SUCCESS;
	}
	
	/**--------------保存 添加的商品------------------------------**/
	
	/**-------------修改商品 modifySeed--------------------------**/
	public String modifySeed() throws Exception
	{
		String id=httpServletRequest.getParameter("ouc");
		tourupin=tourupinService.findById(Long.parseLong(id));
		
		return "modifySeed";
		
	}
	
	
	//保存修改的商品信息
	public String saveModifySeed()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		String tourupinID=httpServletRequest.getParameter("tourupinID");
		
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		
		String name=httpServletRequest.getParameter("name");
		String guige=httpServletRequest.getParameter("guige");
		String dengjiCode=httpServletRequest.getParameter("dengjiCode");
		String factory=httpServletRequest.getParameter("factory");
		String proDate=httpServletRequest.getParameter("proDate");
		TouRuPin touRuPin=tourupinService.findById(Long.parseLong(tourupinID));
		 touRuPin.setName(name);
		 touRuPin.setGuige(guige);
		 touRuPin.setDengjiCode(dengjiCode);
		 touRuPin.setFactory(factory);
		 touRuPin.setProDate(formt.parse(proDate));
		 touRuPin.setEnterpriseID(user.getEnterprise().getEnterpriseID());
		 touRuPin.setEnterpriseName(user.getEnterprise().getEnterpriseName());
		 tourupinService.save(touRuPin);
		return SUCCESS;
	}
	
	/*******************删除商品 deleteSeed***********************************/
	public String deleteSeed() throws Exception
	{/*
		httpServletRequest.setCharacterEncoding("utf-8");
		httpServletResponse.setContentType("text/html;charset=utf-8");
		PrintWriter out=httpServletResponse.getWriter();*/
		
		String ouc=httpServletRequest.getParameter("ouc");
		String[] ids=ouc.split(",");
		for(int i=0;i<ids.length;i++)
		{
			tourupin=tourupinService.findById(Long.parseLong(ids[i]));
			//seedinList=seedinService.findAll();
			
			//seedoutList=seedoutService.findAll();
			tourupinService.remove(tourupin);
		}
		return SUCCESS;
	}
	
	/**__________进货商品的展示_______________________**/
	public String seedShow()throws Exception
	{
		String id=httpServletRequest.getParameter("id");
		tourupin=tourupinService.findById(Long.parseLong(id));
		return "seedshow";
	}
}