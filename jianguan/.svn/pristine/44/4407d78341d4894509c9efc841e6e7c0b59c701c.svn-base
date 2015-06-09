package com.ncs.gsyt.core.trans;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ncs.gsyt.core.util.GetInformation;

public class TransferServer extends Thread{

	public TransferServer() {
		this.start();
	}
	
	public void run() {
		try {
			GetInformation getInfo = new GetInformation("system.properties");
			int serPort = Integer.parseInt(getInfo.getProperty("FilePort"));//服务器默认端口
			String tempFolder = getInfo.getProperty("FilePath");//文件夹,用于存放接收文件
			ServerSocket ss = null;//设定Socket
			ss = new ServerSocket(serPort);
			System.out.println("服务器启动,监听端口" + ss.getLocalPort());
			System.out.println("服务器临时文件路径: " + tempFolder);
			while (true) {
				Socket s = ss.accept();
				new Thread(new ServerThread(s, tempFolder)).start();
			}
		} catch (IOException e) {
			e.getMessage();
			System.out.println("服务器端口被占用,或其他问题.");
		}
	}
}
