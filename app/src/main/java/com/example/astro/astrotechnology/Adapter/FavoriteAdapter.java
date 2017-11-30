package com.example.astro.astrotechnology.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.util.ArrayList;
import java.util.List;

import Model.ChannelItems;

/**
 * Created by vitinhHienAnh on 29-11-17.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    List<ChannelItems> list;
    Context context;
    public FavoriteAdapter(){
        list = new ArrayList<>();
    }

    public void setdata(List<ChannelItems> listChannel){
        list = listChannel;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_favorite_items , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvChannelIdFavorite.setText(list.get(position).getChannelId());
        holder.tvTitlleChannelFavorite.setText(list.get(position).getChannelTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitlleChannelFavorite , tvChannelIdFavorite;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitlleChannelFavorite = itemView.findViewById(R.id.tvTitlleChannelFavorite);
            tvChannelIdFavorite = itemView.findViewById(R.id.tvChannelIdFavorite);
        }
    }
}
