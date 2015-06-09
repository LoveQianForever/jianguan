package com.ncs.gsyt.core.trans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Description 生成临时文件
 * Creation Date 11-01-2008
 * @version 1.0
 */
public class TempFile {

	/**
	 * 创建文件
	 * @param targetFile 文件对象
	 * @param fileLength 文件字节长度
	 */
	public static void creat(File targetFile, long fileLength) {
		long length = fileLength;//指定写入文件文件大小
		byte[] buffer = new byte[1024];// 缓冲区1024 bytes
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(targetFile);
			while (true) { // 建立缓冲区
				if (length > 1024) {
					// 将缓冲区字节写入文件
					try {
						fos.write(buffer);// 写入缓冲
						length = length - 1024;
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					byte[] buf = new byte[(int) length];
					System.arraycopy(buffer, 0, buf, 0, (int) length);
					try {
						fos.write(buf);
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
			//System.out.println("写入临时文件" + targetFile.getName() + ":"
			//		+ targetFile.length() + " bytes");

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//long end = System.currentTimeMillis();
		//System.out.println("临时文件" + targetFile.getName() + "写入耗时:"
		//		+ (end - now) + " ms");
	}
}
