package flightreservationsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightReservationSystem {
	private static final String FLIGHTS_FILE = "flights.txt";
	private static final String CUSTOMERS_FILE = "customers.txt";
	private static final String ADMIN_USERNAME = "pratham";
	private static final String ADMIN_PASSWORD = "1234";
	private List<Flight> flights;
	private List<Customer> customers;

	public FlightReservationSystem() {
		flights = loadFlights();
		customers = loadCustomers();
	}

	private List<Flight> loadFlights() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FLIGHTS_FILE))) {
			return (List<Flight>) ois.readObject();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	private List<Customer> loadCustomers() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CUSTOMERS_FILE))) {
			return (List<Customer>) ois.readObject();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	private void saveFlights() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FLIGHTS_FILE))) {
			oos.writeObject(flights);
		} catch (IOException e) {
			System.out.println("Error saving flights data.");
		}
	}

	private void saveCustomers() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMERS_FILE))) {
			oos.writeObject(customers);
		} catch (IOException e) {
			System.out.println("Error saving customers data.");
		}
	}

	boolean authenticateAdmin(Scanner scanner) {
		System.out.print("Enter admin username: ");
		String username = scanner.nextLine();
		System.out.print("Enter admin password: ");
		String password = scanner.nextLine();
		return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
	}

	public void addFlight(Scanner scanner) {
		System.out.print("Enter flight type (Domestic/International): ");
		String flightType = scanner.nextLine();
		System.out.print("Enter flight number: ");
		String flightNumber = scanner.nextLine();
		System.out.print("Enter departure: ");
		String departure = scanner.nextLine();
		System.out.print("Enter destination: ");
		String destination = scanner.nextLine();
		System.out.print("Enter total seats: ");
		int totalSeats = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter departure time: ");
		String departureTime = scanner.nextLine();
		System.out.print("Enter arrival time: ");
		String arrivalTime = scanner.nextLine();

		if (flightType.equalsIgnoreCase("Domestic")) {
			flights.add(
					new DomesticFlight(flightNumber, departure, destination, totalSeats, departureTime, arrivalTime));
		} else if (flightType.equalsIgnoreCase("International")) {
			flights.add(new InternationalFlight(flightNumber, departure, destination, totalSeats, departureTime,
					arrivalTime));
		} else {
			System.out.println("Invalid flight type.");
			return;
		}
		saveFlights();
		System.out.println("Flight added successfully.");
	}

	public void removeFlight(Scanner scanner) {
		System.out.print("Enter flight number to remove: ");
		String flightNumber = scanner.nextLine();
		flights.removeIf(f -> f.getFlightNumber().equals(flightNumber));
		saveFlights();
		System.out.println("Flight removed successfully.");
	}

	public void viewFlights() {
		flights.forEach(System.out::println);
	}

	public void bookFlight(Scanner scanner) {
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your contact number: ");
		String contact = scanner.nextLine();
		System.out.print("Enter flight number to book: ");
		String flightNumber = scanner.nextLine();

		for (Flight flight : flights) {
			if (flight.getFlightNumber().equals(flightNumber) && flight.bookSeat()) {
				customers.add(new Customer(name, contact, flightNumber));
				saveFlights();
				saveCustomers();
				System.out.println("Flight booked successfully.");
				return;
			}
		}
		System.out.println("Booking failed. Flight may be full or not exist.");
	}

	public void cancelBooking(Scanner scanner) {
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter flight number to cancel: ");
		String flightNumber = scanner.nextLine();

		for (Customer customer : customers) {
			if (customer.getName().equals(name) && customer.getBookedFlight().equals(flightNumber)) {
				for (Flight flight : flights) {
					if (flight.getFlightNumber().equals(flightNumber)) {
						flight.cancelSeat();
						customers.remove(customer);
						saveFlights();
						saveCustomers();
						System.out.println("Booking canceled successfully.");
						return;
					}
				}
			}
		}
		System.out.println("Cancellation failed. Booking not found.");
	}

	public void viewCustomers() {
		customers.forEach(System.out::println);
	}
}
