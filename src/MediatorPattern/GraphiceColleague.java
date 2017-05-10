package MediatorPattern;

public class GraphiceColleague extends Colleague {

	/** 显卡同事 **/
	public GraphiceColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public void voidPlay(String data) {
		System.out.println("显卡同事:" + data);
	}
}
