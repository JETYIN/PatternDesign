package FactoryPattern;

public abstract class Factory {

	//��������,�����Ӧ���������������Ķ���
	public abstract <T extends Product> T creatProduct(Class<T> cla);
}
