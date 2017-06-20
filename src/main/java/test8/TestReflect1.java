package test8;

public class TestReflect1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		// 一般采用这种形式
		class1 = Class.forName("test8.TestReflect1");
		class2 = new TestReflect1().getClass();
		class3 = TestReflect1.class;
		System.out.println("类名称   " + class1.getName());
		System.out.println("类名称   " + class2.getName());
		System.out.println("类名称   " + class3.getName());
	}
}
