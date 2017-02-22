package BuilderPattern;

/** Builder的具体实现类 **/
public class ConcreteBuilder extends Builder {
	//向上转型
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
