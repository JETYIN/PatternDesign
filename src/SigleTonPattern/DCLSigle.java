package SigleTonPattern;

public class DCLSigle {
	/** DOUBLE CHECKLOCK�ĵ���ģʽ���Ƽ����ã���Ч�����бȽϳ�ɫ�ı��� **/

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
