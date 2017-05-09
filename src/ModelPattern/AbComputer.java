package ModelPattern;

public abstract class AbComputer {

	protected void powerOn() {
		System.out.println("ab-开机了");
	}

	protected void checkHandware() {
		System.out.println("ab-检查硬盘");
	}

	protected void loadOs() {
		System.out.println("ab-加载系统");
	}

	protected void login() {
		System.out.println("ab-登录");
	}

	/**定义模板模式**/
	public final void excuet() {
		powerOn();
		checkHandware();
		loadOs();
		login();
	}
}
