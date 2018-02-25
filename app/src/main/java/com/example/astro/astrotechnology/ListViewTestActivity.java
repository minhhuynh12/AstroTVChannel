package com.example.astro.astrotechnology;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.astro.astrotechnology.Adapter.ListviewAdapter;

import java.util.ArrayList;

import Model.ListviewItems;

/**
 * Created by vitinhHienAnh on 20-02-18.
 */

public class ListViewTestActivity extends AppCompatActivity implements ListviewAdapter.MyInterface{
    private ListView listView;
    private ListviewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<ListviewItems> list = new ArrayList<>();
        list.add(new ListviewItems("minh" , "huynh"));
        list.add(new ListviewItems("minh" , "huynh"));
        list.add(new ListviewItems("minh" , "huynh"));
        list.add(new ListviewItems("minh" , "huynh"));
        list.add(new ListviewItems("minh" , "huynh"));

        mAdapter = new ListviewAdapter(this, R.layout.activity_listview_items, list, this);
        listView.setAdapter(mAdapter);




    }

    @Override
    public void onClick(int position, ListviewItems data) {
        Log.d("Activity","position " + position);
    }
}
