package huawei;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Map;
import java.util.TreeMap;

public class SignHelper {
	private static String sign(byte[] data, String privateKey) {
		try {
			byte[] e = Base64.decodeBase64(privateKey);
			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(e);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
			Signature signature = Signature.getInstance("SHA256WithRSA");
			signature.initSign(privateK);
			signature.update(data);
			return Base64.encodeBase64String(signature.sign());
		} catch (Exception var) {
			System.out.println("SignUtil.sign error." + var);
			return "";
		}
	}

	/**
	 * ���ݲ���Map��������õĲ�����
	 * 
	 * @param params
	 * @return
	 */
	private static String format(Map<String, String> params) {
		StringBuffer base = new StringBuffer();
		Map<String, String> tempMap = new TreeMap<String, String>(params);

		// ��ȡ����nsp_key�Ļ�����
		try {
			for (Map.Entry<String, String> entry : tempMap.entrySet()) {
				String k = entry.getKey();
				String v = entry.getValue();
				base.append(k).append("=")
						.append(URLEncoder.encode(v, "UTF-8")).append("&");
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encode parameters failed.");
			e.printStackTrace();
		}

		String body = base.toString()
				.substring(0, base.toString().length() - 1);
		// �ո���Ǻ�ת��
		body = body.replaceAll("\\+", "%20").replaceAll("\\*", "%2A");

		return body;
	}

	public static String generateCPSign(Map<String, String> requestParams,
			final String cpAuthKey) {
		// ����Ϣ���в�ѯ�ַ������ֵ��������ҽ���URLCode����
		String baseStr = format(requestParams);

		// ��CP��ǩ��˽Կ�����������������ַ�������ǩ��
		String cpSign = sign(baseStr.getBytes(Charset.forName("UTF-8")),
				cpAuthKey);
		System.out.println("cpSign:"+cpSign);

		return cpSign;
	}
}
