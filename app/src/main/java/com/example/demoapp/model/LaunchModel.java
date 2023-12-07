package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LaunchModel implements Serializable {
    @SerializedName("flight_number")
    int flight_number;

    @SerializedName("mission_name")
    String mission_name;

    @SerializedName("upcoming")
    boolean upcoming;

    @SerializedName("launch_year")
    String launch_year;

    @SerializedName("launch_date_unix")
    long launch_date_unix;

    @SerializedName("launch_date_utc")
    String launch_date_utc;

    @SerializedName("launch_date_local")
    String launch_date_local;

    @SerializedName("is_tentative")
    boolean is_tentative;

    @SerializedName("tentative_max_precision")
    String tentative_max_precision;

    @SerializedName("tbd")
    boolean tbd;

    @SerializedName("launch_window")
    int launch_window;

    @SerializedName("rocket")
    RocketModel rocket;

    @SerializedName("launch_site")
    LaunchSiteModel launch_site;

    @SerializedName("launch_success")
    boolean launch_success;

    @SerializedName("launch_failure_details")
    LaunchFailModel launch_failure_details;

    @SerializedName("links")
    LinksModel links;

   /* @SerializedName("details")
    String details;*/


    public LaunchSiteModel getLaunch_site() {
        return launch_site;
    }

    public void setLaunch_site(LaunchSiteModel launch_site) {
        this.launch_site = launch_site;
    }

    public boolean isLaunch_success() {
        return launch_success;
    }

    public void setLaunch_success(boolean launch_success) {
        this.launch_success = launch_success;
    }

    public LaunchFailModel getLaunch_failure_details() {
        return launch_failure_details;
    }

    public void setLaunch_failure_details(LaunchFailModel launch_failure_details) {
        this.launch_failure_details = launch_failure_details;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(LinksModel links) {
        this.links = links;
    }

    /*public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }*/

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public boolean isUpcoming() {
        return upcoming;
    }

    public void setUpcoming(boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(String launch_year) {
        this.launch_year = launch_year;
    }

    public long getLaunch_date_unix() {
        return launch_date_unix;
    }

    public void setLaunch_date_unix(long launch_date_unix) {
        this.launch_date_unix = launch_date_unix;
    }

    public String getLaunch_date_utc() {
        return launch_date_utc;
    }

    public void setLaunch_date_utc(String launch_date_utc) {
        this.launch_date_utc = launch_date_utc;
    }

    public String getLaunch_date_local() {
        return launch_date_local;
    }

    public void setLaunch_date_local(String launch_date_local) {
        this.launch_date_local = launch_date_local;
    }

    public boolean isIs_tentative() {
        return is_tentative;
    }

    public void setIs_tentative(boolean is_tentative) {
        this.is_tentative = is_tentative;
    }

    public String getTentative_max_precision() {
        return tentative_max_precision;
    }

    public void setTentative_max_precision(String tentative_max_precision) {
        this.tentative_max_precision = tentative_max_precision;
    }

    public boolean isTbd() {
        return tbd;
    }

    public void setTbd(boolean tbd) {
        this.tbd = tbd;
    }

    public int getLaunch_window() {
        return launch_window;
    }

    public void setLaunch_window(int launch_window) {
        this.launch_window = launch_window;
    }

    public RocketModel getRocket() {
        return rocket;
    }

    public void setRocket(RocketModel rocket) {
        this.rocket = rocket;
    }

    @Override
    public String toString() {
        return "{" +
                "flight_number=" + flight_number +
                ", mission_name='" + mission_name + '\'' +
                ", upcoming=" + upcoming +
                ", launch_year='" + launch_year + '\'' +
                ", launch_date_unix=" + launch_date_unix +
                ", launch_date_utc='" + launch_date_utc + '\'' +
                ", launch_date_local='" + launch_date_local + '\'' +
                ", is_tentative=" + is_tentative +
                ", tentative_max_precision='" + tentative_max_precision + '\'' +
                ", tbd=" + tbd +
                ", launch_window=" + launch_window +
                ", rocket=" + rocket +
                ", launch_site=" + launch_site +
                ", launch_success=" + launch_success +
                ", launch_failure_details=" + launch_failure_details +
                ", links=" + links +
                '}';
    }
}
