package by.htp.rentstation.persons;

import java.util.ArrayList;
import java.util.List;

import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.equipment.RentItem;

public final class Renter extends Person {

	private List<Equipment> rentUnits;
	private int numItems = 0;

	public Renter() {
		super();
		rentUnits = new ArrayList<>();
	}

	public Renter(String name) {
		super(name);
		rentUnits = new ArrayList<>();
	}

	public List<Equipment> getRentUnits() {
		return rentUnits;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	
	public void takeEquipment(Equipment equipment, String rentStartTime) {
		rentUnits.add(equipment);
		equipment.setRentStartTime(rentStartTime);
		if (equipment.getClass() == RentItem.class) {
			setNumItems(getNumItems() + 1);
		}
	}
	
	public void returnEquipment(Equipment equipment, String rentEndTime) {
		rentUnits.remove(equipment);
		equipment.setRentEndTime(rentEndTime);
		if (equipment.getClass() == RentItem.class) {
			setNumItems(getNumItems() - 1);
		}
	}

	@Override
	public String toString() {
		return "Renter name: " + getName() + ", rentUnits: " + rentUnits + ";";
	}

}
