package DynamicProcyPattern;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

	/** InvocationHandler接口定义了一个invoke方法 **/
	/** 通过反射机制实现的动态代理模式 **/

	private Object obj;

	public DynamicProxy(Object object) {
		this.obj = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		/** 通过反射动态调用被代理对象的方法 **/
		Object object = method.invoke(obj, args);
		/**返回被代理对象，反射具有在程序运行期间的动态调用**/
		return object;
	}

	/** 动态代理 **/
}
