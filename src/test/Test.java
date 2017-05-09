package test;

import ChainPattern.Grouper;
import ChainPattern.Manger;
import ModelPattern.AbComputer;
import ModelPattern.CoderComputer;
import ModelPattern.WorkComputer;
import StatePattern.TvContext;
import StatePattern.TvOnStatus;

public class Test {
	public static void main(String[] args) {

		// MyClass.init();
		TvContext.getInstance().setPresentStatus(new TvOnStatus());
		TvContext.getInstance().getTVNext();
		TvContext.getInstance().getTVPre();
		TvContext.getInstance().getTVVolA();
		TvContext.getInstance().getTVVolR();

		/**责任链模式**/
		/*Grouper grouper = new Grouper();
		grouper.dealMeeage(2000);
		Manger manger = new Manger(grouper);*/

		/** 模板模式 --子类可以有多种不同实现，但是抽象父类为其定义的固定方法不变 **/
		AbComputer abComputer = new CoderComputer();
		abComputer.excuet();
		abComputer = new WorkComputer();
		abComputer.excuet();
	}

}
