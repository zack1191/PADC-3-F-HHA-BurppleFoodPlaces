package com.hha.heinhtetaung.burpplefoodplaces.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.hha.heinhtetaung.burpplefoodplaces.R;
import com.hha.heinhtetaung.burpplefoodplaces.activities.fragment.LoginUserFragment;
import com.hha.heinhtetaung.burpplefoodplaces.activities.fragment.RegisterFragment;

import butterknife.ButterKnife;

/**
 * Created by E5 on 1/26/2018.
 */

public class AccountControlActivities extends AppCompatActivity {

    public static final String IE_SCREEN_TYPE = "IE_SCREEN_TYPE";
    public static final int SCREEN_TYPE_LOGIN = 1;
    public static final int SCREEN_TYPE_REGISTER = 2;


    public static Intent newIntentLogin(Context context) {
        Intent intent = new Intent(context, AccountControlActivities.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_LOGIN);
        return intent;
    }

    public static Intent newIntentRegister(Context context) {
        Intent intent = new Intent(context, AccountControlActivities.class);
        intent.putExtra(IE_SCREEN_TYPE, SCREEN_TYPE_REGISTER);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_control);
        ButterKnife.bind(this, this);

        int screenType = getIntent().getIntExtra(IE_SCREEN_TYPE, -1);
        if (screenType == SCREEN_TYPE_LOGIN) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new LoginUserFragment()).commit();
        } else if (screenType == SCREEN_TYPE_REGISTER) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, new RegisterFragment()).commit();
        }


    }
}
