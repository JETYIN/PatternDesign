package MediatorPattern;

public class SoundColleague extends Colleague {

	public SoundColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	/** 声卡同事 **/

	/** 声卡同事处理声音信息 **/
	public void soundPlay(String data) {
		System.out.println("声卡同事:" + data);
	}
}
