package MediatorPattern;

public class CdColleague extends Colleague {
	/** ������Ӳ���е���Ƶ����ȡ�󱻲��� **/
	private String data;

	/** cdͬ�� **/
	public CdColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public String readCd() {
		return data;
	}

	/** Ӳ��ͬ�� **/
	public void cdLoad() {
		data="��Ƶ����(�Կ�ͬ��),��Ƶ����(����ͬ��)";
		//��Ӳ���϶�ȡ����Ƶ���ݺ�����н��ߣ����н���ָ���������Կ�ͬ�½�����Ƶ�Ĳ��Ų���
		mediator.handwareChange(this);
	}
}
