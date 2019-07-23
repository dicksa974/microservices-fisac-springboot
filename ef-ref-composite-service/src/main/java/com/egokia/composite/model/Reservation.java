package com.egokia.composite.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * Created by auth.c.parthasarathy
 */
@Data
@ToString
public class Reservation {
    @NotNull
    @ApiModelProperty(example = "Patrick", required = true)
    private String firstName;

    @NotNull
    @ApiModelProperty(example = "Adams", required = true)
    private String lastName;

    public String getReservationName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
