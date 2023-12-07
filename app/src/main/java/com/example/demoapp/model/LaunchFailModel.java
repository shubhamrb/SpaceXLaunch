package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LaunchFailModel implements Serializable {
    @SerializedName("reason")
    String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "{" +
                "reason='" + reason + '\'' +
                '}';
    }
}
