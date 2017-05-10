package MediatorPattern;

public class CpuCollegue extends Colleague {

	/** 从硬盘读取视频文件，读取后注册告诉中介者读取完毕，中介者通知cpu进行视频，音频解码，解码完毕通知中介者完成，中介者通着声卡和显卡进行播放 **/
	// 视频数据、音频数据
	private String dataSound, dataVideo;

	/** cpu同事 **/
	public CpuCollegue(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	// 获取音频数据
	public String getSoundData() {
		return dataSound;

	}

	// 获取视频数据
	public String getVedioData() {
		return dataVideo;
	}

	/** 将从硬盘中读取的视频文件进行解码，然后通过中介者告诉声卡、显卡进行播放 **/

	public void decodeData(String data) {
		// 此处的data是硬盘中读取到的数据告诉中介者后，中介者传入的数据

		String temp[] = data.split(",");
		// 获取视频数据
		dataVideo = temp[0];
		// 获取音频数据
		dataSound = temp[1];
		// 中介者传入的数据解析结束后通知中介者完成任务，中介者再将任务进行分发
		mediator.handwareChange(this);
	}
}
