package MemorandumPattern;

public class LoLGame {

	/** 备忘录模式，游戏读档，程序状态设置 **/
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

	// 在游戏中的状态
	public void inGamePlay() {
		System.out.println("在游戏中");
	}

	// 创建备忘录
	public Memoto createMemoto() {
		// 创建备忘录保存当前游戏信息
		Memoto memoto = new Memoto();
		memoto.roleID = roleID;
		memoto.roleName = roleName;
		memoto.roleBlance = roleBlance;
		System.out.println("创建备忘录");
		return memoto;
	}

	// 恢复游戏
	public void restore(Memoto memoto) {
		// 恢复游戏将状态保存中的信息读取进去
		this.roleID = memoto.roleID;
		this.roleName = memoto.roleName;
		this.roleBlance = memoto.roleBlance;
		System.out.println("恢复游戏");

	}

	public void quite() {
		System.out.println("退出游戏");
	}
}
