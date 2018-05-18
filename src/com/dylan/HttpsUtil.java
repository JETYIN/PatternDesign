package com.dylan;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName: HttpsUtil
 * @Description: TODO(HttpClient鍙戣捣https璇锋眰宸ュ叿绫�
 * @author tandingbo
 * @date 2016骞�鏈�5鏃�涓婂崍11:19:31
 * 
 */
public final class HttpsUtil {
	// 瓒呮椂鏃堕棿
	public static final String defaultTimeOut = "120";

	public static void main(String[] args) {
		String Url = "https://daichong.3227.com/api/modou/gamelist.html";
		try {
			String getResult = doHttpsGet(Url, null, null);
			String postResult = doHttpsPost(Url, null, null, null);
			System.out.println("_______________get:" + getResult);
			System.out.println("_______________post:" + postResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * post璇锋眰
	 * 
	 * @param url
	 * @param values
	 * @param cookie
	 * @param refer
	 * @return
	 * @throws IOException
	 */
	public static String doHttpsPost(String url, List<NameValuePair> values,
			String cookie, String refer) throws IOException {
		String result = null;

		HttpPost post = new HttpPost(url);
		CloseableHttpClient httpClient = buildHttpClient();
		// 璁剧疆璇锋眰鍜屼紶杈撹秴鏃舵椂闂�
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(
				Integer.valueOf(defaultTimeOut) * 1000).setConnectTimeout(
				Integer.valueOf(defaultTimeOut) * 1000).build();
		post.setConfig(requestConfig);

		if (cookie != null) {
			post.setHeader("Cookie", cookie);
		}
		if (refer != null) {
			post.setHeader("Referer", refer);
		}
		if (values != null) {
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(values,
					Consts.UTF_8);
			post.setEntity(formEntity);
		}

		CloseableHttpResponse response = httpClient.execute(post);
		try {
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			return result;
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

	/**
	 * get璇锋眰
	 * 
	 * @param url
	 * @param cookie
	 * @param refer
	 * @return
	 * @throws IOException
	 */
	public static String doHttpsGet(String url, String cookie, String refer)
			throws IOException {
		String result = null;

		HttpGet get = new HttpGet(url);
		CloseableHttpClient httpClient = buildHttpClient();
		// 璁剧疆璇锋眰鍜屼紶杈撹秴鏃舵椂闂�
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(
				Integer.valueOf(defaultTimeOut) * 1000).setConnectTimeout(
				Integer.valueOf(defaultTimeOut) * 1000).build();
		get.setConfig(requestConfig);

		if (cookie != null) {
			get.setHeader("Cookie", cookie);
		}
		if (refer != null) {
			get.setHeader("Referer", refer);
		}

		CloseableHttpResponse response = httpClient.execute(get);
		try {
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
			return result;
		} finally {
			if (response != null) {
				response.close();
			}
		}
	}

	/**
	 * 鏋勫缓CloseableHttpClient
	 * 
	 * @return
	 */
	public static CloseableHttpClient buildHttpClient() {
		enableSSL();
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setCookieSpec(CookieSpecs.STANDARD_STRICT)
				.setExpectContinueEnabled(true).setTargetPreferredAuthSchemes(
						Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
				.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
				.build();
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
				.<ConnectionSocketFactory> create().register("http",
						PlainConnectionSocketFactory.INSTANCE).register(
						"https", socketFactory).build();
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager)
				.setDefaultRequestConfig(defaultRequestConfig).build();
		return httpClient;
	}

	/**
	 * https缃戠珯涓�埇鎯呭喌涓嬩娇鐢ㄤ簡瀹夊叏绯绘暟杈冧綆鐨凷HA-1绛惧悕锛屽洜姝ら鍏堟垜浠湪璋冪敤SSL涔嬪墠闇�
	 * 閲嶅啓楠岃瘉鏂规硶锛屽彇娑堟娴婼SL銆�
	 */
	private static TrustManager manager = new X509TrustManager() {
		@Override
		public void checkClientTrusted(X509Certificate[] x509Certificates,
				String s) throws CertificateException {

		}

		@Override
		public void checkServerTrusted(X509Certificate[] x509Certificates,
				String s) throws CertificateException {

		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};

	/**
	 * @Description:璋冪敤SSL
	 */
	private static void enableSSL() {
		try {
			SSLContext context = SSLContext.getInstance("TLS");
			context.init(null, new TrustManager[] { manager }, null);
			socketFactory = new SSLConnectionSocketFactory(context,
					NoopHostnameVerifier.INSTANCE);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 杩炴帴宸ュ巶
	 */
	private static SSLConnectionSocketFactory socketFactory;

	public HttpsUtil() {

	}
}
