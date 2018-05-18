package threadTest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class SchdulerFactory {

	/**
	 * 1.线程A和线程B，线程同时运行，线程输出非同步
	 */
	public static void show1() {

		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				printNumber("A");
			}
		});

		Thread thread_B = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				printNumber("B");
			}
		});
		thread_A.start();
		thread_B.start();
	}

	/**
	 * 2.线程A与线程B，B需要线程A执行结束或是接收到线程A的运行结果值才开始执行线程B自身
	 */
	public static void show2() {
		final Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				printNumber("A");
			}
		});

		Thread thread_B = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("thread B is waiting thread A");// 线程B开始等待线程A执行结束
				try {
					thread_A.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				printNumber("B");
			}
		});
		thread_A.start();
		thread_B.start();

	}

	/**
	 * 3.线程间的交叉运行，如：线程A在打印完1以后开始执行线程B的打印123，然后再回到线程A的打印23,需要notify(),wait()
	 */
	public static void show3() {
		final Object lock = new Object();// 创建对象锁
		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {// 线程A得到锁的先开始打印A
					System.out.println("A 1");
					try {
						lock.wait();// 线程A交出锁的控制权进入等待状态
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("A 2");
					System.out.println("A 3");

				}
			}
		});

		Thread thread_B = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {// 线程B等到锁的控制权进入执行
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					lock.notify();// 执行结束交出锁的控制权唤醒等待的线程，注:只能唤醒一个等待的线程，具体哪个需看系统调度
				}
			}
		});
		thread_A.start();
		thread_B.start();
	}

	/**
	 * 4.4个线程ABCD，D需要等待ABC执行结束后才执行，ABC线程异步运行，不能确保ABC线程顺序执行,CountDownLatch:
	 * 线程中用于计数，(ABC线程运行结束再运行D，不保证ABC同步)
	 */
	public static void show4() {
		int worker = 3;
		final CountDownLatch countDownLatch = new CountDownLatch(worker);// 创建计数线程器
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread D is waiting other thread");
				try {
					countDownLatch.await();// 线程D进入等待状态，当ABC线程执行完毕后countDownLatch计数会变为0
					System.out.println("Thread D is Working continue");// 当同步线程ABC执行完毕会继续执行D线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// 线程ABC同步执行
		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread A is Working");
				countDownLatch.countDown();// 线程A执行计数器减1
			}
		});
		Thread thread_B = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread B is Working");
				countDownLatch.countDown();
			}
		});

		Thread thread_C = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread C is Working");
				countDownLatch.countDown();
			}
		});
		thread_A.start();
		thread_B.start();
		thread_C.start();
	}

	/**
	 * 5.方法4中D线程在ABC线程执行结束后才运行，但此过程不保证ABC线程同时执行，方法5将保证ABC线程同步执行,
	 * 既是方法5需要在ABC线程都准备好后才开始执行
	 * 
	 */
	public static void show5() {
		// 现象：在调用start()方法后，线程ABC并不会立即执行，而是等线程内部的准备好后，进行等待其他线程，当所有线程都准备好后会立即执行
		int worker = 3;// 设置需要等待的线程数量为3

		final CyclicBarrier barrier = new CyclicBarrier(worker);

		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long time = new Random().nextInt(10000) + 100;
				try {
					Thread.sleep(time);
					System.out.println("thread_A prepared time:" + time);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println("thtead_A prepared,waitting ohters");
					barrier.await();// 线程自身准备完毕，开始等待其他线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread_A start running");
			}
		});
		Thread thread_B = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long time = new Random().nextInt(10000) + 100;
				try {
					Thread.sleep(time);
					System.out.println("thread_B prepared time:" + time);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println("thtead_B prepared,waitting ohters");
					barrier.await();// 线程自身准备完毕，开始等待其他线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread_B start running");
			}
		});
		Thread thread_C = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long time = new Random().nextInt(10000) + 100;
				try {
					Thread.sleep(time);
					System.out.println("thread_C prepared time:" + time);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println("thtead_C prepared,waitting ohters");
					barrier.await();// 线程自身准备完毕，开始等待其他线程
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("thread_C start running");
			}
		});

		thread_A.start();
		thread_B.start();
		thread_C.start();

	}

	/**
	 * 6.子线程执行耗时操作，将子线程运行结果返回给主线程
	 */
	public static void show6() {
		// 子线程
		Callable<Integer> call = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("callable task start");
				int result = 0;
				for (int i = 0; i < 100; i++) {

					result += i;
				}
				System.out.println("callable task finish,result:" + result);
				return result;
			}
		};
		FutureTask<Integer> task = new FutureTask<Integer>(call);
		new Thread(task).start();
		try {
			System.out.println("Before futureTask.get()");
			System.out.println("Result:" + task.get());// task.get()开始执行此方法时将会阻塞主线程,知道call子线程返回结果
			System.out.println("After futureTask.get()");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printNumber(String threadName) {
		int i = 0;
		while (i < 3) {
			i++;
			System.out.println(threadName + ":" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
