package SigleTonPattern;

import java.lang.ref.WeakReference;

public class WeakSigle {
	// ����weakreference�ķ�ʽ
	private static WeakReference<WeakSigle> weakReference = null;

	private WeakSigle() {
	}

	/**����������**/
	public static synchronized WeakSigle getinstance(){
		if(null!=weakReference&&null!=weakReference.get()){
			return weakReference.get();
			
		}
		WeakSigle weakSigle=new WeakSigle();
		weakReference=new WeakReference<WeakSigle>(weakSigle);
		return weakSigle;
		
	}
}
