package ObserverPattern;

import java.util.Observable;

public class News extends Observable {

	public void publishNews(String mes) {
		//��ʶ״̬���ݷ����ı�
		setChanged();
		//֪ͨ�۲���
		notifyObservers(mes);
	}
}
