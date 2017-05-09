package StatePattern;

public class TvOnStatus implements ITVChoice{

	@Override
	public void addVol() {
		// TODO Auto-generated method stub
		System.out.println("增加音量");
	}

	@Override
	public void nextChannel() {
		// TODO Auto-generated method stub
		System.out.println("下一个台");
	}

	@Override
	public void preChanner() {
		// TODO Auto-generated method stub
		System.out.println("上一个台");
	}

	@Override
	public void reduceVol() {
		// TODO Auto-generated method stub
		System.out.println("减少音量");
	}

}
