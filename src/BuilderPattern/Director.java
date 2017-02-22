package BuilderPattern;

//director,builder�е�ͬһ��װ����
public class Director {

	Builder mBuilder = null;

	// ���췽��ʵ����builder
	public Director(Builder builder) {
		mBuilder = builder;
	}

	// ���й������
	public void construct(String board, String display) {
		mBuilder.buildBoard(board);
		mBuilder.buildDisplay(display);
		mBuilder.buildOS();
	}

}
