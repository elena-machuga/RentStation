package by.htp.rentstation.persons;

public abstract class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {
		super();
	}

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person name: " + name + ";";
	}

}
