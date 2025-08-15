# Flight Reservation System

A simple Java console application for managing flight reservations, bookings, and customers.

## Features

- Add, remove, and view flights (admin)
- Book and cancel flight reservations (customer)
- View all customers (admin)
- Supports domestic and international flights
- Data persistence using text files

## Requirements

- Java 8 or higher

## Project Structure

```
FlightReservationSystem/
├── src/flightreservationsystem/
│   ├── Customer.java
│   ├── DomesticFlight.java
│   ├── Flight.java
│   ├── FlightReservationSystem.java
│   ├── InternationalFlight.java
│   ├── Main.java
├── bin/flightreservationsystem/
│   └── (compiled .class files)
├── flights.txt
├── customers.txt
├── bookings.txt
```

## How to Run

1. Compile the project:
   ```sh
   javac -d bin src/flightreservationsystem/*.java
   ```
2. Run the application:
   ```sh
   java -cp bin flightreservationsystem.Main
   ```

## Admin Credentials

- **Username:** pratham
- **Password:** 1234

## Usage

- Follow the menu prompts in the console to perform admin or customer actions.
- Data is saved in `flights.txt` and `customers.txt` files.

## License

This project is open source and free to use.
