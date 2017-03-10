package Builder;

public class MyOkHttp {
	/** builder模式：將表現和構造分離：仿照okhttp的模式创建一个Builder模式 **/

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

	/** 创建final的builder工厂 **/
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

		/** 创建builder设置参数 **/
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

		/** 返回创建对象,将builder中设置的参数传回MyOkHttp的构造方法中 **/
		public MyOkHttp builde() {
			return new MyOkHttp(this);
		}
	}

}
