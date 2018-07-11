package com.sbt.keyfour.nikolay.digitalhouse.screen.scanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.zxing.integration.android.IntentIntegrator;




public class ScannerPresenter implements ScannerContract.Presenter {


    private static ScannerPresenter presenter;
    private ScannerContract.View view;




    private Context context;


    private ScannerPresenter() {
    }

    public static ScannerPresenter getInstance() {
        if (presenter == null) {
            presenter = new ScannerPresenter();
        }
        return presenter;
    }

    public ScannerPresenter(ScannerContract.View view) {
        this.view = view;
    }


    @Override
    public void loadScannerData() {

    }

    @Override
    public void saveScannerDataInSharedPref() {

    }

    @Override
    public void getResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void startScanner(Activity activity) {
        new IntentIntegrator(activity).initiateScan();
    }


    @Override
    public void takeView(Object view) {

    }

    @Override
    public void dropView() {

    }
}
