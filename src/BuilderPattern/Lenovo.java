package BuilderPattern;

//product类继承自compter
public class Lenovo extends Computer {
	/** 实现抽象方法为未实现的设置电脑操作系统的方法 **/
	public Lenovo() {
	}

	@Override
	public void setOS() {
		// TODO Auto-generated method stub
		mOS="windows update 7";
	}

}
