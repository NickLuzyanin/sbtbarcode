package com.sbt.keyfour.nikolay.digitalhouse.screen.main;

import com.sbt.keyfour.nikolay.digitalhouse.common.BasePresenter;
import com.sbt.keyfour.nikolay.digitalhouse.common.BaseView;
import com.sbt.keyfour.nikolay.digitalhouse.data.UsersData;

import java.util.List;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void showAddRA();

    }

    interface Presenter extends BasePresenter<View> {

        void result(int requestCode, int resultCode);
        void loadListRA();


    }

}
