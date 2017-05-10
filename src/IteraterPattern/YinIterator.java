package IteraterPattern;

import java.util.ArrayList;
import java.util.List;

public class YinIterator implements Iterator {

	private List<Employee> list;
	// 容器中的位置，下标
	private int position;

	public YinIterator(List list) {
		this.list = list;
	}

	// 是否还有下一个，根据list下表决定
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !(position > list.size() - 1 || list.get(position) == null);
	}

	// 返回下一个对象
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Employee employee=list.get(position);
		position++;
		return employee;
	}

}
