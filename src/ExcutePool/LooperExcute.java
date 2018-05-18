package ExcutePool;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LooperExcute {

	private static LooperExcute instance;
	public Map<String, ScheduledFuture<?>> taskMap = Collections
			.synchronizedMap(new HashMap<String, ScheduledFuture<?>>());

	private ScheduledFuture<?> payFuture;
	public static LooperExcute getInstance() {

		if (null == instance) {
			synchronized (LooperExcute.class) {
				if (null == instance) {
					instance = new LooperExcute();
					getExecuteServer();
				}

			}
		}
		return instance;
	}

	private static ScheduledExecutorService executeServer;

	// 创建一个固定数量的线程池，定时和周期执行后台任务
	public static synchronized ScheduledExecutorService getExecuteServer() {
		if (null == executeServer) {

			executeServer = Executors.newScheduledThreadPool(10);
		}

		return executeServer;
	}

	//加入任务
	public void show() {
		
		payFuture=executeServer.scheduleWithFixedDelay(new MyRunnale(), 10, 3, TimeUnit.SECONDS);//初始执行1s后开始任务，间隔10s执行
		taskMap.put("key", payFuture);
		
	}

	private class MyRunnale implements Runnable{

		int num=0;
		int target=5;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			num++;
			System.out.println("run");
			if(num==target){
				
				closeTask();
			}
		}
		
	}
	
	public void closeTask() {
		
		if(!taskMap.isEmpty()){
			if(!taskMap.get("key").isDone()){
				
				taskMap.get("key").cancel(true);
			}
			
			
		}
	}

}
