package IteraterPattern;

public class Test {

	public static void main(String[] args) {
		/** ������ģʽ **/
		CompanyYin companyYin = new CompanyYin();
		yinShow(companyYin.iterator());
	}
	/** ������ģʽ **/
	public static void yinShow(Iterator it) {
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}
}
