package ThreadPattern;

public class ThreadTest {

	private static int s = 0;

	// ��ģʽ���ö��̹߳����ڴ�ķ���
	public static int sum(int n) {
		// ÿ���̹߳�������s
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

	// ���̸߳����������Լ����ڴ�ռ�
	public static int sum1(int n) {
		// �ؼ��㣬ÿ���̵߳ĵ�������
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

	// ���̹߳���ͬһ��̬�ڴ�ռ䣬�������ͬ��������

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
