package org.learning.javagestoreeventi;

import java.time.LocalDate;

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

    private void validateDate(LocalDate date) {
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException("Inserted date is in the past.");
    }

    private void validateCapacity(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("Capacity cannot be <= 0.");
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
}
