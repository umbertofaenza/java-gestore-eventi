package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            //CREATE EVENT
        System.out.println("Insert event.");

        Event event = null;
        do {
            try{
            System.out.print("Title: ");
            String title = scan.nextLine();

            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(scan.nextLine());

            System.out.print("Venue capacity: ");
            int venueCapacity = Integer.parseInt(scan.nextLine());

            event = new Event(title, date, venueCapacity);

            // print new event added
            System.out.println("New event added: " + "\t" + event);

            } catch (IllegalArgumentException | DateTimeParseException e) {
                System.out.println(e.getMessage());
            }
        } while(event == null);


            //ADD BOOKINGS
        boolean addBookingsflag = false;
        do {
            try {
                System.out.print("Add bookings? y/n ");
                String choice = scan.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    System.out.print("How many bookings to add? ");
                    int bookings = Integer.parseInt(scan.nextLine());

                    event.addBookings(bookings);

                    // print bookings status
                    System.out.println(event.getBookingsStatus());

                    addBookingsflag = true;
                } else if (choice.equalsIgnoreCase("n")) {
                    addBookingsflag = true;
                } else {
                    System.out.println("Invalid input.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!addBookingsflag);


            //REMOVE BOOKINGS
        boolean removeBookingsflag = false;
        do {
            try {
                System.out.print("Remove bookings? y/n ");
                String choice = scan.nextLine();

                if (choice.equalsIgnoreCase("y")) {
                    System.out.print("How many bookings to remove? ");
                    int bookings = Integer.parseInt(scan.nextLine());

                    event.removeBookings(bookings);

                    // print bookings status
                    System.out.println(event.getBookingsStatus());

                    removeBookingsflag = true;
                } else if (choice.equalsIgnoreCase("n")) {
                    removeBookingsflag = true;
                } else {
                    System.out.println("Invalid input.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!removeBookingsflag);

        scan.close();
    }
}
