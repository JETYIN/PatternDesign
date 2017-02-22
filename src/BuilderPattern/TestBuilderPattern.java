package BuilderPattern;

public class TestBuilderPattern {
	public static void main(String[] args) {
		// ������
		Builder builder = new ConcreteBuilder();
		// ʵ����director
		Director director = new Director(builder);
		// director�й���������product�����Բ���
		director.construct("intel ����", "retina��ʾ��");
		System.out.println(builder.createProduct().mBoard + "+++"
				+ builder.createProduct().mDisplay);
	}
}
