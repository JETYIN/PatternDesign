package MediatorPattern;

public class GraphiceColleague extends Colleague {

	/** �Կ�ͬ�� **/
	public GraphiceColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void voidPlay(String data) {
		System.out.println("�Կ�ͬ��:" + data);
	}
}
