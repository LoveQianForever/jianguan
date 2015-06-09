package com.ncs.gsyt.core.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {

private static Properties prop = new Properties();
	
	public PropertiesUtil(URL url){
		FileInputStream fis;
		try {
			fis = new FileInputStream(url.getPath());
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		} catch (IOException e4) {
			e4.printStackTrace();
		}
	}
	public static Properties getProperties(URL url){
		new PropertiesUtil(url);
		return prop;
	}
}
