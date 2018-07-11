package com.sbt.keyfour.nikolay.digitalhouse.screen.main;


import com.sbt.keyfour.nikolay.digitalhouse.di.ActivityScoped;
import com.sbt.keyfour.nikolay.digitalhouse.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @ActivityScoped
    @Binds
    abstract MainContract.Presenter mainPresenter(MainPresenter presenter);

}
