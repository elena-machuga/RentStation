package by.htp.rentstation.equipment;

public final class RentAccessory extends Equipment {
	private char size;

	public RentAccessory() {
		super();
	}

	public RentAccessory(Category category, String title) {
		super(category, title);
	}

	public RentAccessory(String title) {
		super(title);
	}

	public RentAccessory(Category category, String title, char size) {
		super(category, title);
		this.size = size;
	}

	public RentAccessory(String title, char size) {
		super(title);
		this.size = size;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return getTitle() + ", category: " + getCategory() + ", size " + size + ";";
	}

}
