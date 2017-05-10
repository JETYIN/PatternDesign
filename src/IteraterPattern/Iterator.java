package IteraterPattern;

public interface Iterator {

	// 迭代器模式---遍历一个容器对象时使用
	// 也叫游标模式
	boolean hasNext();

	Object next();

}
