package com.example.demoapp.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/v3/launches")
    Call<JsonArray> getLaunches();
}
