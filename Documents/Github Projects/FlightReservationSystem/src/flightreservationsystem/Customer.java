package flightreservationsystem;

import java.io.Serializable;

public class Customer implements Serializable {
	private String name;
	private String contactNumber;
	private String bookedFlight;

	public Customer(String name, String contactNumber, String bookedFlight) {
		this.name = name;
		this.contactNumber = contactNumber;
		this.bookedFlight = bookedFlight;
	}

	public String getName() {
		return name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getBookedFlight() {
		return bookedFlight;
	}

	@Override
	public String toString() {
		return "Customer Name: " + name + ", Contact: " + contactNumber + ", Booked Flight: " + bookedFlight;
	}
}
