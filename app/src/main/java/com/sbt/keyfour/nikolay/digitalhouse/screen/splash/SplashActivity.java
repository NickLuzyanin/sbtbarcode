/*
 *
 * Copyright (c) $year Aleksandr Karpov <keyfour13@gmail.com>
 *
 */

package com.sbt.keyfour.nikolay.digitalhouse.screen.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;


import com.sbt.keyfour.nikolay.digitalhouse.R;
import com.sbt.keyfour.nikolay.digitalhouse.screen.scanner.ScannerActivity;
import com.sbt.keyfour.nikolay.digitalhouse.screen.welcome.WelcomeActivity;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    }

    @Override
    public void onResume() {
        super.onResume();
        Observable.just(true)
                .subscribeOn(Schedulers.io())
                .delay(3, TimeUnit.SECONDS)
                //.flatMap(aBoolean -> GetUserToken.getInstance(this).execute(null))
                //.map(Login::getAuthToken)
                //.map(token -> !token.isEmpty())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(startActivityAction1(), Throwable::printStackTrace);
    }

    @NonNull
    private Action1<Boolean> startActivityAction1() {

        return usersExists -> {
            if (usersExists) {
                startActivity(new Intent(this, ScannerActivity.class));
                //startActivity(new Intent(this, MainActivity.class));
            } else {
                startActivity(new Intent(this, ScannerActivity.class));
                //startActivity(new Intent(this, AuthActivity.class));
            }
            this.finish();
        };
    }

}
