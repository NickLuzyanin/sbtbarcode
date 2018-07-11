package com.sbt.keyfour.nikolay.digitalhouse.screen.main;

import com.sbt.keyfour.nikolay.digitalhouse.di.ActivityScoped;

import javax.annotation.Nullable;
import javax.inject.Inject;


@ActivityScoped
final class MainPresenter implements MainContract.Presenter {

    @Nullable
    private MainContract.View mRAView;



    @Inject
    MainPresenter() {

    }


    @Override
    public void result(int requestCode, int resultCode) {

    }


    @Override
    public  void loadListRA() {
        if (mRAView != null) {
            mRAView.showAddRA();
        }
    }



    @Override
    public void takeView(MainContract.View view) {

    }

    @Override
    public void dropView() {

    }
}
