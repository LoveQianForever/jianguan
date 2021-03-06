﻿package com.ncs.gsyt.modules.action;

import java.io.File;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.json.util.JSONObject;
import com.ncs.gsyt.constant.Constant;
import com.ncs.gsyt.core.base.action.BaseAction;
import com.ncs.gsyt.core.base.search.Search;
import com.ncs.gsyt.modules.model.CaiGou;
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.model.DisinfectionRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Enterpriseatta;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.model.ImmunityRecord;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.NongShi;
import com.ncs.gsyt.modules.model.ProductSale;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.ShengChan;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.YuMiao;
import com.ncs.gsyt.modules.model.YuSale;
import com.ncs.gsyt.modules.model.YuSiYang;
import com.ncs.gsyt.modules.model.ZhiLiang;
import com.ncs.gsyt.modules.service.CaiGouService;
import com.ncs.gsyt.modules.service.DieRecordService;
import com.ncs.gsyt.modules.service.DisinfectionRecordService;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.EnterpriseattaService;
import com.ncs.gsyt.modules.service.FoodUseRecordService;
import com.ncs.gsyt.modules.service.ImmunityRecordService;
import com.ncs.gsyt.modules.service.InFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InputPoultyService;
import com.ncs.gsyt.modules.service.MedicineUseRecordService;
import com.ncs.gsyt.modules.service.NongShiService;
import com.ncs.gsyt.modules.service.ProductSaleService;
import com.ncs.gsyt.modules.service.SaleRecordService;
import com.ncs.gsyt.modules.service.SeedInService;
import com.ncs.gsyt.modules.service.SeedOutService;
import com.ncs.gsyt.modules.service.ShengChanService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.service.YuMiaoService;
import com.ncs.gsyt.modules.service.YuSaleService;
import com.ncs.gsyt.modules.service.YuSiYangService;
import com.ncs.gsyt.modules.service.ZhiLiangService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.ImageUtil;
import com.ncs.gsyt.modules.util.UUIDGenerator;
import com.opensymphony.xwork2.ModelDriven;


/**
 *  水产监管
 * 
 * 这个类，主要为了实现 ---水产生产记录的监管---工作，
 *
 * 
 * **/
@Namespace("/admin")
@Controller
public class ZhongZhiMEnterpriseAction extends BaseAction implements ModelDriven<Enterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private EnterpriseattaService enterpriseattaService;
	

	
	private UserService userService;
	
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Resource
	private ShengChanService shengchanService;
	private List<ShengChan> shengchanList=new ArrayList<ShengChan>();
	@Resource
	private NongShiService nongshiService;
	private List<NongShi> nongshiList=new ArrayList<NongShi>();
	@Resource
	private ZhiLiangService zhiliangService;
	private List<ZhiLiang> zhiliangList=new ArrayList<ZhiLiang>();
	@Resource
	private ProductSaleService productsaleService;
	private List<ProductSale> productsaleList=new ArrayList<ProductSale>();
	

	public List<ShengChan> getShengchanList() {
		return shengchanList;
	}

	public void setShengchanList(List<ShengChan> shengchanList) {
		this.shengchanList = shengchanList;
	}

	public List<NongShi> getNongshiList() {
		return nongshiList;
	}

	public void setNongshiList(List<NongShi> nongshiList) {
		this.nongshiList = nongshiList;
	}

	public List<ZhiLiang> getZhiliangList() {
		return zhiliangList;
	}

	public void setZhiliangList(List<ZhiLiang> zhiliangList) {
		this.zhiliangList = zhiliangList;
	}

	public List<ProductSale> getProductsaleList() {
		return productsaleList;
	}

	public void setProductsaleList(List<ProductSale> productsaleList) {
		this.productsaleList = productsaleList;
	}
	private Enterprise enterprise = new Enterprise();
	
	public Enterprise getEnterprise() {
		return enterprise;
	}
	
	@Override
	public Enterprise getModel() {
		return enterprise;
	}
	// 附件处理
	private File uploadify;
	private String uploadifyFileName;

	public File getUploadify() {
		return uploadify;
	}

	public void setUploadify(File uploadify) {
		this.uploadify = uploadify;
	}
	
	public String getUploadifyFileName() {
		return uploadifyFileName;
	}

	public void setUploadifyFileName(String uploadifyFileName) {
		this.uploadifyFileName = uploadifyFileName;
	}

	@Action(value = "/zhongzhiMenterprise", results = {
			@Result(name = SUCCESS, location = "/admin/zhongzhi/zhongzhiManagerlist1.jsp"),
			@Result(name = "form", location = "/admin/enterprise/enterpriseedit.jsp"),
			@Result(name = "form1", location = "/admin/enterprise/setpic.jsp"),
			//@Result(name = SUCCESS, location = "/admin/enterprise/seedEnterpriseedit.jsp")//种子经营者企业 信息展示
	})
	
	@Override
	public String execute() {
		

		HttpSession session=httpServletRequest.getSession(true);
		
		user=(User)session.getAttribute("ADMIN_USER");
		return SUCCESS;
	}
	/**
	 * 初始化增加
	 * @return
	 * @throws Exception
	 */
	private boolean isUpdate() {
		
		if (enterprise == null)
			return false;
		if (enterprise.getEnterpriseID() <= 0)
			return false;
		return true;
	}
	
	public String initAddOrUpdate() throws Exception {
		if (isUpdate()){
			enterprise=enterpriseService.findById(enterprise.getEnterpriseID());
		}else{
			enterprise = new Enterprise();
		}
		return "form";
	}//addOrUpdate
	public String addOrUpdate() throws Exception {
		enterpriseService.save(enterprise);
		return this.execute();
	}
	/**
	 * 设置图片
	 * 
	 * @return
	 */
	
	
	
	
	
	
	public String getList_pass() throws Exception {
		Search search = new Search(Enterprise.class);
		search = this.getSearch(search);
		
		//“3”代表种植 生产企业
		//这里是为了获取种植类企业
		search.addFilterEqual("status", "3");
		
		String enterpriseName=httpServletRequest.getParameter("enterpriseName");
		if(enterpriseName!=null)
		{
			search.addFilterILike("enterpriseName","%"+enterpriseName+"%");
		}
		
		/*根据前台条件生成对应属性判断条件*/
		int count = enterpriseService.count(search);
		List<Enterprise> list = enterpriseService.searchAll(search);
		List<Map<String, Object>> enterpriseList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Enterprise obj = list.get(i);
				//引种记录集合
				Search s1=new Search(ShengChan.class);
				s1.addFilterEqual("enterpriseID",obj.getEnterpriseID());
				shengchanList=shengchanService.searchAll(s1);
				int a=0;
				long time1=0;
				for(ShengChan shengchan:shengchanList)
				{
					for(ShengChan shengchan1:shengchanList)
					{
						Date date=shengchan.getInput_time();
						Date date2=shengchan1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a=a+1;
							
						}
						
					}
					if(a==shengchanList.size())
					{
						time1=shengchan.getInput_time().getTime();
						break;
					}
					a=0;
				}
				
				//投入品采购记录集合
				Search s2=new Search(NongShi.class);
				s1.addFilterEqual("enterpriseDI", obj.getEnterpriseID());
				nongshiList=nongshiService.searchAll(s2);
				int a1=0;
				long time2=0;
				for(NongShi nongshi:nongshiList)
				{
					for(NongShi nongshi1:nongshiList)
					{
						Date date=nongshi.getInput_time();
						Date date2=nongshi1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a1=a1+1;
							
						}
						
					}
					if(a1==nongshiList.size())
					{
						time2=nongshi.getInput_time().getTime();
						break;
					}
					a1=0;
				}
				
				
				//饲料使用记录
				Search s3=new Search(ZhiLiang.class);
				s3.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				zhiliangList=zhiliangService.searchAll(s3);
				int a2=0;
				long time3=0;
				for(ZhiLiang zhiliang:zhiliangList)
				{
					for(ZhiLiang zhiliang1:zhiliangList)
					{
						Date date=zhiliang.getInput_time();
						Date date2=zhiliang1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a2=a2+1;
							
						}
						
					}
					if(a2==zhiliangList.size())
					{
						time3=zhiliang.getInput_time().getTime();
						break;
					}
					a2=0;
				}
				//药品使用记录
				Search s4=new Search(ProductSale.class);
				s4.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				productsaleList=productsaleService.searchAll(s4);
				int a3=0;
				long time4=0;
				for(ProductSale productsale:productsaleList)
				{
					for(ProductSale productsale1:productsaleList)
					{
						Date date=productsale.getInput_time();
						Date date2=productsale1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a3=a3+1;
							
						}
						
					}
					if(a3==productsaleList.size())
					{
						time4=productsale.getInput_time().getTime();
						break;
					}
					a3=0;
				}
				
				
				Long[] lon=new Long[]{time1,time2,time3,time4};
				int c=0;
				long time=0;
				for(int j=0;j<lon.length;j++)
				{
					for(int k=0;k<lon.length;k++)
					{
						if(lon[j]-lon[k]>=0)
						{
							c=c+1;
						}
					}
					if(c==lon.length)
					{
						time=lon[j];
						break;
					}
					c=0;
				}
				String lastTime="";
				if(time1!=0||time2!=0||time3!=0||time4!=0)
				{
					SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
					Date date=new Date();
					date.setTime(time);
					lastTime=formt.format(date);
				}
				else
				{
				 lastTime="无记录";
				}
				Map<String, Object> row = new HashMap<String, Object>();
				
				String shengchan="";
				String nongshi="";
				String zhiliang="";
				String productsale="";
				String shengchanbase="";
				
				
				shengchan= "<a href=\"javascript:void(0)\" onclick=\"shengchan("+obj.getEnterpriseID()
					 +")\">生产资料购买记录</a>";
				
				/*nongshi= "<a href=\"javascript:void(0)\" onclick=\"nongshi("
					+obj.getEnterpriseID()+ ")\">田间农事操作记录</a>";

				zhiliang= "<a href=\"javascript:void(0)\" onclick=\"zhiliang("
					+obj.getEnterpriseID()+ ")\">农产品质量检测记录</a>";

				productsale= "<a href=\"javascript:void(0)\" onclick=\"productsale("
					+obj.getEnterpriseID()+ ")\">产品销售记录</a>";*/
				shengchanbase= "<a href=\"javascript:void(0)\" onclick=\"shengchanbase("
					+obj.getEnterpriseID()+ ")\">生产基地信息</a>";
				
				row.put("id", i);
				row.put("cell",
						new Object[] { obj.getEnterpriseID(),obj.getEnterpriseName(),lastTime,shengchan+"&nbsp;&nbsp;&nbsp;&nbsp;"+shengchanbase+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+"\r\n"+
						zhiliang+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						productsale+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						nongshi+"&nbsp;&nbsp;&nbsp;&nbsp;"
						
				});//其他属性需按页面需要填写
				enterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
		
}