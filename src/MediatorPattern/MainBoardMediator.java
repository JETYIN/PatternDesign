package MediatorPattern;

public class MainBoardMediator extends Mediator {

	/** 具体中介者，主要实现负者对各个关联类进行逻辑处理 **/
	// 具体中介者，知道自己管理的各个下属
	private CdColleague cdColleague;// 硬盘
	private CpuCollegue cpuCollegue;// cpu
	private SoundColleague soundColleague;// 声卡
	private GraphiceColleague graphiceColleague;// 显卡

	@Override
	protected void handwareChange(Colleague c) {
		// TODO Auto-generated method stub
		// 如果硬盘读取了视频资源
		if (c == cdColleague) {
			handleCD((CdColleague) c);
		}
		if (c == cpuCollegue) {
			handleCpu((CpuCollegue) c);
		}
	}

	// 硬盘读取数据资源
	private void handleCD(CdColleague cdColleague) {
		// cpu处理读取到的数据
		cpuCollegue.decodeData(cdColleague.readCd());

	}

	private void handleCpu(CpuCollegue cpuCollegue) {
		// cpu将文件交给声卡、显卡

		soundColleague.soundPlay(cpuCollegue.getSoundData());
		graphiceColleague.voidPlay(cpuCollegue.getVedioData());
	}

	// 注册
	public void setCD(CdColleague cdColleague) {
		this.cdColleague = cdColleague;
	}

	public void setCPU(CpuCollegue cpuCollegue) {
		this.cpuCollegue = cpuCollegue;
	}

	public void setSound(SoundColleague soundColleague) {
		this.soundColleague = soundColleague;

	}

	public void setGraphice(GraphiceColleague graphiceColleague) {
		this.graphiceColleague = graphiceColleague;

	}
}
