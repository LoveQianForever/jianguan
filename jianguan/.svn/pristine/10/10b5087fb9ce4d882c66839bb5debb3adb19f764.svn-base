package com.ncs.gsyt.modules.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ncs.gsyt.core.javapns.devices.Device;
import com.ncs.gsyt.core.javapns.devices.implementations.basic.BasicDevice;
import com.ncs.gsyt.core.javapns.notification.AppleNotificationServerBasicImpl;
import com.ncs.gsyt.core.javapns.notification.PushNotificationManager;
import com.ncs.gsyt.core.javapns.notification.PushNotificationPayload;
import com.ncs.gsyt.core.javapns.notification.PushedNotification;

public class PushUtils22 {

	//private Log    log    = LogFactory.getLog(PushUtils22.class); 
	/**
     * apple的推送方法
     * @param tokens iphone手机获取的token
     * @param message 推送消息的内容
     * @param count 应用图标上小红圈上的数值
     * @param sound 声音
     * @param ab 系统
     * @param certificatePath 证书路径
     * @param certificatePassword 证书密码
     * @param sendCount 单发还是群发 true：单发 false：群发
     */
	 public static void sendpush(List<String[]> tokens, String message, int badge, String sound, String certificatePath, String certificatePassword, boolean sendCount) {
		 try
	        {
	            
	            
	            PushNotificationManager pushManager = new PushNotificationManager();
	            //true：表示的是产品发布推送服务 false：表示的是产品测试推送服务
	            pushManager.initializeConnection(new AppleNotificationServerBasicImpl(certificatePath, certificatePassword, true));
	            List<PushedNotification> notifications = new ArrayList<PushedNotification>();
	            // 发送push消息
	            if (sendCount)
	            {
	                //log.debug("--------------------------apple 推送 单-------");
	                Device device = new BasicDevice();
	                device.setToken(tokens.get(0)[0]);
	                //PushedNotification notification = pushManager.sendNotification(device, payLoad, true);
	                //notifications.add(notification);
	            }
	            else
	            {
	                //log.debug("--------------------------apple 推送 群-------");
	                //List<Device> device = new ArrayList<Device>();
	                
	                //for (String[] tokenArr : tokens)
	                for (int i = 0; i<tokens.size(); i++)
	                {
	                	String[] tokenArr = tokens.get(i);
	                	PushNotificationPayload payLoad = new PushNotificationPayload();
	    	            payLoad.addAlert(tokenArr[1]+"家长，"+tokenArr[2]); // 消息内容
	    	            //payLoad.addBadge(Integer.parseInt(tokenArr[5])); // iphone应用图标上小红圈上的数值
	    	            payLoad.addCustomDictionary("message_class", tokenArr[3]);
	    				payLoad.addCustomDictionary("service_id", tokenArr[4]);
	    				payLoad.addCustomDictionary("student_id", tokenArr[6]);
	    				payLoad.addCustomDictionary("student_name", tokenArr[7]);
	    				payLoad.addSound(sound);//铃音
	    				PushedNotification pushedNotification = new PushedNotification(new BasicDevice(tokenArr[0]), payLoad, i+1);
	    				notifications.add(pushedNotification);
	                }
	                pushManager.sendNotification(notifications);
	            }
	            List<PushedNotification> failedNotifications = PushedNotification.findFailedNotifications(notifications);
	            List<PushedNotification> successfulNotifications = PushedNotification.findSuccessfulNotifications(notifications);
	            int failed = failedNotifications.size();
	            int successful = successfulNotifications.size();
	            //pushManager.stopConnection();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	 }
	 
	public static void main(String[] args) throws Exception {
		//String deviceToken = "df4e189fa178d9f9079169ee8fce12c19fbebdb376e92c736dfb044101fd0048";// iphone手机获取的token
		//String alert = "我的push测试";// push的内容
		//int badge = 1;// 图标小红圈的数值
		//String sound = "default";// 铃音
		//sendAPNS(deviceToken, alert, badge, sound);
	}
}
