package MediatorPattern;

public class CdColleague extends Colleague {
	/** 定义在硬盘中的视频被读取后被播放 **/
	private String data;

	/** cd同事 **/
	public CdColleague(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	public String readCd() {
		return data;
	}

	/** 硬盘同事 **/
	public void cdLoad() {
		data="视频数据(显卡同事),音频数据(声卡同事)";
		//从硬盘上读取到视频数据后告诉中介者，让中介者指挥声卡、显卡同事进行视频的播放操作
		mediator.handwareChange(this);
	}
}
