package com.hha.heinhtetaung.burpplefoodplaces.activities.data.models;

import android.util.Log;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.LoginUserVO;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.SuccessLoginEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.UserLogoutEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.LoginDataAgent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.UserAccountRetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by E5 on 1/27/2018.
 */

public class LoginUserModel {


    private static LoginUserModel sObjInstance;

    private LoginDataAgent mLoginDataAgent;

    private LoginUserVO mLoginUser;

    private LoginUserModel() {
        mLoginDataAgent = UserAccountRetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);//event ko register lote poc lo

    }

    public static LoginUserModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new LoginUserModel();
        }
        return sObjInstance;
    }

    public void loginUser(String phoneNo, String password) {//view layer ka hlan khw tr
        mLoginDataAgent.loginUser(phoneNo, password);
    }

    public void registerUser(String phoneNo, String password, String name) {
        mLoginDataAgent.registerUser(phoneNo, password, name);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserSuccess(SuccessLoginEvent event) {
        mLoginUser = event.getmLoginUser();
    }


    public boolean isUserLogin() {
        return mLoginUser != null;
    }

    public void logout() {
        mLoginUser = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);//event ko broadcast lote tr
    }

}
