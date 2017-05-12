package CompositePattern;

import java.util.Iterator;
import java.util.List;

public class ConFloder extends Floder {

	//文件夹类
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
			// 遍历文件夹--如果里面还是文件夹，则调用文件夹的输出方法
			floder.printAllFile();
			// 下列代只是为了输出打印
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
