package BuilderPattern;

//director,builder中的同一组装过程
public class Director {

	Builder mBuilder = null;

	// 构造方法实例化builder
	public Director(Builder builder) {
		mBuilder = builder;
	}

	// 进行构造对象
	public void construct(String board, String display) {
		mBuilder.buildBoard(board);
		mBuilder.buildDisplay(display);
		mBuilder.buildOS();
	}

}
