package com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA;

import android.support.annotation.Nullable;

import com.sbt.keyfour.nikolay.digitalhouse.di.ActivityScoped;
import com.sbt.keyfour.nikolay.digitalhouse.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AddNewRadioadapterModule {



        @Provides
        @ActivityScoped
        @Nullable
        static String provideTaskId(AddNewRadioadapterActivity activity) {
            return activity.getIntent().getStringExtra(AddNewRadioAdapterFragment.ARGUMENT_EDIT_TASK_ID);
        }

        @Provides
        @ActivityScoped
        static boolean provideStatusDataMissing(AddNewRadioadapterActivity activity) {
            return activity.isDataMissing();
        }

        @FragmentScoped
        @ContributesAndroidInjector
        abstract AddNewRadioAdapterFragment addEditTaskFragment();

        @ActivityScoped
        @Binds
        abstract AddNewRadioAdapterContract.Presenter taskPresenter(AddNewRadioAdapterPresenter presenter);



}
