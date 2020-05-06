package StrategyPattern;

public class Context {

	// 上下文保持抽象接口引用
	private ItravelAbstract strategy;

	public Context(ItravelAbstract act) {
		this.strategy = act;
	}

	// 策略方法调用

	public void trvals() {
		strategy.showTavel();
	}

	// TODO 可以使用泛型生成一个策略创建工厂
}
