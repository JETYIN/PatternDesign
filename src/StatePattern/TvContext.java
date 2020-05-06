package StatePattern;

public class TvContext {
	private ITVChoice tvStatus = new TvOffStatus();

	private TvContext() {
	}

	private volatile static TvContext instance;

	public static TvContext getInstance() {
		if (instance == null) {
			synchronized (TvContext.class) {
				if (instance == null) {
					instance = new TvContext();
				}

			}
		}
		return instance;
	}

	public void setPresentStatus(ITVChoice status) {
		this.tvStatus = status;
	}

	public void getTVNext() {
		tvStatus.nextChannel();
	}

	public void getTVPre() {
		tvStatus.preChanner();
	}

	public void getTVVolA() {
		tvStatus.addVol();
	}

	public void getTVVolR() {
		tvStatus.reduceVol();
	}

}
