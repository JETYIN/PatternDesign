package ExcutePool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutePoolClass {

	// ����
	private static ExecutorService service;
	private static int poolSize = 10;

	// ������һ��sizeΪ10���̳߳�
	public static ExecutorService getExecutorService() {
		if (null == service) {
			service = Executors.newFixedThreadPool(poolSize);

		}
		return service;
	}

	// �̳߳��ύ,����Է���һ��Future����
	public static void submit(Runnable runnable) {
		getExecutorService().submit(runnable);
	}

	//����һ��future����
	public static Future<?> submit(Callable<?> call) {
		return getExecutorService().submit(call);
	}

	public static void shutdown() {
		if (!isShutdown()) {
			getExecutorService().shutdown();
		}

	}

	public static void shutdownNow() {
		if (!isShutdown()) {
			getExecutorService().shutdownNow();
		}
	}

	public static boolean isShutdown() {
		return getExecutorService().isShutdown();
	}

	// ��������ִ���̳߳ص��߳�
	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}
}
