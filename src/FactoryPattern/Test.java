package FactoryPattern;

public class Test {
public static void main(String[] args) {
	Factory factoy=new ConcreatFactory();
	
	factoy.creatProduct(ProductA.class).show();
	factoy.creatProduct(ProductB.class).show();
}
}
