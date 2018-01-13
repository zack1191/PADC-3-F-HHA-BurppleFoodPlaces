package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.BurppleFoodPlacesApp;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadFeaturedEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetFeaturedResponses;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by E5 on 1/12/2018.
 */

public class FeaturedOkHttpDataAgent implements FeaturesDataAgent {

    private static FeaturedOkHttpDataAgent sObjInstance;

    private FeaturedOkHttpDataAgent() {

    }

    public static FeaturedOkHttpDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new FeaturedOkHttpDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadFeatures() {
        new LoadFeaturedTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php");
    }

    private static class LoadFeaturedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String url = urls[0];

            OkHttpClient httpClient = new OkHttpClient.Builder() //1
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();


            try {
                Response response = httpClient.newCall(request).execute(); //4
                if (response.isSuccessful() && response.body() != null) {
                    String responseString = response.body().string();
                    return responseString;
                }

            } catch (IOException e) {
                Log.e(BurppleFoodPlacesApp.LOG_TAG, e.getMessage());
            }

            return null;


        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetFeaturedResponses getFeaturedResponses = gson.fromJson(response, GetFeaturedResponses.class);

            LoadFeaturedEvent event = new LoadFeaturedEvent(getFeaturedResponses.getFeatured());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);

        }
    }
}
