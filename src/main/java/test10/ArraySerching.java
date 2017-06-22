package test10;

import java.util.Arrays;

public class ArraySerching {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = { 5, 2, 9, 6, 11, 15, 14, 13 };
		System.out.println(Arrays.binarySearch(b, 11));
	}
}
