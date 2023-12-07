package com.example.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.model.LaunchModel;

import java.util.ArrayList;
import java.util.List;

public class StagesAdapter extends RecyclerView.Adapter<StagesAdapter.ViewHolder> {

    private Context mContext;
    private View root;
    private List<LaunchModel> list;
    private OnClickListener listener;

    public StagesAdapter(Context mContext, OnClickListener listener) {
        this.mContext = mContext;
        this.listener = listener;
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        root = LayoutInflater.from(mContext).inflate(R.layout.launch_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list.size() > 0) {
            LaunchModel model = list.get(position);
            holder.txt_mission_name.setText("Mission Name : " + model.getMission_name());
            holder.txt_launch_year.setText("Launch Year : " + model.getLaunch_year());
            holder.txt_rocket_name.setText("Rocket Name : " + model.getRocket().getRocket_name());
            holder.itemView.setOnClickListener(v -> listener.onClick(model));
        }
    }

    public interface OnClickListener {
        void onClick(LaunchModel model);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setList(List<LaunchModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView txt_mission_name, txt_launch_year, txt_rocket_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_mission_name = itemView.findViewById(R.id.txt_mission_name);
            txt_launch_year = itemView.findViewById(R.id.txt_launch_year);
            txt_rocket_name = itemView.findViewById(R.id.txt_rocket_name);
        }
    }
}
