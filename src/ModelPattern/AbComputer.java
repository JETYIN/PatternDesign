package ModelPattern;

public abstract class AbComputer {

	protected void powerOn() {
		System.out.println("ab-������");
	}

	protected void checkHandware() {
		System.out.println("ab-���Ӳ��");
	}

	protected void loadOs() {
		System.out.println("ab-����ϵͳ");
	}

	protected void login() {
		System.out.println("ab-��¼");
	}

	/**����ģ��ģʽ**/
	public final void excuet() {
		powerOn();
		checkHandware();
		loadOs();
		login();
	}
}
