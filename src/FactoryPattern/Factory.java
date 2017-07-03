package FactoryPattern;

public abstract class Factory {

	//定义生成,传入对应的类名生成相关类的对象
	public abstract <T extends Product> T creatProduct(Class<T> cla);
	//不定构造参数
	public abstract <T extends Product> T creatProduct(Class<T> cla,Object ...args);
}
