package FactoryPattern;

public class ProductA extends Product {

	private String message;

	public ProductA(String message) {
		this.message = message;
	}

	@Override
	protected void show() {
		// TODO Auto-generated method stub
		System.out.println("message:" + message);
	}

}
