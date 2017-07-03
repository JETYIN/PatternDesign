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

	// �в�
	@Override
	public <T extends Product> T creatProduct(Class<T> cla, Object... args) {
		// TODO Auto-generated method stub
		// 1.��ȡ������������й��췽�� --����3�����췽��
		Product product = null;
		Constructor[] constructor = cla.getConstructors();

		for (Constructor cons : constructor) {
			// 2.������ȡ���Ĺ��췽������ȡÿ�����췽���Ĳ����б��С
			Class clasz[] = cons.getParameterTypes();
			// clasz.length����0��ʾ�вι��캯��
			if (clasz.length > 0) {
				boolean isThisConstructor = true;// �вεĹ��캯�������ɶ��
				for (int i = 0; i < clasz.length; i++) {
					//3.�����캯���Ĳ����б��봫��Ĳ��������б�����Ƚ��Ƿ�����ͬ�������ͣ�����boolean��flag������������ɴ�������
					Class clas = clasz[i];
					if (!clas.isInstance(args[i])) {//��ͬ��instanceof
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
