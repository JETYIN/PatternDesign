package FactoryPattern;

public class Test {
	public static void main(String[] args) {
		Factory factoy = new ConcreatFactory();

		factoy.creatProduct(ProductA.class, "this is new").show();
		factoy.creatProduct(ProductB.class).show();

		// 验证
		P1 p = new P1();
		show(p);

	}

	//此处设置的初始值为long 8字节64位，在32位的电脑上回打印出error，64位则不会，
	public static void show(final P1 p) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					p.set1();
				}
			}
		}).start();

		//
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (true) {
					p.set2();

				}
			}
		}).start();

		//
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				while(true){
					
					p.check();
				}
			}
		}).start();
	}
}
