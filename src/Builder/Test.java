package Builder;

public class Test {

	public static void main(String[] args) {

		MyOkHttp.Builder builder = new MyOkHttp.Builder()
				// 此处Builder为builder模式中的内部类
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
		 * String是字符常量，当第一步定义；额s=cctv后，s+china实际上是创建了一个新的string
		 * s并将值赋予s,既是创建了两个s，当 拼接完成时，第一步的s被当做无用对象回收掉，如果多个字符串拼接，就会创建多个对象，对内存是中浪费
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
