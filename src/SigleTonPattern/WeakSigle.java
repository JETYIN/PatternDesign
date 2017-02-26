package SigleTonPattern;

import java.lang.ref.WeakReference;

public class WeakSigle {
	// 采用weakreference的方式
	private static WeakReference<WeakSigle> weakReference = null;

	private WeakSigle() {
	}

	/**创建若引用**/
	public static synchronized WeakSigle getinstance(){
		if(null!=weakReference&&null!=weakReference.get()){
			return weakReference.get();
			
		}
		WeakSigle weakSigle=new WeakSigle();
		weakReference=new WeakReference<WeakSigle>(weakSigle);
		return weakSigle;
		
	}
}
