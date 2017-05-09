package ChainPattern;

public class Grouper extends CompanyLeader {
	private int limit = 1000;
	private CompanyLeader companyLeader;

	@Override
	public void dealMeeage(int money) {
		// TODO Auto-generated method stub
		/** 当前处理者不能处理，往下传递 **/
		if (limit < money) {
			companyLeader.dealMeeage(money);
		} else {
			System.out.println("1");
			System.out.println("处理了");
		}
	}

	public Grouper() {
	}

	public Grouper(CompanyLeader leader) {
		companyLeader = leader;
	}

}
