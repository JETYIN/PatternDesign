package StrategyPattern;

public class Test {

	public static void main(String[] args) {

		// ʹ��A����
		// TODO�����ַ�ʽ�����ԵĴ��������˿ͻ�������������һ����ѵĴ���ʽ������ֱ�ӷ��õ�Context�����Թ����н��д���
		new Context(new StrategyConcenA()).trvals();// ������A����ʱ
		new Context(new StrategyConcenB()).trvals();// ������B����ʱ
		new Context(new StrategyConcenC()).trvals();// ������C����ʱ

	}
}
