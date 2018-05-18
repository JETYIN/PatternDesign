package com.dylan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;

//import com.yaowang.util.DateUtils;
import com.dylan.HttpsUtil;

public class TestSdkDeposit {

	private static String appKey = "2534A28210A14A97B335490A5C5D096C";
	private static String hostPath = "https://tsdk.modou.com/yaodiansdk/";

	// private static String hostPath="https://localhost/ydsdk/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkOpenId();
	}

	/**
	 * 妫�煡openID
	 */
	private static void checkOpenId() {
		Map<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("openId", "3850DD2D9C3E43BBB7C0E445160C77CE");
		paramsMap.put("gameId", "2016000002");
		testCommon(paramsMap, hostPath + "sdk/server/checkOpenId.html");
	}

	private static void testCommon(Map<String, String> paramsMap, String url) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateString = formatter.format(new Date());
		String nowtime = dateString;
		System.out.println("submit_time:" + nowtime);
		System.out.println("openId:" + "3850DD2D9C3E43BBB7C0E445160C77CE");
		System.out.println("gameId:" + "2016000002");

		paramsMap.put("submit_time", nowtime);
		// 鏋勫缓绛惧悕鍙傛暟
		StringBuilder params = new StringBuilder();
		Object[] keys = paramsMap.keySet().toArray();
		Arrays.sort(keys);
		List<NameValuePair> paramsArr = new ArrayList<NameValuePair>();
		for (Object key : keys) {
			Object value = paramsMap.get(key);
			if (value != null) {
				if (params.length() > 0) {
					params.append("&" + key + "=" + value);
				} else {
					params.append(key + "=" + value);
				}
			}
			HttpUtil.addParams(paramsArr, key + "", value + "");
		}
		System.out.println("params:" + params);
		params.append(appKey);
		System.out.println("appKey:" + "2534A28210A14A97B335490A5C5D096C");
		// 鐢熸垚绛惧悕
		String sign = DigestUtils.shaHex(params.toString()).toUpperCase();
		System.out.println("sign:" + sign);
		HttpUtil.addParams(paramsArr, "sign", sign);
		try {
			System.out.println(url);
			String str = HttpsUtil.doHttpsPost(url, paramsArr, null, null);
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * java.security.cert.X509Certificate[] certs=null; try{
	 * request.getHeader("client-cert");
	 * certs=(X509Certificate[])request.getAttribute
	 * ("javax.servlet.request.X509Certificate");
	 * 
	 * if (certs == null) { out.println("No certificates"); } else if
	 * (certs.length == 0) { out.println("Certificates length is 0"); } else {
	 * java.security.cert.X509Certificate cert = certs[0]; String dn =
	 * cert.getSubjectX500Principal().toString(); out.println("SubjectDN: " +
	 * dn); out.println(); out.println(
	 * "------------------certification detail--------------------");
	 * out.println(cert); out.println(
	 * "----------------------------------------------------------"); } }
	 * catch(Exception e){ out.println("Exception=" + e.getMessage()); }
	 */
}
