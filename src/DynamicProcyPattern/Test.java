package DynamicProcyPattern;

import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {

		// ����һ����Ҫ������Ķ���--С��
		ILawFolw xiaoming = new XiaoMing();

		// ����һ����̬�������--�˴��Ķ�̬���������objectΪ����
		// ��С�����ɶ�̬���������д���
		DynamicProxy dynamicProxy = new DynamicProxy(xiaoming);

		// ��ȡ���������classLoader
		ClassLoader classLoader = xiaoming.getClass().getClassLoader();
		// ��̬����һ��������-��ʦ

		ILawFolw lawyer = (ILawFolw) Proxy.newProxyInstance(classLoader,
				new Class[] { ILawFolw.class }, dynamicProxy);
		lawyer.requestCourse();
		lawyer.requestLaw();
		lawyer.requestNews();
		lawyer.requestLawyer();
	}
}
