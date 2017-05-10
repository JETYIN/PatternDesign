package IteraterPattern;

public class Test {

	public static void main(String[] args) {
		/** 迭代器模式 **/
		CompanyYin companyYin = new CompanyYin();
		yinShow(companyYin.iterator());
	}
	/** 迭代器模式 **/
	public static void yinShow(Iterator it) {
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}

	}
}
