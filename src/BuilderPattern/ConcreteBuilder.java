package BuilderPattern;

/** Builder�ľ���ʵ���� **/
public class ConcreteBuilder extends Builder {
	//����ת��
	private Computer computer = new Lenovo();

	@Override
	public void buildBoard(String board) {
		// TODO Auto-generated method stub
		computer.setBoard(board);
	}

	@Override
	public void buildDisplay(String dispaly) {
		// TODO Auto-generated method stub
		computer.setDisplay(dispaly);
	}

	@Override
	public void buildOS() {
		// TODO Auto-generated method stub
		computer.setOS();
		
	}

	@Override
	public Computer createProduct() {
		// TODO Auto-generated method stub
		return computer;
	}

	
}
