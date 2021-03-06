package com.ncs.gsyt.modules.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.ncs.gsyt.constant.Constant;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CreateTemplate {

	private Configuration configuration = null;
	
	public CreateTemplate() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	
	public String creatFile(String templatefile, Map<String, String> datamap, String outfile) {
		
		String rs = "0";
		//设置模板文件装置方法和路径,FreeMarker支持多种模板装载方法。可以从servlet，classpath，数据库装载，
		//这里我们的模板是放在com.oa.mobile.document.template包下面
		
		configuration.setClassForTemplateLoading(this.getClass(),"/com/ncs/gsyt/template");
		Template t = null;
		try {
			t = configuration.getTemplate(templatefile);//加载模板
			t.setEncoding("UTF-8");
			
			File outFile = new File(outfile);//输出文件
			Writer out = null;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
			t.process(datamap, out);//根据标签替换数据后输出文件
		} catch (IOException e) {
			rs = Constant.WORD_FILE_IO_ERR;//文件异常
			e.printStackTrace();
		} catch (TemplateException e) {
			rs = Constant.WORD_TEMPLATE_ERR;//模板处理异常
			e.printStackTrace();
		} catch (Exception e) {
			rs = Constant.WORD_OTHER_ERR;//其他异常
			e.printStackTrace();
		}
		return rs;
	}
	
	private static String getRootPath(){
		String rootPath ="";
		try{
			 File file = new File(CreateTemplate.class.getResource("/").getFile());
			 rootPath = file.getParentFile()+"\\";
			 rootPath = java.net.URLDecoder.decode(rootPath,"utf-8");
			 return rootPath;
		}catch(Exception e){
			e.printStackTrace();
		}
		return rootPath;
	}
	
	public static void main(String[] args) {
		CreateTemplate write = new CreateTemplate();
		Map<String, String> datamap = new HashMap<String, String>();
		String className = "Place";
		String lowclassName = "Place".toLowerCase();
		String srcPath = "E:\\workspace\\jianguan\\src\\com\\ncs\\gsyt\\modules\\";
		String webPath = "E:\\workspace\\jianguan\\web\\";
		datamap.put("className", className);
		datamap.put("className1", lowclassName);
		datamap.put("title", "批次");
		datamap.put("package", "com.ncs.gsyt");
		datamap.put("ctx", "${ctx}");
		
		
		String rootPath = srcPath + "dao\\";
		String templatefile = "TempDao.ftl";
		String outfile = className + "Dao.java";
		String rs = write.creatFile(templatefile, datamap, rootPath+outfile);
		
		rootPath = srcPath + "dao\\impl\\";
		templatefile = "TempDaoImpl.ftl";
		outfile = className + "DaoImpl.java";
		write.creatFile(templatefile, datamap, rootPath+outfile);
		
		rootPath = srcPath + "service\\";
		templatefile = "TempService.ftl";
		outfile = className + "Service.java";
		write.creatFile(templatefile, datamap, rootPath+outfile);
		
		rootPath = srcPath + "service\\impl\\";
		templatefile = "TempServiceImpl.ftl";
		outfile = className + "ServiceImpl.java";
		write.creatFile(templatefile, datamap, rootPath+outfile);
		
		rootPath = srcPath + "action\\";
		templatefile = "TempAction.ftl";
		outfile = className + "Action.java";
		write.creatFile(templatefile, datamap, rootPath+outfile);
		
		/*rootPath = webPath + "admin\\tourupin\\";
		templatefile = "TemplistJsp.ftl";
		outfile = lowclassName + "list.jsp";
		write.creatFile(templatefile, datamap, rootPath+outfile);*/
		System.out.println(rs);
	}
	
}