package com.sbt.keyfour.nikolay.digitalhouse.screen.main;

import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.sbt.keyfour.nikolay.digitalhouse.R;
import com.sbt.keyfour.nikolay.digitalhouse.screen.scanner.ScannerActivity;
import com.sbt.keyfour.nikolay.digitalhouse.screen.scanner.ScannerContract;
import com.sbt.keyfour.nikolay.digitalhouse.utils.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {



    @Inject
    MainPresenter mTasksPresenter;
    @Inject
    Lazy<MainFragment> RAFragmentProvider;

    private DrawerLayout mDrawerLayout;

    public static void startMainActivity(@NonNull Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setItemIconTintList(null);
            setupDrawerContent(navigationView);
        }
        MainFragment mFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mFragment == null) {
            // Получаем фрагмент от Даггер
            mFragment = RAFragmentProvider.get();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mFragment, R.id.contentFrame);
        }



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:


                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    switch (menuItem.getItemId()) {

                        case R.id.list_navigation_menu_item_scanner:

                            ScannerActivity.start(MainActivity.this);
                            break;

                        case R.id.list_navigation_menu_item_objects:


                            break;

                        case R.id.list_navigation_menu_item_metters:

                            break;

                        case R.id.list_navigation_menu_item_help:

                            break;

                        default:
                            break;
                    }

                    menuItem.setChecked(true);

                    mDrawerLayout.closeDrawers();
                    return true;
                });
    }




}
