package ObserverPattern;

import java.util.Observable;
import java.util.Observer;

public class ObserCoder implements Observer {
	/** �������ԱΪ�۲��� **/
	private String name;

	public ObserCoder(String name) {
		this.name = name;

	}

	@Override
	public void update(Observable o, Object mes) {
		// TODO Auto-generated method stub
		System.out.println(name + "��ǰ�����ĵ������ˣ�������:" + mes);
	}

}
