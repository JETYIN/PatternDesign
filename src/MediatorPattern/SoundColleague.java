package MediatorPattern;

public class SoundColleague extends Colleague {

	public SoundColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	/** ����ͬ�� **/

	/** ����ͬ�´���������Ϣ **/
	public void soundPlay(String data) {
		System.out.println("����ͬ��:" + data);
	}
}
