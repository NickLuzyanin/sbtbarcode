package com.sbt.keyfour.nikolay.digitalhouse.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sbt.keyfour.nikolay.digitalhouse.models.UserRequest;


public class SbtRequest {

    @SerializedName("command")
    @Expose
    private String command;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("request_id")
    @Expose
    private Integer requestId;
    @SerializedName("request")
    @Expose
    private UserRequest request;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public UserRequest getRequest() {
        return request;
    }

    public void setRequest(UserRequest request) {
        this.request = request;
    }

    }

