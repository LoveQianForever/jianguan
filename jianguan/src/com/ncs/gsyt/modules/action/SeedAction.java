package com.ncs.gsyt.modules.action;

import java.io.PrintWriter;
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
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Seed;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.SeedInService;
import com.ncs.gsyt.modules.service.SeedOutService;
import com.ncs.gsyt.modules.service.SeedService;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class SeedAction extends BaseAction implements ModelDriven<Seed>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private SeedService seedService;
	@Resource
	private SeedInService seedinService;
	@Resource
	private SeedOutService seedoutService;
	
	private SeedOut seedout=new SeedOut();
	
	public SeedOut getSeedout() {
		return seedout;
	}

	public void setSeedout(SeedOut seedout) {
		this.seedout = seedout;
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

	private List<SeedIn> seedinList=new ArrayList<SeedIn>();
	public List<SeedIn> getSeedinList() {
		return seedinList;
	}

	public void setSeedinList(List<SeedIn> seedinList) {
		this.seedinList = seedinList;
	}

	private List<SeedOut> seedoutList=new ArrayList<SeedOut>();
	public List<SeedOut> getSeedoutList() {
		return seedoutList;
	}

	public void setSeedoutList(List<SeedOut> seedoutList) {
		this.seedoutList = seedoutList;
	}

	private Seed seed = new Seed();
	
	
	
	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}

	@Override
	public Seed getModel() {
		return seed;
	}
	
	@Action(value = "/seed", results = {
			@Result(name = SUCCESS, location = "/admin/seedproduct/seedlist.jsp"),
			@Result(name = "addSeed", location = "/admin/seedproduct/addSeed.jsp"),
			@Result(name = "modifySeed", location = "/admin/seedproduct/modifySeed.jsp"),
			@Result(name = "seedshow", location = "/admin/seedproduct/seedshow.jsp"),
			@Result(name = "stopModify", location = "/admin/seedproduct/modifySeed1.jsp"),
			@Result(name = "stopDelete", location = "/admin/seedproduct/modifySeed2.jsp")
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {

		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		enterprise=user.getEnterprise();
		
		Search search = new Search(Seed.class);
		search = this.getSearch(search);
		search.addFilterEqual("enterprise", enterprise);
		
	if(seed.getSeed_name()!=null &&!"".equals(seed.getSeed_name()))
	{
		search.addFilterILike("seed_name","%"+seed.getSeed_name()+"%");
	}
	if(seed.getSeed_group()!=null&&!"".equals(seed.getSeed_group()))
	{
		search.addFilterILike("seed_group","%"+ seed.getSeed_group()+"%");
	}
	if(seed.getSeed_place()!=null&& !"".equals(seed.getSeed_place()))
	{
		search.addFilterILike("seed_place", "%"+seed.getSeed_place()+"%");
	}
	if(seed.getSeed_code()!=null&&!"".equals(seed.getSeed_code()))
	{
		search.addFilterILike("seed_code","%"+seed.getSeed_code()+"%");
	
	}
		/*根据前台条件生成对应属性判断条件*/

		int count = seedService.count(search);
		List<Seed> list = seedService.searchAll(search);
		List<Map<String, Object>> seedList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Seed obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getSeed_id());
				row.put("cell",
						new Object[] { obj.getSeed_id(),obj.getSeed_name(),obj.getSeed_group(),obj.getSeed_place()
						,obj.getSeed_code(),obj.getStore_condition(),null!=obj.getEnterprise()?obj.getEnterprise().getEnterpriseName():""});//其他属性需按页面需要填写
				seedList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, seedList);

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
		String seed_name=httpServletRequest.getParameter("seed_name");
		String seed_group=httpServletRequest.getParameter("seed_group");
		String seed_place=httpServletRequest.getParameter("seed_place");
		String seed_code=httpServletRequest.getParameter("seed_code");
		String seed_pack=httpServletRequest.getParameter("seed_pack");
		String store_condition=httpServletRequest.getParameter("store_condition");
		Seed seed=new Seed();
		seed.setSeed_name(seed_name);
		seed.setSeed_group(seed_group);
		seed.setSeed_place(seed_place);
		seed.setSeed_code(seed_code);
		seed.setSeed_pack(seed_pack);
		seed.setStore_condition(store_condition);
		seed.setEnterprise(user.getEnterprise());
		seedService.save(seed);
		return SUCCESS;
	}
	
	/**--------------保存 添加的商品------------------------------**/
	
	/**-------------修改商品 modifySeed--------------------------**/
	public String modifySeed() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//获得要修改的商品
		String id=httpServletRequest.getParameter("ouc");
		seed=seedService.findById(Long.parseLong(id));
		//查询销售表，有没有此类商品的销售记录
		Search search11=new Search(SeedOut.class);
		search11.addFilterEqual("seed",seed);
		System.out.println(seedoutService.count(search11)+"----");
		int count=seedoutService.count(search11);
		if(count==0)
		{
		return "modifySeed";
		}
		else
		{
			
			return "stopModify";
		}
		
	}
	
	
	//保存修改的商品信息
	public String saveModifySeed()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		user=(User)session.getAttribute("ADMIN_USER");
		String seed_id=httpServletRequest.getParameter("seed_id");
		String seed_name=httpServletRequest.getParameter("seed_name");
		String seed_group=httpServletRequest.getParameter("seed_group");
		String seed_place=httpServletRequest.getParameter("seed_place");
		String seed_code=httpServletRequest.getParameter("seed_code");
		String seed_pack=httpServletRequest.getParameter("seed_pack");
		String store_condition=httpServletRequest.getParameter("store_condition");
		
		seed=seedService.findById(Long.parseLong(seed_id));
		seed.setSeed_name(seed_name);
		seed.setSeed_group(seed_group);
		seed.setSeed_place(seed_place);
		seed.setSeed_code(seed_code);
		seed.setSeed_pack(seed_pack);
		seed.setStore_condition(store_condition);
		seed.setEnterprise(user.getEnterprise());
		seedService.save(seed);
		return SUCCESS;
	}
	
	/*******************删除商品 deleteSeed***********************************/
	public String deleteSeed() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		//获得要删除的商品
		String id=httpServletRequest.getParameter("ouc");
		seed=seedService.findById(Long.parseLong(id));
		//查询销售表，有没有此类商品的销售记录
		Search search11=new Search(SeedOut.class);
		search11.addFilterEqual("seed",seed);
		System.out.println(seedoutService.count(search11)+"----");
		int count=seedoutService.count(search11);
		//查询进货单，有没有此类商品的进货记录
		Search search12=new Search(SeedIn.class);
		search12.addFilterEqual("seed",seed);
		System.out.println(seedoutService.count(search11)+"----");
		int count1=seedinService.count(search12);
		if(count==0&&count1==0)
		{
			seedService.remove(seed);
			return SUCCESS;
		}else
		{
			return "stopDelete";
		}
		
	}
	
	/**__________进货商品的展示_______________________**/
	public String seedShow()throws Exception
	{
		String id=httpServletRequest.getParameter("id");
		seed=seedService.findById(Long.parseLong(id));
		return "seedshow";
	}
}