package com.sbt.keyfour.nikolay.digitalhouse.screen.scanner;

import android.app.Activity;
import android.content.Intent;

import com.sbt.keyfour.nikolay.digitalhouse.common.BasePresenter;
import com.sbt.keyfour.nikolay.digitalhouse.common.BaseView;

public interface ScannerContract {

    interface View extends BaseView<Presenter> {

        void showScanner();
        void saveScannerData(int requestCode, int resultCode, Intent data);

    }

    interface Presenter extends BasePresenter{


        void loadScannerData();
        void saveScannerDataInSharedPref();
        void getResult(int requestCode, int resultCode, Intent data);
        void startScanner(Activity act);
    }
}
