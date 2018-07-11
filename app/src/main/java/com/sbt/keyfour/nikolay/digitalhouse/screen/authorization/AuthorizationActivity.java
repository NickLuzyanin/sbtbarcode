package com.sbt.keyfour.nikolay.digitalhouse.screen.authorization;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.sbt.keyfour.nikolay.digitalhouse.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AuthorizationActivity  extends AppCompatActivity implements AuthorizationContract {


    /*@BindView(R.id.toolbar)
    Toolbar mToolbar;*/

    @BindView(R.id.loginEdit)
    EditText mLoginEdit;

    @BindView(R.id.passwordEdit)
    EditText mPasswordEdit;

    @BindView(R.id.loginInputLayout)
    TextInputLayout mLoginInputLayout;

    @BindView(R.id.passwordInputLayout)
    TextInputLayout mPasswordInputLayout;

    private LoadingView mLoadingView;

    private AuthorizationPresenter mPresenter;

    /*public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, AuthorizationActivity.class);
        activity.startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_user);
        ButterKnife.bind(this);
        //setSupportActionBar(mToolbar);
        //mLoadingView = LoadingDialog.view(getSupportFragmentManager());
        //LifecycleHandler lifecycleHandler = LoaderLifecycleHandler.create(this, getSupportLoaderManager());
        mPresenter = new AuthorizationPresenter( this);
        mPresenter.init();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.logInButton)
    public void onLogInButtonClick() {
        String login = mLoginEdit.getText().toString();
        String password = mPasswordEdit.getText().toString();
        mPresenter.tryLogIn(login, password);
    }

    @Override
    public void showLoading() {
        mLoadingView.showLoading();
    }

    @Override
    public void hideLoading() {
        mLoadingView.hideLoading();
    }

    @Override
    public void showLoginError() {
        mLoginInputLayout.setError(getString(R.string.error));
    }

    @Override
    public void showPasswordError() {
        mPasswordInputLayout.setError(getString(R.string.error));
    }

    @Override
    public void openRepositoriesScreen() {
        //RepositoriesActivity.start(this);
        finish();
    }


}
