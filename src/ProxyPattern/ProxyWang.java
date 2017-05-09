package ProxyPattern;

public class ProxyWang implements ILawFolw {
	/** 当前的代理类，可以实现多对一的关系 **/
	/** 代理实现了接口的所有对象 **/

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
