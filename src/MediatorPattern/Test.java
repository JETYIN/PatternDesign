package MediatorPattern;

public class Test {

	public static void main(String[] args) {
		// 创建主板对象--具体中介者
		MainBoardMediator mainBoardMediator = new MainBoardMediator();

		// 各个成员都应该知道自己的中介者是谁
		CdColleague cdColleague = new CdColleague(mainBoardMediator);
		CpuCollegue cpuCollegue = new CpuCollegue(mainBoardMediator);
		SoundColleague soundColleague = new SoundColleague(mainBoardMediator);
		GraphiceColleague graphiceColleague = new GraphiceColleague(
				mainBoardMediator);

		// 将各个成员注册到中介者
		mainBoardMediator.setCD(cdColleague);
		mainBoardMediator.setCPU(cpuCollegue);
		mainBoardMediator.setGraphice(graphiceColleague);
		mainBoardMediator.setSound(soundColleague);

		// 从硬盘读取文件
		cdColleague.cdLoad();
	}
}
