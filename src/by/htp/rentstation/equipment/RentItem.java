package by.htp.rentstation.equipment;

public final class RentItem extends Equipment {
	private double mortgage;

	public RentItem() {
		super();
	}

	public RentItem(String title) {
		super(title);
	}

	public RentItem(Category category, String title) {
		super(category, title);
	}

	public RentItem(String title, double mortgage) {
		super(title);
		this.mortgage = mortgage;
	}

	public RentItem(Category category, String title, double mortgage) {
		super(category, title);
		this.mortgage = mortgage;
	}

	public double getMortgage() {
		return mortgage;
	}

	public void setMortgage(double mortgage) {
		this.mortgage = mortgage;
	}


	@Override
	public String toString() {
		return getTitle() + ", category: " + getCategory() +  ", mortgage " + mortgage + ";";
	}
	
	

}
