package MediatorPattern;

public class CpuCollegue extends Colleague {

	/** ��Ӳ�̶�ȡ��Ƶ�ļ�����ȡ��ע������н��߶�ȡ��ϣ��н���֪ͨcpu������Ƶ����Ƶ���룬�������֪ͨ�н�����ɣ��н���ͨ���������Կ����в��� **/
	// ��Ƶ���ݡ���Ƶ����
	private String dataSound, dataVideo;

	/** cpuͬ�� **/
	public CpuCollegue(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	// ��ȡ��Ƶ����
	public String getSoundData() {
		return dataSound;

	}

	// ��ȡ��Ƶ����
	public String getVedioData() {
		return dataVideo;
	}

	/** ����Ӳ���ж�ȡ����Ƶ�ļ����н��룬Ȼ��ͨ���н��߸����������Կ����в��� **/

	public void decodeData(String data) {
		// �˴���data��Ӳ���ж�ȡ�������ݸ����н��ߺ��н��ߴ��������

		String temp[] = data.split(",");
		// ��ȡ��Ƶ����
		dataVideo = temp[0];
		// ��ȡ��Ƶ����
		dataSound = temp[1];
		// �н��ߴ�������ݽ���������֪ͨ�н�����������н����ٽ�������зַ�
		mediator.handwareChange(this);
	}
}
