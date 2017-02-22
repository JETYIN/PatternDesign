package BuilderPattern;

/** 在android bulder模式中的product（抽象类-扩展） **/
public abstract class Computer {
	// 主板
	protected String mBoard;
	// 操作系统
	protected String mOS;
	// 显示器
	protected String mDisplay;

	protected Computer() {
	}

	// 设置主板信息
	public void setBoard(String board) {
		mBoard = board;
	}

	// 设置显示器信息
	public void setDisplay(String display) {
		mDisplay = display;
	}

	// 设置操作系统信息-抽象方法
	public abstract void setOS() ;
	
	public String toString(){
		return "computer";
	}

}
