package com.sbt.keyfour.nikolay.digitalhouse.data;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.sbt.keyfour.nikolay.digitalhouse.R;

public enum WelcomeContent {

    FIRST_WELCOME_PAGE(R.string.content_first_page, R.drawable.house),

    SECOND_WELCOME_PAGE(R.string.content_second_page, R.drawable.control_h),;

    private final int mTextId;
    private final int mDrawableId;

    WelcomeContent(@StringRes int textId, @DrawableRes int drawableId) {
        mTextId = textId;
        mDrawableId = drawableId;
    }

    @StringRes
    public int getTextId() {
        return mTextId;
    }

    @DrawableRes
    public int getDrawableId() {
        return mDrawableId;
    }



}
