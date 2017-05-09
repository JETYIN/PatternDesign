package ChainPattern;

public class Manger extends CompanyLeader {
	private int limit = 50000;
	private CompanyLeader companyLeader;

	@Override
	public void dealMeeage(int money) {
		// TODO Auto-generated method stub
		if (limit < money) {
			companyLeader.dealMeeage(money);
		} else {
			System.out.println("2");
			System.out.println("´¦ÀíÁË");
		}
	}

	public Manger(CompanyLeader leader) {
		companyLeader = leader;
	}
}
