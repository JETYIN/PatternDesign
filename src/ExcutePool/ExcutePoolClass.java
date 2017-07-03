package ExcutePool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExcutePoolClass {

	// 创建
	private static ExecutorService service;
	private static int poolSize = 10;

	// 创建了一个size为10的线程池
	public static ExecutorService getExecutorService() {
		if (null == service) {
			service = Executors.newFixedThreadPool(poolSize);

		}
		return service;
	}

	// 线程池提交,其可以返回一个Future对象
	public static void submit(Runnable runnable) {
		getExecutorService().submit(runnable);
	}

	//返回一个future对象
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

	// 创建用于执行线程池的线程
	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}
}
