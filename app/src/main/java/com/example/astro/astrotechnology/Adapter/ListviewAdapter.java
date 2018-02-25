package com.example.astro.astrotechnology.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.util.List;

import Model.ListviewItems;

/**
 * Created by vitinhHienAnh on 20-02-18.
 */

public class ListviewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ListviewItems> list;

    MyInterface myInterface;
    public ListviewAdapter(Context context, int layout, List<ListviewItems> list, MyInterface myInterface) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.myInterface = myInterface;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class MyViewHolder {
        int position;
        ListviewItems data;
        TextView tv1;
        TextView tv2;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        final MyViewHolder holder;
        holder = new MyViewHolder();
        holder.data = list.get(pos);
        holder.position = pos;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);
        holder.tv1 = (TextView) view.findViewById(R.id.tvListview1);
        holder.tv2 = (TextView) view.findViewById(R.id.tvListview2);

        holder.tv1.setText(list.get(pos).getTv1());
        holder.tv2.setText(list.get(pos).getTv2());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myInterface != null){
                    myInterface.onClick(holder.position, holder.data);
                }
            }
        });

        return view;
    }


    public interface MyInterface {
        void onClick(int position, ListviewItems data);
    }
}
