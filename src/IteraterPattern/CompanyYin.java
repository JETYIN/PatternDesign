package IteraterPattern;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.OMGVMCID;

public class CompanyYin<T> implements CompanyIterator<T> {
	private List<Employee> list = new ArrayList<Employee>();

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new YinIterator(list);
	}

	// 构造数据
	public CompanyYin() {
		list.add(new Employee("name1", 18, "code1"));
		list.add(new Employee("name2", 18, "code2"));
		list.add(new Employee("name3", 18, "code3"));
		list.add(new Employee("name4", 18, "code4"));
		list.add(new Employee("name5", 18, "code5"));
		list.add(new Employee("name6", 18, "code6"));
		list.add(new Employee("name7", 18, "code7"));
		list.add(new Employee("name8", 18, "code8"));
		list.add(new Employee("name9", 18, "code9"));
		list.add(new Employee("name10", 18, "code10"));
	}

	public List<Employee> getEmployee() {
		return list;
	}

	@Override
	public void add(T obj) {
		// TODO Auto-generated method stub
		list.add((Employee) obj);
	}

	@Override
	public void delete(T obj) {
		// TODO Auto-generated method stub
		list.remove(obj);
	}

	
}
