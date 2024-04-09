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
        if(date.isBefore(LocalDate.now())) throw new IllegalArgumentException();
    }

    private void validateCapacity(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException();
    }
}
