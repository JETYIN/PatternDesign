package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Floder {
	//͸�������ģʽ
	/** ��ǰģʽΪ���ģʽ--����ģ��Ϊ�ļ���-�ļ� **/

	List<Floder> floderList = new ArrayList<Floder>();
	private String name;

	public Floder(String name) {
		this.name = name;
	}

	// ����ļ�--�����������
	protected abstract void addFile(Floder floder);

	// ɾ���ļ�
	protected abstract void removeFile(Floder floder);

	// ɾ�������ļ�
	protected abstract void clearAllFile();

	// ��������ļ�
	protected abstract void printAllFile();

	// ��ȡ�ļ��������е��ļ������ļ�
	protected abstract List<Floder> getAllFolderlist();

	protected String getFloderName() {
		return name;
	}
}
