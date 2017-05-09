package DynamicProcyPattern;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	/** InvocationHandler�ӿڶ�����һ��invoke���� **/
	/** ͨ���������ʵ�ֵĶ�̬����ģʽ **/

	private Object obj;

	public DynamicProxy(Object object) {
		this.obj = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		/** ͨ�����䶯̬���ñ��������ķ��� **/
		Object object = method.invoke(obj, args);
		/**���ر�������󣬷�������ڳ��������ڼ�Ķ�̬����**/
		return object;
	}

	/** ��̬���� **/
}
