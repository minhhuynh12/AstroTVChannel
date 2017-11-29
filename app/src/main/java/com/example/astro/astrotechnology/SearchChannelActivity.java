package com.example.astro.astrotechnology;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.astro.astrotechnology.Adapter.SearchChannelAdapter;

import Model.EventSearchChannelItems;
import Model.Sample;
import Remote.MainService;
import Remote.MainUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vitinhHienAnh on 13-11-17.
 */

public class SearchChannelActivity extends AppCompatActivity {
    EditText editSearchChannel;
    RecyclerView recycSearchChannel;
    SearchChannelAdapter mAdapter;
    MainService mService;
    TextView tvNotifiSearchChannel;
    FrameLayout frameImgBackSearch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final EditText editSearchChannel;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_channel);
        editSearchChannel = (EditText) findViewById(R.id.editSearchChannel);

        recycSearchChannel = (RecyclerView) findViewById(R.id.recycSearchChannel);
        tvNotifiSearchChannel = (TextView) findViewById(R.id.tvNotifiSearchChannel);
        frameImgBackSearch = (FrameLayout) findViewById(R.id.frameImgBackSearch);
        Intent intent = this.getIntent();

        final Bundle bundle = intent.getBundleExtra("en");
        intent.putExtras(bundle);

        Sample thumbs = (Sample) bundle.getSerializable("values");


        editSearchChannel.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    recycSearchChannel.setVisibility(View.VISIBLE);
                    //recyclerView search channel
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchChannelActivity.this);
                    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycSearchChannel.setLayoutManager(linearLayoutManager);
                    mAdapter = new SearchChannelAdapter();
                    recycSearchChannel.setAdapter(mAdapter);

                    loadApi(editSearchChannel.getText().toString());

                    hideKeyboard();


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

//                    }


                    return true;
                }
                return false;
            }

        });

        frameImgBackSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchChannelActivity.super.onBackPressed();
            }
        });

        editSearchChannel.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                    hideKeyboardonFocusChange(SearchChannelActivity.this);
                } else {
                    showKeyboard(SearchChannelActivity.this);

                }
            }
        });

    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    private void loadApi(String keyWord) {
        mService = MainUtils.getServiceMain();
        mService.getDataSearch(keyWord).enqueue(new Callback<EventSearchChannelItems>() {
            @Override
            public void onResponse(Call<EventSearchChannelItems> call, Response<EventSearchChannelItems> response) {
                for (int i = 0; i < response.body().getEvents().size(); i++) {
                    mAdapter.setData(response.body().getEvents().get(i).getFields());
                }
                if (response.body().getEvents().isEmpty()) {
                    tvNotifiSearchChannel.setVisibility(View.VISIBLE);
                    tvNotifiSearchChannel.setText("Cannot find channel.");
                } else {
                    tvNotifiSearchChannel.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<EventSearchChannelItems> call, Throwable t) {

            }
        });
    }


    private void showKeyboard(Activity activity) {
        if (activity != null) {
            activity.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void hideKeyboardonFocusChange(Activity activity) {
        if (activity != null) {
            activity.getWindow()
                    .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }


}
