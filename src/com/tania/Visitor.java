package com.tania;

import java.util.Date;

/**
 * Created by tania on 28.02.17.
 */
public class Visitor {
    private Date arrivalTime;
    private Date departureTime;

    public Visitor(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
