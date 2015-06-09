package com.ncs.gsyt.modules.util;

import java.rmi.RemoteException;



import org.apache.axis2.AxisFault;

import com.microsoft.support.SmsPortStub;
import com.microsoft.support.SmsPortStub.SendSmsAT;
import com.microsoft.support.SmsPortStub.SendSmsATResponse;
import com.ncs.gsyt.constant.Constant;

public class SmsUtil {

	/**
	 * 发送短信
	 * @param linkPhone 发送手机
	 * @param content 短信内容  km1  gm1     命令+开关序号; 
	 * @param sendDate 发送日期
	 * @param smsLabel 短信标签
	 * */
	public static String doSendSMS(String linkPhone, String content, String sendDate, String smsLabel) {
		String result = "-99";
		try {
			SmsPortStub sps = new SmsPortStub();
			SendSmsAT ss = new SendSmsAT();
			ss.setEpid(Constant.SMS_EPID);
			ss.setUser_Name(Constant.SMS_USERNAME);
			ss.setPassword(Constant.SMS_PASSWORD);
			ss.setPhone(linkPhone);
			ss.setContent(content + "【" + smsLabel + "】");
			ss.setSendtime(sendDate);
			SendSmsATResponse ssp = sps.SendSmsAT(ss);
			result = ssp.getSendSmsATResult();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String args[]) {
		System.out.println(SmsUtil.doSendSMS("13956951731", "收到请回访", "", "飞鸟科技"));//
	}
}
