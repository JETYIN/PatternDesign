package algorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//FIXME 关于ReentrantLock的Condition使用，关于两个线程的通信与交替执行(类似于wait和notify)
public class Test2 {

	public static void main(String[] args) {

		final ReentrantLock lock = new ReentrantLock();
		final Condition condition1 = lock.newCondition();
		final Condition condition2 = lock.newCondition();
		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					lock.lock();
					for (int i = 65; i < 91; i++) {
						System.out.println("----------thread1------- "
								+ (char) i);
						condition2.signal();
						condition1.await();
					}
					condition2.signal();
				} catch (Exception e) {
				} finally {
					lock.unlock();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				try {
					lock.lock();
					for (int i = 0; i < 26; i++) {
						System.out.println("----------thread2------- " + i);
						condition1.signal();
						condition2.await();
					}
					condition1.signal();
				} catch (Exception e) {
				} finally {
					lock.unlock();
				}
			}
		});
		thread1.start();
		thread2.start();

	}
}
