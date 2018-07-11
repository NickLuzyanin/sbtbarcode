package com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA;

import android.text.Editable;

import com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot.BackendSbtService;
import com.sbt.keyfour.nikolay.digitalhouse.common.BasePresenter;
import com.sbt.keyfour.nikolay.digitalhouse.common.BaseView;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.CityListResponse;

import java.util.List;

public interface AddNewRadioAdapterContract {

    interface View extends BaseView<Presenter> {

        void showCityList(List<String> cityListResponse);

        void showStreetList(List<String> cityListResponse);


        void setTitle(String title);

        void setDescription(String description);

        boolean isActive();

        void showWait();

        void removeWait();
    }

    interface Presenter extends BasePresenter<View> {


        void getCityList(BackendSbtService sbtservice, Editable cityRequest);
        void getStreetList(BackendSbtService sbtservice, Editable streetRequest);



    }


}
