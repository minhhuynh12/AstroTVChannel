package com.example.astro.astrotechnology.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.astro.astrotechnology.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.astro.astrotechnology.Adapter.DetailChannelAdapter;
import Model.DetailChannelItems;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by imac on 11/9/17.
 */

public class DetailChannelFragment extends Fragment implements View.OnClickListener {

    SimpleDateFormat DesiredFormat = new SimpleDateFormat("yyyy-MM-dd");
    RecyclerView recycDetailChannel;
    MainService mService;
    DetailChannelAdapter mAdapter;
    Button btnPopUpTime;
    private Dialog dialog;
    TextView tvTimer;
    String timer = " ";
    String day = " ";
    String month = " ";
    String year = " ";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_channel, container, false);
        recycDetailChannel = view.findViewById(R.id.recycDetailChannel);
        btnPopUpTime = view.findViewById(R.id.btnPopUpTime);
        tvTimer = view.findViewById(R.id.tvTimer);

        btnPopUpTime.setOnClickListener(this);


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

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnPopUpTime:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.layout_popup_timer);
        dialog.show();

        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        day = String.valueOf(mDay);
        month = String.valueOf(mMonth +1);
        year = String.valueOf(mYear);

        Button btnSubmit = dialog.findViewById(R.id.btnSubmit);
        Button btnCannal = dialog.findViewById(R.id.btnCannal);
        final com.shawnlin.numberpicker.NumberPicker numberTimerDay = dialog.findViewById(R.id.numberTimerDay);
        final com.shawnlin.numberpicker.NumberPicker numberTimerMonth = dialog.findViewById(R.id.numberTimerMonth);
        final com.shawnlin.numberpicker.NumberPicker numberTimerYear = dialog.findViewById(R.id.numberTimerYear);

        numberTimerDay.setValue(mDay);
        numberTimerMonth.setValue(mMonth +1);
        numberTimerYear.setValue(mYear);

        btnCannal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        numberTimerDay.setOnValueChangedListener(new com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(com.shawnlin.numberpicker.NumberPicker picker, int oldVal, int newVal) {
                day = String.valueOf(newVal);
            }
        });

        numberTimerMonth.setOnValueChangedListener(new com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(com.shawnlin.numberpicker.NumberPicker picker, int oldVal, int newVal) {
                month = String.valueOf(newVal);
            }
        });

        numberTimerYear.setOnValueChangedListener(new com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(com.shawnlin.numberpicker.NumberPicker picker, int oldVal, int newVal) {
                year = String.valueOf(newVal);
            }
        });



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer = day + "/" + month + "/" + year;
                tvTimer.setText(timer);
                dialog.dismiss();
            }
        });

    }
}
