package com.example.astro.astrotechnology.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.astro.astrotechnology.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by imac on 11/9/17.
 */

public class DetailChannelFragment extends Fragment {

    SimpleDateFormat DesiredFormat = new SimpleDateFormat("MM/dd/yyyy HH:MM:SS a");
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_channel, container , false );
        Date currentTime = Calendar.getInstance().getTime();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        Date newDate = calendar.getTime();
        String formattedDate = DesiredFormat.format(newDate.getTime());

        Log.d("real time: " , "values: " + formattedDate);
        return view;
    }
}
