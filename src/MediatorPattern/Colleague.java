package MediatorPattern;

public abstract class Colleague {

	/** ����ͬ�� **/
	// ÿ��ͬ�¶���֪�������н�����˭
	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
}
