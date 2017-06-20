package test7;

import java.util.Formatter;

public class Demo1 {
	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);
		char u = 'a';
		System.out.println("u='a'");
		System.out.println(f.format("s: %s\n", u));
	}
}
