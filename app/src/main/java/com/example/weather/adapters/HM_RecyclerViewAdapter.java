package com.example.weather.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.repository.weather.data.Hour;

import java.util.List;

public class HM_RecyclerViewAdapter extends RecyclerView.Adapter<HM_RecyclerViewAdapter.MyViewHolder> {
    private List<Hour> hours;
    private Context context;

    public HM_RecyclerViewAdapter(List<Hour> hours, Context context) {
        this.hours = hours;
        this.context = context;
    }

    @NonNull
    @Override
    public HM_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new HM_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HM_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.temperature.setText(String.format("%s°C", (int)hours.get(position).getTemp_c()));
        switch (hours.get(position).getCondition().getCode()) {
            case 1000:
                if (hours.get(position).getIs_day() == 1) {
                    holder.icon.setImageResource(R.drawable.sun);
                } else {
                    holder.icon.setImageResource(R.drawable.moon);
                }
                break;
            case 1273:
            case 1180:
            case 1183:
            case 1246:
            case 1063:
                holder.icon.setImageResource(R.drawable.rainy);
                break;
            default:
                holder.icon.setImageResource(R.drawable.cloudy);
                break;
        }
        if (position <= 12) holder.time.setText(String.format("%dAM", position));
        else holder.time.setText(String.format("%dPM", position % 12));
    }

    @Override
    public int getItemCount() {
        return 24;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView temperature, time;
        ImageView icon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            temperature = itemView.findViewById(R.id.TV_listitem_temperature);
            time = itemView.findViewById(R.id.TV_listitem_time);
            icon = itemView.findViewById(R.id.IV_listitem_icon);
        }
    }
}
