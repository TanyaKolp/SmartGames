package com.tania.entity;

import java.util.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by tanya on 26.10.17.
 */
public class Event {
    private String name;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private List<DayOfEvent> days;

    public Event() {
    }

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public List<DayOfEvent> getDays() {
        return days;
    }

    public void setDays(List<DayOfEvent> days) {
        this.days = days;
    }
}
