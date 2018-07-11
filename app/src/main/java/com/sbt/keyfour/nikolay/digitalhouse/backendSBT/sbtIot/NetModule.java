package com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot;

import com.sbt.keyfour.nikolay.digitalhouse.BuildConfig;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


@Module
public class NetModule {

   /* @Inject
    File cacheFile =  new File("responses");*/

    public NetModule() {

    }


    @Provides
    @Singleton
    Retrofit provideCall() {
       /* Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                /*Логгирование запросов к серверу и ответов от него (POST,GET)*/
                .addInterceptor(new HttpLoggingInterceptor().setLevel((BuildConfig.DEBUG) ?HttpLoggingInterceptor.Level.BODY: HttpLoggingInterceptor.Level.NONE))
              //.cache(cache)
                .build();


        return   new Retrofit.Builder()
                //.baseUrl("http://iotnew.askuer.ru/")
                .baseUrl("http://askue.iot-oblako.ru/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public SbtService providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(SbtService.class);
    }
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public BackendSbtService providesService(SbtService networkService) {
        return new BackendSbtService(networkService);
    }

}