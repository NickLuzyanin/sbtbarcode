package com.sbt.keyfour.nikolay.digitalhouse.screen.welcome;

import com.sbt.keyfour.nikolay.digitalhouse.common.BasePresenter;
import com.sbt.keyfour.nikolay.digitalhouse.common.BaseView;
import com.sbt.keyfour.nikolay.digitalhouse.data.WelcomeContent;

import java.util.List;

public interface WelcomeView {


    interface View extends BaseView<Presenter> {

        void showContent(int index, boolean isLastContent);

    }

    interface Presenter extends BasePresenter {
        void startAuthActivity();
        void onActionClick();
        void onPageChange(int selectedPage, boolean fromUser);
        List<WelcomeContent> getBenefits();

    }

}
