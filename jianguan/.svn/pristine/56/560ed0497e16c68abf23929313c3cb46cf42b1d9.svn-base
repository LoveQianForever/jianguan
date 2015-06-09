package com.ncs.gsyt.core.util;

import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class GetInformation {

	public Properties prop;

	  public GetInformation(String s) {
	    String s1 = s.trim();
	    init(s1);
	  }

	  private void init(String s) {

	    java.io.InputStream inputstream = getClass().getClassLoader().getResourceAsStream(s);
	    // System.out.println("name=" + s);
	    prop = new Properties();
	    try {
	      prop.load(inputstream);
	    }
	    catch (Exception exception) {
	      System.err.println("Can't rea\t from property file: " + s + ".Make sure that the file is under proper path");
	      return;
	    }
	  }

	  public String getProperty(String s) {
	    String s1 = "";
	    s1 = prop.getProperty(s);
	    if (s1 == null) {
	      System.out.println("Please check the property name '" + s + "' and try it again");
	      s1 = "";
	    }
	    return s1;
	  }

	  public static String getPropFromBundle(String s, String s1) {
	    try {
	      ResourceBundle resourcebundle = ResourceBundle.getBundle(s);
	      return resourcebundle.getString(s1);
	    }
	    catch (MissingResourceException missingresourceexception) {
	      missingresourceexception.printStackTrace();
	    }
	    return "";
	  }

	  public static void main(String args[]) {
	    System.out.println(getPropFromBundle("db", args[0]));
	    System.out.println("This is a test");
	  }
}
