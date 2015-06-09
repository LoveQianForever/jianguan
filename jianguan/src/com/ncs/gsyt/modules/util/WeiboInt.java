package com.ncs.gsyt.modules.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import weibo4j.Weibo;
import weibo4j.Status;
import weibo4j.http.AccessToken;
import weibo4j.http.RequestToken;

public class WeiboInt {

	static AccessToken accessToken = null;

	public WeiboInt(String note) {
		try {
			/*
			 * if (args.length < 3) { System.out.println(
			 * "Usage: java weibo4j.examples.OAuthUploadByFile token tokenSecret filePath"
			 * ); System.exit( -1); }
			 */

			System.setProperty("weibo4j.oauth.consumerKey", "2497916752");
			System.setProperty("weibo4j.oauth.consumerSecret",
					"5aaa6896b64a31de9806f08853a49c9d");
			Weibo weibo = new Weibo();
			if (accessToken == null) {
				RequestToken requestToken = weibo.getOAuthRequestToken();
				String xml = postUrl(requestToken.getAuthorizationURL()
						+ "&oauth_callback=xml&display=xml&userId=44414897@qq.com&passwd=vivian6006");
				System.out.println(xml);
				String pin = parseXml(xml);
				accessToken = requestToken.getAccessToken(pin);

			}
			/*
			 * 此处需要填写AccessToken的key和Secret，可以从OAuthUpdate的执行结果中拷贝过来
			 */
			// weibo.setToken(accessToken.getToken(),accessToken.getTokenSecret());
			// weibo.setToken("509151426cdd4975d30427490442c056","d59d3fbeaa463ba4b24f9b7b672a7744");
			try {
				String msg = URLEncoder.encode(note, "UTF-8");
				Status status = weibo.updateStatus(msg);

				System.out.println("Successfully upload the status to ["
						+ status.getText() + "].");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception ioe) {
			System.out.println("Failed to read the system input.");
		}
	}

	public WeiboInt(String note, String filepath) {
		try {
			/*
			 * if (args.length < 3) { System.out.println(
			 * "Usage: java weibo4j.examples.OAuthUploadByFile token tokenSecret filePath"
			 * ); System.exit( -1); }
			 */

			System.setProperty("weibo4j.oauth.consumerKey", "2497916752");
			System.setProperty("weibo4j.oauth.consumerSecret",
					"5aaa6896b64a31de9806f08853a49c9d");
			Weibo weibo = new Weibo();
			if (accessToken == null) {
				RequestToken requestToken = weibo.getOAuthRequestToken();
				String xml = postUrl(requestToken.getAuthorizationURL()
						+ "&oauth_callback=xml&display=xml&userId=44414897@qq.com&passwd=vivian");
				System.out.println(xml);
				String pin = parseXml(xml);
				accessToken = requestToken.getAccessToken(pin);

			}
			/*
			 * 此处需要填写AccessToken的key和Secret，可以从OAuthUpdate的执行结果中拷贝过来
			 */
			// weibo.setToken(accessToken.getToken(),accessToken.getTokenSecret());
			// weibo.setToken("509151426cdd4975d30427490442c056","d59d3fbeaa463ba4b24f9b7b672a7744");
			try {
				File file = new File(filepath);
				String msg = URLEncoder.encode(note, "UTF-8");
				Status status = weibo.uploadStatus(msg, file);

				System.out.println("Successfully upload the status to ["
						+ status.getText() + "].");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception ioe) {
			System.out.println("Failed to read the system input.");
		}
	}

	public static String postUrl(String urlpath) {
		InputStream in = null;
		try {
			URL url = new URL(urlpath);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(2000);
			in = connection.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			byte[] bb = new byte[bis.available()];
			bis.read(bb);
			return new String(bb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();

				}

			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;

	}

	public static String parseXml(String xml) {
		int index = xml.indexOf("<oauth_verifier>")
				+ "<oauth_verifier>".length();
		int end = xml.indexOf("</oauth_verifier>");
		xml = xml.substring(index, end);
		System.out.println(xml);
		return xml;
	}
}
