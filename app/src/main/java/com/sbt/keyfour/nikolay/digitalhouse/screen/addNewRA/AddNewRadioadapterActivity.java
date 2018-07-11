package com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.ActionBar;

import android.support.v7.widget.Toolbar;

import com.sbt.keyfour.nikolay.digitalhouse.R;

import com.sbt.keyfour.nikolay.digitalhouse.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

import static android.net.http.SslCertificate.restoreState;

public class AddNewRadioadapterActivity extends DaggerAppCompatActivity {

    public static final int REQUEST_ADD_RA = 1;



    @Inject
    AddNewRadioAdapterContract.Presenter mAddEditTasksPresenter;

    @Inject
    AddNewRadioAdapterFragment mFragment;

    @Inject
    @Nullable
    String mTaskId;




    private boolean mIsDataMissing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addtask_act);


        AddNewRadioAdapterFragment addEditTaskFragment =
                (AddNewRadioAdapterFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if (addEditTaskFragment == null) {
            addEditTaskFragment = mFragment;

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addEditTaskFragment, R.id.contentFrame);
        }
        restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



    boolean isDataMissing() {
        return mIsDataMissing;
    }



}
