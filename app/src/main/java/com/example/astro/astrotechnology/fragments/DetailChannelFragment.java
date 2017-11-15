package com.example.astro.astrotechnology.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astro.astrotechnology.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Adapter.DetailChannelAdapter;
import Model.DetailChannelItems;
import Model.GetEventItems;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by imac on 11/9/17.
 */

public class DetailChannelFragment extends Fragment {

    SimpleDateFormat DesiredFormat = new SimpleDateFormat("yyyy-MM-dd");
    RecyclerView recycDetailChannel;
    MainService mService;
    DetailChannelAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_channel, container, false);
        recycDetailChannel = view.findViewById(R.id.recycDetailChannel);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycDetailChannel.setLayoutManager(linearLayoutManager);
        mAdapter = new DetailChannelAdapter(getContext());
        recycDetailChannel.setAdapter(mAdapter);

        //get channelId
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String chennalId = bundle.getString("channelId");
            String newChennalId = "[" + chennalId + "]";
//            List<String> list = new ArrayList<>();
//            list.add(chennalId);
//            list.add(chennalId);
            //list[0] = chennalId;


            //current time
            Date currentTime = Calendar.getInstance().getTime();
            String currentDate = DesiredFormat.format(currentTime.getTime());

            // next day
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentTime);
            calendar.add(Calendar.DAY_OF_YEAR, +1);
            Date newDate = calendar.getTime();
            String formattedDate = DesiredFormat.format(newDate.getTime());
            LoadApiDetailChannel(newChennalId, currentDate, formattedDate);
        }
        return view;
    }


    private void LoadApiDetailChannel(String channelID, String periodStart, String periodEnd) {
        mService = MainUtils.getServiceMain();
        mService.getDetailChannel(channelID, periodStart, periodEnd).enqueue(new Callback<DetailChannelItems>() {
            @Override
            public void onResponse(Call<DetailChannelItems> call, Response<DetailChannelItems> response) {
                mAdapter.setData(response.body().getGetEvent());
            }

            @Override
            public void onFailure(Call<DetailChannelItems> call, Throwable t) {

            }
        });

    }
}
