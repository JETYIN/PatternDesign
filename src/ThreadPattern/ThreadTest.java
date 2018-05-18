package ThreadPattern;

public class ThreadTest {

	private static int s = 0;

	// 此模式采用多线程共享内存的方法
	public static int sum(int n) {
		// 每个线程共享数据s
		s = 0;
		for (int i = 0; i <= n; i++) {
			s += i;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	// 多线程各自运行在自己的内存空间
	public static int sum1(int n) {
		// 关键点，每个线程的单独数据
		int s = 0;
		for (int i = 0; i <= n; i++) {
			s += i;
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	// 多线程共享同一静态内存空间，但是添加同步锁机制

	public synchronized static int sum2(int n) {

		s = 0;
		for (int i = 0; i <= n; i++) {
			s += i;
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;

	}
}
