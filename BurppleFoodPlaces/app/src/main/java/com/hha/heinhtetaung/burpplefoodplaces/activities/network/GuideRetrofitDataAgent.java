package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadGuidesEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadPromotionEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetGuidesResponses;
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

public class GuideRetrofitDataAgent implements GuidesDataAgent {
    public static GuideRetrofitDataAgent sObjInstance;

    private GuideApi guideApi;

    public static GuideRetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new GuideRetrofitDataAgent();
        }
        return sObjInstance;
    }

    private GuideRetrofitDataAgent() {
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

        guideApi = retrofit.create(GuideApi.class);

    }

    @Override
    public void loadGuides() {
        Call<GetGuidesResponses> getGuidesResponsesCall = guideApi.getGuides(1, "b002c7e1a528b7cb460933fc2875e916");

        getGuidesResponsesCall.enqueue(new Callback<GetGuidesResponses>() {
            @Override
            public void onResponse(Call<GetGuidesResponses> call, Response<GetGuidesResponses> response) {

                GetGuidesResponses getGuidesResponses = response.body();
                if (getGuidesResponses != null) {
                    LoadGuidesEvent event = new LoadGuidesEvent(getGuidesResponses.getFeatured());
                    EventBus eventBus = EventBus.getDefault();
                    eventBus.post(event);
                }
            }

            @Override
            public void onFailure(Call<GetGuidesResponses> call, Throwable t) {

            }
        });


    }

}
