package com.ncs.gsyt.modules.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

/*import sun.misc.BASE64Encoder;*/

public class StringUtil {
	/**
	 * <p>
	 * Description
	 * </p>
	 */
	public static boolean bTextBox = true;

	/**
	 * <p>
	 * Description 对参数传送过来的字符串进行iso-8859-1 GBK格式转化后返回
	 * </p>
	 */
	public static String getGBKFromISO(String str) {
		// System.out.println("**********************"+str+"**************");
		try {
			byte[] buf = str.getBytes("iso-8859-1");
			str = new String(buf, "GBK");
			return str;
		} catch (java.io.UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * <p>
	 * Description 对参数传送过来的字符串进行iso-8859-1 GBK格式转化后返回
	 * </p>
	 */
	public static String getISOFromGBK(String str) {
		// System.out.println("**********************"+str+"**************");
		try {
			byte[] buf = str.getBytes("GBK");
			str = new String(buf, "iso-8859-1");
			return str;
		} catch (java.io.UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * <p>
	 * Description 对参数传送过来的字符串进行iso-8859-1 GBK格式转化后返回
	 * </p>
	 */
	public static String getUTFFromGBK(String str) {
		// System.out.println("**********************"+str+"**************");
		try {
			byte[] buf = str.getBytes("GBK");
			str = new String(buf, "UTF-8");
			return str;
		} catch (java.io.UnsupportedEncodingException e) {
			return "";
		}
	}

	/**
	 * Explore String The first parament is father string (String). The second
	 * parament is separator (String). return a Vector.
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public static Vector explore(String handleStr, String pointStr) {
		Vector v = new Vector();
		int pos1, pos2;
		try {
			if (handleStr.length() > 0) {
				pos1 = handleStr.indexOf(pointStr);
				pos2 = 0;
				while (pos1 != -1) {
					v.addElement(handleStr.substring(pos2, pos1));
					pos2 = pos1 + pointStr.length();
					pos1 = handleStr.indexOf(pointStr, pos2);
				}
				v.addElement(handleStr.substring(pos2));
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
		return v;
	}

	/**
	 * <p>
	 * Description 将参数中的源字符串handleStr中的全部pointStr替换成repStr并返回
	 * </p>
	 * The first parament is father string (String). The second parament is sub
	 * string (String). The third parament is replace string (String). return a
	 * String.
	 */
	public static String replace(String handleStr, String pointStr,
			String repStr) {
		String str = new String();
		int pos1, pos2;
		try {
			if (handleStr.length() > 0) {
				pos1 = handleStr.indexOf(pointStr);
				pos2 = 0;
				while (pos1 != -1) {
					str += handleStr.substring(pos2, pos1);
					str += repStr;
					pos2 = pos1 + pointStr.length();
					pos1 = handleStr.indexOf(pointStr, pos2);
				}
				str += handleStr.substring(pos2);
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
		return str;
	}

	/**
	 * <p>
	 * Description
	 * </p>
	 */
	public static void SetReturn(boolean bAttrib) {
		bTextBox = bAttrib;
	}

	/**
	 * <p>
	 * Description 将参数中的源字符串handleStr中的xml标签转化成html标签
	 * </p>
	 * Change HTML special char in String The first parament is father string
	 * (String). return a String.
	 */
	public static String htmlspecialchars(String handleStr) {
		if (handleStr == null)
			return "";

		String str = handleStr;
		str = replace(str, "&", "&amp;");
		str = replace(str, "\"", "&quot;");
		str = replace(str, "<", "&lt;");
		str = replace(str, ">", "&gt;");

		if (!bTextBox)
			str = replace(str, "\n", "<br>");

		return str;
	}

	/**
	 * <p>
	 * Description
	 * </p>
	 */
	public static String ReturnChar2BR(String handleStr) {
		String str = handleStr;
		str = replace(str, "\n", "<br>");
		return str;
	}

	/**
	 * Implode String The first parament is father Vector (String). The second
	 * parament is separator (String). return a String.
	 */
	public static String implode(@SuppressWarnings("rawtypes")
	Vector handler, String separator) {
		StringBuffer strbuf = new StringBuffer();
		try {
			if (!handler.isEmpty()) {
				int len = handler.size();
				for (int loopi = 0; loopi < len; loopi++) {
					strbuf.append((String) handler.get(loopi));
					if (loopi != len - 1)
						strbuf.append(separator);
				}
			}
		} catch (Exception error) {
			error.printStackTrace();
		}
		return strbuf.toString();
	}

	/**
	 * Return appointed String from a String Vector param1: String Vector
	 * param2: appointed Index param3: include Excel CSV process.
	 */
	public static String getField(@SuppressWarnings("rawtypes")
	Vector vt, int i, boolean isExcel) {
		String str = "";
		try {
			str = (String) vt.get(i);
			if (str != null && str.length() > 2 && isExcel) {
				if (str.substring(0, 1).compareTo("\"") == 0) {
					str = str.substring(1, str.length() - 1);
					str = StringUtil.replace(str, "\"\"", "\"");
				}
			}
		} catch (ArrayIndexOutOfBoundsException aibe) {
			System.out
					.println("Exceed the length of array, Please check the field number");
			return "";
		}
		return str;
	}

	/**
	 * fill in inschar in string's left or right, in order to let string have
	 * appoint length. param1: father string param2: need fill in char param3: 0
	 * is left fill in 1 is right fill in param4: total string length after fill
	 * in char
	 */
	public static String InsStr(String str, String InsChar, int intDirect,
			int Len) {
		int intLen = str.length();
		StringBuffer strBuffer = new StringBuffer(str);

		if (intLen < Len) {
			int inttmpLen = Len - intLen;
			for (int i = 0; i < inttmpLen; i++) {
				if (intDirect == 1) {
					str = str.concat(InsChar);
				} else if (intDirect == 0) {
					strBuffer.insert(0, InsChar);
					str = strBuffer.toString();
				}
			}
		}
		return str;
	}

	/**
	 * <p>
	 * Description
	 * </p>
	 */
	public static int searchdiv(String str, String divided) {
		String tmpsearchstr = new String();
		tmpsearchstr = str;
		divided = divided.trim();
		int divpos = -1;

		if (tmpsearchstr != "") {
			divpos = tmpsearchstr.indexOf(divided);

			return divpos;
		} else
			return 0;
	}

	public static String ExtractStr(String str, String startdiv, String enddiv) {
		int startdivlen = startdiv.length();
		str = str.trim();

		int startpos = -1;
		int endpos = -1;

		startdiv = startdiv.trim();
		enddiv = enddiv.trim();
		startpos = searchdiv(str, startdiv);
		if (str != "") {
			if (startpos >= 0) {
				str = str.substring(startpos + startdivlen);
				str = str.trim();
			}
			endpos = searchdiv(str, enddiv);
			if (endpos == -1)
				return "";
			str = str.substring(0, endpos);
			str = str.trim();
		}
		return str;
	}

	/**
	 * <p>
	 * Description
	 * </p>
	 */
	public static String isNull(String str) {
		if (str == null)
			return "";
		else if (str.length() == 0)
			return "";
		else
			return str;
	}

	/**
	 * 页面表单的某些字符串当为""时转化为NULL
	 */
	public static String isString(String str) {
		if (str != null && !str.equals(""))
			return str;
		else
			return null;
	}

	/**
	 * 为了处理页面From 提交的表单对象 (一下是用来处理的方法) / /**
	 * 
	 * @param request
	 * @param s
	 *            参数名称
	 * 
	 * @return 参数值
	 */
	public static String getString(HttpServletRequest request, String s) {
		String s1 = request.getParameter(s);
		if (s1 != null && !s1.equals(""))
			return s1;
		else
			return null;
	}

	/**
	 * @param request
	 * @param s
	 *            参数名称
	 * @param s1
	 *            if s=null 时 参数值s1
	 * 
	 * @return 参数值
	 */
	public static String getString(HttpServletRequest request, String s,
			String s1) {
		String s2 = getString(request, s);
		if (s2 == null)
			s2 = s1;
		return s2;
	}

	/**
	 * @param request
	 * @param s
	 *            参数值
	 * 
	 * @return 返回值类型是整型
	 */
	public static int getInt(HttpServletRequest request, String s) {
		try {

			return Integer.parseInt(getString(request, s));

		} catch (NumberFormatException numberformatexception) {

			System.out
					.println("com.ving.sbzl.StringUtil ERROR getInt(HttpServletRequest request, String s)");
			numberformatexception.printStackTrace();
			return 0;
		}
	}

	/**
	 * @param request
	 * @param s
	 *            参数值
	 * @param i
	 *            if s=null 时 参数值
	 * 
	 * @return 返回值类型是整型
	 */
	public static int getInt(HttpServletRequest request, String s, int i) {
		try {
			String s1 = getString(request, s);
			if (s1 == null)
				return i;
			else
				return Integer.parseInt(s1);
		} catch (NumberFormatException numberformatexception) {
			System.out
					.println("com.ving.sbzl.StringUtil ERROR getInt(HttpServletRequest request, String s, int i)");
			numberformatexception.printStackTrace();
		}
		return 0;
	}

	public static long getLong(HttpServletRequest request, String s, long i) {
		try {
			String s1 = getString(request, s);
			if (s1 == null)
				return i;
			else
				return Long.parseLong(s1);
		} catch (NumberFormatException numberformatexception) {
			System.out
					.println("com.ving.sbzl.StringUtil ERROR getLong(HttpServletRequest request, String s, long  i)");
			numberformatexception.printStackTrace();
		}
		return 0;
	}

	public static String[] getStrArray(HttpServletRequest request, String s) {

		return request.getParameterValues(s);

	}

	public static int[] getIntArray(HttpServletRequest request, String s) {

		String[] s1 = getStrArray(request, s);
		int[] j = null;

		if (s1 != null) {
			for (int i = 0; i < s1.length; i++) {
				if (i == 0)
					j = new int[s1.length];
				j[i] = Integer.parseInt(s1[i]);
			}
		}
		return j;
	}

	/**
	 * public static void main(String args[]) { System.out.println("This class
	 * is used for String Process."); System.out.println(" This class is wrote
	 * by James Wang."); System.out.println(""); System.out.println(" This class
	 * include next method:"); System.out.println(" StringUtil.explore() is used
	 * for explore a String to a Vector with a separator. For example:");
	 * System.out.println("
	 * StringUtil.explore(\"James;Summer;John;Robin\",\";\") result is a Vector:
	 * "+explore("James;Summer;John;Robin",";")); System.out.println("
	 * StringUtil.replace() is used for replace a String at a father String with
	 * other String. For example:"); System.out.println("
	 * StringUtil.replace(\";James;Summer;John;Robin;\",\";\",\"&\") result is a
	 * String: "+replace(";James;Summer;John;Robin;",";","&"));
	 * System.out.println(" StringUtil.htmlspecialchars() is used for replace
	 * all HTML special chars(& \" < >) in father String. For example:");
	 * System.out.println(" StringUtil.htmlspecialchars(\"James&Summer\"John<Robin>\")
	 * result is a String: "+htmlspecialchars("James&Summer\"John<Robin>"));
	 * System.out.println(" StringUtil.implode() is used for implode a Vector to
	 * a String with a separator. For example:"); Vector mainv=new Vector();
	 * mainv.addElement("James"); mainv.addElement("Robin");
	 * mainv.addElement("Rebort"); mainv.addElement("John");
	 * System.out.println(" StringUtil.implode(String_Vector,\";\") result is a
	 * String: "+implode(mainv,";")); }
	 * 
	 */

	public static String formatDate(String date) {
		if (date == null || date.indexOf("1900-01-01") != -1 || date.equals(""))
			date = "";
		else if (date.length() >= 10)
			date = date.substring(0, 10);

		return date;
	}

	/**
	 * 空判断处理
	 */
	public static boolean isEmpty(String input) {
		if (input == null) {
			return true;
		}
		if ("".equals(input.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 空对象处理
	 */
	public static String checkNull(Object ob) {
		if ((ob == null) || (ob.equals("null"))) {
			return "";
		} else {
			return ob.toString();
		}
	}

	/**
	 * 校验是否数字
	 */
	public static boolean isDigit(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}
		boolean reUse = false;
		for (int i = 0; i < input.length(); i++) {

			if (input.indexOf(".") == 0 || input.indexOf(".") == input.length()) {
				return false;
			}
			// 是否有多余的.
			if (input.substring(i, i + 1).equals(".")) {

				if (!reUse) {
					reUse = true;
					continue;
				} else {
					return false;
				}

			}

			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 读取文件用BASE64转码为字符串返回
	 */
	public static String fileToString(String pathfile) {
		String rs = "";
		BufferedImage bi;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			File file = new File(pathfile);
			bi = ImageIO.read(file);
			ImageIO.write(bi, "png", baos);
			byte[] bytes = baos.toByteArray();
			/*BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			rs = encoder.encodeBuffer(bytes).trim();*/
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}

	/**
	 * 去掉obj的空白字符,如果str为null则返回""
	 */
	public static String getString(String obj) {
		return StringUtil.isNullValue(obj) ? "" : obj.trim();
	}

	/**
	 * 去掉obj的空白字符,如果str为null则返回""
	 */
	public static String getString(Object obj) {
		return StringUtil.isNullValue(obj) ? "" : obj.toString().trim();
	}

	/**
	 * 判断该对象是否为空<br/> 目前支持Object、String、Map、Collection类型判断
	 * 
	 * @param obj
	 *            对象
	 * @return 判断是否为null或""为集合长度为0返回true,否则返回false
	 */
	@SuppressWarnings("unchecked")
	public static boolean isNullValue(Object obj) {
		if (obj == null) {
			return true;
		} else if (obj instanceof String) {
			return "".equals(obj) ? true : false;
		} else if (obj instanceof Collection) {
			Collection c = (Collection) obj;
			return c.size() == 0 ? true : false;
		} else if (obj instanceof Map) {
			Map c = (Map) obj;
			return c.size() == 0 ? true : false;
		}

		return false;
	}
	
	/**
	 * 校验是否正整数
	 */
	public static boolean isNumber(String input) {
		if (StringUtil.isEmpty(input)) {
			return false;
		}
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static String getIcon(String filename) {
		String icon = "";
		if (filename.endsWith(".avi") || filename.endsWith(".rm") || filename.endsWith(".rmvb")) {
			icon = "avi.png";
		} else if (filename.endsWith(".bmp")) {
			icon = "bmp.png";
		} else if (filename.endsWith(".doc") || filename.endsWith(".docx")) {
			icon = "docx_win.png";
		} else if (filename.endsWith(".fla")) {
			icon = "fla.png";
		} else if (filename.endsWith(".gif")) {
			icon = "gif.png";
		} else if (filename.endsWith(".html")) {
			icon = "html.png";
		} else if (filename.endsWith(".ind")) {
			icon = "ind.png";
		} else if (filename.endsWith(".ini")) {
			icon = "ini.png";
		} else if (filename.endsWith(".jpg") || filename.endsWith(".jpeg")) {
			icon = "jpeg.png";
		} else if (filename.endsWith(".jsf")) {
			icon = "jsf.png";
		} else if (filename.endsWith(".midi")) {
			icon = "midi.png";
		} else if (filename.endsWith(".mov")) {
			icon = "mov.png";
		} else if (filename.endsWith(".mp3")) {
			icon = "mp3.png";
		} else if (filename.endsWith(".mpeg")) {
			icon = "mpeg.png";
		} else if (filename.endsWith(".pdf")) {
			icon = "pdf.png";
		} else if (filename.endsWith(".png")) {
			icon = "png.png";
		} else if (filename.endsWith(".ppt") || filename.endsWith(".pptx")) {
			icon = "pptx_win.png";
		} else if (filename.endsWith(".proj")) {
			icon = "proj.png";
		} else if (filename.endsWith(".psd")) {
			icon = "psd.png";
		} else if (filename.endsWith(".rar")) {
			icon = "rar.png";
		} else if (filename.endsWith(".txt")) {
			icon = "text.png";
		} else if (filename.endsWith(".tiff")) {
			icon = "tiff.png";
		} else if (filename.endsWith(".url")) {
			icon = "url.png";
		} else if (filename.endsWith(".vsd")) {
			icon = "vsd.png";
		} else if (filename.endsWith(".wav")) {
			icon = "wav.png";
		} else if (filename.endsWith(".wma")) {
			icon = "wma.png";
		} else if (filename.endsWith(".wmv")) {
			icon = "wmv.png";
		} else if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
			icon = "xlsx_win.png";
		} else if (filename.endsWith(".zip")) {
			icon = "zip.png";
		} else {
			icon = "settings.png";
		} 
		return icon;
	}
}
