package com.example.demoapp.activity;

import static com.example.demoapp.utils.AppConstant.SHARED_PREF_BOOKMARK;
import static com.example.demoapp.utils.AppConstant.SHARED_PREF_LAUNCH_DATA;
import static com.example.demoapp.utils.AppConstant.SHARED_PREF_NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.adapter.LaunchesAdapter;
import com.example.demoapp.databinding.ActivityMainBinding;
import com.example.demoapp.model.LaunchModel;
import com.example.demoapp.viewModel.MainActivityViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LaunchesAdapter.OnClickListener {

    MainActivityViewModel viewModel;
    ActivityMainBinding binding;
    LaunchesAdapter launchesAdapter, launchesBookmarkAdapter;
    private SharedPreferences sharedPreferences;
    private List<LaunchModel> bookmarkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        bookmarkList = new ArrayList<>();
        viewModel.getLaunchResponse().observe(this, jsonArray -> {
            binding.pullToRefresh.setRefreshing(false);
            if (launchesAdapter != null) {
                Type launches = new TypeToken<List<LaunchModel>>() {
                }.getType();

                List<LaunchModel> list = new Gson().fromJson(jsonArray.toString(), launches);
                sharedPreferences.edit().putString(SHARED_PREF_LAUNCH_DATA, list.toString()).apply();
                launchesAdapter.setList(list);
            }
        });

        binding.pullToRefresh.setOnRefreshListener(() -> {
            binding.pullToRefresh.setRefreshing(true);
            viewModel.getLaunches();
        });
        setUpLauchesRecycler();

        getBookmark();
    }

    private void getBookmark() {
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerViewBookmark.setLayoutManager(manager);
        binding.recyclerViewBookmark.setItemAnimator(null);
        launchesBookmarkAdapter = new LaunchesAdapter(this, this,true);
        binding.recyclerViewBookmark.setAdapter(launchesBookmarkAdapter);

        String data = sharedPreferences.getString(SHARED_PREF_BOOKMARK, null);
        if (data != null) {
            Type launches = new TypeToken<List<LaunchModel>>() {
            }.getType();

            bookmarkList = new Gson().fromJson(data, launches);

            if (bookmarkList.size() != 0) {
                launchesBookmarkAdapter.setList(bookmarkList);
                binding.bookmarkLabel.setVisibility(View.VISIBLE);
            } else {
                binding.bookmarkLabel.setVisibility(View.GONE);
            }
        } else {
            binding.bookmarkLabel.setVisibility(View.GONE);
        }
    }

    private void setUpLauchesRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(manager);
        binding.recyclerView.setItemAnimator(null);
        launchesAdapter = new LaunchesAdapter(this, this,false);
        binding.recyclerView.setAdapter(launchesAdapter);

        String data = sharedPreferences.getString(SHARED_PREF_LAUNCH_DATA, null);
        if (data != null) {
            Type launches = new TypeToken<List<LaunchModel>>() {
            }.getType();

            List<LaunchModel> list = new Gson().fromJson(data, launches);

            if (list.size() != 0) {
                launchesAdapter.setList(list);
                /*update the list*/
                viewModel.getLaunches();
            } else {
                viewModel.getLaunches();
            }
        } else {
            viewModel.getLaunches();
        }
    }

    @Override
    public void onClick(LaunchModel model) {
        startActivity(new Intent(this, DetailsActivity.class).putExtra("model", model));
    }

    @Override
    public void onBookmark(LaunchModel model) {
        bookmarkList.add(model);
        sharedPreferences.edit().putString(SHARED_PREF_BOOKMARK, bookmarkList.toString()).apply();

        if (bookmarkList.size() != 0) {
            binding.bookmarkLabel.setVisibility(View.VISIBLE);
        } else {
            binding.bookmarkLabel.setVisibility(View.GONE);
        }

        launchesBookmarkAdapter.setList(bookmarkList);
    }
}