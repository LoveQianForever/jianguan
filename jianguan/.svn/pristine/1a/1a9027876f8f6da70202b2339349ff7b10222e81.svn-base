package com.ncs.gsyt.core.trans;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.net.SocketException;

public class ServerThread implements Runnable {

	Socket s;// 实例化socket类

	private String tempFolder;// 临时文件夹名

	public ServerThread(Socket s, String tempFolder) {
		this.s = s;
		this.tempFolder = tempFolder;
	}

	public void run() {
		try {

			InputStream ins = s.getInputStream();
			OutputStream outs = s.getOutputStream();

			DataInputStream dis = new DataInputStream(ins);
			DataOutputStream dos = new DataOutputStream(outs);

			// 取得线程ID
			String SerID = "SerID-" + Thread.currentThread().getName();

			while (true) {
				try {

					String inStr = dis.readUTF();

					// 接收到的文件包含头信息
					if (inStr != null) {
						// 对收到的socket包过滤出文件信息
						if (inStr.indexOf("ClientInfo") > -1) {
							// if (inStr.contains("ClientInfo")) {
							System.out.println(SerID + " get FileInfo! ");
							// 文件名字
							String fName = new String(inStr.replaceAll(
									"(.+<FileName>)|(<\\/FileName>\\S+)", "")
									.toString().getBytes("utf-8"), "utf-8");
							// 文件总长度
							String fSize = new String(inStr.replaceAll(
									"(.+<FileLength>)|<\\/FileLength>", "")
									.toString().getBytes("utf-8"), "utf-8");
							System.out.println("size: " + fSize);
							long Size = Long.parseLong(fSize);
							// 区块起始长度
							String fPs = new String(
									inStr
											.replaceAll(
													"(.+<FilePointerStart>)|(</FilePointerStart>\\S+)",
													"").toString().getBytes(
													"utf-8"), "utf-8");
							System.out.println("PS: " + fPs);
							// 区块结束长度
							String fPe = new String(
									inStr
											.replaceAll(
													"(.+<FilePointerEnd>)|(</FilePointerEnd>\\S+)",
													"").toString().getBytes(
													"utf-8"), "utf-8");
							System.out.println("PE: " + fPe);
							long PointS = Long.parseLong(fPs); // 分块头
							long PointE = Long.parseLong(fPe); // 分块尾
							System.out.println("SourceFile Name :" + fName);
							File tempF = new File(tempFolder, fName);
							if (!tempF.exists()) {
								// 检测目标文件夹是否存在
								if (new File(tempFolder).isDirectory()) {
									TempFile.creat(tempF, Size);// 如果临时文件不存在就建立
								} else {
									boolean creat = new File(tempFolder)
											.mkdirs();
									if (creat) {
										TempFile.creat(tempF, Size);// 如果临时文件不存在就建立
									} else {
										//System.out
										//		.println("Error:System can not creat folder!");
										//System.out.println(SerID + " exits");
										dis.close();// 关闭包类
										dos.close();// 关闭输出流
										s.close();// 关连接
										Thread.currentThread().stop();
									}
								}

							}
							// 返回服务器准备好了
							String SerReady = SerID + " ServerReady=1";
							dos.writeUTF(SerReady);// 返回服务器信息
							dos.flush();

							// 取得客户端发送标志"SendStart"
							if (dis.readUTF().equals("SendStart")) {

								// 随机读写文件(适应多线程方式)
								RandomAccessFile fos = new RandomAccessFile(
										tempF.getPath(), "rw");

								long curPoint = PointS;// 文件指针起点
								long endSet = PointE;// 文件指针终点
								System.out.println(SerID + " 文件指针起点:" + curPoint);
								System.out.println(SerID + " 文件指针终点:" + endSet);
								long nowSize = 0;// 已读/写字节
								byte[] buffer = new byte[1024]; // 建立缓冲区

								while (curPoint < endSet) {
									int length = 0;
									try {

										if ((endSet - curPoint + 1) < 1024) {
											fos.seek(curPoint);// 寻找写入位置
											byte[] bufferM = new byte[(int) (endSet
													- curPoint + 1)];// 调整缓冲区大小
											length = ins.read(bufferM);// 读取bufferM缓冲socket流

											try {
												fos.write(bufferM);// 将取得的socket流写入文件
												dos.writeUTF("SerGotIt");// 返回服务器信息
												dos.flush();
												curPoint += length;// 文件指针增加
												nowSize += length;
												fos.close();
												// 向发送接收结束标志
												dos.writeUTF("ReciveEnd");
												dos.flush();
												//System.out.println(SerID
												//		+ " is receive ok.");
												break;

											} catch (IOException e) {
												e.printStackTrace();
											}
										} else {
											fos.seek(curPoint);
											length = ins.read(buffer);
										}
									} catch (IOException e) {
										e.printStackTrace();
										System.out.println(SerID
												+ " is abnormally closed.");
										break;
									}

									if (length == buffer.length) {
										// 将缓冲区字节写入文件
										try {
											//System.out
											//		.println(SerID
											//				+ " receive "
											//				+ buffer.length
											//				+ " bytes.");
											fos.write(buffer);
											dos.writeUTF("SerGotIt");// 返回服务器信息
											dos.flush();
											curPoint += buffer.length;// 指针+1024
											nowSize += buffer.length;
											//System.out.println(SerID + " 指针位置 "
											//		+ curPoint);
											//System.out.println(SerID
											//		+ "线程size写入进度:" + nowSize);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}
								
							}

						}
					}
					// 接收到客户端结束标志，跳出循环
					if (dis.readUTF().equals("SendEnd")) {
						System.out.println("服务器接收完毕");
						break;
					}

				} catch (SocketException s) {
					// s.printStackTrace();
					// 客户端非正常退出处理
					System.out.println(SerID + " 线程异常.");
					break;
				}
			}
			
			dis.close();// 关闭包类
			dos.close();// 关闭输出流
			ins.close();
			outs.close();
			s.close();// 关连接
			//Thread.currentThread().stop();
			System.out.println(SerID + " exited.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
