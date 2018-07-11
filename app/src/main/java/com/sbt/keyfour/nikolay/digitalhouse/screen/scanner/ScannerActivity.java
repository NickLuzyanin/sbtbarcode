package com.sbt.keyfour.nikolay.digitalhouse.screen.scanner;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.sbt.keyfour.nikolay.digitalhouse.R;
import com.sbt.keyfour.nikolay.digitalhouse.screen.addNewRA.AddNewRadioAdapterFragment;
import com.sbt.keyfour.nikolay.digitalhouse.screen.main.MainActivity;
import com.sbt.keyfour.nikolay.digitalhouse.screen.welcome.WelcomeActivity;


public class ScannerActivity extends AppCompatActivity implements ScannerContract.View{

    private  ScannerContract.Presenter presenter = ScannerPresenter.getInstance();




    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, ScannerActivity.class);
        activity.startActivity(intent);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //setPresenter(new ScannerPresenter(this));
        //presenter.initPresenter();
        showScanner();
    }

    // Get the results:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {



        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                MainActivity.startMainActivity(ScannerActivity.this);

            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putString("FileName", result.getContents());
                Intent intent = new Intent(this, AddNewRadioAdapterFragment.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void showScanner() {
        presenter.startScanner(this);
    }

    @Override
    public void saveScannerData(int requestCode, int resultCode, Intent data) {

    }




}
