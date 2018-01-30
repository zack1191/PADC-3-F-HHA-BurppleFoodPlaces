package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.SuccessLoginEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetLoginResponses;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 1/27/2018.
 */

public class UserAccountRetrofitDataAgent implements LoginDataAgent {

    private LoginApi mLoginApi;
    private static UserAccountRetrofitDataAgent sObjInstance;

    public static UserAccountRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new UserAccountRetrofitDataAgent();
        }
        return sObjInstance;
    }

    private UserAccountRetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();
        mLoginApi = retrofit.create(LoginApi.class);

    }


    @Override
    public void loginUser(String phoneNo, String password) {

        Call<GetLoginResponses> loginCall = mLoginApi.loginUser(phoneNo, password);
        loginCall.enqueue(new Callback<GetLoginResponses>() {
            @Override
            public void onResponse(Call<GetLoginResponses> call, Response<GetLoginResponses> response) {
                GetLoginResponses loginResponses = response.body();
                if (loginResponses != null) {
                    SuccessLoginEvent event = new SuccessLoginEvent(loginResponses.getLoginUserVO());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetLoginResponses> call, Throwable t) {

            }
        });

    }

    @Override
    public void registerUser(String phoneNo, String password, String name) {

    }
}
