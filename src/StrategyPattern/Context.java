package StrategyPattern;

public class Context {

	// �����ı��ֳ���ӿ�����
	private ItravelAbstract strategy;

	public Context(ItravelAbstract act) {
		this.strategy = act;
	}

	// ���Է�������

	public void trvals() {
		strategy.showTavel();
	}

	// TODO ����ʹ�÷�������һ�����Դ�������
}
