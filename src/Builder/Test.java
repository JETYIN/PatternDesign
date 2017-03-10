package Builder;

public class Test {

	public static void main(String[] args) {
		
		MyOkHttp.Builder builder=new MyOkHttp.Builder()
		                                   .addWork(false)
		                                   .changeUserAge(100)
		                                   .updateBorn(1990)
		                                   .userNameSetting("china");
		MyOkHttp okhttp=builder.builde();
		
		System.out.println("this is:"+String.valueOf(okhttp.getBorn())+"*****"+
				"this is:"+String.valueOf(okhttp.getUserAge())+"*****"+"this is:"+okhttp.getUserName());
		
	}

}
