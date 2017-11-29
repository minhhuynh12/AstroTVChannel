package com.example.astro.astrotechnology.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.util.ArrayList;
import java.util.List;

import Model.SearchChannelItems;

/**
 * Created by vitinhHienAnh on 15-11-17.
 */

public class SearchChannelAdapter extends RecyclerView.Adapter<SearchChannelAdapter.ViewHolder> {
    List<SearchChannelItems> list;
    public SearchChannelAdapter(){
        list = new ArrayList<>();
    }

    public void setData(List<SearchChannelItems> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_search_channel_items, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvChannelTitle.setText(list.get(position).getChannelTitle());
        holder.tvChannelNumber.setText(list.get(position).getChannelStbNumber());
        holder.tvDisplayDataTime.setText(list.get(position).getDisplayDateTime());
        holder.tvDisplayEndDateTime.setText(list.get(position).getDisplayEndDateTime());
        holder.tvEventName.setText(list.get(position).getEventName());
        holder.tvEventDescription.setText(list.get(position).getEventDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChannelTitle, tvChannelNumber, tvDisplayDataTime, tvDisplayEndDateTime, tvEventName, tvEventDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            tvChannelTitle = itemView.findViewById(R.id.tvChannelTitle);
            tvChannelNumber = itemView.findViewById(R.id.tvChannelNumber);
            tvDisplayDataTime = itemView.findViewById(R.id.tvDisplayDataTime);
            tvDisplayEndDateTime = itemView.findViewById(R.id.tvDisplayEndDateTime);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvEventDescription = itemView.findViewById(R.id.tvEventDescription);
        }
    }
}
