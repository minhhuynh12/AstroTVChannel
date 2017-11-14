package com.example.astro.astrotechnology;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.astro.astrotechnology.fragments.DetailChannelFragment;

import Adapter.MainAdapter;
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
    ImageView imgSearchMain;
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
        imgSearchMain = (ImageView) findViewById(R.id.imgSearchMain);

        imgSearchMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchChannelActivity.class);
                Bundle bundle = new Bundle();
                Sample sample = new Sample();
                sample.list = mAdapter.list;
                bundle.putSerializable("values", sample);
                intent.putExtra("en",bundle);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycMain.setLayoutManager(linearLayoutManager);

        mAdapter = new MainAdapter();
        recycMain.setAdapter(mAdapter);
        LoadApi();

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

                ChannelItems item = mAdapter.getData(position);
                Bundle bundle = new Bundle();
                bundle.putString("channelId", item.getChannelId());


                frag = new DetailChannelFragment();
                frag.setArguments(bundle);
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameFragment, frag);
                fragmentTransaction.commit();
            }
        });
    }
}
