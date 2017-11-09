package com.example.astro.astrotechnology;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import Adapter.MainAdapter;
import Model.MainItems;
import Remote.MainService;
import Remote.MainUtils;
import com.example.astro.astrotechnology.fragments.DetailChannelFragment;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycMain;
    FrameLayout frameFragment;
    MainAdapter mAdapter;
    MainService mService;
    Fragment frag;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycMain = (RecyclerView) findViewById(R.id.recycMain);
        frameFragment = (FrameLayout) findViewById(R.id.frameFragment);


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
                mAdapter.setOnItemClickListener(new MainAdapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View view) {
                        recycMain.setVisibility(view.GONE);
                        frameFragment.setVisibility(view.VISIBLE);
                    frag = new DetailChannelFragment();
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frameFragment , frag);
                        fragmentTransaction.commit();



                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }
}
