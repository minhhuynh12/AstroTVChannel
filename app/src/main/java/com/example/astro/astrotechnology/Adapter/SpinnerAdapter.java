package com.example.astro.astrotechnology.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.util.List;

import Model.SpinnerItems;

/**
 * Created by vitinhHienAnh on 06-05-18.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<SpinnerItems> itemsList;

    public SpinnerAdapter(Context context, int mylayout , List<SpinnerItems> itemsList){
        this.context = context;
        layout = mylayout;
        this.itemsList = itemsList;
    }

    public void setData(List<SpinnerItems> itemsList){
        this.itemsList = itemsList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        TextView tvSpinner = view.findViewById(R.id.tvSpinner);

        tvSpinner.setText(itemsList.get(position).getA());

        return view;
    }
}
