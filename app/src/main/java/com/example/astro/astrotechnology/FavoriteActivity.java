package com.example.astro.astrotechnology;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.astro.astrotechnology.Adapter.FavoriteAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Model.ChannelFavorite;
import Model.ChannelFavoriteBundle;
import Model.ChannelItems;
import Model.MainItems;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vitinhHienAnh on 22-11-17.
 */

public class FavoriteActivity extends AppCompatActivity {
    Context context;
    private ChannelFavoriteBundle channelFavoriteBundle;
    private ChannelFavorite channelFavorite;
    FavoriteAdapter mAdapter;
    MainService mService;
    TextView tvNothingFavorite;
    RecyclerView recycFavorite;
    ArrayList<ChannelItems> results = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        context = this;
        recycFavorite = (RecyclerView) findViewById(R.id.recycFavorite);
        tvNothingFavorite = (TextView) findViewById(R.id.tvNothingFavorite);

//        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
//        builder1.setMessage("Write your message here.");
//        builder1.setCancelable(true);
//
//        builder1.setPositiveButton(
//                "Yes",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        builder1.setNegativeButton(
//                "No",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//                    }
//                });
//
//        AlertDialog alert11 = builder1.create();
//        alert11.show();
//        Intent intent = this.getIntent();
//
//        final Bundle bundle = intent.getBundleExtra("listFavorite");

        channelFavoriteBundle = (ChannelFavoriteBundle) getIntent().getSerializableExtra("listFavorite");

//<<<<<<< HEAD

        if (channelFavoriteBundle.list.size() > 0) {
            recycFavorite.setVisibility(View.VISIBLE);
            tvNothingFavorite.setVisibility(View.GONE);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            mAdapter = new FavoriteAdapter();
            recycFavorite.setLayoutManager(linearLayoutManager);
            recycFavorite.setAdapter(mAdapter);

            loadApi(channelFavoriteBundle.list);


        } else {
            recycFavorite.setVisibility(View.GONE);
            tvNothingFavorite.setVisibility(View.VISIBLE);
//=======
//        for (int i = 0; i < channelFavoriteBundle.list.size(); i++){
//            if(channelFavoriteBundle.list.get(i).isFavorite == true){
//                if(channelFavoriteBundle.list.size() > 0){
//                    recycFavorite.setVisibility(View.VISIBLE);
//                    tvNothingFavorite.setVisibility(View.GONE);
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//                    mAdapter = new FavoriteAdapter();
//                    recycFavorite.setLayoutManager(linearLayoutManager);
//                    recycFavorite.setAdapter(mAdapter);
//
//                    loadApi(channelFavoriteBundle.list);
//                }
//            }
////            else {
////                recycFavorite.setVisibility(View.GONE);
////                tvNothingFavorite.setVisibility(View.VISIBLE);
////            }
//            }
//>>>>>>> dev
        }
        }





    private void loadApi(final List<ChannelFavorite> listFavorited) {

        mService = MainUtils.getServiceMain();
        mService.getMainListChannel().enqueue(new Callback<MainItems>() {
            @Override
            public void onResponse(Call<MainItems> call, Response<MainItems> response) {

                results = new ArrayList<>();
                for ( ChannelItems data1  : response.body().getChannels() ) {
                    boolean found = false;
                    for ( ChannelFavorite data2 : listFavorited ) {
                        Log.d("ppppp" , "list: " + data2.getChannelId());

                        if(data2.isFavorite == true && data1.getChannelId().equals(data2.getChannelId())){
                            results.add(new ChannelItems(data1.getChannelId() , data1.getChannelTitle()));
                        }

//                        if(data1.getChannelId().equals(data2.getChannelId())){
//                            found = true;
//                        }
                    }
//                    if(found){
//
//
//                    }
                }

                mAdapter.setdata(results);

            }

            @Override
            public void onFailure(Call<MainItems> call, Throwable t) {

            }
        });
    }


}

