package com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ProgressBar;
import android.widget.TextView;

import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import com.sbt.keyfour.nikolay.digitalhouse.R;
import com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot.BackendSbtService;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.CityListResponse;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.SbtResponse;
import com.sbt.keyfour.nikolay.digitalhouse.screen.scanner.ScannerActivity;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;



public class AddNewRadioAdapterFragment extends Fragment implements AddNewRadioAdapterContract.View {


    public static final String ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID";

    private AutoCompleteTextView cityAutoCompleteText;
    private AutoCompleteTextView streetAutoCompleteText;

    private TextView netaddressRA;


    ArrayAdapter<String> adapter;



    @Inject
    public BackendSbtService sbtservice;

    ProgressBar progressBar;

    @Inject
    AddNewRadioAdapterContract.Presenter mPresenter;


    @Inject
    public AddNewRadioAdapterFragment() {
        // Required empty public constructor
    }



    @Override
    public void onResume() {
        super.onResume();


       mPresenter.takeView(this);

       cityAutoCompleteText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable cityRequest) {

                if (cityRequest.toString().length()>= 4){
                    mPresenter.getCityList(sbtservice,cityRequest);
                }


            }
        });






    }

    @Override
    public void onPause() {
       //mPresenter.dropView();
        super.onPause();
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        FloatingActionButton fab = getActivity().findViewById(R.id.fab_edit_task_done);
        fab.setImageResource(R.drawable.ic_done);
        fab.setOnClickListener(v -> {

        });

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.addradioadapter_frag, container, false);

        cityAutoCompleteText =root.findViewById(R.id.input_city_name);
        streetAutoCompleteText =root.findViewById(R.id.input_street_name);
        netaddressRA = root.findViewById(R.id.input_netaddress_name);
        netaddressRA.setOnClickListener((View v) -> {
            Intent intent1 = new Intent(getActivity(), ScannerActivity.class);
            startActivity(intent1);
        });


        progressBar = root.findViewById(R.id.progress1);

        setHasOptionsMenu(true);
        setRetainInstance(true);
        return root;
    }



    @Override
    public void showCityList(List<String> cityListResponse) {

        adapter = new ArrayAdapter<String>(getContext(),R.layout.my_simple_list_item_1,cityListResponse);
        cityAutoCompleteText.setAdapter(adapter);



    }

    @Override
    public void showStreetList(List<String> cityListResponse) {

    }


    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setDescription(String description) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }



}
