package FactoryPattern;

public class Test {
	public static void main(String[] args) {
		Factory factoy = new ConcreatFactory();

		factoy.creatProduct(ProductA.class, "this is new").show();
		factoy.creatProduct(ProductB.class).show();

		// ��֤
		P1 p = new P1();
		show(p);

	}

	//�˴����õĳ�ʼֵΪlong 8�ֽ�64λ����32λ�ĵ����ϻش�ӡ��error��64λ�򲻻ᣬ
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
