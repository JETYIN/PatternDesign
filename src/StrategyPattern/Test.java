package StrategyPattern;

public class Test {

	public static void main(String[] args) {

		// 使用A策略
		new Context(new StrategyConcenA()).trvals();// 当采用A策略时
		new Context(new StrategyConcenB()).trvals();// 当采用B策略时
		new Context(new StrategyConcenC()).trvals();// 当采用C策略时

	}
}
