package com.hha.heinhtetaung.burpplefoodplaces.activities.viewpods;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.LoginUserVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.delegate.AfterLoginDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 1/26/2018.
 */

public class AfterLoginUserViewPod extends RelativeLayout {

    @BindView(R.id.tv_login_username)
    TextView tvLoginUserName;

    @BindView(R.id.tv_login_phoneno)
    TextView tvLoginPhoneNo;

    @BindView(R.id.iv_login_profile)
    ImageView ivLoginProfile;


    private AfterLoginDelegate mDelegate;

    public AfterLoginUserViewPod(Context context) {
        super(context);
    }

    public AfterLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AfterLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setDelegate(AfterLoginDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

    }

    public void bindData(LoginUserVO loginUser) {
        tvLoginUserName.setText(loginUser.getName());
        tvLoginPhoneNo.setText(loginUser.getEmail());

        Glide.with(ivLoginProfile.getContext())
                .load(loginUser.getProfileUrl())
                .into(ivLoginProfile);
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view) {
        mDelegate.onTapLogout();
    }

}
