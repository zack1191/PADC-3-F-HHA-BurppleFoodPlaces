package com.hha.heinhtetaung.burpplefoodplaces.activities.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.LoginUserModel;
import com.hha.heinhtetaung.burpplefoodplaces.activities.delegate.AfterLoginDelegate;
import com.hha.heinhtetaung.burpplefoodplaces.activities.delegate.BeforeLoginDelegate;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.SuccessLoginEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.UserLogoutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by E5 on 1/26/2018.
 */

public class AccountControlViewPod extends FrameLayout {
    @BindView(R.id.vp_before_login_user)
    BeforeLoginUserViewPod vpBeforeLogin;

    @BindView(R.id.vp_after_login_user)
    AfterLoginUserViewPod vpAfterLogin;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        refreshUserSession();

        EventBus.getDefault().register(this);

    }


    public void setDelegate(BeforeLoginDelegate delegate) {

        vpBeforeLogin.setDelegate(delegate);

    }

//    public void setDelegate(AfterLoginDelegate delegate) {
//
//        vpAfterLogin.setDelegate(delegate);
//    }


    public void refreshUserSession() {
        if (LoginUserModel.getsObjInstance().isUserLogin()) {
            vpBeforeLogin.setVisibility(View.GONE);
            vpAfterLogin.setVisibility(View.VISIBLE);

        } else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpAfterLogin.setVisibility(View.GONE);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        vpBeforeLogin.setVisibility(View.GONE);
        vpAfterLogin.setVisibility(View.VISIBLE);

        vpAfterLogin.bindData(event.getmLoginUser());
    }

    public void setDelegate(AfterLoginDelegate loginDelegate) {
        vpAfterLogin.setDelegate(loginDelegate);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event) {
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpAfterLogin.setVisibility(View.GONE);
    }


}
