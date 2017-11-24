package com.example.astro.astrotechnology;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import Model.ChannelFavorite;
import Model.ChannelFavoriteBundle;

/**
 * Created by vitinhHienAnh on 22-11-17.
 */

public class TestPopUpActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_popup);

        context = this;

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
        Intent intent = this.getIntent();

        final Bundle bundle = intent.getBundleExtra("listFavorite");


        if(bundle != null){
            ChannelFavoriteBundle channelFavoriteBundle = (ChannelFavoriteBundle) bundle.getSerializable("theListFavorite");
            for (ChannelFavorite data : channelFavoriteBundle.getList()) {
                Log.d("ppppp" , "list: " + data.getChannelId().toString());
            }
            //Log.d("ppppp" , "list: " + values);
        }
    }
    }
