package Builder;

public class Test {

	public static void main(String[] args) {

		MyOkHttp.Builder builder = new MyOkHttp.Builder()
				// �˴�BuilderΪbuilderģʽ�е��ڲ���
				.addWork(false).changeUserAge(100).updateBorn(1990)
				.userNameSetting("china");
		
		MyOkHttp okhttp = builder.builde();

		System.out.println("this is:" + String.valueOf(okhttp.getBorn())
				+ "*****" + "this is:" + String.valueOf(okhttp.getUserAge())
				+ "*****" + "this is:" + okhttp.getUserName());
		show();

	}

	public static void show() {

		/**
		 * String���ַ�����������һ�����壻��s=cctv��s+chinaʵ�����Ǵ�����һ���µ�string
		 * s����ֵ����s,���Ǵ���������s���� ƴ�����ʱ����һ����s���������ö�����յ����������ַ���ƴ�ӣ��ͻᴴ��������󣬶��ڴ������˷�
		 * 
		 * class java.lang.String@3048162 class java.lang.String@1239281589
		 * 
		 **/
		String s = "cctv";
		System.out.println(s.getClass() + "@" + s.hashCode());
		s = s + "china";
		System.out.println(s.getClass() + "@" + s.hashCode());
	}

}
