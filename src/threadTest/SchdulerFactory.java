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
	 * 1.�߳�A���߳�B���߳�ͬʱ���У��߳������ͬ��
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
	 * 2.�߳�A���߳�B��B��Ҫ�߳�Aִ�н������ǽ��յ��߳�A�����н��ֵ�ſ�ʼִ���߳�B����
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
				System.out.println("thread B is waiting thread A");// �߳�B��ʼ�ȴ��߳�Aִ�н���
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
	 * 3.�̼߳�Ľ������У��磺�߳�A�ڴ�ӡ��1�Ժ�ʼִ���߳�B�Ĵ�ӡ123��Ȼ���ٻص��߳�A�Ĵ�ӡ23,��Ҫnotify(),wait()
	 */
	public static void show3() {
		final Object lock = new Object();// ����������
		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (lock) {// �߳�A�õ������ȿ�ʼ��ӡA
					System.out.println("A 1");
					try {
						lock.wait();// �߳�A�������Ŀ���Ȩ����ȴ�״̬
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
				synchronized (lock) {// �߳�B�ȵ����Ŀ���Ȩ����ִ��
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					lock.notify();// ִ�н����������Ŀ���Ȩ���ѵȴ����̣߳�ע:ֻ�ܻ���һ���ȴ����̣߳������ĸ��迴ϵͳ����
				}
			}
		});
		thread_A.start();
		thread_B.start();
	}

	/**
	 * 4.4���߳�ABCD��D��Ҫ�ȴ�ABCִ�н������ִ�У�ABC�߳��첽���У�����ȷ��ABC�߳�˳��ִ��,CountDownLatch:
	 * �߳������ڼ�����(ABC�߳����н���������D������֤ABCͬ��)
	 */
	public static void show4() {
		int worker = 3;
		final CountDownLatch countDownLatch = new CountDownLatch(worker);// ���������߳���
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread D is waiting other thread");
				try {
					countDownLatch.await();// �߳�D����ȴ�״̬����ABC�߳�ִ����Ϻ�countDownLatch�������Ϊ0
					System.out.println("Thread D is Working continue");// ��ͬ���߳�ABCִ����ϻ����ִ��D�߳�
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// �߳�ABCͬ��ִ��
		Thread thread_A = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Thread A is Working");
				countDownLatch.countDown();// �߳�Aִ�м�������1
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
	 * 5.����4��D�߳���ABC�߳�ִ�н���������У����˹��̲���֤ABC�߳�ͬʱִ�У�����5����֤ABC�߳�ͬ��ִ��,
	 * ���Ƿ���5��Ҫ��ABC�̶߳�׼���ú�ſ�ʼִ��
	 * 
	 */
	public static void show5() {
		// �����ڵ���start()�������߳�ABC����������ִ�У����ǵ��߳��ڲ���׼���ú󣬽��еȴ������̣߳��������̶߳�׼���ú������ִ��
		int worker = 3;// ������Ҫ�ȴ����߳�����Ϊ3

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
					barrier.await();// �߳�����׼����ϣ���ʼ�ȴ������߳�
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
					barrier.await();// �߳�����׼����ϣ���ʼ�ȴ������߳�
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
					barrier.await();// �߳�����׼����ϣ���ʼ�ȴ������߳�
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
	 * 6.���߳�ִ�к�ʱ�����������߳����н�����ظ����߳�
	 */
	public static void show6() {
		// ���߳�
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
			System.out.println("Result:" + task.get());// task.get()��ʼִ�д˷���ʱ�����������߳�,֪��call���̷߳��ؽ��
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
