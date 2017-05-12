package CompositePattern;

import java.util.List;

public class ConFile extends Floder {
	// 文件类--文件不支持遍历操作

	public ConFile(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void addFile(Floder floder) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("当前为文件类--不支持该操作");
	}

	@Override
	protected void clearAllFile() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("当前为文件类--不支持该操作");
	}

	@Override
	protected List<Floder> getAllFolderlist() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("当前为文件类--不支持该操作");
	}

	@Override
	protected void printAllFile() {
		// TODO Auto-generated method stub
		System.out.print(getFloderName());
	}

	@Override
	protected void removeFile(Floder floder) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("当前为文件类--不支持该操作");
	}

}
