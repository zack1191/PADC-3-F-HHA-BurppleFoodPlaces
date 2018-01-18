package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadFeaturedEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetFeaturedResponses;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 1/16/2018.
 */

public class FeaturedRetrofitDataAgent implements FeaturesDataAgent {
    private static FeaturedRetrofitDataAgent sObjInstance;

    private FeaturedApi featuredApi;

    private FeaturedRetrofitDataAgent() {

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

        featuredApi = retrofit.create(FeaturedApi.class);
    }

    public static FeaturedRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new FeaturedRetrofitDataAgent();
        }
        return sObjInstance;
    }


    @Override
    public void loadFeatures() {

        final Call<GetFeaturedResponses> getFeaturedResponseCall = featuredApi.getFeatured(1, "b002c7e1a528b7cb460933fc2875e916");

        getFeaturedResponseCall.enqueue(new Callback<GetFeaturedResponses>() {
            @Override
            public void onResponse(Call<GetFeaturedResponses> call, Response<GetFeaturedResponses> response) {
                GetFeaturedResponses getFeaturedResponses = response.body();
                if (getFeaturedResponses != null) {
                    LoadFeaturedEvent event = new LoadFeaturedEvent(getFeaturedResponses.getFeatured());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetFeaturedResponses> call, Throwable t) {

            }
        });

    }
}
