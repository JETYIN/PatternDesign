package ObserverPattern;

import java.util.Observable;

public class News extends Observable {

	public void publishNews(String mes) {
		//标识状态内容发生改变
		setChanged();
		//通知观察者
		notifyObservers(mes);
	}
}
