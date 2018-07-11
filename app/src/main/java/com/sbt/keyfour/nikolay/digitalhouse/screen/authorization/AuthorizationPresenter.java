package com.sbt.keyfour.nikolay.digitalhouse.screen.authorization;

import android.support.annotation.NonNull;
import android.text.TextUtils;



public class AuthorizationPresenter {

    //private final LifecycleHandler mLifecycleHandler;
    private final AuthorizationActivity mAuthView;

    public AuthorizationPresenter(AuthorizationActivity mAuthView) {
            this.mAuthView = mAuthView;
    }

    public void init() {
        //String token = PreferenceUtils.getToken();
        //if (!TextUtils.isEmpty(token)) {
         //   mAuthView.openRepositoriesScreen();
        //}
    }

    public void tryLogIn(@NonNull String login, @NonNull String password) {
        if (TextUtils.isEmpty(login)) {
           // mAuthView.showLoginError();
        } else if (TextUtils.isEmpty(password)) {
           // mAuthView.showPasswordError();
        } else {
            /*RepositoryProvider.provideGithubRepository()
                    .auth(login, password)
                    .doOnSubscribe(mAuthView::showLoading)
                    .doOnTerminate(mAuthView::hideLoading)
                    .compose(mLifecycleHandler.reload(R.id.auth_request))
                    .subscribe(authorization -> mAuthView.openRepositoriesScreen(),
                            throwable -> mAuthView.showLoginError());*/
        }
    }





}
