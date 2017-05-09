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

		/**������ģʽ**/
		/*Grouper grouper = new Grouper();
		grouper.dealMeeage(2000);
		Manger manger = new Manger(grouper);*/

		/** ģ��ģʽ --��������ж��ֲ�ͬʵ�֣����ǳ�����Ϊ�䶨��Ĺ̶��������� **/
		AbComputer abComputer = new CoderComputer();
		abComputer.excuet();
		abComputer = new WorkComputer();
		abComputer.excuet();
	}

}
