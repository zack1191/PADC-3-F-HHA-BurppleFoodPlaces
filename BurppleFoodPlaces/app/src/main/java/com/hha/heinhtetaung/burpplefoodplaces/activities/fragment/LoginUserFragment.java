package com.hha.heinhtetaung.burpplefoodplaces.activities.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.LoginUserModel;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.SuccessLoginEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 1/24/2018.
 */

public class LoginUserFragment extends Fragment {

    @BindView(R.id.et_mobile_or_email)
    EditText etEmail;

    @BindView(R.id.password)
    EditText etPassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view) {
        String phoneNo = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        LoginUserModel.getsObjInstance().loginUser(phoneNo, password);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }


    }

}
