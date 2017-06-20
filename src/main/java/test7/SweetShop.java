package test7;

public class SweetShop {
	public static void main(String[] args) {
		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
		} catch (Exception e) {
			System.out.println("Couldn't find Gum");
		}
	}
}
