package com.tania.entity;

/**
 * Created by tanya on 26.10.17.
 */
public class DayOfEvent {
    Event event;
    int dayOfweek;

    public DayOfEvent(Event event, int dayOfweek) {
        this.event = event;
        this.dayOfweek = dayOfweek;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getDayOfweek() {
        return dayOfweek;
    }

    public void setDayOfweek(int dayOfweek) {
        this.dayOfweek = dayOfweek;
    }
}
