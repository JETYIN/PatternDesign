package huawei;

import org.apache.http.util.Asserts;

import java.util.HashMap;
import java.util.Map;

public class GameServiceCallDemo {
	private static final String RETURN_CODE_SUCCEED = "0";

	/**
	 * 
	 * @param requestUri
	 *            请求URL
	 *            https://gss-cn.game.hicloud.com/GameService-HMS/api/gbClientApi
	 * @param requestParams
	 *            请求参数对
	 * @param cpAuthKey
	 *            CP侧签名私钥
	 */

	public static void callGameService(String requestUri,
			Map<String, String> requestParams, final String cpAuthKey) {
		requestParams.put("cpSign", SignHelper.generateCPSign(requestParams,
				cpAuthKey));

		// 响应消息中返回参数
		Map<String, Object> responseParamPairs = RequestHandler.doPost(
				requestUri, requestParams);

		if (responseParamPairs.isEmpty()) {
			System.out.println("None response parameter.");
		} else {
			if (RETURN_CODE_SUCCEED.equalsIgnoreCase(getString("rtnCode",
					responseParamPairs))) {
				System.out.println("rtnCode: "
						+ getString("rtnCode", responseParamPairs));
				System.out
						.println("ts: " + getString("ts", responseParamPairs));
				System.out.println("rtnSign: "
						+ getString("rtnSign", responseParamPairs));
			} else {
				System.out.println("rtnCode: "
						+ getString("rtnCode", responseParamPairs));
				System.out.println("errMsg: "
						+ getString("errMsg", responseParamPairs));
			}
		}
	}

	private static String getString(String key,
			Map<String, Object> responseParamPairs) {
		Asserts.notNull(responseParamPairs, "responseParamPairs");

		Object value = responseParamPairs.get(key);

		if (value == null) {
			return null;
		}

		return value.toString();
	}

	public static void main(String[] args)
    {

        // CP签名私钥
        final String CP_AUTH_SIGN_PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIvK5NdUneYrz96HmvY5waScy8GKZokkTuhy7J3ptWMH81BpIvUR0GCZ09W3hMQ1JiTL7C3dbwLmcginmsHgX946Cz5XiPQCaBXOm+uZ0BVdWG5Ut+EC0UJaA+9ngqwMoU7DVVtZRYzpN61bnsqlD7FvWUsMVIjw9kXG8/UqkM/1AgMBAAECgYBafM1ArV9APJ/jlbezJpO4MF6cOzBAGaaSRMHxPfTR07WmGUgthohx32EF+DMSpqy4KOAKmElhgTXTcFp2oPysa+WrdobHYDRfSof3ffFSS0jhLPmU3ZrQrbi+1Nx4dsm1aQQxmeYlrwHJO3N0YhqTNG40FxX4V+7R/O/D8+NHCQJBAOuZanE6FgVwr1VHljJVYrTJ0c00DUFvvG6xurhDWwaqYE28dZKWdLw3x+XOcnBAmiRalZeB1sf/AIbTJ0uFgEcCQQCX5bVETTbZCbNDzpUePQjs7Axpa/3PNtUmfOQpQlmVuEqE19KcEbC5PzvturewPz4EWGqF3Ui5V8OqNLaIEOfjAkEA6uMyfx51NAlLlQ9hDF+aoDoSRK7fhFzdFdN2IB1vFC8rAnWhFnuQeNJ4JoJ0D7wosZPqTnnxY8W1hbXhGGdKIwJAJtq/b2VA7muoy2OAiWebbN9EnYLePa8M/vdbdaJfQAkQJsL+QKXVysz+C2WDrzW+K2ZieTONcrucdWFef5ezeQJBAMC8wR+Moa3D98DtmN0BmnPDIJSpaYjisSCLkyVVU/mX9p0ExJA+5Msv4QEnW9CjoZSc2ZqGB8Pn1FDwErMkvII=";

        // 游戏服务器提供给CP签名接口URL
        final String requestUri = "http://lfhigametest.hwcloudtest.cn:38080/GameService-HMS/api/gbClientApi";

        // CP请求参数
        Map<String,String> mockRequestParams = new HashMap<String,String>();
        mockRequestParams.put("method","external.hms.gs.checkPlayerSign");
        mockRequestParams.put("appId","300011255");
        mockRequestParams.put("cpId","900086000000000375");
        mockRequestParams.put("ts","1500552495471");
        mockRequestParams.put("playerId","1646420000000006");
        mockRequestParams.put("playerLevel","2");
        mockRequestParams.put("playerSSign","KdbNLoC23SOMlkW2fm9q+dTgQEASqZJP1QzMkNwGCFEMnNinY1CTg3Z7hIAb2GPCgw+39vvEZ2Ruvj5Fts0xAzV4qfRXUCC6bHVE1l/aFJUnHl8JAcpY8k3ZqPqng1suwzdlZor9eyPe52uRDLvxrDTqUAFH4s9vVR8PbpAEBFGhrD/nyZ+W0ORQ16ondxZQCTnkGDt6lrp7mX4vTQYJ8C8vv1fZgIKJPR4GAL8Hu0CEkJd0NCoktzL59WNzLOTL3D0iZl4mV8UcGx3aiKN2UZiuKf1J3ePG8wf6g7nXgM8EGRfZlItdqgPRP+898m73Z2KDntW2YGPMluH60ckjMQ==");

        GameServiceCallDemo.callGameService(requestUri,mockRequestParams,CP_AUTH_SIGN_PRIVATE_KEY);
    }
}
