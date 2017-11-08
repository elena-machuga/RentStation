package by.htp.rentstation.station;

import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.persons.Manager;
import by.htp.rentstation.persons.Renter;

public interface Rentable {

	void rentOut(Equipment equipment, Renter renter, String rentStartTime);
	void rentIn(Equipment equipment, Renter renter, String rentEndTime, Manager manager);
}
