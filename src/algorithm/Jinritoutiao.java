package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ͷ��������:
 * 
 * @author Administrator
 * 
 */
public class Jinritoutiao {

	public static void main(String[] args) {
		String target = "asdfgsdasdasassaaa";
		System.out.println(lengthOfLongestSubstring(target));
	}

	/**
	 * ����ظ��ִ� �ⷨһ
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int j = 0, i = 0; j < n; j++) {
			// Math.max���غ����е����ֵ
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	/**
	 * ��Ģ������������,100�������ϣ�ÿ�������϶��ж�Ģ��������Ģ��
	 */
	public static void show() {

		
	}

}
