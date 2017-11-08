package com.tania.dailyevents;

import com.tania.entity.DayOfEvent;
import com.tania.entity.Event;
import org.apache.commons.lang.time.DateUtils;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by tanya on 26.10.17.
 */
public class Main {
    public static void main(String[] args) {
        Event event = getEvent();
        java.util.Date now = new java.util.Date();
        System.out.println("now and " + event.getStartDate() + " = " + now.compareTo(event.getStartDate()));
        System.out.println("now and " + event.getEndDate() + " = " + now.compareTo(event.getEndDate()));
        System.out.println("now and " + event.getStartTime() + " = " + now.compareTo(event.getStartTime()));
        System.out.println("now and " + event.getEndTime() + " = " + now.compareTo(event.getEndTime()));
        System.out.println(DateUtils.isSameDay(now, event.getEndDate()));
        Calendar eventCalend = Calendar.getInstance();
        eventCalend.setTime(event.getEndDate());
        int eHour = eventCalend.get(Calendar.HOUR);
        int eMinute = eventCalend.get(Calendar.MINUTE);
        Calendar nowCalend = Calendar.getInstance();
        nowCalend.setTime(now);
        int nowHour = nowCalend.get(Calendar.HOUR);
        int nowMinute = nowCalend.get(Calendar.MINUTE);
        System.out.println("***********");
//        if(eHour)
    }

    private static Event getEvent() {
        Event event = new Event("qw");
        event.setStartDate(Date.valueOf("2017-10-25"));
        event.setEndDate(Date.valueOf("2017-11-02"));
        event.setStartTime(Time.valueOf("10:00:00"));
        event.setEndTime(Time.valueOf("16:00:00"));
        event.setDays(getDays(new int[]{1, 2, 3}, event));
        return event;
    }

    private static List<DayOfEvent> getDays(int[] ints, Event event) {
        List<DayOfEvent> dayOfEvents = new ArrayList<>();
        DayOfEvent day;
        for (int i : ints) {
            day = new DayOfEvent(event, i);
            dayOfEvents.add(day);
        }
        return dayOfEvents;
    }

    private void run(Event event) {
        System.out.println("run event: " + event.getName());
    }
}
