package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Event {
    private String title;
    private LocalDate date;
    private int venueCapacity;
    private int bookings;

    public Event(String title, LocalDate date, int venueCapacity) throws IllegalArgumentException {
        validateDate(date);
        validateCapacity(venueCapacity);
        this.title = title;
        this.date = date;
        this.venueCapacity = venueCapacity;
        bookings = 0;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws IllegalArgumentException {
        validateDate(date);
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public int getBookings() {
        return bookings;
    }

    public void addBookings(int newBookings) throws IllegalArgumentException {
        if(newBookings < 0) throw new IllegalArgumentException("Invalid number of bookings.");
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Event has passed.");
        if(newBookings > venueCapacity - bookings) throw new IllegalArgumentException("Not enough bookings available.");

        bookings += newBookings;
    }

    public void removeBookings(int numberOfBookings) throws IllegalArgumentException {
        if(numberOfBookings < 0) throw new IllegalArgumentException("Invalid number of bookings.");
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Event has passed.");
        if(numberOfBookings > bookings) throw new IllegalArgumentException("Not enough bookings to remove.");

        bookings -= numberOfBookings;
    }

    @Override
    public String toString() {
        String formattedDate = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));

        return formattedDate + " - " + title;
    }

    public String getDetails() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", venueCapacity=" + venueCapacity +
                ", bookings=" + bookings +
                '}';
    }

    private void validateDate(LocalDate date) {
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Inserted date is in the past.");
    }

    private void validateCapacity(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("Capacity cannot be <= 0.");
    }

    public String getBookingsStatus() {
        return "Total bookings: " + getBookings() + " - "
                + "Still available: " + (getVenueCapacity() - getBookings());
    }
}