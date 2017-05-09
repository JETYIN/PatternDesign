package ProxyPattern;

public class Test {
	public static void main(String[] args) {

		/** 构造一个实现 **/
		ILawFolw iLawFolw = new XiaoMing();
		/** 注册代理模式 **/
		ProxyWang proxyWang = new ProxyWang(iLawFolw);
		/** 进行代理方法调用 **/
		proxyWang.requestCourse();
		proxyWang.requestLaw();
		proxyWang.requestLawyer();
		proxyWang.requestNews();
	}

}
