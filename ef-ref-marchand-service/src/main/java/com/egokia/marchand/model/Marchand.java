package com.egokia.marchand.model;

import com.sun.corba.se.spi.ior.ObjectId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@ToString
public class Marchand {

    @Id
    @ApiModelProperty(notes = "Unique identifier", example = "1", required = true, position = 0)
    private ObjectId _id;
    private Date creation;
    @ApiModelProperty(notes = "Nom Enseigne", example = "FoodTruck", required = true, position = 1)
    private String name;
    @ApiModelProperty(notes = "nom gérant", example = "John", required = true, position = 2)
    private String lastname;
    @ApiModelProperty(notes = "prénom gérant", example = "Doe", required = true, position = 3)
    private String firstname;
    @ApiModelProperty(notes = "activation", example = "True", position = 4)
    private Boolean activation;
    @ApiModelProperty(notes = "status", example = "STANDARD", required = true, position = 5)
    protected String status;
    @ApiModelProperty(notes = "site web", example = "www.site.re", position = 6)
    private String url;
    @ApiModelProperty(notes = "activité", example = "Restauration", required = true, position = 7)
    private String activity;

    public Marchand(ObjectId _id, Date creation, String name, String lastname, String firstname, Boolean activation, String status, String url, String activity) {
        this._id = _id;
        this.creation = creation;
        this.name = name;
        this.lastname = lastname;
        this.firstname = firstname;
        this.activation = activation;
        this.status = status;
        this.url = url;
        this.activity = activity;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getActivation() {
        return activation;
    }

    public void setActivation(Boolean activation) {
        this.activation = activation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
