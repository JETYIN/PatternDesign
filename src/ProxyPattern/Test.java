package ProxyPattern;

public class Test {
	public static void main(String[] args) {

		/** ����һ��ʵ�� **/
		ILawFolw iLawFolw = new XiaoMing();
		/** ע�����ģʽ **/
		ProxyWang proxyWang = new ProxyWang(iLawFolw);
		/** ���д��������� **/
		proxyWang.requestCourse();
		proxyWang.requestLaw();
		proxyWang.requestLawyer();
		proxyWang.requestNews();
	}

}
