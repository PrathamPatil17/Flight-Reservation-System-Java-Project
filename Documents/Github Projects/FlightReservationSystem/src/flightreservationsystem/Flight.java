package flightreservationsystem;

import java.io.Serializable;

public abstract class Flight implements Serializable {
	private String flightNumber;
	private String departure;
	private String destination;
	private int totalSeats;
	private int bookedSeats;
	private String departureTime;
	private String arrivalTime;

	public Flight(String flightNumber, String departure, String destination, int totalSeats, String departureTime,
			String arrivalTime) {
		this.flightNumber = flightNumber;
		this.departure = departure;
		this.destination = destination;
		this.totalSeats = totalSeats;
		this.bookedSeats = 0;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public int getAvailableSeats() {
		return totalSeats - bookedSeats;
	}

	public boolean bookSeat() {
		if (bookedSeats < totalSeats) {
			bookedSeats++;
			return true;
		}
		return false;
	}

	public void cancelSeat() {
		if (bookedSeats > 0) {
			bookedSeats--;
		}
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public String toString() {
		return "Flight Number: " + flightNumber + ", Departure: " + departure + ", Destination: " + destination
				+ ", Available Seats: " + getAvailableSeats() + ", Departure Time: " + departureTime
				+ ", Arrival Time: " + arrivalTime;
	}
}
