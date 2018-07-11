package com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot;


import com.sbt.keyfour.nikolay.digitalhouse.BuildConfig;
import com.sbt.keyfour.nikolay.digitalhouse.models.cities.CityListResponse;
import com.sbt.keyfour.nikolay.digitalhouse.models.SbtRequest;

import com.sbt.keyfour.nikolay.digitalhouse.models.UserRequest;
import com.sbt.keyfour.nikolay.digitalhouse.utils.md5Hash.Md5;


import java.util.Random;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BackendSbtService {


    private  final SbtService networkService;

    private   String stringForHash;
    private   String md5Hash;




    public BackendSbtService(SbtService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCityList(final GetCityListCallback callback, String cityRequest)  {

        Random RequestID = new Random();
        int cityID = RequestID.nextInt(9000);
        Md5 Hash = new Md5();

        stringForHash = new String("getCity:"+BuildConfig.api_code+":NikolaySBT:7bee0477f82303aa43de5d78f7b9cb05:"+cityID);
        md5Hash = Hash.ConvertStringToMd5Heashes(stringForHash);

        SbtRequest sbtrequest  = new SbtRequest();
        sbtrequest.setCommand("getCity");
        sbtrequest.setHash(md5Hash);
        sbtrequest.setLogin("NikolaySBT");
        UserRequest userRequest = new UserRequest();
        userRequest.setStr(cityRequest);
        sbtrequest.setRequest(userRequest);
        sbtrequest.setRequestId(cityID);


      //String md5 = getCity:a4c686e3bb30dfe717f855b86536302d:NikolaySBT:7bee0477f82303aa43de5d78f7b9cb05:5973;
      //md5 = 45ff0c375f14e83abc08173505c4bcb0;

       return   networkService.getCities(sbtrequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> Observable.error(throwable))
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(CityListResponse cityListResponses) {
                        callback.onSuccess(cityListResponses);
                    }


                });
    }


    public Subscription getStreetList(final GetCityListCallback callback, String cityRequest)  {

        Random RequestID = new Random();
        int cityID = RequestID.nextInt(9000);
        Md5 Hash = new Md5();

        stringForHash = new String("getCity:"+BuildConfig.api_code+":NikolaySBT:7bee0477f82303aa43de5d78f7b9cb05:"+cityID);
        md5Hash = Hash.ConvertStringToMd5Heashes(stringForHash);

        SbtRequest sbtrequest  = new SbtRequest();
        sbtrequest.setCommand("getCity");
        sbtrequest.setHash(md5Hash);
        sbtrequest.setLogin("NikolaySBT");
        UserRequest userRequest = new UserRequest();
        userRequest.setStr(cityRequest);
        sbtrequest.setRequest(userRequest);
        sbtrequest.setRequestId(cityID);


        //String md5 = getCity:a4c686e3bb30dfe717f855b86536302d:NikolaySBT:7bee0477f82303aa43de5d78f7b9cb05:5973;
        //md5 = 45ff0c375f14e83abc08173505c4bcb0;

        return   networkService.getCities(sbtrequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(throwable -> Observable.error(throwable))
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(CityListResponse cityListResponses) {
                        callback.onSuccess(cityListResponses);
                    }


                });
    }



    public interface GetCityListCallback{
        void onSuccess(CityListResponse cityListResponse);

        void onError(NetworkError networkError);
    }
}
