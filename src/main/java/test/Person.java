package test;

public class Person {

	public Person(String name, int getId_card) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId_card() {
		return getId_card;
	}

	public void setGetId_card(Long getId_card) {
		this.getId_card = getId_card;
	}

	private String name;
	private Long getId_card;
}
