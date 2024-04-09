package org.learning.javagestoreeventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EventsProgram {
    private String title;
    private List<Event> events;

    public EventsProgram(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEventsOnDate(LocalDate date) {
        return events.stream().filter(e -> e.getDate().isEqual(date)).collect(Collectors.toList());
    }

    public int getNumberOfEvents() {
        int counter = 0;
        for(Event event: events) {
            counter++;
        }

        return counter;
    }

    public void emptyList() {
        events.clear();
    }

    public String getProgram() {
        Collections.sort(events);

        return title + "\n" + events.stream().map(Event::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public String toString() {
        return "EventsProgram{" +
                "title='" + title + '\'' +
                ", events=" + events +
                '}';
    }
}
