package com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA;

import android.support.annotation.Nullable;
import android.text.Editable;

import com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot.BackendSbtService;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.CityListResponse;
import com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot.NetworkError;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.SbtResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import rx.Subscription;
import rx.subscriptions.CompositeSubscription;



public class AddNewRadioAdapterPresenter implements AddNewRadioAdapterContract.Presenter {


    private final BackendSbtService service;
    private CompositeSubscription subscriptions;


    @Nullable
    private AddNewRadioAdapterContract.View mAddRAView;

    @Nullable
    private String cityRequests;



    @Inject
    AddNewRadioAdapterPresenter(BackendSbtService service) {
        this.service = service;

        this.subscriptions = new CompositeSubscription();
    }




    @Override
    public void getCityList(BackendSbtService sbtservice,Editable cityRequest) {

        cityRequests=cityRequest.toString();


        mAddRAView.showWait();

            Subscription subscription = service.getCityList(new BackendSbtService.GetCityListCallback() {
                @Override
                public void onSuccess(CityListResponse cityListResponse) {
                    List<String> City = new ArrayList<String>();
                    for(SbtResponse city: cityListResponse.getResponse()){
                        City.add(city.getName());
                    }
                    mAddRAView.removeWait();
                    mAddRAView.showCityList(City);
                }

                @Override
                public void onError(NetworkError networkError) {
                    mAddRAView.removeWait();
                    //mAddTaskView.onFailure(networkError.getAppErrorMessage());
                }

            },cityRequests);

            subscriptions.add(subscription);


    }

    @Override
    public void getStreetList(BackendSbtService sbtservice, Editable streetRequest) {

        Subscription subscription = service.getCityList(new BackendSbtService.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                List<String> City = new ArrayList<String>();
                for(SbtResponse city: cityListResponse.getResponse()){
                    City.add(city.getName());
                }
                mAddRAView.removeWait();
                mAddRAView.showCityList(City);
            }

            @Override
            public void onError(NetworkError networkError) {
                mAddRAView.removeWait();
                //mAddTaskView.onFailure(networkError.getAppErrorMessage());
            }

        },cityRequests);

        subscriptions.add(subscription);
    }



    @Override
    public void takeView(AddNewRadioAdapterContract.View view) {
        mAddRAView = view;
    }

    @Override
    public void dropView() {

    }
}
