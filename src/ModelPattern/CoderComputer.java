package ModelPattern;

public class CoderComputer extends AbComputer{
	
	@Override
	protected void checkHandware() {
		// TODO Auto-generated method stub
		System.out.println("coder-普通查盘方式");
	}

	@Override
	protected void login() {
		// TODO Auto-generated method stub
		System.out.println("coder-普通账户密码登录");
	}
}
