package ThreadPattern;

public class Test {

	public static void main(String[] args) {
		// init1();
		// init2();
		init3();
	}

	// 1.多个线程共享一块内存区域-不加保护
	private static void init1() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();
	}

	// 2.不使用共享内存，每个线程空间独立，单独独立
	private static void init2() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();

	}

	// 3.添加线程同步机制
	private static void init3() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();

	}

}
