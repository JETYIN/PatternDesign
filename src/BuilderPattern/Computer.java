package BuilderPattern;

/** ��android bulderģʽ�е�product��������-��չ�� **/
public abstract class Computer {
	// ����
	protected String mBoard;
	// ����ϵͳ
	protected String mOS;
	// ��ʾ��
	protected String mDisplay;

	protected Computer() {
	}

	// ����������Ϣ
	public void setBoard(String board) {
		mBoard = board;
	}

	// ������ʾ����Ϣ
	public void setDisplay(String display) {
		mDisplay = display;
	}

	// ���ò���ϵͳ��Ϣ-���󷽷�
	public abstract void setOS() ;
	
	public String toString(){
		return "computer";
	}

}
