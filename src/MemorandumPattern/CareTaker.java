package MemorandumPattern;

public class CareTaker {
	// careTaker���������¼

	private Memoto memoto;

	public void archive(Memoto memoto) {
		this.memoto = memoto;
	}

	// ��ȡ�浵
	public Memoto getMemoto() {
		return memoto;
	}
}
