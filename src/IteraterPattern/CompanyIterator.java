package IteraterPattern;

public interface CompanyIterator <T>{

	// ��ȡ����������
	public Iterator iterator();
	//���һ��Ԫ��
	public void add(T obj);
	//ɾ��һ��Ԫ��
	public void delete(T obj);
}
