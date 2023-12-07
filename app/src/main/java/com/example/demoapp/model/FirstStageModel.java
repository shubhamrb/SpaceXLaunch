package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FirstStageModel implements Serializable {
    @SerializedName("cores")
    List<CoresModel> cores;

    public List<CoresModel> getCores() {
        return cores;
    }

    public void setCores(List<CoresModel> cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return "{" +
                "cores=" + cores +
                '}';
    }
}
