package CompositePattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Floder {
	//透明的组合模式
	/** 当前模式为组合模式--定义模型为文件夹-文件 **/

	List<Floder> floderList = new ArrayList<Floder>();
	private String name;

	public Floder(String name) {
		this.name = name;
	}

	// 添加文件--添加子类引用
	protected abstract void addFile(Floder floder);

	// 删除文件
	protected abstract void removeFile(Floder floder);

	// 删除所有文件
	protected abstract void clearAllFile();

	// 输出所有文件
	protected abstract void printAllFile();

	// 获取文件夹下所有的文件和子文件
	protected abstract List<Floder> getAllFolderlist();

	protected String getFloderName() {
		return name;
	}
}
