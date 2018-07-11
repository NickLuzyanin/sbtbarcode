package com.sbt.keyfour.nikolay.digitalhouse.di;


import android.app.Application;

import com.sbt.keyfour.nikolay.digitalhouse.AppDelegate;
import com.sbt.keyfour.nikolay.digitalhouse.backendSBT.sbtIot.NetModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {//TasksRepositoryModule.class,
        NetModule.class,
                        ApplicationModule.class,
                        ActivityBindingModule.class,
                        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AppDelegate> {

    //TasksRepository getTasksRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);




        AppComponent build();
    }
}
