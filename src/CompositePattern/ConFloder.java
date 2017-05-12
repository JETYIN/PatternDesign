package CompositePattern;

import java.util.Iterator;
import java.util.List;

public class ConFloder extends Floder {

	//�ļ�����
	public ConFloder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addFile(Floder floder) {
		// TODO Auto-generated method stub
		floderList.add(floder);
	}

	@Override
	protected void clearAllFile() {
		// TODO Auto-generated method stub
		floderList.clear();
	}

	@Override
	protected List<Floder> getAllFolderlist() {
		// TODO Auto-generated method stub
		return floderList;
	}

	@Override
	protected void printAllFile() {
		// TODO Auto-generated method stub
		Iterator<Floder> it = floderList.iterator();
		System.out.print(getFloderName() + "(");
		while (it.hasNext()) {
			Floder floder = it.next();
			// �����ļ���--������滹���ļ��У�������ļ��е��������
			floder.printAllFile();
			// ���д�ֻ��Ϊ�������ӡ
			if (it.hasNext()) {
				System.out.print(",");
			}
		}
		System.out.print(")");
	}

	@Override
	protected void removeFile(Floder floder) {
		// TODO Auto-generated method stub
		floderList.remove(floder);
	}

}
