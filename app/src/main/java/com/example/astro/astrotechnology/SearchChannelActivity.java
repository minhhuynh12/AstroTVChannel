package com.example.astro.astrotechnology;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import Adapter.SearchChannelAdapter;
import Model.ChannelItems;
import Model.EventSearchChannelItems;
import Model.FieldsSearchChannelItems;
import Model.Sample;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.data;

/**
 * Created by vitinhHienAnh on 13-11-17.
 */

public class SearchChannelActivity extends AppCompatActivity {
    EditText editSearchChannel;
    RecyclerView recycSearchChannel;
    SearchChannelAdapter mAdapter;
    MainService mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final EditText editSearchChannel;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_channel);
        editSearchChannel = (EditText) findViewById(R.id.editSearchChannel);

        recycSearchChannel = (RecyclerView) findViewById(R.id.recycSearchChannel);
        Intent intent = this.getIntent();

        final Bundle bundle = intent.getBundleExtra("en");
        intent.putExtras(bundle);

        Sample thumbs= (Sample)bundle.getSerializable("values");


        editSearchChannel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String input;
                if(actionId == EditorInfo.IME_ACTION_DONE)
                {
                    recycSearchChannel.setVisibility(View.VISIBLE);
                    //recyclerView search channel
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchChannelActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycSearchChannel.setLayoutManager(linearLayoutManager);
                    mAdapter = new SearchChannelAdapter();
                    recycSearchChannel.setAdapter(mAdapter);

                    loadApi(editSearchChannel.getText().toString());




                    //Search to bundle
//                    if(bundle != null){
//                        Sample thumbs= (Sample)bundle.getSerializable("values");
//                        for (ChannelItems s : thumbs.getList()) {
//                            Log.d("aaaaaaa" , "values " + editSearchChannel.getText().toString());
//                            editSearchChannel.getText().toString().equals(s.getChannelTitle());
//                            if(editSearchChannel.getText().toString().equals(s.getChannelTitle())){
//                                tvShowChannel.setText(s.getChannelTitle().toString());
//                            }
//
//                        }
//
//                    }


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

    private void loadApi(String keyWord) {
        mService = MainUtils.getServiceMain();
        mService.getDataSearch(keyWord).enqueue(new Callback<EventSearchChannelItems>() {
            @Override
            public void onResponse(Call<EventSearchChannelItems> call, Response<EventSearchChannelItems> response) {
                for (int i = 0; i < response.body().getEvents().size(); i++) {
                    mAdapter.setData(response.body().getEvents().get(i).getFields());
                }

            }

            @Override
            public void onFailure(Call<EventSearchChannelItems> call, Throwable t) {

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
