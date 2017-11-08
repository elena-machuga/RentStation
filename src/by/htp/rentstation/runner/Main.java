package by.htp.rentstation.runner;

import java.io.IOException;

import by.htp.rentstation.equipment.Category;
import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.equipment.RentAccessory;
import by.htp.rentstation.equipment.RentItem;
import by.htp.rentstation.persons.Manager;
import by.htp.rentstation.station.RentStation;

public class Main {

	public static void main(String[] args) {

		RentStation rs = new RentStation();
		Manager manager = new Manager("Peter");

		Equipment skis = new RentItem(Category.WINTER, "Skis", 10.0);
		Equipment bike = new RentItem(Category.SUMMER, "Bike", 25.0);
		Equipment skate = new RentItem(Category.SUMMER, "Skate", 11.0);
		Equipment rollers = new RentItem(Category.SUMMER, "Rollers", 10.0);
		Equipment helmet = new RentAccessory(Category.SUMMER, "Helmet", 'M');
		Equipment gloves = new RentAccessory(Category.WINTER, "Gloves", 'M');

		rs.addEquipment(gloves);
		rs.addEquipment(helmet);
		rs.addEquipment(rollers);
		rs.addEquipment(skate);
		rs.addEquipment(bike);
		rs.addEquipment(skis);

		rs.reportFull();
		System.out.println();

		do {
			try {
				Menu.menu(rs, manager);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (true);

		// rs.rentOut(rollers, renter, "11/01/2017 15:00");
		// rs.rentOut(skate, renter, "10/30/2017 15:00");
		// rs.rentOut(bike, renter, "11/01/2017 15:00");
		//
		// rs.reportFull();
		//
		// rs.rentOut(skis, renter, "11/01/2017 15:00");
		//
		// rs.reportFull();
		//
		// rs.rentIn(rollers, renter, "11/01/2017 19:30", manager);
		// rs.rentIn(skate, renter, "11/01/2017 20:00", manager);
		//
		// manager.profitReport();

	}



}
