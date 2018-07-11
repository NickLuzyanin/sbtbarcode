package com.sbt.keyfour.nikolay.digitalhouse.screen.welcome;



import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sbt.keyfour.nikolay.digitalhouse.data.WelcomeContent;

import java.util.List;


public class WelcomeAdapter extends FragmentStatePagerAdapter {

    private final List<WelcomeContent> mBenefits;

    public WelcomeAdapter(FragmentManager fm, @NonNull List<WelcomeContent> benefits) {
        super(fm);
        mBenefits = benefits;
    }

    @Override
    public Fragment getItem(int position) {
        return WelcomeFragment.create(mBenefits.get(position));
    }

    @Override
    public int getCount() {
        return mBenefits.size();
    }
}
