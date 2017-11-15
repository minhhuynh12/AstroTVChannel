package com.example.astro.astrotechnology;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

import Model.ChannelItems;
import Model.Sample;

import static android.R.attr.data;

/**
 * Created by vitinhHienAnh on 13-11-17.
 */

public class SearchChannelActivity extends AppCompatActivity {
    EditText editSearchChannel;
    TextView tvShowChannel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final EditText editSearchChannel;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_channel);
        editSearchChannel = (EditText) findViewById(R.id.editSearchChannel);
        tvShowChannel = (TextView) findViewById(R.id.tvShowChannel);
        Intent intent = this.getIntent();

        final Bundle bundle = intent.getBundleExtra("en");
        intent.putExtras(bundle);

        Sample thumbs= (Sample)bundle.getSerializable("values");
        Log.d("ddddd" , "values " + thumbs.getList().toString());

        editSearchChannel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String input;
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    if(bundle != null){
                        Sample thumbs= (Sample)bundle.getSerializable("values");
                        for (ChannelItems s : thumbs.getList()) {
                            Log.d("aaaaaaa" , "values " + editSearchChannel.getText().toString());
                            if(editSearchChannel.getText().toString().equals(s.getChannelTitle())){
                                tvShowChannel.setText(s.getChannelTitle());
                            }

                        }

                    }

//                    input= v.getText().toString();
//                    Toast toast= Toast.makeText(SearchChannelActivity.this,input,
//                            Toast.LENGTH_LONG);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    toast.show();
                    return true;
                }
                return false;
            }
        });


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
