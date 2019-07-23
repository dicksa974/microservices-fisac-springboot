package com.egokia.banniere.model;

import lombok.Data;

import java.util.Collection;

/**
 * Created by auth.c.parthasarathy
 */
@Data
public class BookingDetail {
    private Reservation reservation;
    private Collection<Venue> venues;

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Collection<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Collection<Venue> venues) {
        this.venues = venues;
    }
}