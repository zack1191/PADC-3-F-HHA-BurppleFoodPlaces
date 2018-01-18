package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadPromotionEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetPromotionResponses;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 1/18/2018.
 */

public class PromotionRetrofitDataAgent implements PromotionDataAgent {
    public static PromotionRetrofitDataAgent sObjInstance;

    private PromotionApi promotionApi;

    public static PromotionRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new PromotionRetrofitDataAgent();
        }
        return sObjInstance;
    }

    private PromotionRetrofitDataAgent() {

        OkHttpClient httpClient = new OkHttpClient.Builder() //1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder() //2
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        promotionApi = retrofit.create(PromotionApi.class);

    }

    @Override
    public void loadPromotion() {

        Call<GetPromotionResponses> getPromotionResponseCall = promotionApi.getPromotions(1, "b002c7e1a528b7cb460933fc2875e916");

        getPromotionResponseCall.enqueue(new Callback<GetPromotionResponses>() {


            @Override
            public void onResponse(Call<GetPromotionResponses> call, Response<GetPromotionResponses> response) {
                GetPromotionResponses getPromotionResponse = response.body();
                if (getPromotionResponse != null) {
                    LoadPromotionEvent event = new LoadPromotionEvent(getPromotionResponse.getPromotions());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetPromotionResponses> call, Throwable t) {

            }
        });


    }
}
