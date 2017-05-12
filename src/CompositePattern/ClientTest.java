package CompositePattern;

public class ClientTest {
	public static void main(String[] args) {

		// ����һ���ļ��б�

		Floder c_disk = new ConFloder("C:");
		c_disk.addFile(new ConFloder("txt.1"));
		c_disk.addFile(new ConFloder("txt.2"));

		Floder floder_one = new ConFloder("tecentGame");
		floder_one.addFile(new ConFloder("game.1"));
		floder_one.addFile(new ConFloder("game.2"));
		c_disk.addFile(floder_one);

		Floder floder_two = new ConFloder("workSpace");
		floder_two.addFile(new ConFloder("work.1"));
		floder_two.addFile(new ConFloder("work.2"));
		c_disk.addFile(floder_two);

		// ����c���������
		c_disk.printAllFile();

	}

}
