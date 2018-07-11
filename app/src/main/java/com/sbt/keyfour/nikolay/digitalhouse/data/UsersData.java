package com.sbt.keyfour.nikolay.digitalhouse.data;

import java.util.UUID;

public class UsersData {

    private UUID mId;

    private String mStreetName;
    private String mHomeNumber;
    private String mApartmentNumber;
    private String mMetterNumber;
    private String mHVScount;
    private String mGVScount;


    public UsersData(){

        mId = UUID.randomUUID();
    }




}
