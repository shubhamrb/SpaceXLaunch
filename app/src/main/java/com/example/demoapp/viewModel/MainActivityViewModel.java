package com.example.demoapp.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.demoapp.api.APIClient;
import com.example.demoapp.api.APIInterface;
import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private APIInterface apiInterface;
    private MutableLiveData<JsonArray> apiResponse = new MutableLiveData<>();

    public void getLaunches() {
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<JsonArray> call = apiInterface.getLaunches();
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

                if (response.body() != null) {
                    Log.e("Response : ", response.body().toString());
                    apiResponse.setValue(response.body());
                } else {
                    apiResponse.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public LiveData<JsonArray> getLaunchResponse() {
        return apiResponse;
    }
}
