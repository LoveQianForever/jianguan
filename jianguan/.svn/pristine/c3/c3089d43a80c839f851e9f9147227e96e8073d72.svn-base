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
import com.ncs.gsyt.modules.model.ImmunityRecord;
import com.ncs.gsyt.modules.model.InFoodMedicineRecord;
import com.ncs.gsyt.modules.model.InputPoulty;
import com.ncs.gsyt.modules.model.MedicineUseRecord;
import com.ncs.gsyt.modules.model.SaleRecord;
import com.ncs.gsyt.modules.model.SeedIn;
import com.ncs.gsyt.modules.model.SeedOut;
import com.ncs.gsyt.modules.model.User;
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
public class PoultryMEnterpriseAction extends BaseAction implements ModelDriven<Enterprise>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private EnterpriseService enterpriseService;
	
	@Resource
	private EnterpriseattaService enterpriseattaService;
	
	@Resource
	private InputPoultyService inputPoultyService;//引种记录
	
	private InputPoulty inputPoulty=new InputPoulty();//引种记录
	
	private List<InputPoulty> inputPoultyList=new ArrayList<InputPoulty>();//引种集合
	
	public List<InputPoulty> getInputPoultyList() {
		return inputPoultyList;
	}

	public void setInputPoultyList(List<InputPoulty> inputPoultyList) {
		this.inputPoultyList = inputPoultyList;
	}



	@Resource
	private InFoodMedicineRecordService inFoodMedicineRecordService;//投入品采购记录
	
	private List<InFoodMedicineRecord> inFoodMedicineRecordList=new ArrayList<InFoodMedicineRecord>();//投入品采购记录
	
	private InFoodMedicineRecord inFoodMedicineRecord=new InFoodMedicineRecord();//投入品采购记录
	
	@Resource
	private FoodUseRecordService foodUseRecordService;//饲料使用记录
	
	private List<FoodUseRecord> foodUseRecordList=new ArrayList<FoodUseRecord>();//饲料使用记录
	private FoodUseRecord foodUseRecord=new FoodUseRecord();//饲料使用记录
	
	@Resource
	private ImmunityRecordService immunityRecordService;
	
	private List<ImmunityRecord> immunityRecordList=new ArrayList<ImmunityRecord>();
	private ImmunityRecord immunityRecord=new ImmunityRecord();
	
	
	public List<ImmunityRecord> getImmunityRecordList() {
		return immunityRecordList;
	}

	public void setImmunityRecordList(List<ImmunityRecord> immunityRecordList) {
		this.immunityRecordList = immunityRecordList;
	}

	public ImmunityRecord getImmunityRecord() {
		return immunityRecord;
	}

	public void setImmunityRecord(ImmunityRecord immunityRecord) {
		this.immunityRecord = immunityRecord;
	}



	@Resource
	private MedicineUseRecordService  medicineUseRecordService;
	
	private List<MedicineUseRecord> medicineUseRecordList= new ArrayList<MedicineUseRecord>();
	
	private MedicineUseRecord medicineUseRecord=new MedicineUseRecord();
	
	@Resource
	private DisinfectionRecordService disinfectionRecordService;
	private List<DisinfectionRecord> disinfectionRecordList=new ArrayList<DisinfectionRecord>();
	private DisinfectionRecord disinfectionRecord=new DisinfectionRecord();
	
	@Resource
	private DieRecordService dieRecordService;
	private List<DieRecord> dieRecordList=new ArrayList<DieRecord>();
	private DieRecord dieRecord=new DieRecord();
	
	@Resource
	private SaleRecordService saleRecordService;
	
	private List<SaleRecord> saleRecordList=new ArrayList<SaleRecord>();
	private SaleRecord saleRecord=new SaleRecord();
	
	
	public List<SaleRecord> getSaleRecordList() {
		return saleRecordList;
	}

	public void setSaleRecordList(List<SaleRecord> saleRecordList) {
		this.saleRecordList = saleRecordList;
	}

	public SaleRecord getSaleRecord() {
		return saleRecord;
	}

	public void setSaleRecord(SaleRecord saleRecord) {
		this.saleRecord = saleRecord;
	}

	public List<DieRecord> getDieRecordList() {
		return dieRecordList;
	}

	public void setDieRecordList(List<DieRecord> dieRecordList) {
		this.dieRecordList = dieRecordList;
	}

	public DieRecord getDieRecord() {
		return dieRecord;
	}

	public void setDieRecord(DieRecord dieRecord) {
		this.dieRecord = dieRecord;
	}

	public List<DisinfectionRecord> getDisinfectionRecordList() {
		return disinfectionRecordList;
	}

	public void setDisinfectionRecordList(
			List<DisinfectionRecord> disinfectionRecordList) {
		this.disinfectionRecordList = disinfectionRecordList;
	}

	public DisinfectionRecord getDisinfectionRecord() {
		return disinfectionRecord;
	}

	public void setDisinfectionRecord(DisinfectionRecord disinfectionRecord) {
		this.disinfectionRecord = disinfectionRecord;
	}

	public List<MedicineUseRecord> getMedicineUseRecordList() {
		return medicineUseRecordList;
	}

	public void setMedicineUseRecordList(
			List<MedicineUseRecord> medicineUseRecordList) {
		this.medicineUseRecordList = medicineUseRecordList;
	}

	public MedicineUseRecord getMedicineUseRecord() {
		return medicineUseRecord;
	}

	public void setMedicineUseRecord(MedicineUseRecord medicineUseRecord) {
		this.medicineUseRecord = medicineUseRecord;
	}

	public List<FoodUseRecord> getFoodUseRecordList() {
		return foodUseRecordList;
	}

	public void setFoodUseRecordList(List<FoodUseRecord> foodUseRecordList) {
		this.foodUseRecordList = foodUseRecordList;
	}

	public FoodUseRecord getFoodUseRecord() {
		return foodUseRecord;
	}

	public void setFoodUseRecord(FoodUseRecord foodUseRecord) {
		this.foodUseRecord = foodUseRecord;
	}

	public List<InFoodMedicineRecord> getInFoodMedicineRecordList() {
		return inFoodMedicineRecordList;
	}

	public void setInFoodMedicineRecordList(
			List<InFoodMedicineRecord> inFoodMedicineRecordList) {
		this.inFoodMedicineRecordList = inFoodMedicineRecordList;
	}

	public InFoodMedicineRecord getInFoodMedicineRecord() {
		return inFoodMedicineRecord;
	}

	public void setInFoodMedicineRecord(InFoodMedicineRecord inFoodMedicineRecord) {
		this.inFoodMedicineRecord = inFoodMedicineRecord;
	}



	private UserService userService;
	
	private User user=new User();
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	public InputPoulty getInputPoulty() {
		return inputPoulty;
	}

	public void setInputPoulty(InputPoulty inputPoulty) {
		this.inputPoulty = inputPoulty;
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

	@Action(value = "/poultryMenterprise", results = {
			@Result(name = SUCCESS, location = "/admin/poultry/poultryManagerlist1.jsp"),
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
		//“6”代表 禽类 生产企业
		//这里是为了获取禽类企业
		search.addFilterEqual("status", "6");
		
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
				Search s1=new Search(InputPoulty.class);
				s1.addFilterEqual("enterpriseID",list.get(i).getEnterpriseID());
				inputPoultyList=inputPoultyService.searchAll(s1);
				int a=0;
				long time1=0;
				for(InputPoulty inputPoulty:inputPoultyList)
				{
					for(InputPoulty inputPoulty1:inputPoultyList)
					{
						Date date=inputPoulty.getInput_time();
						Date date2=inputPoulty1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a=a+1;
							
						}
						
					}
					if(a==inputPoultyList.size())
					{
						time1=inputPoulty.getInput_time().getTime();
						break;
					}
					a=0;
				}
				
				//投入品采购记录集合
				Search s2=new Search(InFoodMedicineRecord.class);
				s1.addFilterEqual("enterpriseDI", obj.getEnterpriseID());
				inFoodMedicineRecordList=inFoodMedicineRecordService.searchAll(s2);
				int a1=0;
				long time2=0;
				for(InFoodMedicineRecord inFoodMedicineRecord:inFoodMedicineRecordList)
				{
					for(InFoodMedicineRecord inFoodMedicineRecord1:inFoodMedicineRecordList)
					{
						Date date=inFoodMedicineRecord.getInput_time();
						Date date2=inFoodMedicineRecord1.getInput_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a1=a1+1;
							
						}
						
					}
					if(a1==inFoodMedicineRecordList.size())
					{
						time2=inFoodMedicineRecord.getInput_time().getTime();
						break;
					}
					a1=0;
				}
				
				
				//饲料使用记录
				Search s3=new Search(FoodUseRecord.class);
				s3.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				foodUseRecordList=foodUseRecordService.searchAll(s3);
				int a2=0;
				long time3=0;
				for(FoodUseRecord foodUseRecord:foodUseRecordList)
				{
					for(FoodUseRecord foodUseRecord1:foodUseRecordList)
					{
						Date date=foodUseRecord.getUse_time();
						Date date2=foodUseRecord1.getUse_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a2=a2+1;
							
						}
						
					}
					if(a2==foodUseRecordList.size())
					{
						time3=foodUseRecord.getUse_time().getTime();
						break;
					}
					a2=0;
				}
				//药品使用记录
				Search s4=new Search(MedicineUseRecord.class);
				s4.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				medicineUseRecordList=medicineUseRecordService.searchAll(s4);
				int a3=0;
				long time4=0;
				for(MedicineUseRecord medicineUseRecord:medicineUseRecordList)
				{
					for(MedicineUseRecord medicineUseRecord1:medicineUseRecordList)
					{
						Date date=medicineUseRecord.getUse_time();
						Date date2=medicineUseRecord1.getUse_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a3=a3+1;
							
						}
						
					}
					if(a3==medicineUseRecordList.size())
					{
						time4=medicineUseRecord.getUse_time().getTime();
						break;
					}
					a3=0;
				}
				
				//免疫记录
				Search s5=new Search(ImmunityRecord.class);
				s5.addFilterEqual("enterprise", obj);
				immunityRecordList=immunityRecordService.searchAll(s5);
				int a4=0;
				long time5=0;
				for(ImmunityRecord immunityRecord:immunityRecordList)
				{
					for(ImmunityRecord immunityRecord1:immunityRecordList)
					{
						Date date=immunityRecord.getImmunity_time();
						Date date2=immunityRecord1.getImmunity_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a4=a4+1;
							
						}
						
					}
					if(a4==immunityRecordList.size())
					{
						time5=immunityRecord.getImmunity_time().getTime();
						break;
					}
					a4=0;
				}
				
				
				//防疫消毒记录
				Search s6=new Search(DisinfectionRecord.class);
				s6.addFilterEqual("enterprise", obj);
				disinfectionRecordList=disinfectionRecordService.searchAll(s6);
				int a5=0;
				long time6=0;
				for(DisinfectionRecord disinfectionRecord:disinfectionRecordList)
				{
					for(DisinfectionRecord disinfectionRecord1:disinfectionRecordList)
					{
						Date date=disinfectionRecord.getCreatetime();
						Date date2=disinfectionRecord1.getCreatetime();
						if(date.getTime()-date2.getTime()>=0)
						{
							a5=a5+1;
							
						}
						
					}
					if(a5==disinfectionRecordList.size())
					{
						time6=disinfectionRecord.getCreatetime().getTime();
						break;
					}
					a5=0;
				}
				//病死处理记录
				Search s7=new Search(DieRecord.class);
				s7.addFilterEqual("enterpriseID",obj.getEnterpriseID());
				dieRecordList=dieRecordService.searchAll(s7);
				int a6=0;
				long time7=0;
				for(DieRecord dieRecord:dieRecordList)
				{
					for(DieRecord dieRecord1:dieRecordList)
					{
						Date date=dieRecord.getRecord_time();
						Date date2=dieRecord1.getRecord_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a6=a6+1;
							
						}
						
					}
					if(a6==dieRecordList.size())
					{
						time7=dieRecord.getRecord_time().getTime();
						break;
					}
					a6=0;
				}
				
				//销售记录
				Search s8=new Search(SaleRecord.class);
				s8.addFilterEqual("enterpriseID", obj.getEnterpriseID());
				saleRecordList=saleRecordService.searchAll(s8);
				int a7=0;
				long time8=0;
				for(SaleRecord saleRecord:saleRecordList)
				{
					for(SaleRecord saleRecord1:saleRecordList)
					{
						Date date=saleRecord.getSale_time();
						Date date2=saleRecord1.getSale_time();
						if(date.getTime()-date2.getTime()>=0)
						{
							a7=a7+1;
							
						}
						
					}
					if(a7==saleRecordList.size())
					{
						time8=saleRecord.getSale_time().getTime();
						break;
					}
					a7=0;
				}
				Long[] lon=new Long[]{time1,time2,time3,time4,time5,time6,time7,time8};
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
				if(time1!=0||time2!=0||time3!=0||time4!=0||time5!=0||time6!=0||time7!=0||time8!=0)
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
				
				String inputPoulty="";
				String inFoodMedicineRecord="";
				String foodUseRecord="";
				String medicineUseRecord="";
				String immunityRecord="";
				String disinfectionRecord="";
				String dieRecord="";
				String saleRecord="";
				
				inputPoulty= "<a href=\"javascript:void(0)\" onclick=\"inputPoulty("+obj.getEnterpriseID()
					 +")\">引种记录</a>";
				
				inFoodMedicineRecord= "<a href=\"javascript:void(0)\" onclick=\"inFoodMedicineRecord("
					+obj.getEnterpriseID()+ ")\">投入品采购记录</a>";

				foodUseRecord= "<a href=\"javascript:void(0)\" onclick=\"foodUseRecord("
					+obj.getEnterpriseID()+ ")\">用料记录</a>";

				medicineUseRecord= "<a href=\"javascript:void(0)\" onclick=\"medicineUseRecord("
					+obj.getEnterpriseID()+ ")\">用药记录</a>";

				immunityRecord= "<a href=\"javascript:void(0)\" onclick=\"immunityRecord("
					+obj.getEnterpriseID()+ ")\">免疫记录</a>";

				disinfectionRecord= "<a href=\"javascript:void(0)\" onclick=\"disinfectionRecord("
					+obj.getEnterpriseID()+ ")\">消毒防疫记录</a>";

				dieRecord= "<a href=\"javascript:void(0)\" onclick=\"dieRecord("
					+obj.getEnterpriseID()+ ")\">死亡处理记录</a>";

				saleRecord= "<a href=\"javascript:void(0)\" onclick=\"saleRecord("
					+obj.getEnterpriseID()+ ")\">销售记录</a>";
				
				row.put("id", i);
				row.put("cell",
						new Object[] { obj.getEnterpriseID(),obj.getEnterpriseName(),lastTime,inputPoulty+"&nbsp;&nbsp;&nbsp;&nbsp;"+inFoodMedicineRecord+
						"&nbsp;&nbsp;&nbsp;&nbsp;"+"\r\n"+
						foodUseRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						medicineUseRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"\r\n"+
						immunityRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						disinfectionRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						"\r\n"+
						dieRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"+
						saleRecord+"&nbsp;&nbsp;&nbsp;&nbsp;"
						
				});//其他属性需按页面需要填写
				enterpriseList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, enterpriseList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
		
}