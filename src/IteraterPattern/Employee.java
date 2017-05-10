package IteraterPattern;

public class Employee {

	// 员工实体类
	private String name;
	private int age;
	private String position;

	public Employee(String name, int age, String position) {
		this.name = name;
		this.age = age;
		this.position = position;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new StringBuilder(name).append("" + age).append(position)
				.toString();
	}
}
