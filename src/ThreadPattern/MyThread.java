package ThreadPattern;

import java.util.concurrent.Executors;

public class MyThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + ":"
					+ ThreadTest.sum2(100));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
