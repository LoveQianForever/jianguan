﻿package com.ncs.gsyt.modules.action;

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
import com.ncs.gsyt.modules.model.Batch;
import com.ncs.gsyt.modules.model.ImmunityJieZhong;
import com.ncs.gsyt.modules.model.MuZhuPeiZhongRecord;
import com.ncs.gsyt.modules.model.User;
import com.ncs.gsyt.modules.service.BatchService;
import com.ncs.gsyt.modules.service.MuZhuPeiZhongRecordService;
import com.ncs.gsyt.modules.util.DateUtil;
import com.ncs.gsyt.modules.util.StringUtil;
import com.ncs.gsyt.modules.util.WordTemplateUtil;
import com.json.util.JSONObject;
import com.opensymphony.xwork2.ModelDriven;

@Namespace("/admin")
@Controller
public class MuZhuPeiZhongRecordAction extends BaseAction implements ModelDriven<MuZhuPeiZhongRecord>{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private MuZhuPeiZhongRecordService muzhupeizhongrecordService;
	
	@Resource
	private BatchService batchService;
	private List<Batch> batchList=new ArrayList<Batch>();
	private Batch batch=new Batch();
	
	
	public List<Batch> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch> batchList) {
		this.batchList = batchList;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}



	private MuZhuPeiZhongRecord muzhupeizhongrecord = new MuZhuPeiZhongRecord();
	
	public MuZhuPeiZhongRecord getMuzhupeizhongrecord() {
		return muzhupeizhongrecord;
	}

	public void setMuzhupeizhongrecord(MuZhuPeiZhongRecord muzhupeizhongrecord) {
		this.muzhupeizhongrecord = muzhupeizhongrecord;
	}



	private List<MuZhuPeiZhongRecord> muzhupeizhongrecordList=new ArrayList<MuZhuPeiZhongRecord>();
	public List<MuZhuPeiZhongRecord> getMuzhupeizhongrecordList() {
		return muzhupeizhongrecordList;
	}

	public void setMuzhupeizhongrecordList(
			List<MuZhuPeiZhongRecord> muzhupeizhongrecordList) {
		this.muzhupeizhongrecordList = muzhupeizhongrecordList;
	}

	public MuZhuPeiZhongRecord getMuZhuPeiZhongRecord() {
		return muzhupeizhongrecord;
	}
	
	@Override
	public MuZhuPeiZhongRecord getModel() {
		return muzhupeizhongrecord;
	}
	
	@Action(value = "/muzhupeizhongrecord", results = {
			@Result(name = SUCCESS, location = "/admin/pig/muzhupeizhongrecordlist.jsp"),
			@Result(name = "add", location = "/admin/pig/addmuzhupeizhongrecord.jsp"),
			@Result(name = "addBatch", location = "/admin/pig/addBatchmuzhupeizhongrecord.jsp"),//添加批次概念
			@Result(name = "modify", location = "/admin/pig/modifymuzhupeizhongrecord.jsp"),
			@Result(name = "modifyBatch", location = "/admin/pig/modifyBatchmuzhupeizhongrecord.jsp"),//添加批次概念
			@Result(name = "stopModify", location = "/admin/pig/modifymuzhupeizhongrecord1.jsp"),
			@Result(name = "stopBatchModify", location = "/admin/pig/modifyBatchmuzhupeizhongrecord1.jsp")//添加批次概念
	})
	
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String getList_pass() throws Exception {
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		Search search = new Search(MuZhuPeiZhongRecord.class);
		search = this.getSearch(search);
	
		//帅选当前企业下的，母猪配种管理记录
		search.addFilterEqual("enterpriseID",user.getEnterprise().getEnterpriseID());
		//配对日期查询
		SimpleDateFormat formt=new SimpleDateFormat("yyyy-MM-dd");
		String gaptime="";
		String begindate =StringUtil.isNull(httpServletRequest.getParameter("begindate"));
	
		String enddate =StringUtil.isNull(httpServletRequest.getParameter("enddate"));
	if (!"".equals(begindate)) {         //起始条件不为空
		search.addFilterGreaterOrEqual("peiDuiTime",formt.parse(begindate+" 00:00:00"));
		gaptime=begindate+"后";
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("peiDuiTime", formt.parse(enddate+" 23:59:59"));
			gaptime=begindate+"到"+enddate;
		}
		
	}else{
		if (!"".equals(enddate)) {
			search.addFilterLessOrEqual("peiDuiTime",formt.parse(enddate+" 23:59:59"));
			gaptime=enddate+"之前";
		}
		gaptime="所有日期";
	}
	//预产期查询
	
	String gaptime1="";
	String begindate1 =StringUtil.isNull(httpServletRequest.getParameter("begindate1"));

	String enddate1 =StringUtil.isNull(httpServletRequest.getParameter("enddate1"));
if (!"".equals(begindate1)) {         //起始条件不为空
	search.addFilterGreaterOrEqual("yuChanQi",formt.parse(begindate1+" 00:00:00"));
	gaptime1=begindate1+"后";
	if (!"".equals(enddate1)) {
		search.addFilterLessOrEqual("yuChanQi", formt.parse(enddate1+" 23:59:59"));
		gaptime1=begindate1+"到"+enddate1;
	}
	
}else{
	if (!"".equals(enddate1)) {
		search.addFilterLessOrEqual("yuChanQi",formt.parse(enddate1+" 23:59:59"));
		gaptime1=enddate1+"之前";
	}
	gaptime1="所有日期";
}
	
	
		
		/*根据前台条件生成对应属性判断条件*/

		int count = muzhupeizhongrecordService.count(search);
		List<MuZhuPeiZhongRecord> list = muzhupeizhongrecordService.searchAll(search);
		List<Map<String, Object>> muzhupeizhongrecordList = new ArrayList<Map<String, Object>>();

		if (null != list) {
			for (int i = 0; i < list.size(); i++) {
				MuZhuPeiZhongRecord obj = list.get(i);
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("id", obj.getPeiZhongID());
				row.put("cell",
						new Object[] { obj.getPeiZhongID(),obj.getErHaoM(),obj.getPinZhongM(),obj.getTaici(),
						DateUtil.formatDate(obj.getPeiDuiTime(),"yyyy-MM-dd"),obj.getPinZhongG(),obj.getErHaoG(),obj.getPeiZhongFangShi(),
						obj.getPeiZhong_name(),DateUtil.formatDate(obj.getYuChanQi(), "yyyy-MM-dd"),DateUtil.formatDate(obj.getFenWanQi(), "yyyy-MM-dd"),obj.getZaiShu(),obj.getHuoZai(),
						obj.getMuNaiYi(),obj.getRuoZai(),obj.getSiZai(),obj.getFenWan_name()
						});//其他属性需按页面需要填写
				muzhupeizhongrecordList.add(row);
			}
		}

		JSONObject json = resultTOJson(search, count, muzhupeizhongrecordList);

		sendMessages(httpServletResponse, json.toString());

		return null;
	}
	
	

	

	/**-------------添加信息-----------------------**/
	public String add()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段	
		if(count1==0)
		{
		return "add";
		}else
		{
			batchList=batchService.searchAll(s1);
			return "addBatch";
		}
	}
	
	/**--------------保存添加的信息--------------------**/
	public String saveAdd()throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**添加批次，让溯源系统获取到监管里的农事操作记录**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//count1不等于0的情况下，说明溯源批次表里，有该批次记录，因此添加记录的时候，有选择批次的字段	
		//参数
		SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		
		
		MuZhuPeiZhongRecord muZhuPeiZhongRecord=new MuZhuPeiZhongRecord();
		
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			muZhuPeiZhongRecord.setPiCi(batchID);
		}
			String erHaoM=httpServletRequest.getParameter("erHaoM");
			String pinZhongM=httpServletRequest.getParameter("pinZhongM");
			String taici=httpServletRequest.getParameter("taici");
			String peiDuiTime=httpServletRequest.getParameter("peiDuiTime");
			Date date1=fomt.parse(peiDuiTime);//
			String pinZhongG=httpServletRequest.getParameter("pinZhongG");
			String erHaoG=httpServletRequest.getParameter("erHaoG");
			String peiZhongFangShi=httpServletRequest.getParameter("peiZhongFangShi");
			String peiZhong_name=httpServletRequest.getParameter("peiZhong_name");
			String yuChanQi=httpServletRequest.getParameter("yuChanQi");
			Date date2=fomt.parse(yuChanQi);//
			String fenWanQi=httpServletRequest.getParameter("fenWanQi");
			Date date3=fomt.parse(fenWanQi);//
			
			String[] peidui=peiDuiTime.split("-");
			String[] yuchan=yuChanQi.split("-");
			String[] fenwan=fenWanQi.split("-");
			
			/**-----------------副参数-------------------------------**/
			String peiDuiTime11=httpServletRequest.getParameter("peiDuiTime11");
			Date date4=fomt.parse(peiDuiTime11);//
			String pinZhongG11=httpServletRequest.getParameter("pinZhongG11");
			String erHaoG11=httpServletRequest.getParameter("erHaoG11");
			String peiZhongFangShi11=httpServletRequest.getParameter("peiZhongFangShi11");
			String peiZhong_name11=httpServletRequest.getParameter("peiZhong_name11");
			String[] peidui11=peiDuiTime11.split("-");
			/**-----------------副参数-------------------------------**/
			
			String zaiShu=httpServletRequest.getParameter("zaiShu");
			String huoZai=httpServletRequest.getParameter("huoZai");
			String muNaiYi=httpServletRequest.getParameter("muNaiYi");
			String ruoZai=httpServletRequest.getParameter("ruoZai");
			String siZai=httpServletRequest.getParameter("siZai");
			String fenWan_name=httpServletRequest.getParameter("fenWan_name");
			/**------------------副参数 set-------------------------**/
			muZhuPeiZhongRecord.setPeiDuiTime11(date4);
			muZhuPeiZhongRecord.setYear11(peidui11[0]);
			muZhuPeiZhongRecord.setMonth11(peidui11[1]);
			muZhuPeiZhongRecord.setDay11(peidui11[2]);
			muZhuPeiZhongRecord.setPinZhongG11(pinZhongG11);
			muZhuPeiZhongRecord.setErHaoG11(erHaoG11);
			muZhuPeiZhongRecord.setPeiZhongFangShi11(peiZhongFangShi11);
			muZhuPeiZhongRecord.setPeiZhong_name11(peiZhong_name11);
			/**------------------副参数 set-------------------------**/
			muZhuPeiZhongRecord.setErHaoM(erHaoM);
			muZhuPeiZhongRecord.setPinZhongM(pinZhongM);
			muZhuPeiZhongRecord.setTaici(taici);
			muZhuPeiZhongRecord.setPeiDuiTime(date1);
			muZhuPeiZhongRecord.setPinZhongG(pinZhongG);
			muZhuPeiZhongRecord.setErHaoG(erHaoG);
			muZhuPeiZhongRecord.setPeiZhongFangShi(peiZhongFangShi);
			muZhuPeiZhongRecord.setPeiZhong_name(peiZhong_name);
			muZhuPeiZhongRecord.setYuChanQi(date2);
			muZhuPeiZhongRecord.setFenWanQi(date3);
			muZhuPeiZhongRecord.setZaiShu(Integer.parseInt(zaiShu));
			muZhuPeiZhongRecord.setHuoZai(Integer.parseInt(huoZai));
			muZhuPeiZhongRecord.setMuNaiYi(Integer.parseInt(muNaiYi));
			muZhuPeiZhongRecord.setRuoZai(Integer.parseInt(ruoZai));
			muZhuPeiZhongRecord.setSiZai(Integer.parseInt(siZai));
			muZhuPeiZhongRecord.setFenWan_name(fenWan_name);
			muZhuPeiZhongRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			muZhuPeiZhongRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			muZhuPeiZhongRecord.setYear1(peidui[0]);
			muZhuPeiZhongRecord.setMonth1(peidui[1]);
			muZhuPeiZhongRecord.setDay1(peidui[2]);
			muZhuPeiZhongRecord.setYear2(yuchan[0]);
			muZhuPeiZhongRecord.setMonth2(yuchan[1]);
			muZhuPeiZhongRecord.setDay2(yuchan[2]);
			muZhuPeiZhongRecord.setYear3(fenwan[0]);
			muZhuPeiZhongRecord.setMonth3(fenwan[1]);
			muZhuPeiZhongRecord.setDay3(fenwan[2]);
			
			muzhupeizhongrecordService.save(muZhuPeiZhongRecord);
			
		return SUCCESS;
	}
	/**----------------修改信息-----------------------------**/
	public String  modify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		
		String id=httpServletRequest.getParameter("ouc");
		muzhupeizhongrecord=muzhupeizhongrecordService.findById(Long.parseLong(id));
		
		Date curren=new Date();
		Date date=muzhupeizhongrecord.getPeiDuiTime();
		if((curren.getTime()-date.getTime())/3600000<=24)
		{	
			if(count1==0)
			{
			return "modify";
			}else
			{
				batchList=batchService.searchAll(s1);
				return "modifyBatch";
			}
		}
		else
		{
			if(count1==0)
			{
			return "stopModify";
			}
			else
			{
				batchList=batchService.searchAll(s1);
				return "stopBatchModify";
			}
		}
		
		
		
	}
	/**------------------保存修改的信息----------------------**/
	public String saveModify() throws Exception
	{
		HttpSession session=httpServletRequest.getSession(true);
		User user=(User)session.getAttribute("ADMIN_USER");
		
		/**----判断溯源批次表batch，有没有与当前企业对应的信息------**/
		Search s1=new Search(Batch.class);
		s1.addFilterEqual("product.enterprise.enterpriseID", user.getEnterprise().getEnterpriseID());
		int count1=batchService.count(s1);
		//参数
		String peiZhongID=httpServletRequest.getParameter("peiZhongID");
		MuZhuPeiZhongRecord muZhuPeiZhongRecord=muzhupeizhongrecordService.findById(Long.parseLong(peiZhongID));
		
		//溯源：count1等于0情况下
		if(count1!=0)
		{
			//溯源：将批次值，保存到当前记录表里；
			String batchID=httpServletRequest.getParameter("batchID");	
			muZhuPeiZhongRecord.setPiCi(batchID);
		}
		
			SimpleDateFormat fomt=new SimpleDateFormat("yyyy-MM-dd");
		/**-------------------------------------------------------------------------**/
			String erHaoM=httpServletRequest.getParameter("erHaoM");
			String pinZhongM=httpServletRequest.getParameter("pinZhongM");
			String taici=httpServletRequest.getParameter("taici");
			String peiDuiTime=httpServletRequest.getParameter("peiDuiTime");
			Date date1=fomt.parse(peiDuiTime);//
			String pinZhongG=httpServletRequest.getParameter("pinZhongG");
			String erHaoG=httpServletRequest.getParameter("erHaoG");
			String peiZhongFangShi=httpServletRequest.getParameter("peiZhongFangShi");
			String peiZhong_name=httpServletRequest.getParameter("peiZhong_name");
			String yuChanQi=httpServletRequest.getParameter("yuChanQi");
			Date date2=fomt.parse(yuChanQi);//
			String fenWanQi=httpServletRequest.getParameter("fenWanQi");
			Date date3=fomt.parse(fenWanQi);//
			
			String[] peidui=peiDuiTime.split("-");
			String[] yuchan=yuChanQi.split("-");
			String[] fenwan=fenWanQi.split("-");
			String zaiShu=httpServletRequest.getParameter("zaiShu");
			String huoZai=httpServletRequest.getParameter("huoZai");
			String muNaiYi=httpServletRequest.getParameter("muNaiYi");
			String ruoZai=httpServletRequest.getParameter("ruoZai");
			String siZai=httpServletRequest.getParameter("siZai");
			String fenWan_name=httpServletRequest.getParameter("fenWan_name");
			
			/**-----------------副参数-------------------------------**/
			String peiDuiTime11=httpServletRequest.getParameter("peiDuiTime11");
			Date date4=fomt.parse(peiDuiTime11);//
			String pinZhongG11=httpServletRequest.getParameter("pinZhongG11");
			String erHaoG11=httpServletRequest.getParameter("erHaoG11");
			String peiZhongFangShi11=httpServletRequest.getParameter("peiZhongFangShi11");
			String peiZhong_name11=httpServletRequest.getParameter("peiZhong_name11");
			String[] peidui11=peiDuiTime11.split("-");
			/**-----------------副参数-------------------------------**/
			
			/**------------------副参数 set-------------------------**/
			muZhuPeiZhongRecord.setPeiDuiTime11(date4);
			muZhuPeiZhongRecord.setYear11(peidui11[0]);
			muZhuPeiZhongRecord.setMonth11(peidui11[1]);
			muZhuPeiZhongRecord.setDay11(peidui11[2]);
			muZhuPeiZhongRecord.setPinZhongG11(pinZhongG11);
			muZhuPeiZhongRecord.setErHaoG11(erHaoG11);
			muZhuPeiZhongRecord.setPeiZhongFangShi11(peiZhongFangShi11);
			muZhuPeiZhongRecord.setPeiZhong_name11(peiZhong_name11);
			/**------------------副参数 set-------------------------**/
			muZhuPeiZhongRecord.setErHaoM(erHaoM);
			muZhuPeiZhongRecord.setPinZhongM(pinZhongM);
			muZhuPeiZhongRecord.setTaici(taici);
			muZhuPeiZhongRecord.setPeiDuiTime(date1);
			muZhuPeiZhongRecord.setPinZhongG(pinZhongG);
			muZhuPeiZhongRecord.setErHaoG(erHaoG);
			muZhuPeiZhongRecord.setPeiZhongFangShi(peiZhongFangShi);
			muZhuPeiZhongRecord.setPeiZhong_name(peiZhong_name);
			muZhuPeiZhongRecord.setYuChanQi(date2);
			muZhuPeiZhongRecord.setFenWanQi(date3);
			muZhuPeiZhongRecord.setZaiShu(Integer.parseInt(zaiShu));
			muZhuPeiZhongRecord.setHuoZai(Integer.parseInt(huoZai));
			muZhuPeiZhongRecord.setMuNaiYi(Integer.parseInt(muNaiYi));
			muZhuPeiZhongRecord.setRuoZai(Integer.parseInt(ruoZai));
			muZhuPeiZhongRecord.setSiZai(Integer.parseInt(siZai));
			muZhuPeiZhongRecord.setFenWan_name(fenWan_name);
			muZhuPeiZhongRecord.setEnterpriseID(user.getEnterprise().getEnterpriseID());
			muZhuPeiZhongRecord.setEnterpriseName(user.getEnterprise().getEnterpriseName());
			
			muZhuPeiZhongRecord.setYear1(peidui[0]);
			muZhuPeiZhongRecord.setMonth1(peidui[1]);
			muZhuPeiZhongRecord.setDay1(peidui[2]);
			muZhuPeiZhongRecord.setYear2(yuchan[0]);
			muZhuPeiZhongRecord.setMonth2(yuchan[1]);
			muZhuPeiZhongRecord.setYear3(fenwan[0]);
			muZhuPeiZhongRecord.setMonth3(fenwan[1]);
			muZhuPeiZhongRecord.setDay3(fenwan[2]);
			muzhupeizhongrecordService.save(muZhuPeiZhongRecord);
			
		
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
			muzhupeizhongrecord=muzhupeizhongrecordService.findById(Long.parseLong(idss[i]));//获取sale记录
			muzhupeizhongrecordList.add(muzhupeizhongrecord);
		}
		
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String,Object> datamap = new HashMap<String, Object>();
		//String[] regdatearr = DateUtil.formatDate(source.getRegDate(), "yyyy-MM-dd-HH-mm").split("-");
		datamap.put("muzhupeizhongrecordList", muzhupeizhongrecordList);
		datamap.put("enterpriseName", enterpriseName);
		datamap.put("yearth", yearth);
		
		String templatefile = "muzhupeizhongrecord.ftl";//销售记录ftl模板
		String docfilename =  "muzhupeizhongrecord.doc";
		String reportPath = Constant.EXAPREPORT_STOR_PATH + File.separator + docfilename;
		
		wordUtil.creatDoc(templatefile, datamap, reportPath);
		/**----------------------------------------------------------------**/
		httpServletResponse.setContentType("application/x-msdownload");
		httpServletResponse.setCharacterEncoding("UTF-8");
		File file=new File(reportPath);
		httpServletResponse.setContentLength((int)file.length());
		httpServletResponse.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("母猪配种记录.doc","UTF-8"));
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