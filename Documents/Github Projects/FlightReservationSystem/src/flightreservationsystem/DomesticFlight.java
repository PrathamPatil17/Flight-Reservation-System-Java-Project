package flightreservationsystem;

public class DomesticFlight extends Flight {
	public DomesticFlight(String flightNumber, String departure, String destination, int totalSeats,
			String departureTime, String arrivalTime) {
		super(flightNumber, departure, destination, totalSeats, departureTime, arrivalTime);
	}

	@Override
	public String toString() {
		return "Domestic " + super.toString();
	}
}
