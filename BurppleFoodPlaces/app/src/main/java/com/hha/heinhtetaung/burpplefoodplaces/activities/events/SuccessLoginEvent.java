package com.hha.heinhtetaung.burpplefoodplaces.activities.events;

import com.hha.heinhtetaung.burpplefoodplaces.activities.data.models.vo.LoginUserVO;

/**
 * Created by E5 on 1/27/2018.
 */

public class SuccessLoginEvent {
    private LoginUserVO mLoginUser;

    public SuccessLoginEvent(LoginUserVO mLoginUser) {
        this.mLoginUser = mLoginUser;
    }

    public LoginUserVO getmLoginUser() {
        return mLoginUser;
    }
}
