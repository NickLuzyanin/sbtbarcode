package com.sbt.keyfour.nikolay.digitalhouse;

import com.sbt.keyfour.nikolay.digitalhouse.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;



public class AppDelegate extends DaggerApplication {


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        return DaggerAppComponent.builder().application(this).build();

    }




}
