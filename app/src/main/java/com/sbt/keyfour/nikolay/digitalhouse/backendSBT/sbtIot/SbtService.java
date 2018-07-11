package com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot;


import com.sbt.keyfour.nikolay.digitalhouse.models.cities.CityListResponse;
import com.sbt.keyfour.nikolay.digitalhouse.models.SbtRequest;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface SbtService {


    @Headers("Content-Type:application/json;charset=utf8;")
    @POST("/adapters.api")
    Observable<CityListResponse> getCities(@Body SbtRequest userRequest);


}
