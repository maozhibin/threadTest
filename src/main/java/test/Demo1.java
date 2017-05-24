package test;

import java.util.TreeMap;

public class Demo1 {
	public static void main(String[] args) {
		int[] arr = { 1, 9, 8, 11, 3, 4, 6, 5 };
		Demo1 demo1 = new Demo1();
		demo1.sort(arr);
		TreeMap<String, Object> trep = new TreeMap<String, Object>();
	}

	public void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int team = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = team;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
