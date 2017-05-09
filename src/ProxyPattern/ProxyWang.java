package ProxyPattern;

public class ProxyWang implements ILawFolw {
	/** ��ǰ�Ĵ����࣬����ʵ�ֶ��һ�Ĺ�ϵ **/
	/** ����ʵ���˽ӿڵ����ж��� **/

	private ILawFolw lawFolwImp;

	public ProxyWang(ILawFolw iLawFolw) {
		this.lawFolwImp = iLawFolw;
	}

	@Override
	public void requestCourse() {
		// TODO Auto-generated method stub
		lawFolwImp.requestCourse();
	}

	@Override
	public void requestLaw() {
		// TODO Auto-generated method stub
		lawFolwImp.requestLaw();
	}

	@Override
	public void requestLawyer() {
		// TODO Auto-generated method stub
		lawFolwImp.requestLawyer();
	}

	@Override
	public void requestNews() {
		// TODO Auto-generated method stub
		lawFolwImp.requestNews();
	}

}
