package com.sbt.keyfour.nikolay.digitalhouse.screen.welcome;

import android.support.annotation.NonNull;


import com.sbt.keyfour.nikolay.digitalhouse.AppDelegate;
import com.sbt.keyfour.nikolay.digitalhouse.data.WelcomeContent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class WelcomePresenter implements WelcomeView.Presenter{


    private static WelcomePresenter presenter;


    @Inject
    WelcomeActivity view;

    private static final int PAGES_COUNT = 2;

    private int mCurrentItem = 0;


    private WelcomePresenter() {

    }


    public static WelcomePresenter getInstance() {
        if (presenter == null) {
            presenter = new WelcomePresenter();

        }
        return presenter;
    }


    public WelcomePresenter(WelcomeActivity view) {
        this.view = view;
    }


    @Override
    public void startAuthActivity() {

    }

    public void onActionClick() {
        if (isLastContent()) {
            /*PreferenceUtils.saveWalkthroughPassed();
            view.startAuthActivity();*/
        } else {
            mCurrentItem++;
            view.showContent(mCurrentItem, isLastContent());
        }
    }

    private boolean isLastContent() {
        return mCurrentItem == PAGES_COUNT - 1;
    }

    public void onPageChange(int selectedPage, boolean fromUser) {
        if (fromUser) {
            mCurrentItem = selectedPage;
            view.showContent(mCurrentItem, isLastContent());
        }
    }

    @NonNull
    public List<WelcomeContent> getBenefits() {
        return new ArrayList<WelcomeContent>() {
            {
                add(WelcomeContent.FIRST_WELCOME_PAGE);
                add(WelcomeContent.SECOND_WELCOME_PAGE);
                //add(WelcomeContent.THIRD_WELCOME_PAGE);
            }
        };
    }



    @Override
    public void takeView(Object view) {

    }

    @Override
    public void dropView() {

    }
}
