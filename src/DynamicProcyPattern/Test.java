package DynamicProcyPattern;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {

		// 构造一个需要被代理的对象--小明
		ILawFolw xiaoming = new XiaoMing();

		// 构造一个动态代理对象--此处的动态代理对象已object为参数
		// 将小明交由动态代理对象进行代理
		DynamicProxy dynamicProxy = new DynamicProxy(xiaoming);

		// 获取被代理类的classLoader
		ClassLoader classLoader = xiaoming.getClass().getClassLoader();

		show(classLoader);
		// 动态构造一个代理者-律师

		ILawFolw lawyer = (ILawFolw) Proxy.newProxyInstance(classLoader,
				new Class[] { ILawFolw.class }, dynamicProxy);
		lawyer.requestCourse();
		lawyer.requestLaw();
		lawyer.requestNews();
		lawyer.requestLawyer();
	}

	/**classLoader的上层是ExtClassLoader-->AppClassLoader**/
	/** 显示类加载器 **/
	public static void show(ClassLoader loader) {

		ClassLoader tempLoader = null;

		System.out.println(loader);
		tempLoader = loader.getParent();

		System.out.println(tempLoader);
	}
}
