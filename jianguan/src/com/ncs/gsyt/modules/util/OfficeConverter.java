package com.ncs.gsyt.modules.util;

import java.io.File;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class OfficeConverter {

	public static void main(String[] args) {
		File inputFile = new File("D:/test/投标书1安徽新长江投资股份有限公司1.doc");
		File outputFile = new File("D:/test/test2.html");

		OpenOfficeConnection con = new SocketOpenOfficeConnection(8100);
		try {
			con.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(con);
			converter.convert(inputFile, outputFile);
		} catch (ConnectException e) {
			System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.disconnect();
					con = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void convert(String sourcefile, String targetfile) {
		File inputFile = new File(sourcefile);
		File outputFile = new File(targetfile);
		
		OpenOfficeConnection con = new SocketOpenOfficeConnection(8100);
		try {
			con.connect();
			DocumentConverter converter = new OpenOfficeDocumentConverter(con);
			converter.convert(inputFile, outputFile);
		} catch (ConnectException e) {
			System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.disconnect();
					con = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
