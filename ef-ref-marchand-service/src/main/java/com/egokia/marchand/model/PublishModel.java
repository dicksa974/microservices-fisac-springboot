package com.egokia.marchand.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by auth.c.parthasarathy
 */
@Data
public class PublishModel implements Serializable {

    private static final long serialVersionUID = 5672689509808851922L;
    private String reservationName;
    private long id;

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
