package PatternCallBack;

public class Teacher {

	public void teacherResult(int a, int b, ISolveQuestion iSolveQuestion) {

		int result = a + b;
		iSolveQuestion.Iadd(a, b, result);
	
	}
}
