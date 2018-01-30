package com.hha.heinhtetaung.burpplefoodplaces.activities.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.delegate.BeforeLoginDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 1/25/2018.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {


    private BeforeLoginDelegate mDelegate;

    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }

    public void setDelegate(BeforeLoginDelegate delegate) {
        mDelegate = delegate;
    }

    @OnClick(R.id.btn_to_login)
    public void onTapToLogin(View view) {
        mDelegate.onTapToLogin();
    }

    @OnClick(R.id.btn_to_register)
    public void onTapToRegister(View view) {
        mDelegate.onTapToRegister();
    }
}
