package by.htp.rentstation.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.persons.Manager;
import by.htp.rentstation.persons.Renter;
import by.htp.rentstation.station.RentStation;

public class Menu {
	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void menu(RentStation rs, Manager manager) throws IOException {

		System.out.println();
		System.out.println("Enter number of action: \n" + "1. View the list of avaliable equipment. \n"
				+ "2. View the list of equipment in rent. \r\n" + "3. Rent equipment. \r\n"
				+ "4. Return equipment. \r\n" + "5. Equipment with expired rental period. \r\n"
				+ "6. Close Rent Station. \r\n");

		String response = in.readLine();
		if (!response.equals("1") && !response.equals("2") && !response.equals("3") && !response.equals("4")
				&& !response.equals("5") && !response.equals("6")) {
			System.out.println("Action code was not found. Valid codes 1, 2, 3, 4, 5 or 6.");
			response = in.readLine();
		}

		switch (response) {
		case "1":
			reportForRent(rs);
			break;
		case "2":
			reportInRent(rs);
			break;
		case "3":
			rentEquipment(rs);
			break;
		case "4":
			returnEquipment(rs, manager);
			break;
		case "5":
			System.out.println("\"Enter current date and time MM/dd/yyyy HH:mm\"");
			String dateTime = in.readLine();
			expiredEquipment(dateTime, rs, manager);
			break;
		case "6":
			closeStation(manager);
			break;
		default:
			break;
		}
	}

	public static void reportForRent(RentStation rs) {
		rs.reportEquipmentForRent();
	}

	public static void reportInRent(RentStation rs) {
		rs.reportEquipmentInRent();
	}

	// ToDo
	public static void rentEquipment(RentStation rs) throws IOException {
		System.out.println("Enter renter name");
		String rName = in.readLine();
		Renter renter = RentStation.search(rs.getRenters(), rName);
		if (renter == null) {
			renter = new Renter(rName);
		}
		rs.setRenters(renter);
		System.out.println("Enter current date and time MM/dd/yyyy HH:mm");
		String rentStartTime = in.readLine();
		System.out.println(
				"Select equipment for rent. You may rent up to 3 items and unlimited number of accessories. Press double Enter to finish selection");
		String e = in.readLine();
		while (!e.equals("")) {
			Equipment eq = RentStation.search(e, rs.getEquipmentForRent());
			if (eq != null) {
				rs.rentOut(eq, renter, rentStartTime);
			} else {
				System.out.println("Equipment not found");
			}
			e = in.readLine();
		}
	}

	public static void returnEquipment(RentStation rs, Manager manager) throws IOException {
		System.out.println("Enter renter name");
		String rName = in.readLine();
		System.out.println("Enter current date and time MM/dd/yyyy HH:mm");
		String rentEndTime = in.readLine();
		System.out.println("Select equipment to return");
		String e = in.readLine();
		while (!e.equals("")) {
			Renter renter = RentStation.search(rs.getRenters(), rName);
			Equipment eq = RentStation.search(e, rs.getEquipmentInRent());
			if (!eq.equals(null)) {
				rs.rentIn(eq, renter, rentEndTime, manager);
			}
			e = in.readLine();
		}
	}

	public static void expiredEquipment(String dateTime, RentStation rs, Manager manager) {
		try {
			System.out.println("Expired equipment:");
			System.out.println(manager.findExpired(dateTime, rs));
		} catch (ParseException e) {
			System.out.println("Invalid date and time format. Enter current date and time MM/dd/yyyy HH:mm");
			e.printStackTrace();
		}
	}

	public static void closeStation(Manager manager) {
		manager.profitReport();
		System.exit(0);
	}

}
