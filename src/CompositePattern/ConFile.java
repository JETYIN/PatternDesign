package CompositePattern;

import java.util.List;

public class ConFile extends Floder {
	// �ļ���--�ļ���֧�ֱ�������

	public ConFile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addFile(Floder floder) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("��ǰΪ�ļ���--��֧�ָò���");
	}

	@Override
	protected void clearAllFile() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("��ǰΪ�ļ���--��֧�ָò���");
	}

	@Override
	protected List<Floder> getAllFolderlist() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("��ǰΪ�ļ���--��֧�ָò���");
	}

	@Override
	protected void printAllFile() {
		// TODO Auto-generated method stub
		System.out.print(getFloderName());
	}

	@Override
	protected void removeFile(Floder floder) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("��ǰΪ�ļ���--��֧�ָò���");
	}

}
