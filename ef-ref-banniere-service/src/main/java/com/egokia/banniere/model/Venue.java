package com.egokia.banniere.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Aniruth Parthasarathy
 */
@Data
@ToString
public class Venue {
    @ApiModelProperty(example = "Wunsch and Sons", required = true)
    private String venueName;
    @ApiModelProperty(example = "true", required = false)
    private boolean isAvailable;

    @ApiModelProperty(example = "47", required = true)
    private long reservationId;
    @ApiModelProperty(example = "2004-06-20 17:51:58", required = true)
    private String bookingDate;
    private String personName;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
