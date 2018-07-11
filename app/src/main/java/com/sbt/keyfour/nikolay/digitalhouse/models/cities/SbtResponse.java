package com.sbt.keyfour.nikolay.digitalhouse.models.cities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class SbtResponse {

    @SerializedName("cityID")
    @Expose
    private Integer cityID;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public SbtResponse(String fullname) {
        this.name = fullname;

    }



}
