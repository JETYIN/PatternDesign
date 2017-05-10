package IteraterPattern;

import java.util.ArrayList;
import java.util.List;

public class YinIterator implements Iterator {

	private List<Employee> list;
	// �����е�λ�ã��±�
	private int position;

	public YinIterator(List list) {
		this.list = list;
	}

	// �Ƿ�����һ��������list�±����
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !(position > list.size() - 1 || list.get(position) == null);
	}

	// ������һ������
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Employee employee=list.get(position);
		position++;
		return employee;
	}

}
