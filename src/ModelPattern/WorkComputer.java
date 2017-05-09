package ModelPattern;

public class WorkComputer extends AbComputer{

	@Override
	protected void checkHandware() {
		// TODO Auto-generated method stub
		System.out.println("work-工作站查盘方式");
	}
	@Override
	protected void login() {
		// TODO Auto-generated method stub
		System.out.println("work-工作站高级身份认证");
	}
}
