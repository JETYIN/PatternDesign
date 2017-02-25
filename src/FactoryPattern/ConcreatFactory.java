package FactoryPattern;

public class ConcreatFactory extends Factory {

	@Override
	public <T extends Product> T creatProduct(Class<T> cla) {
		// TODO Auto-generated method stub
		Product product=null;
		try {
			product=(Product) Class.forName(cla.getName()).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		return (T) product;
	}

}
