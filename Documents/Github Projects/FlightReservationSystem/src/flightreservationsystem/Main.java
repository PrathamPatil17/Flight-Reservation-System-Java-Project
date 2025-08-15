package flightreservationsystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		FlightReservationSystem system = new FlightReservationSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nFlight Reservation System Menu:");
			System.out.println("1. Add Flight (Admin)");
			System.out.println("2. Remove Flight (Admin)");
			System.out.println("3. View All Flights");
			System.out.println("4. Book Flight (Customer)");
			System.out.println("5. Cancel Booking (Customer)");
			System.out.println("6. View Customers (Admin)");
			System.out.println("7. Exit");
			System.out.print("Choose an option: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
				if (system.authenticateAdmin(scanner)) {
					system.addFlight(scanner);
				} else {
					System.out.println("Authentication failed. Access denied.");
				}
				break;
			case 2:
				if (system.authenticateAdmin(scanner)) {
					system.removeFlight(scanner);
				} else {
					System.out.println("Authentication failed. Access denied.");
				}
				break;
			case 3:
				system.viewFlights();
				break;
			case 4:
				system.bookFlight(scanner);
				break;
			case 5:
				system.cancelBooking(scanner);
				break;
			case 6:
				if (system.authenticateAdmin(scanner)) {
					system.viewCustomers();
				} else {
					System.out.println("Authentication failed. Access denied.");
				}
				break;
			case 7:
				System.out.println("Exiting system. Goodbye!");
				scanner.close();
				return;
			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}
}
