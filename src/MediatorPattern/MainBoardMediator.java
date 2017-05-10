package MediatorPattern;

public class MainBoardMediator extends Mediator {

	/** �����н��ߣ���Ҫʵ�ָ��߶Ը�������������߼����� **/
	// �����н��ߣ�֪���Լ�����ĸ�������
	private CdColleague cdColleague;// Ӳ��
	private CpuCollegue cpuCollegue;// cpu
	private SoundColleague soundColleague;// ����
	private GraphiceColleague graphiceColleague;// �Կ�

	@Override
	protected void handwareChange(Colleague c) {
		// TODO Auto-generated method stub
		// ���Ӳ�̶�ȡ����Ƶ��Դ
		if (c == cdColleague) {
			handleCD((CdColleague) c);
		}
		if (c == cpuCollegue) {
			handleCpu((CpuCollegue) c);
		}
	}

	// Ӳ�̶�ȡ������Դ
	private void handleCD(CdColleague cdColleague) {
		// cpu�����ȡ��������
		cpuCollegue.decodeData(cdColleague.readCd());

	}

	private void handleCpu(CpuCollegue cpuCollegue) {
		// cpu���ļ������������Կ�

		soundColleague.soundPlay(cpuCollegue.getSoundData());
		graphiceColleague.voidPlay(cpuCollegue.getVedioData());
	}

	// ע��
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
