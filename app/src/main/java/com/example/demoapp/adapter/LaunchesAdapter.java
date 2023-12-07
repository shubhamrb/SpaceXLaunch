package com.example.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.model.LaunchModel;

import java.util.ArrayList;
import java.util.List;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {

    private Context mContext;
    private View root;
    private List<LaunchModel> list;
    private OnClickListener listener;
    private boolean isBookmarked;

    public LaunchesAdapter(Context mContext, OnClickListener listener, boolean isBookmarked) {
        this.mContext = mContext;
        this.listener = listener;
        list = new ArrayList<>();
        this.isBookmarked = isBookmarked;
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
            if (isBookmarked) {
                holder.btn_bookmark.setVisibility(View.GONE);
            } else {
                holder.btn_bookmark.setVisibility(View.VISIBLE);
            }
            holder.btn_bookmark.setOnClickListener(v -> {
                listener.onBookmark(model);
            });
            holder.itemView.setOnClickListener(v -> listener.onClick(model));
        }
    }

    public interface OnClickListener {
        void onClick(LaunchModel model);

        void onBookmark(LaunchModel model);
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
        private ImageView btn_bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_mission_name = itemView.findViewById(R.id.txt_mission_name);
            txt_launch_year = itemView.findViewById(R.id.txt_launch_year);
            txt_rocket_name = itemView.findViewById(R.id.txt_rocket_name);
            btn_bookmark = itemView.findViewById(R.id.btn_bookmark);
        }
    }
}
