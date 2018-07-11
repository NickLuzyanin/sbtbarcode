package com.sbt.keyfour.nikolay.digitalhouse.models.streets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SbtStreetResponse {

    @SerializedName("StreetID")
    @Expose
    private Integer streetID;
    @SerializedName("Streetname")
    @Expose
    private String streetname;

    public Integer getCityID() {
        return streetID;
    }

    public Integer getStreetID() {
        return streetID;
    }

    public void setStreetID(Integer streetID) {
        this.streetID = streetID;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }
}
