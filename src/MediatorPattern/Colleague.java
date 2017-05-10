package MediatorPattern;

public abstract class Colleague {

	/** 抽象同事 **/
	// 每个同事都该知道他的中介者是谁
	protected Mediator mediator;

	public Colleague(Mediator mediator) {
		this.mediator = mediator;
	}
}
