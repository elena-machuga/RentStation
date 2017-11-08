package by.htp.rentstation.station;

import java.util.ArrayList;
import java.util.List;

import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.equipment.RentAccessory;
import by.htp.rentstation.equipment.RentItem;
import by.htp.rentstation.persons.Manager;
import by.htp.rentstation.persons.Renter;

public class RentStation implements Rentable{

	private List<Equipment> equipmentForRent;
	private List<Equipment> equipmentInRent;
	private List<Renter> renters;
	private int itemCount;
	private int accessoryCount;
	private static double profitTotal = 0;
	private static double feeTotal = 0;

	public RentStation() {
		equipmentForRent = new ArrayList<Equipment>();
		equipmentInRent = new ArrayList<Equipment>();
		renters = new ArrayList<>();
	}

	public List<Equipment> getEquipmentForRent() {
		return equipmentForRent;
	}

	public List<Equipment> getEquipmentInRent() {
		return equipmentInRent;
	}

	public List<Renter> getRenters() {
		return renters;
	}

	public void setRenters(Renter renter) {
		renters.add(renter);
	}

	public int getItemCount() {
		return itemCount;
	}

	public int getAccessoryCount() {
		return accessoryCount;
	}

	public static double getProfitTotal() {
		return profitTotal;
	}

	public static void setProfitTotal(double profitTotal) {
		RentStation.profitTotal = profitTotal;
	}

	public static double getFeeTotal() {
		return feeTotal;
	}

	public static void setFeeTotal(double feeTotal) {
		RentStation.feeTotal = feeTotal;
	}

	public void addEquipment(Equipment equipment) {
		equipmentForRent.add(equipment);
		if (equipment.getClass() == RentItem.class) {
			itemCount++;
		} else if (equipment.getClass() == RentAccessory.class) {
			accessoryCount++;
		}
	}

	public void rentOut(Equipment equipment, Renter renter, String rentStartTime) {

		if (equipment.getClass() == RentItem.class && renter.getNumItems() < 3) {
			equipmentForRent.remove(equipment);
			equipmentInRent.add(equipment);
			itemCount--;
			renter.takeEquipment(equipment, rentStartTime);
			RentUnit.addUnits(equipment);
		} else if (equipment.getClass() == RentItem.class && renter.getNumItems() >= 3){
			System.out.println("You have rent max number of items.");
		} else if (equipment.getClass() == RentAccessory.class) {
			equipmentForRent.remove(equipment);
			equipmentInRent.add(equipment);
			accessoryCount--;
			renter.takeEquipment(equipment, rentStartTime);
			RentUnit.addUnits(equipment);
		}
	}

	public void rentIn(Equipment equipment, Renter renter, String rentEndTime, Manager manager) {
		equipmentInRent.remove(equipment);
		equipmentForRent.add(equipment);
		renter.returnEquipment(equipment, rentEndTime);
		if (equipment.getClass() == RentItem.class) {
			manager.countProfit(equipment);
			itemCount++;
		} else if (equipment.getClass() == RentAccessory.class) {
			accessoryCount++;
		}
	}
	
	public static Equipment search(String title, List<Equipment> list) {
		Equipment found = null;
		for (Equipment e : list) {
			if (e.getTitle().equalsIgnoreCase(title)) {
				found = e;
				break;
			}
		}
		return found;

	}

	public static Renter search(List<Renter> renterList, String name) {
		Renter found = null;
		for (Renter r : renterList) {
			if (r.getName().equalsIgnoreCase(name)) {
				found = r;
				break;
			}
		}
		return found;

	}

	public void reportEquipmentForRent() {
		System.out.println(
				"Total number of items avaliable for rent: " + itemCount + " and accessories: " + accessoryCount + ":");
		for (Equipment eq : equipmentForRent) {
			System.out.println(eq.toString());
		}
	}

	public void reportEquipmentInRent() {
		System.out.println("Equipment in rent:");
		for (Equipment eq : equipmentInRent) {
			System.out.println(eq.toString());
		}
	}

	public void reportFull() {
		reportEquipmentForRent();
		reportEquipmentInRent();

	}

	@Override
	public String toString() {
		return "RentStation [equipmentForRent=" + equipmentForRent + ", equipmentInRent=" + equipmentInRent
				+ ", itemCount=" + itemCount + ", accessoryCount=" + accessoryCount + "]";
	}

}
