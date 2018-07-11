package com.sbt.keyfour.nikolay.digitalhouse.screen.welcome;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.sbt.keyfour.nikolay.digitalhouse.R;
import com.sbt.keyfour.nikolay.digitalhouse.data.WelcomeContent;

import butterknife.BindView;
import butterknife.ButterKnife;



public class WelcomeFragment extends Fragment implements WelcomeView.View{

    private static final String BENEFIT_KEY = "benefit";

    @BindView(R.id.benefitIcon)
    ImageView mBenefitIcon;

    @BindView(R.id.benefitText)
    TextView mBenefitText;

    private WelcomeContent mBenefit;

    @NonNull
    public static WelcomeFragment create(@NonNull WelcomeContent benefit) {
        Bundle bundle = new Bundle();


        bundle.putString(BENEFIT_KEY, benefit.name());
        WelcomeFragment fragment = new WelcomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String benefit = getArguments().getString(BENEFIT_KEY, WelcomeContent.FIRST_WELCOME_PAGE.name());
        mBenefit = WelcomeContent.valueOf(benefit);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_benefit, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBenefitIcon.setImageResource(mBenefit.getDrawableId());
        mBenefitText.setText(mBenefit.getTextId());
    }

    @Override
    public void showContent(int index, boolean isLastContent) {

    }


}
