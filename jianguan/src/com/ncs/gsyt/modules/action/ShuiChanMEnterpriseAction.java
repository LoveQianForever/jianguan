package com.ncs.gsyt.modules.action;

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
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.YuMiao;
import com.ncs.gsyt.modules.model.YuSale;
import com.ncs.gsyt.modules.model.YuSiYang;
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
import com.ncs.gsyt.modules.service.SaleRecordService;
import com.ncs.gsyt.modules.service.SeedInService;
import com.ncs.gsyt.modules.service.SeedOutService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.service.YuMiaoService;
import com.ncs.gsyt.modules.service.YuSaleService;
import com.ncs.gsyt.modules.service.YuSiYangService;
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
public class ShuiChanMEnterpriseAction extends BaseAction implements ModelDriven<Enterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private EnterpriseattaService enterpriseattaService;
	

	@Resource
	private YuMiaoService yumiaoService;
	private List<YuMiao> yumiaoList=new ArrayList<YuMiao>();
	
	@Resource
	private YuSaleService yusaleService;
	private List<YuSale> yusaleList=new ArrayList<YuSale>();
	@Resource
	private CaiGouService caigouService;
	private List<CaiGou> caigouList=new ArrayList<CaiGou>();
	@Resource
	private YuSiYangService yusiyangService;
	private List<YuSiYang> yusiyangList=new ArrayList<YuSiYang>();
	private UserService userService;
	
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public List<YuMiao> getYumiaoList() {
		return yumiaoList;
	}

	public void setYumiaoList(List<YuMiao> yumiaoList) {
		this.yumiaoList = yumiaoList;
	}

	public List<YuSale> getYusaleList() {
		return yusaleList;
	}

	public void setYusaleList(List<YuSale> yusaleList) {
		this.yusaleList = yusaleList;
	}

	public List<CaiGou> getCaigouList() {
		return caigouList;
	}

	public void setCaigouList(List<CaiGou> caigouList) {
		this.caigouList = caigouList;
	}

	public List<YuSiYang> getYusiyangList() {
		return yusiyangList;
	}

	public void setYusiyangList(List<YuSiYang> yusiyangList) {
		this.yusiyangList = yusiyangList;
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

	@Action(value = "/shuichanMenterprise", results = {
			@Result(name = SUCCESS, location = "/admin/yulei/shuiChanManagerlist1.jsp"),
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
		//“4”代表 水产 生产企业
		//这里是为了获取水产类企业
		search.addFilterEqual("status", "4");
		
		/*根据前台条件生成对应属性判断条件*/
		String enterpriseName=httpServletRequest.getParameter("enterpriseName");
		if(enterpriseName!=null)
		{
			search.addFilterILike("enterpriseName","%"+enterpriseName+"%");
		}
		
		
		
		int count = enterpriseService.count(search);
		List<Enterprise> list = enterpriseService.searchAll(search);
		List<Map<String, Object>> enterpriseList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				Enterprise obj = list.get(i);
				//引种记录集合
				Search s1=new Search(YuMiao.class);
				s1.addFilterEqual("enterpriseID",obj.getEnterpriseID());
				yumiaoList=yumiaoService.searchAll(s1);
				int a=0;
				long time1=0;
				for(YuMiao yumiao:yumiaoList)
				{
					for(YuMiao yumiao1:yumiaoList)
					{
						Date date=yumiao.getInput_time();
						Date date2=yumiao1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a=a+1;
							
						}
						
					}
					if(a==yumiaoList.size())
					{
						time1=yumiao.getInput_time().getTime();
						break;
					}
					a=0;
				}
				
				//投入品采购记录集合
				Search s2=new Search(YuSale.class);
				s1.addFilterEqual("enterpriseDI", obj.getEnterpriseID());
				yusaleList=yusaleService.searchAll(s2);
				int a1=0;
				long time2=0;
				for(YuSale yusale:yusaleList)
				{
					for(YuSale yusale1:yusaleList)
					{
						Date date=yusale.getInput_time();
						Date date2=yusale1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a1=a1+1;
							
						}
						
					}
					if(a1==yusaleList.size())
					{
						time2=yusale.getInput_time().getTime();
						break;
					}
					a1=0;
				}
				
				
				//饲料使用记录
				Search s3=new Search(CaiGou.class);
				s3.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				caigouList=caigouService.searchAll(s3);
				int a2=0;
				long time3=0;
				for(CaiGou caigou:caigouList)
				{
					for(CaiGou caigou1:caigouList)
					{
						Date date=caigou.getInput_time();
						Date date2=caigou1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a2=a2+1;
							
						}
						
					}
					if(a2==caigouList.size())
					{
						time3=caigou.getInput_time().getTime();
						break;
					}
					a2=0;
				}
				//药品使用记录
				Search s4=new Search(YuSiYang.class);
				s4.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				yusiyangList=yusiyangService.searchAll(s4);
				int a3=0;
				long time4=0;
				for(YuSiYang yusiyang:yusiyangList)
				{
					for(YuSiYang yusiyang1:yusiyangList)
					{
						Date date=yusiyang.getInput_time();
						Date date2=yusiyang1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a3=a3+1;
							
						}
						
					}
					if(a3==yusiyangList.size())
					{
						time4=yusiyang.getInput_time().getTime();
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
				
				String yumiao="";
				String caigou="";
				String yusiyang="";
				String yusale="";
				
				
				yumiao= "<a href=\"javascript:void(0)\" onclick=\"yumiao("+obj.getEnterpriseID()
					 +")\">苗种放养记录</a>";
				
				caigou= "<a href=\"javascript:void(0)\" onclick=\"caigou("
					+obj.getEnterpriseID()+ ")\">投入品采购记录</a>";

				yusiyang= "<a href=\"javascript:void(0)\" onclick=\"yusiyang("
					+obj.getEnterpriseID()+ ")\">渔业生产操作记录</a>";

				yusale= "<a href=\"javascript:void(0)\" onclick=\"yusale("
					+obj.getEnterpriseID()+ ")\">水产销售记录</a>";
				
				row.put("id", i);
				row.put("cell",
						new Object[] { obj.getEnterpriseID(),obj.getEnterpriseName(),lastTime,yumiao+"&nbsp;&nbsp;&nbsp;&nbsp;"+caigou+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+"\r\n"+
						yusiyang+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						yusale+"&nbsp;&nbsp;&nbsp;&nbsp;"
						
				});//其他属性需按页面需要填写
				enterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
		
}