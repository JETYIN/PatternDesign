package FactoryPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConcreatFactory extends Factory {

	@Override
	public <T extends Product> T creatProduct(Class<T> cla) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product = (Product) Class.forName(cla.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return (T) product;
	}

	// 有参
	@Override
	public <T extends Product> T creatProduct(Class<T> cla, Object... args) {
		// TODO Auto-generated method stub
		// 1.获取被创建类的所有构造方法 --比如3个构造方法
		Product product = null;
		Constructor[] constructor = cla.getConstructors();

		for (Constructor cons : constructor) {
			// 2.遍历获取到的构造方法，获取每个构造方法的参数列表大小
			Class clasz[] = cons.getParameterTypes();
			// clasz.length大于0表示有参构造函数
			if (clasz.length > 0) {
				boolean isThisConstructor = true;// 有参的构造函数可能由多个
				for (int i = 0; i < clasz.length; i++) {
					//3.将构造函数的参数列表与传入的不定参数列表遍历比较是否是相同数据类型，设置boolean的flag，条件成立则可创建对象
					Class clas = clasz[i];
					if (!clas.isInstance(args[i])) {//等同于instanceof
						isThisConstructor = false;
					}

				}
				if (isThisConstructor) {
					try {
						product = (Product) cons.newInstance(args);
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					continue;
				}
			}
		}

		return (T) product;
	}

}
