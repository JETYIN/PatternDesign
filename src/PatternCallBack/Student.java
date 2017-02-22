package PatternCallBack;

public class Student {

	public void ask(int a, int b) {
		new Teacher().teacherResult(a, b, new ISolveQuestion() {

			@Override
			public void Iadd(int a, int b, int result) {
				// TODO Auto-generated method stub
				System.out.println("result is:" + result);
			}
		});

	}

}
