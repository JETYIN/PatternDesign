package ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class ObserCoder implements Observer {
	/** 定义程序员为观察者 **/
	private String name;

	public ObserCoder(String name) {
		this.name = name;

	}

	@Override
	public void update(Observable o, Object mes) {
		// TODO Auto-generated method stub
		System.out.println(name + "当前技术文档更新了，内容是:" + mes);
	}

}
