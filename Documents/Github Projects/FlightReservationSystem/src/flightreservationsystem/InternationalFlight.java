package flightreservationsystem;

public class InternationalFlight extends Flight {
	public InternationalFlight(String flightNumber, String departure, String destination, int totalSeats,
			String departureTime, String arrivalTime) {
		super(flightNumber, departure, destination, totalSeats, departureTime, arrivalTime);
	}

	@Override
	public String toString() {
		return "International " + super.toString();
	}
}
