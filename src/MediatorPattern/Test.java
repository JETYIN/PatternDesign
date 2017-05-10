package MediatorPattern;

public class Test {

	public static void main(String[] args) {
		// �����������--�����н���
		MainBoardMediator mainBoardMediator = new MainBoardMediator();

		// ������Ա��Ӧ��֪���Լ����н�����˭
		CdColleague cdColleague = new CdColleague(mainBoardMediator);
		CpuCollegue cpuCollegue = new CpuCollegue(mainBoardMediator);
		SoundColleague soundColleague = new SoundColleague(mainBoardMediator);
		GraphiceColleague graphiceColleague = new GraphiceColleague(
				mainBoardMediator);

		// ��������Աע�ᵽ�н���
		mainBoardMediator.setCD(cdColleague);
		mainBoardMediator.setCPU(cpuCollegue);
		mainBoardMediator.setGraphice(graphiceColleague);
		mainBoardMediator.setSound(soundColleague);

		// ��Ӳ�̶�ȡ�ļ�
		cdColleague.cdLoad();
	}
}
