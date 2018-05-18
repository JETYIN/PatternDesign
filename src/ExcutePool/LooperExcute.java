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

	// ����һ���̶��������̳߳أ���ʱ������ִ�к�̨����
	public static synchronized ScheduledExecutorService getExecuteServer() {
		if (null == executeServer) {

			executeServer = Executors.newScheduledThreadPool(10);
		}

		return executeServer;
	}

	//��������
	public void show() {
		
		payFuture=executeServer.scheduleWithFixedDelay(new MyRunnale(), 10, 3, TimeUnit.SECONDS);//��ʼִ��1s��ʼ���񣬼��10sִ��
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
