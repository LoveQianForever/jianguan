package com.ncs.gsyt.core.trans;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * Description 文件传输线程
 *
 * @param info;
 *            初始化时打包的文件信息
 * @param sourceFilePath
 *            文件路径+文件名(例:x:\example\example.class)
 * @param offSet
 *            文件指针起点值地址(按文件区块数量划分)
 * @param endSet
 *            文件指针终点值地址(按文件区块数量划分)
 * @param serPort
 *            默认连接端口2008;
 * @param serIP
 *            连接IP
 * @version 1.1
 */
public class FileTransThread implements Runnable {

	private String info;// 文件信息
	private String sourceFilePath;// 源文件路径

	private long offSet;// 这个线程写入文件起始值地址
	private long endSet;// 这个线程写入的文件长度

	private int serPort;// 默认连接端口2008;
	private String serIP;// 连接IP

	FileTransThread(String info, String sourceFilePath, long offSet,
			long endSet, String serIP, int serPort) {
		this.info = info;
		this.sourceFilePath = sourceFilePath;
		this.offSet = offSet;
		this.endSet = endSet;
		this.serIP = serIP;
		this.serPort = serPort;
	}

	public void run() {
		try {
			String CliID = "ClientID-" + Thread.currentThread().getId();
			System.out.println(CliID + " connect " + serIP);
			Socket s = new Socket(InetAddress.getByName(serIP), serPort);
			System.out.println(CliID + " successfully connected.");

			InputStream clientIn = s.getInputStream();
			OutputStream clientOut = s.getOutputStream();

			DataInputStream dis = new DataInputStream(clientIn);

			DataOutputStream dos = new DataOutputStream(clientOut);

			dos.writeUTF(info);// 发送文件信息到服务器
			dos.flush();
			System.out.println(CliID + " send FileInfo!");

			while (true) {

				String inStr = dis.readUTF();
				// 判断服务器是否准备接收
				if (inStr.contains("ServerReady=1")) {
					System.out.println(CliID + " report: " + inStr);
					// 开始准备文件传输

					dos.writeUTF("SendStart");// 发送接收标志
					dos.flush();

					RandomAccessFile fos = new RandomAccessFile(sourceFilePath,
							"r");

					long curPoint = offSet;

					long nowSize = 0;
					byte[] buffer = new byte[1024];

					while (curPoint < endSet) { // 建立缓冲区
						int length = 0;
						try {

							if ((endSet - curPoint + 1) < 1024) {
								fos.seek(curPoint);
								byte[] bufferM = new byte[(int) (endSet
										- curPoint + 1)];// 调整缓冲区大小
								length = fos.read(bufferM);

								try {
									clientOut.write(bufferM);
									clientOut.flush();
									//等待服务器确认
									for (;;) {
										if (dis.readUTF().equals("SerGotIt")) {
											break;
										}
									}
									curPoint += length;
									nowSize += length;
									fos.close();
									System.out.println(CliID + " is send ok.");
									break;

								} catch (IOException e) {
									e.printStackTrace();
									System.out.println(CliID
											+ " is abnormally closed.");
									break;

								}
							} else {
								fos.seek(curPoint);
								length = fos.read(buffer);
							}
						} catch (IOException e) {
							e.printStackTrace();

						}

						if (length == buffer.length) {
							// 将缓冲区字节写入文件
							try {
								System.out.println(CliID + " send "
										+ buffer.length + " bytes.");
								clientOut.write(buffer);
								clientOut.flush();
								//等待服务器确认
								for (;;) {
									if (dis.readUTF().equals("SerGotIt")) {
										break;
									}
								}
								curPoint += buffer.length;// 指针+1024
								nowSize += buffer.length;
								System.out.println(CliID + " 指针位置 " + curPoint);
								System.out.println(CliID + "线程size读入进度:"
										+ nowSize);
							} catch (IOException e) {
								e.printStackTrace();
								System.out.println(CliID
										+ " is abnormally closed.");
								break;

							}
						}
					}
				}
				// 向服务端发送结束标志，跳出循环
				if (dis.readUTF().equals("ReciveEnd")) {
					dos.writeUTF("SendEnd");
					dos.flush();
					System.out.println("传输完毕");
					break;
				}
			}
			dis.close();// 关闭包类
			dos.close();// 关闭输出流
			s.close();// 关连接
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
