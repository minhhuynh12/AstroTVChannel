package com.example.astro.astrotechnology.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.astro.astrotechnology.MainActivity;
import com.example.astro.astrotechnology.R;

/**
 * Created by vitinhHienAnh on 06-05-18.
 */

public class SecondFragemnt extends Fragment {
    TextView tvFirstFragment;
    Button btnBack;

    public static Fragment newInstance() {
        Fragment fragment = new SecondFragemnt();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvFirstFragment = view.findViewById(R.id.tvFirstFragment);
        btnBack = view.findViewById(R.id.btnBack);
        tvFirstFragment.setText("secondFragment");

        tvFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });


        return view;
    }
}
