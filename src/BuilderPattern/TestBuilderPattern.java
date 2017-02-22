package BuilderPattern;

public class TestBuilderPattern {
	public static void main(String[] args) {
		// 构造器
		Builder builder = new ConcreteBuilder();
		// 实例化director
		Director director = new Director(builder);
		// director中构造器构造product的属性参数
		director.construct("intel 主板", "retina显示器");
		System.out.println(builder.createProduct().mBoard + "+++"
				+ builder.createProduct().mDisplay);
	}
}
