package IteraterPattern;

public interface CompanyIterator <T>{

	// 获取迭代器对象
	public Iterator iterator();
	//添加一个元素
	public void add(T obj);
	//删除一个元素
	public void delete(T obj);
}
