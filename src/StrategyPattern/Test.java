package StrategyPattern;

public class Test {

	public static void main(String[] args) {

		// ʹ��A����
		new Context(new StrategyConcenA()).trvals();// ������A����ʱ
		new Context(new StrategyConcenB()).trvals();// ������B����ʱ
		new Context(new StrategyConcenC()).trvals();// ������C����ʱ

	}
}
