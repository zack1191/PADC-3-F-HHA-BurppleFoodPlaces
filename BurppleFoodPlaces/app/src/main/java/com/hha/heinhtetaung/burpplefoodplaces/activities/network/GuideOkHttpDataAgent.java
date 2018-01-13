package com.hha.heinhtetaung.burpplefoodplaces.activities.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.hha.heinhtetaung.burpplefoodplaces.activities.BurppleFoodPlacesApp;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadGuidesEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.events.LoadPromotionEvent;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetGuidesResponses;
import com.hha.heinhtetaung.burpplefoodplaces.activities.network.responses.GetPromotionResponses;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by E5 on 1/13/2018.
 */

public class GuideOkHttpDataAgent implements GuidesDataAgent {
    public static GuideOkHttpDataAgent sObjInstance;

    private GuideOkHttpDataAgent() {

    }

    public static GuideOkHttpDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new GuideOkHttpDataAgent();
        }
        return sObjInstance;
    }

    @Override
    public void loadGuides() {
        new loadGuidesTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");
    }

    private static class loadGuidesTask extends AsyncTask<String, Void, String> {

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


            String responseString = null;
            try {
                Response response = httpClient.newCall(request).execute();
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                }
            } catch (Exception e) {
                Log.e(BurppleFoodPlacesApp.LOG_TAG, e.getMessage());
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson = new Gson();
            GetGuidesResponses getGuidesResponses = gson.fromJson(response, GetGuidesResponses.class);

            LoadGuidesEvent event = new LoadGuidesEvent(getGuidesResponses.getFeatured());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);
        }
    }
}
