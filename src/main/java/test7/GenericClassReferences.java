package test7;

public class GenericClassReferences {
	public static void main(String[] args) {
		Class intCalss = int.class;
		Class<? extends Number> genericIntClass = int.class;
		genericIntClass = Integer.class;
		intCalss = double.class;
	}
}
