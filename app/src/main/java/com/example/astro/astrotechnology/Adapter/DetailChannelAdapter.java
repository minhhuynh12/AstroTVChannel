package com.example.astro.astrotechnology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import Model.GetEventItems;

/**
 * Created by vitinhHienAnh on 11-11-17.
 */

public class DetailChannelAdapter extends RecyclerView.Adapter<DetailChannelAdapter.ViewHolder> {
    List<GetEventItems> list;
    Context context;
    public DetailChannelAdapter( Context context){
        list = new ArrayList<>();
        this.context=context;
    }

    public void setData(List<GetEventItems> list){
        this.list = list;
        notifyDataSetChanged();
    }

    public GetEventItems getData(int position){ return list.get(position);}

    @Override
    public DetailChannelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_detail_channel_items , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailChannelAdapter.ViewHolder holder, int position) {
        holder.tvChannelTitle.setText(list.get(position).getChannelTitle());
        holder.tvProgramTitle.setText(list.get(position).getProgrammeTitle());
        holder.tvShortSysnopsis.setText(list.get(position).getShortSynopsis());
        holder.tvDisplayDateNameUTC.setText(list.get(position).getDisplayDateTimeUtc());
        holder.tvDisplayDate.setText(list.get(position).getDisplayDateTime());
        Picasso.with(context).load(list.get(position).getEpgEventImage()).placeholder(R.drawable.astro).resize(50 , 50).into(holder.imgDetailChannel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvChannelTitle, tvProgramTitle , tvShortSysnopsis , tvDisplayDateNameUTC , tvDisplayDate;
        ImageView imgDetailChannel;
        public ViewHolder(View itemView) {
            super(itemView);
            tvChannelTitle = itemView.findViewById(R.id.tvChannelTitle);
            tvProgramTitle = itemView.findViewById(R.id.tvProgramTitle);
            tvShortSysnopsis = itemView.findViewById(R.id.tvShortSysnopsis);
            tvDisplayDateNameUTC = itemView.findViewById(R.id.tvDisplayDateNameUTC);
            tvDisplayDate = itemView.findViewById(R.id.tvDisplayDate);
            imgDetailChannel = itemView.findViewById(R.id.imgDetailChannel);
        }
    }
}
