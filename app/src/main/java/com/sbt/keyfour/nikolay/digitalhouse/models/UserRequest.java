package com.sbt.keyfour.nikolay.digitalhouse.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRequest {

        @SerializedName("str")
        @Expose
        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

    }

