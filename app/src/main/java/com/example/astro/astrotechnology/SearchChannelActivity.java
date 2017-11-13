package com.example.astro.astrotechnology;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by vitinhHienAnh on 13-11-17.
 */

public class SearchChannelActivity extends AppCompatActivity {
    EditText editSearchChannel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_channel);
        editSearchChannel = (EditText) findViewById(R.id.editSearchChannel);
//        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//        im.showSoftInput(editSearchChannel, InputMethodManager.SHOW_IMPLICIT);

        editSearchChannel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){

                    hideKeyboard(SearchChannelActivity.this);
                }else {
                    showKeyboard(SearchChannelActivity.this);
                }
            }
        });


    }

    private void showKeyboard(Activity activity) {
        if(activity != null){
            activity.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void hideKeyboard(Activity activity) {
        if (activity != null) {
            activity.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }
}
