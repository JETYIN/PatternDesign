package test;

public class Final {

	public static void main(String[] args) {
		new Funcell().show();
		System.out.println("flag:" + Funcell.flag + ",number:" + Funcell.number
				+ ",student:" + Funcell.stu.name);
		Funcell.flag = false;
		Funcell.number = 2;
		Funcell.stu = new Student(2, "two");
		System.out.println("flag:" + Funcell.flag + ",number:" + Funcell.number
				+ ",student:" + Funcell.stu.name);
		Funcell.flag = true;
		Funcell.number = 3;
		Funcell.stu = new Student(2, "three");
		System.out.println("flag:" + Funcell.flag + ",number:" + Funcell.number
				+ ",student:" + Funcell.stu.name);
		Funcell.flag = false;
		Funcell.number = 2;
		Funcell.stu = new Student(2, "four");
		System.out.println("flag:" + Funcell.flag + ",number:" + Funcell.number
				+ ",student:" + Funcell.stu.name);
	}
}
