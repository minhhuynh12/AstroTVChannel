package com.example.astro.astrotechnology.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astro.astrotechnology.Adapter.SpinnerAdapter;
import com.example.astro.astrotechnology.MainActivity;
import com.example.astro.astrotechnology.R;

import java.util.ArrayList;

import Model.SpinerSecondItems;
import Model.SpinnerItems;

/**
 * Created by vitinhHienAnh on 06-05-18.
 */

public class FirstFragment extends Fragment {

    TextView tvFirstFragment;
    Spinner spinner;
    Spinner spinnerSecond;
    Button btnSubmit;

    public static Fragment newInstance() {
        Fragment fragment = new FirstFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tvFirstFragment = view.findViewById(R.id.tvFirstFragment);
        spinner = view.findViewById(R.id.spinner);
        spinnerSecond = view.findViewById(R.id.spinnerSecond);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        final ArrayList<SpinnerItems> list = new ArrayList<>();
        list.add(new SpinnerItems("----Choose----"));
        list.add(new SpinnerItems("A"));
        list.add(new SpinnerItems("B"));
        list.add(new SpinnerItems("C"));
        list.add(new SpinnerItems("D"));
        list.add(new SpinnerItems("E"));

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getActivity(), R.layout.layout_spinner_items , list);
        spinner.setAdapter(spinnerAdapter);
        spinnerAdapter.setData(list);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(), list.get(i).getA() , Toast.LENGTH_SHORT).show();
                if(list.size() > 0) {
                    if (!list.get(i).getA().equals("----Choose----")) {
                        final ArrayList<SpinnerItems> listSecond = new ArrayList<>();
                        listSecond.add(new SpinnerItems("F"));
                        listSecond.add(new SpinnerItems("h"));
                        listSecond.add(new SpinnerItems("m"));
                        listSecond.add(new SpinnerItems("n"));
                        listSecond.add(new SpinnerItems("r"));

//                        for (int i = 0 ; list.size(); i++){
//                            listSecond.add(new SpinnerItems(list.get(i).getA()));
//                        }


                        // move item at current position to first position
                        SpinnerItems object = listSecond.get(2);
                        listSecond.remove(2);
                        listSecond.add(0 ,  object);



                        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(getActivity(), R.layout.layout_spinner_items, listSecond);
                        spinnerSecond.setAdapter(spinnerAdapter1);
                        spinnerAdapter1.setData(listSecond);

                        spinnerSecond.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                Toast.makeText(getActivity(), listSecond.get(i).getA(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {

                            }
                        });
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(0).getA().equals("----Choose----")){
                    Toast.makeText(getActivity(), "you need choose spinner" , Toast.LENGTH_SHORT).show();
                }
            }
        });


        tvFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).addFragment(R.id.frameFragment, SecondFragemnt.newInstance() );

            }
        });
        return view;
    }

}
