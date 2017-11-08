package by.htp.rentstation.persons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.rentstation.equipment.Equipment;
import by.htp.rentstation.equipment.RentItem;
import by.htp.rentstation.station.RentStation;
import by.htp.rentstation.station.RentUnit;

public final class Manager extends Person {

	public Manager() {
		super();
	}

	public Manager(String name) {
		super(name);
	}

	public final void countProfit(Equipment equipment) {
		double profit = 0;
		double delta = (double) ((equipment.getRentEndTime().getTime() - equipment.getRentStartTime().getTime())
				/ 3600000);
		int deltaInt = (int) Math.ceil(delta);
		if (deltaInt <= 24) {
			profit = deltaInt * ((RentItem) equipment).getMortgage();
		} else {
			profit = ((RentItem) equipment).getMortgage() * 24;
			countFee(equipment);
		}
		RentStation.setProfitTotal(RentStation.getProfitTotal() + profit);
	}

	public final void countFee(Equipment equipment) {
		double delta = (double) ((equipment.getRentEndTime().getTime() - equipment.getRentStartTime().getTime())
				/ 3600000);
		int deltaInt = (int) Math.ceil(delta);
		double feeSum = Math.round((deltaInt - 24) * Equipment.getFee() * 100);
		RentStation.setFeeTotal(RentStation.getFeeTotal() + feeSum / 100);
	}

	public List<Equipment> findExpired(String dateTime, RentStation rs) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date checkdate = df.parse(dateTime);
		List<Equipment> expired = new ArrayList<>();
		for (Equipment e : rs.getEquipmentInRent()) {
			double delta = (double) ((checkdate.getTime() - e.getRentStartTime().getTime()) / 3600000);
			int deltaInt = (int) Math.ceil(delta);
			if (deltaInt >= 24) {
				expired.add(e);
			}
		}
		
		return expired;

	}

	public void profitReport() {
		System.out.println("For the day the Rent Station made " + RentStation.getProfitTotal() + " of profit and "
				+ RentStation.getFeeTotal() + " of fees.");
		System.out.println(RentUnit.generateReport());
	}

}
