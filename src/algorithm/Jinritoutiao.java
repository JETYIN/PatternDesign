package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 今日头条面试题:
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
	 * 最长不重复字串 解法一
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int j = 0, i = 0; j < n; j++) {
			// Math.max返回函数中的最大值
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	/**
	 * 毒蘑菇与体力问题,100个格子上，每个格子上都有毒蘑菇和体力蘑菇
	 */
	public static void show() {

		
	}

}
