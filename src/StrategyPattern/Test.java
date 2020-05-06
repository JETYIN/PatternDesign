package StrategyPattern;

public class Test {

	public static void main(String[] args) {

		// 使用A策略
		// TODO，这种方式将策略的创建放在了客户端来处理，不是一个最佳的处理方式，建议直接放置到Context，策略工厂中进行处理
		new Context(new StrategyConcenA()).trvals();// 当采用A策略时
		new Context(new StrategyConcenB()).trvals();// 当采用B策略时
		new Context(new StrategyConcenC()).trvals();// 当采用C策略时

	}
}
