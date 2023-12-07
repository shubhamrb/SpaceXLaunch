package com.example.demoapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.demoapp.databinding.ActivityDetailsBinding;
import com.example.demoapp.model.LaunchModel;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    private LaunchModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().hasExtra("model")) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                model = getIntent().getSerializableExtra("model", LaunchModel.class);
            } else {
                model = (LaunchModel) getIntent().getSerializableExtra("model");
            }

            if (model != null) {
                binding.txtMissionName.setText("Mission Name : " + model.getMission_name());
                binding.txtLaunchYear.setText("Launch Year : " + model.getLaunch_year());
                binding.txtRocketName.setText("Rocket Name : " + model.getRocket().getRocket_name());
                binding.txtLaunchSite.setText("Launch Stile : " + model.getLaunch_site().getSite_name());

                if (model.isLaunch_success()) {
                    binding.txtRocketName.setText("Launch Status : Success");
                } else {
                    binding.txtRocketName.setText("Launch Status : Failed ( " + model.getLaunch_failure_details().getReason() + " )");
                }
                Glide.with(this).load(model.getLinks().getMission_patch_small()).into(binding.missionPatchImage);

                binding.txtArticle.setText(model.getLinks().getArticle_link());
            }


        }
    }
}