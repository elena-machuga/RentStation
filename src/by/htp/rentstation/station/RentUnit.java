package by.htp.rentstation.station;

import java.util.ArrayList;
import java.util.List;

import by.htp.rentstation.equipment.Equipment;

public class RentUnit {
	private static List<Equipment> units = new ArrayList<Equipment>();

	public List<Equipment> getUnits() {
		return units;
	}

	public static void addUnits(Equipment equipment) {
		units.add(equipment);
	}

	public static String generateReport() {
		return "Equipment that was rented: \n" + units;
	}

}
