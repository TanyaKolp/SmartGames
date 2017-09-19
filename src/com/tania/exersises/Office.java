package com.tania.exersises;

import com.tania.Visitor;

import java.util.*;

/**
 * Created by tania on 28.02.17.
 */
public class Office {
    Set<Visitor> visitors = new HashSet<>();

    public void arrive(Visitor visitor) {
        visitors.add(visitor);
        visitor.setArrivalTime(new Date(0, 0, 0, (int) (Math.random() * 23), (int) (Math.random() * 59)));
    }

    public void leave(Visitor visitor) {
        int hour = visitor.getArrivalTime().getHours();
        hour = hour + (int) (Math.random() * (24 - hour));
        int minute = visitor.getArrivalTime().getMinutes();
        minute = minute + (int) (Math.random() * (59 - minute));
        visitor.setDepartureTime(new Date(0, 0, 0, hour, minute));
    }

    public Visitor findTimeInterval() {
        Visitor timeInterval = null;
        Date start = null;
        Date end;
        int counter = 0;
        Visitor[] arrive = sortByArrive(visitors);
        Visitor[] leave = sortByLeave(visitors);
        for (int i = 0; i < arrive.length; i++) {
            if (start == null || start.before(arrive[i].getArrivalTime())) {
                start = arrive[i].getArrivalTime();
            }
            counter++;
        }
        return timeInterval;
    }

    private Visitor[] sortByArrive(Set<Visitor> visitors) {
        Visitor[] sortedArray = (Visitor[]) visitors.toArray();
        Arrays.sort(sortedArray, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                if (o1.getArrivalTime().equals(o2.getArrivalTime())) {
                    return 0;
                } else if (o1.getArrivalTime().after(o2.getArrivalTime())) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return sortedArray;
    }

    private Visitor[] sortByLeave(Set<Visitor> visitors) {
        Visitor[] sortedArray = (Visitor[]) visitors.toArray();
        Arrays.sort(sortedArray, new Comparator<Visitor>() {
            @Override
            public int compare(Visitor o1, Visitor o2) {
                if (o1.getDepartureTime().equals(o2.getDepartureTime())) {
                    return 0;
                } else if (o1.getDepartureTime().after(o2.getDepartureTime())) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        return sortedArray;
    }
}
