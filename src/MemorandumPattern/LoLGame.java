package MemorandumPattern;

public class LoLGame {

	/** ����¼ģʽ����Ϸ����������״̬���� **/
	private String roleID;
	private String roleName;
	private String roleBlance;

	public LoLGame(String roleID, String roleName, String roleBlance) {
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleBlance = roleBlance;

	}

	public LoLGame() {
	}

	// ����Ϸ�е�״̬
	public void inGamePlay() {
		System.out.println("����Ϸ��");
	}

	// ��������¼
	public Memoto createMemoto() {
		// ��������¼���浱ǰ��Ϸ��Ϣ
		Memoto memoto = new Memoto();
		memoto.roleID = roleID;
		memoto.roleName = roleName;
		memoto.roleBlance = roleBlance;
		System.out.println("��������¼");
		return memoto;
	}

	// �ָ���Ϸ
	public void restore(Memoto memoto) {
		// �ָ���Ϸ��״̬�����е���Ϣ��ȡ��ȥ
		this.roleID = memoto.roleID;
		this.roleName = memoto.roleName;
		this.roleBlance = memoto.roleBlance;
		System.out.println("�ָ���Ϸ");

	}

	public void quite() {
		System.out.println("�˳���Ϸ");
	}
}
