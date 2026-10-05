package mini.project;

import java.util.ArrayList;
import java.util.Scanner;

class Train {

    int trainNumber;
    String trainName;
    String source;
    String destination;
    int seats;

    Train(int trainNumber, String trainName, String source,
          String destination, int seats) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    void displayTrain() {

        System.out.println("Train Number : " + trainNumber);
        System.out.println("Train Name   : " + trainName);
        System.out.println("From         : " + source);
        System.out.println("To           : " + destination);
        System.out.println("Available Seats : " + seats);
        System.out.println("----------------------------");
    }
}

class Booking {

    int bookingId;
    String passengerName;
    int trainNumber;

    Booking(int bookingId, String passengerName, int trainNumber) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
    }

    void displayBooking() {

        System.out.println("Booking ID    : " + bookingId);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Train Number  : " + trainNumber);
        System.out.println("----------------------------");
    }
}

public class RailwayManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Train> trains = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Railway Management System =====");
            System.out.println("1. Add Train");
            System.out.println("2. View Trains");
            System.out.println("3. Search Train");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. View Bookings");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Train Number: ");
                int trainNumber = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Train Name: ");
                String trainName = sc.nextLine();

                System.out.print("Enter Source: ");
                String source = sc.nextLine();

                System.out.print("Enter Destination: ");
                String destination = sc.nextLine();

                System.out.print("Enter Number of Seats: ");
                int seats = sc.nextInt();

                Train train = new Train(
                        trainNumber,
                        trainName,
                        source,
                        destination,
                        seats
                );

                trains.add(train);

                System.out.println("Train added successfully!");

                break;

            case 2:

                if (trains.isEmpty()) {

                    System.out.println("No trains available.");

                } else {

                    for (Train t : trains) {

                        t.displayTrain();
                    }
                }

                break;

            case 3:

                System.out.print("Enter Train Number: ");
                int searchTrain = sc.nextInt();

                boolean trainFound = false;

                for (Train t : trains) {

                    if (t.trainNumber == searchTrain) {

                        t.displayTrain();

                        trainFound = true;
                    }
                }

                if (!trainFound) {

                    System.out.println("Train not found.");
                }

                break;

            case 4:

                System.out.print("Enter Train Number: ");
                int bookTrain = sc.nextInt();

                sc.nextLine();

                boolean available = false;

                for (Train t : trains) {

                    if (t.trainNumber == bookTrain) {

                        available = true;

                        if (t.seats > 0) {

                            System.out.print("Enter Passenger Name: ");
                            String passengerName = sc.nextLine();

                            System.out.print("Enter Booking ID: ");
                            int bookingId = sc.nextInt();

                            Booking booking = new Booking(
                                    bookingId,
                                    passengerName,
                                    bookTrain
                            );

                            bookings.add(booking);

                            t.seats--;

                            System.out.println("Ticket booked successfully!");

                        } else {

                            System.out.println("No seats available.");
                        }
                    }
                }

                if (!available) {

                    System.out.println("Train not found.");
                }

                break;

            case 5:

                System.out.print("Enter Booking ID: ");
                int cancelId = sc.nextInt();

                boolean cancelled = false;

                for (int i = 0; i < bookings.size(); i++) {

                    if (bookings.get(i).bookingId == cancelId) {

                        int cancelledTrain = bookings.get(i).trainNumber;

                        bookings.remove(i);

                        for (Train t : trains) {

                            if (t.trainNumber == cancelledTrain) {

                                t.seats++;
                            }
                        }

                        System.out.println("Ticket cancelled successfully!");

                        cancelled = true;

                        break;
                    }
                }

                if (!cancelled) {

                    System.out.println("Booking not found.");
                }

                break;

            case 6:

                if (bookings.isEmpty()) {

                    System.out.println("No bookings available.");

                } else {

                    for (Booking b : bookings) {

                        b.displayBooking();
                    }
                }

                break;

            case 7:

                System.out.println("Thank you for using Railway Management System.");

                sc.close();

                return;

            default:

                System.out.println("Invalid choice.");
            }
        }
    }
}