package Builder;

public class MyOkHttp {
	/** builderģʽ������F�͘�����x������okhttp��ģʽ����һ��Builderģʽ **/

	public MyOkHttp() {
		this(new Builder());
	}

	public MyOkHttp(Builder builder) {

		this.user_age = builder.user_age;
		this.user_born = builder.user_born;
		this.user_work = builder.user_work;
		this.user_name = builder.user_name;

	}

	public String getUserName() {
		return user_name;
	}

	public int getUserAge() {
		return user_age;
	}

	public int getBorn() {
		return user_born;
	}

	public boolean getWork() {
		return user_work;
	}

	final String user_name;
	final int user_age;
	final boolean user_work;
	final int user_born;

	/** this is the inner final class zone **/

	/** ����final��builder���� **/
	public final static class Builder {

		String user_name;
		int user_age;
		boolean user_work;
		int user_born;

		public Builder() {
			user_name = "dylan";
			user_age = 18;
			user_work = true;
			user_born = 2000;

		}

		Builder(MyOkHttp okhttp) {

			this.user_name = okhttp.user_name;
			this.user_age = okhttp.user_age;
			this.user_work = okhttp.user_work;
			this.user_born = okhttp.user_born;
		}

		/** ����builder���ò��� **/
		public Builder userNameSetting(String name) {
			this.user_name = name;
			return this;

		}

		public Builder changeUserAge(int age) {
			this.user_age = age;
			return this;
		}

		public Builder updateBorn(int born) {
			this.user_born = born;
			return this;
		}

		public Builder addWork(boolean is) {
			this.user_work = is;
			return this;
		}

		/** ���ش�������,��builder�����õĲ�������MyOkHttp�Ĺ��췽���� **/
		public MyOkHttp builde() {
			return new MyOkHttp(this);
		}
	}

}
