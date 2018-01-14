package com.example.astro.astrotechnology;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.astro.astrotechnology.fragments.DetailChannelFragment;

import com.example.astro.astrotechnology.Adapter.MainAdapter;

import Model.ChannelFavoriteBundle;
import Model.ChannelItems;
import Model.MainItems;
import Model.Sample;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycMain;
    ImageView imgSearchMain, imgLikeMain, imgShowBar;
    FrameLayout frameFragment;
    MainAdapter mAdapter;
    MainService mService;
    Fragment frag;
    FragmentManager manager;
    FragmentTransaction fragmentTransaction;

    private static final String BACK_STACK_ROOT_TAG = "DetailChannelFragment";
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycMain = (RecyclerView) findViewById(R.id.recycMain);
        frameFragment = (FrameLayout) findViewById(R.id.frameFragment);
        imgSearchMain = (ImageView) findViewById(R.id.imgSearchMain);
        imgLikeMain = (ImageView) findViewById(R.id.imgLikeMain);
        imgShowBar = (ImageView) findViewById(R.id.imgShowBar);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        // load channel favorite
        imgShowBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Bundle bundle = new Bundle();

                ChannelFavoriteBundle channelFavoriteBundle = new ChannelFavoriteBundle();
                channelFavoriteBundle.list = mAdapter.listFavorite;
                Intent intent = new Intent(MainActivity.this, FavoriteActivity.class);
//                bundle.putSerializable("theListFavorite" , channelFavoriteBundle);
                intent.putExtra("listFavorite", channelFavoriteBundle);
                startActivity(intent);
            }
        });
        // to search channel
        imgSearchMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchChannelActivity.class);
                Bundle bundle = new Bundle();
                Sample sample = new Sample();
                sample.list = mAdapter.list;
                bundle.putSerializable("values", sample);
                intent.putExtra("en", bundle);
                startActivity(intent);

            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycMain.setLayoutManager(linearLayoutManager);

        mAdapter = new MainAdapter(this);
        recycMain.setAdapter(mAdapter);
        LoadApi();

        mAdapter.listFavorite.toString();

        /*
        conflict
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recycMain.setLayoutManager(linearLayoutManager);

         */


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        frameFragment.setVisibility(View.GONE);
        recycMain.setVisibility(View.VISIBLE);
    }

    //get all channel
    private void LoadApi() {
        mService = MainUtils.getServiceMain();
        mService.getMainListChannel().enqueue(new Callback<MainItems>() {
            @Override
            public void onResponse(Call<MainItems> call, Response<MainItems> response) {
                mAdapter.setData(response.body().getChannels());
            }

            @Override
            public void onFailure(Call<MainItems> call, Throwable t) {

            }
        });

        mAdapter.setOnItemClickListener(new MainAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                recycMain.setVisibility(view.GONE);
                frameFragment.setVisibility(view.VISIBLE);

//                imgLikeMain.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
////                if(toggle){
////                    imgLikeMain.setImageResource(R.drawable.img_liked);
////                }else {
////                    imgLikeMain.setImageResource(R.drawable.img_like);
////                }
//                        Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
//                    }
//                });

                ChannelItems item = mAdapter.getData(position);
                Bundle bundle = new Bundle();
                bundle.putString("channelId", item.getChannelId());

                if (bundle != null) {
                    frag = new DetailChannelFragment();
                    frag.setArguments(bundle);
//                    fragmentTransaction = getSupportFragmentManager().beginTransaction().addToBackStack(BACK_STACK_ROOT_TAG);
//                    fragmentTransaction.replace(R.id.frameFragment, frag);
//                    fragmentTransaction.commit();

                    manager = getSupportFragmentManager();
                    manager.beginTransaction()
                            .addToBackStack(BACK_STACK_ROOT_TAG)
                            .replace(R.id.frameFragment, frag)
                            .commit();
                }
            }

        });

    }


/*
    manager = getSupportFragmentManager();
                    manager.beginTransaction()
                            .addToBackStack(BACK_STACK_ROOT_TAG)
                            .replace(R.id.frameFragment, frag)
                            .commit();
                            
 */


}
