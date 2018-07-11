package com.sbt.keyfour.nikolay.digitalhouse.models.cities;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CityListResponse {

    @SerializedName("result")
    @Expose
    private String result;

    @SerializedName("response")
    @Expose
    private List<SbtResponse> response =  new ArrayList<SbtResponse>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<SbtResponse> getResponse() {
        return response;
    }

    public void setResponse(List<SbtResponse> response) {
        this.response = response;
    }

}