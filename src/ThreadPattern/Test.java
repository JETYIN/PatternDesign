package ThreadPattern;

public class Test {

	public static void main(String[] args) {
		// init1();
		// init2();
		init3();
	}

	// 1.����̹߳���һ���ڴ�����-���ӱ���
	private static void init1() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();
	}

	// 2.��ʹ�ù����ڴ棬ÿ���߳̿ռ��������������
	private static void init2() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();

	}

	// 3.����߳�ͬ������
	private static void init3() {
		MyThread t1 = new MyThread();
		new Thread(t1).start();

		MyThread t2 = new MyThread();
		new Thread(t2).start();

		MyThread t3 = new MyThread();
		new Thread(t3).start();

	}

}
