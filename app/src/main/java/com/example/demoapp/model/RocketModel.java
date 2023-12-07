package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RocketModel implements Serializable {
    @SerializedName("rocket_id")
    String rocket_id;

    @SerializedName("rocket_name")
    String rocket_name;

    @SerializedName("rocket_type")
    String rocket_type;

    @SerializedName("first_stage")
    FirstStageModel first_stage;

    public String getRocket_id() {
        return rocket_id;
    }

    public void setRocket_id(String rocket_id) {
        this.rocket_id = rocket_id;
    }

    public String getRocket_name() {
        return rocket_name;
    }

    public void setRocket_name(String rocket_name) {
        this.rocket_name = rocket_name;
    }

    public String getRocket_type() {
        return rocket_type;
    }

    public void setRocket_type(String rocket_type) {
        this.rocket_type = rocket_type;
    }

    public FirstStageModel getFirst_stage() {
        return first_stage;
    }

    public void setFirst_stage(FirstStageModel first_stage) {
        this.first_stage = first_stage;
    }

    @Override
    public String toString() {
        return "{" +
                "rocket_id='" + rocket_id + '\'' +
                ", rocket_name='" + rocket_name + '\'' +
                ", rocket_type='" + rocket_type + '\'' +
                ", first_stage=" + first_stage +
                '}';
    }
}
