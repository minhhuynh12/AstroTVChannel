package com.example.astro.astrotechnology;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by vitinhHienAnh on 21-11-17.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
    /*
    conflict
    super.onCreate();
     */


}
