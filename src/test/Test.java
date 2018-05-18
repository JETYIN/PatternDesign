package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ChainPattern.Grouper;
import ChainPattern.Manger;
import ModelPattern.AbComputer;
import ModelPattern.CoderComputer;
import ModelPattern.WorkComputer;
import StatePattern.TvContext;
import StatePattern.TvOnStatus;

public class Test {

	public static void main(String[] args) {
		String goodsName = "60563元萨法宝";
		String payUnit;
		String num;
		// MyClass.init();
		TvContext.getInstance().setPresentStatus(new TvOnStatus());
		TvContext.getInstance().getTVNext();
		TvContext.getInstance().getTVPre();
		TvContext.getInstance().getTVVolA();
		TvContext.getInstance().getTVVolR();

		/** 责任链模式 **/
		/*
		 * Grouper grouper = new Grouper(); grouper.dealMeeage(2000); Manger
		 * manger = new Manger(grouper);
		 */

		/** 模板模式 --子类可以有多种不同实现，但是抽象父类为其定义的固定方法不变 **/
		AbComputer abComputer = new CoderComputer();
		abComputer.excuet();
		abComputer = new WorkComputer();
		abComputer.excuet();
		split("3200元宝");
		payUnit = goodsName.replaceAll("([1-9]+[0-9]*|0)(\\.[\\d]+)?", "");
		num = goodsName.replaceAll("[\u4E00-\u9FA5]?", "");
		System.out.println(payUnit);
		System.out.println(num);
		testMap("key3");
	}

	public static void split(String name) {
		String str = name.substring(name.length() - 2, name.length());
		String bol = "true";
		System.out.println(str);
		System.out.println(Boolean.parseBoolean(bol));
	}

	public static Map<String, List<String>> getMap() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();

		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		map.put("key1", list1);
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		map.put("key2", list2);
		List<String> list3 = new ArrayList<String>();
		list3.add("1");
		list3.add("2");
		map.put("key3", list3);
		List<String> list4 = new ArrayList<String>();
		list4.add("1");
		list4.add("2");
		map.put("key4", list4);

		return map;
	}

	public static void testMap(String target) {

		Map<String, List<String>> map = getMap();
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			if (it.next().equalsIgnoreCase(target)) {
				it.remove();
			}
		}
		System.out.println(map.toString());
	}
}
