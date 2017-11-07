package com.example.astro.astrotechnology;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MainAdapter;
import Model.MainItems;
import Remote.MainService;
import Remote.MainUtils;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycMain;
    MainAdapter mAdapter;
    MainService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycMain = (RecyclerView) findViewById(R.id.recycMain);

//        ArrayList<MainItems> itemses = new ArrayList<>();
//        itemses.add(new MainItems("minh","huynh","cong"));
//        itemses.add(new MainItems("minh","huynh","cong"));
//        itemses.add(new MainItems("minh","huynh","cong"));
//        itemses.add(new MainItems("minh","huynh","cong"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycMain.setLayoutManager(linearLayoutManager);


        mAdapter = new MainAdapter();
        recycMain.setAdapter(mAdapter);
        LoadApi();

    }

    private void LoadApi() {
        Log.d("connect load api" , "aaaaaaaa");
        mService = MainUtils.getServiceMain();
        mService.getMainListChannel().enqueue(new Callback<MainItems>() {
            @Override
            public void onResponse(Response<MainItems> response, Retrofit retrofit) {
                mAdapter.setData(response.body().getChannels());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
