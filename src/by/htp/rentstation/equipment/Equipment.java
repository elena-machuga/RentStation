package by.htp.rentstation.equipment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Equipment {
	private Category category;
	private String title;
	private Date rentStartTime;
	private Date rentEndTime;
	private static final double fee = 0.1;

	public Equipment() {

	}

	public Equipment(String title) {
		this.title = title;
	}

	public Equipment(Category category, String title) {
		this.category = category;
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getRentStartTime() {
		return rentStartTime;
	}

	public void setRentStartTime(String rentStartTime) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			this.rentStartTime = df.parse(rentStartTime);
		} catch (ParseException e) {
			System.out.println("Invalid date and time format. Enter current date and time MM/dd/yyyy HH:mm");
			e.printStackTrace();
		}
	}

	public Date getRentEndTime() {
		return rentEndTime;
	}

	public void setRentEndTime(String rentEndTime) {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			this.rentEndTime = df.parse(rentEndTime);
		} catch (ParseException e) {
			System.out.println("Invalid date and time format. Enter current date and time MM/dd/yyyy HH:mm");
			e.printStackTrace();
		}
	}

	public static double getFee() {
		return fee;
	}

	@Override
	public String toString() {
		return title + ", category: " + getCategory() +  ";\n";
	}
	
	

}
