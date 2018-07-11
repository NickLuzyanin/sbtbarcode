package com.sbt.keyfour.nikolay.digitalhouse.screen.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;


import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;

import android.widget.TextView;


import com.sbt.keyfour.nikolay.digitalhouse.R;

import com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA.AddNewRadioadapterActivity;



import javax.inject.Inject;

import dagger.android.support.DaggerFragment;



public class MainFragment extends DaggerFragment implements MainContract.View {





    @Inject
    MainContract.Presenter mPresenter;



    private BaseAdapter mListAdapter;
    private View mNoTasksView;
    private ImageView mNoTaskIcon;
    private TextView mNoTaskMainView;
    private TextView mNoTaskAddView;


    @Inject
    public MainFragment() {

    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mListAdapter = new RAAdapter(new ArrayList<Task>(0), mItemListener);
    }

    @Override
    public void onResume() {
        super.onResume();
       // mPresenter.takeView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //mPresenter.dropView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
       // mPresenter.result(requestCode, resultCode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.listra_frag, container, false);


        // Set up  no tasks view
        mNoTasksView = root.findViewById(R.id.noRA);
        mNoTaskIcon = (ImageView) root.findViewById(R.id.noRAIcon);
        mNoTaskMainView = (TextView) root.findViewById(R.id.noRAMain);
        mNoTaskAddView = (TextView) root.findViewById(R.id.noRAAdd);
        mNoTaskAddView.setOnClickListener(v -> {
            //showAddRA();
        });

        // Set up floating action button
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_task);

        fab.setImageResource(R.drawable.ic_add);
        fab.setOnClickListener(v -> showAddRA());
        return root;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.tasks_fragment_menu, menu);
    }


    @Override
    public void showAddRA() {
        Intent intent = new Intent(getContext(),AddNewRadioadapterActivity.class);
        startActivityForResult(intent, AddNewRadioadapterActivity.REQUEST_ADD_RA);


    }



}
