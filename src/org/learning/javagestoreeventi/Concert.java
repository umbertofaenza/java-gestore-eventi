package org.learning.javagestoreeventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Concert extends Event {
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int venueCapacity, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, venueCapacity);
        validatePrice(price);
        validateTime(time);
        this.time = time;
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        validateTime(time);
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Price cannot be < 0");
    }

    private void validateTime(LocalTime time) {
        if(time.isBefore(LocalTime.now())) throw new IllegalArgumentException("Time entered is in the past.");
    }

    public String getFormattedDateTime() {
        String formattedDate = getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
        String timeColonPattern = "HH:mm";
        String formattedTime = getTime().format(DateTimeFormatter.ofPattern(timeColonPattern));

        return formattedDate + " " + formattedTime;
    }

    public String getFormattedPrice() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');

        DecimalFormat formatter = new DecimalFormat("00.00€", symbols);

        return formatter.format(price);
    }

    @Override
    public String toString() {
        return getFormattedDateTime() + " - " + getTitle() + " - " + getFormattedPrice();
    }
}
