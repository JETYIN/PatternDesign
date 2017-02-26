package SigleTonPattern;

public class DCLSigle {
	/** DOUBLE CHECKLOCK的单例模式，推荐采用，在效率上有比较出色的表现 **/

	private static DCLSigle instance = null;

	private DCLSigle() {
	}

	public static DCLSigle getinstance() {
		if (instance == null) {
			synchronized (DCLSigle.class) {
				if (instance == null) {
					instance = new DCLSigle();
				}

			}
		}
		return instance;
	}
}
