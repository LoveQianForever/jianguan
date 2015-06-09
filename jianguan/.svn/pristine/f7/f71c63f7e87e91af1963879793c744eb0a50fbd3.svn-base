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
import com.ncs.gsyt.modules.model.DieRecord;
import com.ncs.gsyt.modules.model.DisinfectionRecord;
import com.ncs.gsyt.modules.model.Enterprise;
import com.ncs.gsyt.modules.model.Enterpriseatta;
import com.ncs.gsyt.modules.model.FoodUseRecord;
import com.ncs.gsyt.modules.model.ImmunityJieZhong;
import com.ncs.gsyt.modules.model.ImmunityRecord;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InPigFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.MuZhuPeiZhongRecord;
import com.ncs.gsyt.modules.model.NoHaiDealRecord;
import com.ncs.gsyt.modules.model.PigFoodUseRecord;
import com.ncs.gsyt.modules.model.PigMedicineUseRecord;
import com.ncs.gsyt.modules.model.PigSaleRecord;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.model.XiaoDuRecord;
import com.ncs.gsyt.modules.model.XuShuiChiClear;
import com.ncs.gsyt.modules.service.DieRecordService;
import com.ncs.gsyt.modules.service.DisinfectionRecordService;
import com.ncs.gsyt.modules.service.EnterpriseService;
import com.ncs.gsyt.modules.service.EnterpriseattaService;
import com.ncs.gsyt.modules.service.FoodUseRecordService;
import com.ncs.gsyt.modules.service.ImmunityJieZhongService;
import com.ncs.gsyt.modules.service.ImmunityRecordService;
import com.ncs.gsyt.modules.service.InFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InPigFoodMedicineRecordService;
import com.ncs.gsyt.modules.service.InputPoultyService;
import com.ncs.gsyt.modules.service.MedicineUseRecordService;
import com.ncs.gsyt.modules.service.MuZhuPeiZhongRecordService;
import com.ncs.gsyt.modules.service.NoHaiDealRecordService;
import com.ncs.gsyt.modules.service.PigFoodUseRecordService;
import com.ncs.gsyt.modules.service.PigMedicineUseRecordService;
import com.ncs.gsyt.modules.service.PigSaleRecordService;
import com.ncs.gsyt.modules.service.SaleRecordService;
import com.ncs.gsyt.modules.service.SeedInService;
import com.ncs.gsyt.modules.service.SeedOutService;
import com.ncs.gsyt.modules.service.UserService;
import com.ncs.gsyt.modules.service.XiaoDuRecordService;
import com.ncs.gsyt.modules.service.XuShuiChiClearService;
import com.ncs.gsyt.modules.util.ImageUtil;
import com.ncs.gsyt.modules.util.UUIDGenerator;
import com.opensymphony.xwork2.ModelDriven;


/**
 *  禽类监管
 * 
 * 这个类，主要为了实现 ---禽类的监管---工作，
 *
 * 
 * **/
@Namespace("/admin")
@Controller
public class ShengZhuMEnterpriseAction extends BaseAction implements ModelDriven<Enterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private XiaoDuRecordService xiaodurecordService;
	private List<XiaoDuRecord> xiaodurecordList=new ArrayList<XiaoDuRecord>();
	public List<XiaoDuRecord> getXiaodurecordList() {
		return xiaodurecordList;
	}

	public void setXiaodurecordList(List<XiaoDuRecord> xiaodurecordList) {
		this.xiaodurecordList = xiaodurecordList;
	}
@Resource
private NoHaiDealRecordService nohaidealrecordService;
private List<NoHaiDealRecord> nohaidealrecordList=new ArrayList<NoHaiDealRecord>();
	public List<NoHaiDealRecord> getNohaidealrecordList() {
	return nohaidealrecordList;
}

public void setNohaidealrecordList(List<NoHaiDealRecord> nohaidealrecordList) {
	this.nohaidealrecordList = nohaidealrecordList;
}
	@Resource
	private EnterpriseattaService enterpriseattaService;
	@Resource
	private PigMedicineUseRecordService pigmedicineuserecordService;
	private List<PigMedicineUseRecord> pigmedicineuserecordList=new ArrayList<PigMedicineUseRecord>();
	public List<PigMedicineUseRecord> getPigmedicineuserecordList() {
		return pigmedicineuserecordList;
	}

	public void setPigmedicineuserecordList(
			List<PigMedicineUseRecord> pigmedicineuserecordList) {
		this.pigmedicineuserecordList = pigmedicineuserecordList;
	}
@Resource
private XuShuiChiClearService xushuichiclearService;
private List<XuShuiChiClear> xushuichiclearList=new ArrayList<XuShuiChiClear>();
	public List<XuShuiChiClear> getXushuichiclearList() {
	return xushuichiclearList;
}

public void setXushuichiclearList(List<XuShuiChiClear> xushuichiclearList) {
	this.xushuichiclearList = xushuichiclearList;
}

@Resource
private PigSaleRecordService pigsalerecordService;
private List<PigSaleRecord> pigsalerecordList=new ArrayList<PigSaleRecord>();
	public List<PigSaleRecord> getPigsalerecordList() {
	return pigsalerecordList;
}

public void setPigsalerecordList(List<PigSaleRecord> pigsalerecordList) {
	this.pigsalerecordList = pigsalerecordList;
}
	@Resource
	private MuZhuPeiZhongRecordService muzhupeizhongrecordService;
	private  List<MuZhuPeiZhongRecord> muzhupeizhongrecordList=new ArrayList<MuZhuPeiZhongRecord>(); 
	public List<MuZhuPeiZhongRecord> getMuzhupeizhongrecordList() {
		return muzhupeizhongrecordList;
	}

	public void setMuzhupeizhongrecordList(
			List<MuZhuPeiZhongRecord> muzhupeizhongrecordList) {
		this.muzhupeizhongrecordList = muzhupeizhongrecordList;
	}
@Resource
private PigFoodUseRecordService pigfooduserecordService;
private List<PigFoodUseRecord> pigfooduserecordList=new ArrayList<PigFoodUseRecord>();
	public List<PigFoodUseRecord> getPigfooduserecordList() {
	return pigfooduserecordList;
}

	@Resource
	private ImmunityJieZhongService immunityjiezhongService;
	private List<ImmunityJieZhong> immunityjiezhongList=new ArrayList<ImmunityJieZhong>();
public List<ImmunityJieZhong> getImmunityjiezhongList() {
		return immunityjiezhongList;
	}

	public void setImmunityjiezhongList(List<ImmunityJieZhong> immunityjiezhongList) {
		this.immunityjiezhongList = immunityjiezhongList;
	}

public void setPigfooduserecordList(List<PigFoodUseRecord> pigfooduserecordList) {
	this.pigfooduserecordList = pigfooduserecordList;
}

	@Resource
	private InPigFoodMedicineRecordService inpigfoodmedicinerecordService;
	private List<InPigFoodMedicineRecord> inpigfoodmedicinerecordList=new ArrayList<InPigFoodMedicineRecord>();

	public List<InPigFoodMedicineRecord> getInpigfoodmedicinerecordList() {
		return inpigfoodmedicinerecordList;
	}

	public void setInpigfoodmedicinerecordList(
			List<InPigFoodMedicineRecord> inpigfoodmedicinerecordList) {
		this.inpigfoodmedicinerecordList = inpigfoodmedicinerecordList;
	}

	private UserService userService;
	
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Action(value = "/shengzhuMenterprise", results = {
			@Result(name = SUCCESS, location = "/admin/pig/shengzhuManagerlist1.jsp"),
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
		//“5”代表生猪 生产企业
		//这里是为了获取生猪类企业
		search.addFilterEqual("status", "5");
		
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
				//母猪配种生成记录表
				Search s1=new Search(MuZhuPeiZhongRecord.class);
				s1.addFilterEqual("enterpriseID",list.get(i).getEnterpriseID());
				muzhupeizhongrecordList=muzhupeizhongrecordService.searchAll(s1);
				int a=0;
				long time1=0;
				for(MuZhuPeiZhongRecord muzhupeizhongrecord:muzhupeizhongrecordList)
				{
					for(MuZhuPeiZhongRecord muzhupeizhongrecord1:muzhupeizhongrecordList)
					{
						Date date=muzhupeizhongrecord.getPeiDuiTime();
						Date date2=muzhupeizhongrecord1.getPeiDuiTime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a=a+1;
							
						}
						
					}
					if(a==muzhupeizhongrecordList.size())
					{
						time1=muzhupeizhongrecord.getPeiDuiTime().getTime();
						break;
					}
					a=0;
				}
				
				//投入品采购记录集合
				Search s2=new Search(InPigFoodMedicineRecord.class);
				s1.addFilterEqual("enterpriseDI", obj.getEnterpriseID());
				inpigfoodmedicinerecordList=inpigfoodmedicinerecordService.searchAll(s2);
				int a1=0;
				long time2=0;
				for(InPigFoodMedicineRecord inpigfoodmedicinerecord:inpigfoodmedicinerecordList)
				{
					for(InPigFoodMedicineRecord inpigfoodmedicinerecord1:inpigfoodmedicinerecordList)
					{
						Date date=inpigfoodmedicinerecord.getCreateTime();
						Date date2=inpigfoodmedicinerecord1.getCreateTime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a1=a1+1;
							
						}
						
					}
					if(a1==inpigfoodmedicinerecordList.size())
					{
						time2=inpigfoodmedicinerecord.getCreateTime().getTime();
						break;
					}
					a1=0;
				}
				
				
				//兽药使用记录表
				Search s3=new Search(PigMedicineUseRecord.class);
				s3.addFilterEqual("enterpriseDI", obj.getEnterpriseID());
				pigmedicineuserecordList=pigmedicineuserecordService.searchAll(s3);
				int a2=0;
				long time3=0;
				for(PigMedicineUseRecord pigmedicineuserecord:pigmedicineuserecordList)
				{
					for(PigMedicineUseRecord pigmedicineuserecord1:pigmedicineuserecordList)
					{
						Date date=pigmedicineuserecord.getUseDate();
						Date date2=pigmedicineuserecord1.getUseDate();
						if(date.getTime()-date2.getTime()>=0)
						{
							a2=a2+1;
							
						}
						
					}
					if(a2==pigmedicineuserecordList.size())
					{
						time3=pigmedicineuserecord.getUseDate().getTime();
						break;
					}
					a2=0;
				}
				//日常消毒记录表
				Search s4=new Search(XiaoDuRecord.class);
				s4.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				xiaodurecordList=xiaodurecordService.searchAll(s4);
				int a3=0;
				long time4=0;
				for(XiaoDuRecord xiaodurecord:xiaodurecordList)
				{
					for(XiaoDuRecord xiaodurecord1:xiaodurecordList)
					{
						Date date=xiaodurecord.getCreateDate();
						Date date2=xiaodurecord1.getCreateDate();
						if(date.getTime()-date2.getTime()>=0)
						{
							a3=a3+1;
							
						}
						
					}
					if(a3==xiaodurecordList.size())
					{
						time4=xiaodurecord.getCreateDate().getTime();
						break;
					}
					a3=0;
				}
				
				//蓄水设施清洗记录表
				Search s5=new Search(XuShuiChiClear.class);
				s5.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				xushuichiclearList=xushuichiclearService.searchAll(s5);
				int a4=0;
				long time5=0;
				for(XuShuiChiClear xushuichiclear:xushuichiclearList)
				{
					for(XuShuiChiClear xushuichiclear1:xushuichiclearList)
					{
						Date date=xushuichiclear.getCreateTime();
						Date date2=xushuichiclear1.getCreateTime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a4=a4+1;
							
						}
						
					}
					if(a4==xushuichiclearList.size())
					{
						time5=xushuichiclear.getCreateTime().getTime();
						break;
					}
					a4=0;
				}
				
				
				//饲料使用记录表
				Search s6=new Search(PigFoodUseRecord.class);
				s6.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				pigfooduserecordList=pigfooduserecordService.searchAll(s6);
				int a5=0;
				long time6=0;
				for(PigFoodUseRecord pigfooduserecord:pigfooduserecordList)
				{
					for(PigFoodUseRecord pigfooduserecord1:pigfooduserecordList)
					{
						Date date=pigfooduserecord.getCreateTime();
						Date date2=pigfooduserecord1.getCreateTime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a5=a5+1;
							
						}
						
					}
					if(a5==pigfooduserecordList.size())
					{
						time6=pigfooduserecord.getCreateTime().getTime();
						break;
					}
					a5=0;
				}
				//无害化处理记录表 
				Search s7=new Search(NoHaiDealRecord.class);
				s7.addFilterEqual("enterpriseID",obj.getEnterpriseID());
				nohaidealrecordList=nohaidealrecordService.searchAll(s7);
				int a6=0;
				long time7=0;
				for(NoHaiDealRecord nohaidealrecord:nohaidealrecordList)
				{
					for(NoHaiDealRecord nohaidealrecord1:nohaidealrecordList)
					{
						Date date=nohaidealrecord.getCreateDate();
						Date date2=nohaidealrecord1.getCreateDate();
						if(date.getTime()-date2.getTime()>=0)
						{
							a6=a6+1;
							
						}
						
					}
					if(a6==nohaidealrecordList.size())
					{
						time7=nohaidealrecord.getCreateDate().getTime();
						break;
					}
					a6=0;
				}
				
				//销售记录
				Search s8=new Search(PigSaleRecord.class);
				s8.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				pigsalerecordList=pigsalerecordService.searchAll(s8);
				int a7=0;
				long time8=0;
				for(PigSaleRecord pigsalerecord:pigsalerecordList)
				{
					for(PigSaleRecord pigsalerecord1:pigsalerecordList)
					{
						Date date=pigsalerecord.getSaleDate();
						Date date2=pigsalerecord1.getSaleDate();
						if(date.getTime()-date2.getTime()>=0)
						{
							a7=a7+1;
							
						}
						
					}
					if(a7==pigsalerecordList.size())
					{
						time8=pigsalerecord.getSaleDate().getTime();
						break;
					}
					a7=0;
				}
				
				//销售记录
				Search s9=new Search(ImmunityJieZhong.class);
				s9.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				immunityjiezhongList=immunityjiezhongService.searchAll(s9);
				int a8=0;
				long time9=0;
				for(ImmunityJieZhong immunityjiezhong:immunityjiezhongList)
				{
					for(ImmunityJieZhong immunityjiezhong1:immunityjiezhongList)
					{
						Date date=immunityjiezhong.getNowTime();
						Date date2=immunityjiezhong1.getNowTime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a8=a8+1;
							
						}
						
					}
					if(a8==immunityjiezhongList.size())
					{
						time9=immunityjiezhong.getNowTime().getTime();
						break;
					}
					a8=0;
				}
				
				
				Long[] lon=new Long[]{time1,time2,time3,time4,time5,time6,time7,time8,time9};
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
				if(time1!=0||time2!=0||time3!=0||time4!=0||time5!=0||time6!=0||time7!=0||time8!=0||time9!=0)
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
				
				String muzhupeizhongrecord="";
				String inpigfoodmedicinerecord="";
				String pigmedicineuserecord="";
				String xiaodurecord="";
				
				String xushuichiclear="";
				String pigfooduserecord="";
				String nohaidealrecord="";
				String pigsalerecord="";
				String immunityjiezhong="";
				
				muzhupeizhongrecord= "<a href=\"javascript:void(0)\" onclick=\"muzhupeizhongrecord("+obj.getEnterpriseID()
					 +")\">母猪配种生成记录</a>";
				
				inpigfoodmedicinerecord= "<a href=\"javascript:void(0)\" onclick=\"inpigfoodmedicinerecord("
					+obj.getEnterpriseID()+ ")\">投入品采购记录</a>";

				pigmedicineuserecord= "<a href=\"javascript:void(0)\" onclick=\"pigmedicineuserecord("
					+obj.getEnterpriseID()+ ")\">兽药使用记录</a>";

				xiaodurecord= "<a href=\"javascript:void(0)\" onclick=\"xiaodurecord("
					+obj.getEnterpriseID()+ ")\">日常消毒记录</a>";

				xushuichiclear= "<a href=\"javascript:void(0)\" onclick=\"xushuichiclear("
					+obj.getEnterpriseID()+ ")\">蓄水设施清洗记录</a>";

				pigfooduserecord= "<a href=\"javascript:void(0)\" onclick=\"pigfooduserecord("
					+obj.getEnterpriseID()+ ")\">饲料使用记录</a>";

				nohaidealrecord= "<a href=\"javascript:void(0)\" onclick=\"nohaidealrecord("
					+obj.getEnterpriseID()+ ")\">无害化处理记录</a>";

				pigsalerecord= "<a href=\"javascript:void(0)\" onclick=\"pigsalerecord("
					+obj.getEnterpriseID()+ ")\">生猪销售记录</a>";
				immunityjiezhong= "<a href=\"javascript:void(0)\" onclick=\"immunityjiezhong("
					+obj.getEnterpriseID()+ ")\">免疫接种记录</a>";
				
				row.put("id", i);
				row.put("cell",
						new Object[] { obj.getEnterpriseID(),obj.getEnterpriseName(),lastTime,muzhupeizhongrecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+inpigfoodmedicinerecord+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+"\r\n"+
						pigmedicineuserecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						xiaodurecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"\r"+
						xushuichiclear+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						pigfooduserecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"\n"+
						nohaidealrecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						pigsalerecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						immunityjiezhong+"&nbsp;&nbsp;&nbsp;&nbsp;"
						
				});//其他属性需按页面需要填写
				enterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
		
}