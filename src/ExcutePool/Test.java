package ExcutePool;

public class Test {

	public static void main(String[] args) {

		LooperExcute.getInstance().show();
		show();
	}

	private static void show() {
		String qq = "qq:1324564";

		String str[] = qq.split(":");
		System.out.println(str[1]);
		System.out.println(Integer.valueOf("1"));
	}
}
