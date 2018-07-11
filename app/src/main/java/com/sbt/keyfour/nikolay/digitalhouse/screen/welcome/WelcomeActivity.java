package com.sbt.keyfour.nikolay.digitalhouse.screen.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


import com.sbt.keyfour.nikolay.digitalhouse.AppDelegate;
import com.sbt.keyfour.nikolay.digitalhouse.R;

import com.sbt.keyfour.nikolay.digitalhouse.widget.PageChangeViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity implements PageChangeViewPager.PagerStateListener, WelcomeView.View{

    @Inject
    WelcomePresenter presenter;

    @BindView(R.id.pager)
    PageChangeViewPager mPager;

    @BindView(R.id.btn_walkthrough)
    Button mActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("FileName");
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        mPager.setAdapter(new WelcomeAdapter(getSupportFragmentManager(), presenter.getBenefits()));
        mPager.setOnPageChangedListener(this);

        mActionButton.setText(R.string.next_uppercase);

        /*if (PreferenceUtils.isWalkthroughPassed()) {
            startAuthorizationActivity();
        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btn_walkthrough)
    public void onActionButtonClick() {
        presenter.onActionClick();
    }




    public void showContent(int index, boolean isLastContent) {
        mActionButton.setText(isLastContent ? R.string.finish_uppercase : R.string.next_uppercase);
        if (index == mPager.getCurrentItem()) {
            return;
        }
        mPager.smoothScrollNext(getResources().getInteger(android.R.integer.config_mediumAnimTime));
    }

    @Override
    public void onPageChanged(int selectedPage, boolean fromUser) {
        presenter.onPageChange(selectedPage,fromUser);
    }



}
