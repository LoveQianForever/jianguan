package com.ncs.gsyt.modules.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


/**
 * JAXB包装工具，实现java和xml之间的互相转换
 * @author nichun 2012-02-08
 * @version 1.0 
 * */
public class Object2XML {

	private static ConcurrentHashMap<Class<?>, JAXBContext> jaxbContextMap = new ConcurrentHashMap<Class<?>,JAXBContext>(); 
	
	/**  
	* 将JAXB实现对象转换成XML格式的字符串  
	* @param <T> 这里的类是具体类，不能是接口  
	* @param object 转换对象实例  
	* @return  String
	*/
	public static <T> String toXML(Class<T> object, T t) throws JAXBException {

		JAXBContext jc = null;
		if (jaxbContextMap.get(object) == null) {
			Map<String, String> properties = new HashMap<String, String>();
			jc = JAXBContext.newInstance(new Class<?>[]{object},properties);
			jaxbContextMap.put(object, jc);
		} else {
			jc = jaxbContextMap.get(object);
		}

		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_ENCODING, "utf-8");// 编码格式
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 格式化输出xml
		m.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否生成头信息
		StringWriter sw = new StringWriter();
		m.marshal(t, sw);
		return sw.toString();

	}
	
	/**  
	* 将XML格式的文件转换成JAXB实现对象  
	* @param object  
	* @param file  
	* @return  <T>
	*/ 
	@SuppressWarnings("unchecked")
	public static  <T> T toJava(Class<T> object, FileReader fr) {
		try {
			JAXBContext jc = null;
			if(jaxbContextMap.get(object)==null) {
				Map<String, String> properties = new HashMap<String, String>();
				jc = JAXBContext.newInstance(new Class<?>[]{object},properties);
				jaxbContextMap.put(object, jc);
			} else {
				jc = jaxbContextMap.get(object);
			}
			
			Unmarshaller um = jc.createUnmarshaller();
			return (T) um.unmarshal(fr);
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		} 
		return null;
	}
	
	public static void main(String[] args) throws JAXBException, IOException{
		FileReader fr = new FileReader("d:\\test.xml");
		//User user = (User)Object2XML.toJava(User.class, fr);
		//System.out.println(user.getId());
	}
}
