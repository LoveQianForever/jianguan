package com.ncs.gsyt.modules.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.ncs.gsyt.constant.Constant;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * ********************************************************* 
 * Copyright hfhuadi
 * 2011. All rights reserved.
 * 
 * @file: WordTemplateUtil
 * @date: 2011-9-26
 * @brief: word文档模板替换生成工具
 * @author: nichun
 * @version: 1.0.0
 * @since 1.0
 *  Change Log:
 *      <author>      <time>       <version>     <description>
 *      nichun       2011-9-26       1.0.0          create
 * **********************************************************
 */
public class WordTemplateUtil {

	private Configuration configuration = null;
	
	public WordTemplateUtil() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		//configuration.setEncoding(Locale.CHINA, "utf-8");
	}
	
	/**
	 * author nichun
	 * 2011-9-26
	 * TODO 根据指定模板在指定文件夹下创建word文件
	 * @param templatefile 模板文件
	 * @param datamap 替换数据map
	 * @param wordpathfile 生成word文件
	 * @return String 错误号
	 */
	public String creatDoc(String templatefile, Map<String, Object> datamap, String wordpathfile) {
		
		String rs = "0";
		//设置模板文件装置方法和路径,FreeMarker支持多种模板装载方法。可以从servlet，classpath，数据库装载，
		//这里我们的模板是放在com.oa.mobile.document.template包下面
		
		configuration.setClassForTemplateLoading(this.getClass(),"/com/ncs/gsyt/document/template");
		Template t = null;
		try {
			t = configuration.getTemplate(templatefile);//加载模板
			t.setEncoding("UTF-8");
			File outFile = new File(wordpathfile);//输出文件
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
	
	public String creatHtml(String templatefile, Map<String, String> datamap) {
		String html = "";
		configuration.setClassForTemplateLoading(this.getClass(),"/com/ncs/gsyt/document/template");
		Template t = null;
		try {
			t = configuration.getTemplate(templatefile);//加载模板
			t.setEncoding("UTF-8");
			Writer out = new StringWriter(2048);
			t.process(datamap, out);//根据标签替换数据后输出文件
			html = out.toString();
		} catch (IOException e) {
			html = Constant.WORD_FILE_IO_ERR;//文件异常
			e.printStackTrace();
		} catch (TemplateException e) {
			html = Constant.WORD_TEMPLATE_ERR;//模板处理异常
			e.printStackTrace();
		} catch (Exception e) {
			html = Constant.WORD_OTHER_ERR;//其他异常
			e.printStackTrace();
		}
		return html;
	}
	
	public static void main(String[] args) {
		WordTemplateUtil wordUtil = new WordTemplateUtil();
		Map<String, Object> datamap = new HashMap<String, Object>();
		datamap.put("leixing", "III");
		datamap.put("secleixing", "");
		datamap.put("result1", "1.123");
		datamap.put("result2", "1.234");
		datamap.put("result3", "1.012");
		datamap.put("result4", "1.1");
		datamap.put("result5", "1.08");
		datamap.put("result6", "1.61");
		datamap.put("result7", "1.83");
		datamap.put("leixingming", "协调操作和技艺服务类");
		datamap.put("name", "李秋水");
		datamap.put("sex", "女性");
		datamap.put("age", "22");
		datamap.put("job", "服装缝纫工、数控车工、汽车驾驶员");
		datamap.put(
				"tedian",
				"对使用工具，较多的利用动手能力的事情感兴趣，性格踏实稳重，会较多的注意工作中的细节，不喜欢竞争和冒险，倾向于保守、中规中矩的工作，对需要耐心、细致精确的活动感兴趣。");
		datamap.put(
				"gongzuo",
				"需要利用一些固定的、常规的工具进行的操作类工作。");
		datamap.put(
				"youshi",
				"踏实稳重、谦虚顺从，做事细致有条理，耐心负责，有较强的沟通表达能力，可以与他人建立良好的人际关系。动手能力强，动作协调，善于利用工具。易于交往，但是不喜欢与人竞争，不适合需要较强竞争性的工作，不擅长组织和领导他人进行工作和活动，不喜欢对问题刨根问底，缺乏探索研究精神，不善于进行艺术鉴赏和艺术创造等活动。");
		datamap.put(
				"fangxiang",
				"根据个人的兴趣倾向，他在需要动手能力强，保守、程序化的工作中，兴趣维持的持久，较容易取得成就。推荐职业：服装缝纫师、数据车工、汽车驾驶员。");
		datamap.put("lianputu", StringUtil.fileToString("D:/leidatu.png"));
		datamap.put("lianputu", StringUtil.fileToString("E:/space/study_spase/evaluation/evaluation/doc/examreport/34340111010006/faceFile/34/34/0001/34340111010007_face.png"));
		String templatefile = "zyxq.ftl";
		String wordpathfile = "D:/outFile.doc";	
		String rs = wordUtil.creatDoc(templatefile, datamap, wordpathfile);
		System.out.println(rs);
	}
}
