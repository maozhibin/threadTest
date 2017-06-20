package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class YuGiOh {
	public static void main(String args[]) {
		Long start = new Date().getTime();
		System.out.println("kaishi:" + start);
		System.out.println("------------");
		List<String> list = new ArrayList<String>();
		data(list);
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1 == null || o2 == null) {
					return -1;
				}
				if (o1.length() > o2.length()) {
					return 1;
				}
				if (o1.length() < o2.length()) {
					return -1;
				}
				if (o1.compareTo(o2) > 0) {
					return 1;
				}
				if (o1.compareTo(o2) < 0) {
					return -1;
				}
				if (o1.compareTo(o2) == 0) {
					return 0;
				}
				return 0;
			}
		});
		System.out.println("list--------------------------");
		for (String string : list) {
			System.out.println(string);
		}

		System.out.println("list--------------------------");

		// set中存放的是不可重复的元素
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i);
			if (!set.contains(value) && set.size() < 10) {
				set.add(value);
			}

		}
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println("------------");
		Long end = new Date().getTime();
		System.out.println(end - start);
	}

	/**
	 * 生成一千条数据
	 */
	public static void data(List<String> list) {
		Integer x = null;
		for (int i = 0; i < 10000000; i++) {
			x = (int) (Math.random() * 100);
			list.add("阿毛" + x);
		}
		System.out.println(list.size());
		System.out.println("--------------------------------------");
	}
}