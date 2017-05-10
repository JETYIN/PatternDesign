package MemorandumPattern;

public class CareTaker {
	// careTaker负责管理备忘录

	private Memoto memoto;

	public void archive(Memoto memoto) {
		this.memoto = memoto;
	}

	// 获取存档
	public Memoto getMemoto() {
		return memoto;
	}
}
