package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 在一千条数据中查询出前有十条相同的数据
 * 
 * @author Administrator
 *
 */
public class test4 {
	/**
	 * 生成一千条数据
	 */
	public static void data(List<String> list) {
		Integer x = null;
		for (int i = 0; i < 1000; i++) {
			x = (int) (Math.random() * 1000);
			list.add("阿毛" + x);
		}
		System.out.println(list.size());
		System.out.println("--------------------------------------");
	}

	/**
	 * 查询相同的前十条数据
	 * 
	 * @param args
	 */
	public static void inquiry() {

		List<String> list = new ArrayList<String>();
		data(list);
		System.out.println("相同---------------------------------");
		Set<String> set = new HashSet<String>();
		String temp = "";
		for (int i = 0; i < list.size(); i++) {
			temp = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				if (temp.equals(list.get(j)) && set.size() < 10) {
					set.add(list.get(i));
				}
			}

		}
		for (String seat1 : set) {
			System.out.println(seat1);
		}
		System.out.println(set.size());
	}

}
