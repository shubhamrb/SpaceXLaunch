package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CoresModel implements Serializable {
    @SerializedName("core_serial")
    String core_serial;

    @SerializedName("flight")
    int flight;

    @SerializedName("block")
    String block;

    @SerializedName("gridfins")
    boolean gridfins;

    @SerializedName("legs")
    boolean legs;

    @SerializedName("reused")
    boolean reused;

    @SerializedName("land_success")
    String land_success;

    @SerializedName("landing_intent")
    boolean landing_intent;

    @SerializedName("landing_type")
    String landing_type;

    @SerializedName("landing_vehicle")
    String landing_vehicle;

    public String getCore_serial() {
        return core_serial;
    }

    public void setCore_serial(String core_serial) {
        this.core_serial = core_serial;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public boolean isGridfins() {
        return gridfins;
    }

    public void setGridfins(boolean gridfins) {
        this.gridfins = gridfins;
    }

    public boolean isLegs() {
        return legs;
    }

    public void setLegs(boolean legs) {
        this.legs = legs;
    }

    public boolean isReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public String getLand_success() {
        return land_success;
    }

    public void setLand_success(String land_success) {
        this.land_success = land_success;
    }

    public boolean isLanding_intent() {
        return landing_intent;
    }

    public void setLanding_intent(boolean landing_intent) {
        this.landing_intent = landing_intent;
    }

    public String getLanding_type() {
        return landing_type;
    }

    public void setLanding_type(String landing_type) {
        this.landing_type = landing_type;
    }

    public String getLanding_vehicle() {
        return landing_vehicle;
    }

    public void setLanding_vehicle(String landing_vehicle) {
        this.landing_vehicle = landing_vehicle;
    }

    @Override
    public String toString() {
        return "{" +
                "core_serial='" + core_serial + '\'' +
                ", flight=" + flight +
                ", block='" + block + '\'' +
                ", gridfins=" + gridfins +
                ", legs=" + legs +
                ", reused=" + reused +
                ", land_success='" + land_success + '\'' +
                ", landing_intent=" + landing_intent +
                ", landing_type='" + landing_type + '\'' +
                ", landing_vehicle='" + landing_vehicle + '\'' +
                '}';
    }
}
