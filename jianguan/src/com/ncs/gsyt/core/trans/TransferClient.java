package com.ncs.gsyt.core.trans;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Description Socket文件传输客户端(默认支持多线程传输,未支持断点续传,未支持内网UDF传输)
 */
public class TransferClient {

	public static void main(String[] args) {
		//String[] args1 = new String[]{"127.0.0.1","2999","e:\\","5"};
		TransferClient.start(args, "ahtcs_ahcz.rar");
	}
	/**
	 * Description 文件传输客户端
	 *
	 * @param args[0]
	 *            文件路径+文件名(例:x:\example\example.class)
	 * @param args[1]
	 *            服务器IP地址(例: 192.168.1.1)
	 * @param args[2]
	 *            端口默认2008(例: 2008)
	 * @param args[3]
	 *            区块长度默认5 (例: 5)
	 * @param fileName
	 * 			  传送文件名
	 */
	public static void start(String[] args, String fileName) {

		int serPort = 2999;// 默认连接端口2008;
		int blockNum = 20;// 文件区块数量(同时决定线程数)
		String serIP = "127.0.0.1";// 服务器IP
		String filePath = "e:\\";// 欲发送文件路径+文件名

		if (args.length < 1 || null == args) {
			System.out.println("采用默认配置连接");
		} else {
			if (args[0].length() > 0) {
				serIP = args[0];
			}

			if (args[1].length() > 0) {
				serPort = Integer.parseInt(args[1]);
			}
			if (args[2].length() > 0) {
				filePath = args[2];
			}
			if (args[3].length() > 0) {
				blockNum = Integer.parseInt(args[3].replaceAll("\\D", ""));
			}
		}
		System.out.println("文件路径: " + filePath);
		System.out.println("文件名: " + fileName);
		System.out.println("连接IP: " + serIP);
		System.out.println("连接端口: " + serPort);
		System.out.println("线程数: " + blockNum);

		// 取得文件信息
		File source = new File(filePath+fileName);
		if (!source.exists()) {
			System.out.println("要传输的文件不存在!");
			return;
		}

		long fSize = source.length(); // 文件长
		//blockNum = (int)fSize/10000000;

		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String currentTime = sdf.format(new Date());

		String fName = currentTime + Math.round(100) + "-" + source.getName();// 按时间生成文件名
		//String fName = source.getName();
		System.out.println("源文件长度 " + fSize + " bytes.");

		// 区块信息
		long blockSize = fSize / blockNum; // 区块长度
		

		String[] fInfo = new String[blockNum];// 按区块生产文件信息组

		long offset = 0;// 区块起点位置
		long endset = 0;// 区块终点位置
		String sourceFilePath = source.getPath();// 取源文件路径

		// 打包区块信息
		for (int i = 0; i < blockNum; i++) {

			offset = ((long) i) * blockSize;// 设置文件指针起点
			endset = (((long) i + 1) * blockSize - 1 + (i == blockNum - 1 ? fSize
					% blockNum
					: 0));// 设置文件指针终点

			fInfo[i] = "ClientInfo<FileName>" + fName + "</FileName>";
			fInfo[i] += "<FilePointerStart>" + offset + "</FilePointerStart>";
			fInfo[i] += "<FilePointerEnd>" + endset + "</FilePointerEnd>";
			fInfo[i] += "<FileLength>" + fSize + "</FileLength>";

			// 按区块开启线程
			new Thread(new FileTransThread(fInfo[i], sourceFilePath, offset,
					endset, serIP, serPort)).start();
		}

	}
}
